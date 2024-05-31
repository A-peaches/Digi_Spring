package kr.soft.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.soft.contact.ContactSet;
import kr.soft.contact.dao.ContactDao;

@Component
public class ContactSearchService {
	private ContactDao contactDao;

	public ContactDao getContactDao() {
		return contactDao;
	}

	@Autowired
	public ContactSearchService(ContactDao contactDao) {
		System.out.println("contactDao 주소 : " + contactDao);
		this.contactDao = contactDao;
	}
	
	public ContactSet searchContact(String name) {
		if(verify(name)) { //이름이 있으면
			return contactDao.select(name);
		} else { //이름이 없으면
			System.out.println("Contact information is available");
		}
		
		return null;
	}

	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet != null ? true : false; // 연락처 있을시 true, 없을시 false.
	}
	
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
}
