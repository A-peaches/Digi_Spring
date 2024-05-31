package kr.soft.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.soft.contact.ContactSet;
import kr.soft.contact.dao.ContactDao;

@Component
public class ContactRegisterService {
	private ContactDao contactDao;
	
	@Autowired
	public ContactRegisterService(ContactDao contactDao) {
		System.out.println("contactDao 주소 : " + contactDao);
		this.contactDao = contactDao; // contactDao 필드 초기화.
	}
	
	public void register (ContactSet contactSet) {
		String name = contactSet.getName(); //이름 가지고오기
		if(verify(name)) {
			contactDao.insert(contactSet); //기존에 없으면(true) 저장 
		} else {
			System.out.println("The name has already registered."); //기존에 있으면 경고출력
		}	
	}

	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet == null ? true : false; // 연락처 조회결과가 null이면 true, 아니면 false.
	}
	
	public void setWordDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
}
