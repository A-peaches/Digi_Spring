package kr.soft.contact;

import org.springframework.context.support.GenericXmlApplicationContext;

import kr.soft.contact.service.ContactRegisterService;
import kr.soft.contact.service.ContactSearchService;
import kr.soft.contact.utils.InitSampleData;

public class MainClass {
	
	public static void main(String args[]) {
		
		//IoC 컨테이너 생성
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		//샘플 데이터
		InitSampleData initSampleData = ctx.getBean("initSampleData",InitSampleData.class);
		String[] names = initSampleData.getNames();
		String[] phoneNumbers = initSampleData.getPhoneNumbers();
		
		//데이터 등록
		ContactRegisterService registerService = 
				ctx.getBean("registerService",ContactRegisterService.class);
		for(int i = 0; i<names.length; i++) {
			ContactSet contactSet = new ContactSet(names[i],phoneNumbers[i]);
			registerService.register(contactSet);
		}
		
		//데이터 조회 
		ContactSearchService searchService = 
				ctx.getBean("searchService", ContactSearchService.class);
		
		ContactSet contactSet = searchService.searchContact("김피피");
		System.out.println("name : " + contactSet.getName());
		System.out.println("phone number : " + contactSet.getPhoneNumber());
		System.out.println("=========================================");
		
		contactSet = searchService.searchContact("김치치");
		System.out.println("name : " + contactSet.getName());
		System.out.println("phone number : " + contactSet.getPhoneNumber());
		System.out.println("=========================================");
		
		contactSet = searchService.searchContact("김포포");
		System.out.println("name : " + contactSet.getName());
		System.out.println("phone number : " + contactSet.getPhoneNumber());
		System.out.println("=========================================");
		
	}
}
