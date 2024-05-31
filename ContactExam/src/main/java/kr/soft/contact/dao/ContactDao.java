package kr.soft.contact.dao;

import java.util.HashMap;
import java.util.Map;

import kr.soft.contact.ContactSet;

public class ContactDao {
	
	//����ó ���� ����
	private Map<String,ContactSet> contactDB = new HashMap<String, ContactSet>();
	
	
	public void insert(ContactSet contactSet) { //����ó ����
		contactDB.put(contactSet.getName(), contactSet);
	}
	
	public ContactSet select(String name) { //����ó ��ȸ
		return contactDB.get(name);
	}
	
	public Map<String,ContactSet> getContactDB() {
		return contactDB;
	}
	
}
