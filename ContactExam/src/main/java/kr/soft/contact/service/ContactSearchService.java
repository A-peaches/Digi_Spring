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
		System.out.println("contactDao �ּ� : " + contactDao);
		this.contactDao = contactDao;
	}
	
	public ContactSet searchContact(String name) {
		if(verify(name)) { //�̸��� ������
			return contactDao.select(name);
		} else { //�̸��� ������
			System.out.println("Contact information is available");
		}
		
		return null;
	}

	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet != null ? true : false; // ����ó ������ true, ������ false.
	}
	
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
}
