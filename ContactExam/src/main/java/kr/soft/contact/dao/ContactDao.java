package kr.soft.contact.dao;

import java.util.HashMap;
import java.util.Map;

import kr.soft.contact.ContactSet;

public class ContactDao {
	
	//연락처 정보 저장
	private Map<String,ContactSet> contactDB = new HashMap<String, ContactSet>();
	
	
	public void insert(ContactSet contactSet) { //연락처 저장
		contactDB.put(contactSet.getName(), contactSet);
	}
	
	public ContactSet select(String name) { //연락처 조회
		return contactDB.get(name);
	}
	
	public Map<String,ContactSet> getContactDB() {
		return contactDB;
	}
	
}
