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
		System.out.println("contactDao �ּ� : " + contactDao);
		this.contactDao = contactDao; // contactDao �ʵ� �ʱ�ȭ.
	}
	
	public void register (ContactSet contactSet) {
		String name = contactSet.getName(); //�̸� ���������
		if(verify(name)) {
			contactDao.insert(contactSet); //������ ������(true) ���� 
		} else {
			System.out.println("The name has already registered."); //������ ������ ������
		}	
	}

	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet == null ? true : false; // ����ó ��ȸ����� null�̸� true, �ƴϸ� false.
	}
	
	public void setWordDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
}
