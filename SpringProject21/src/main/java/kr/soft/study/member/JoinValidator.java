package kr.soft.study.member;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class JoinValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return JoinData.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("Join valuedate()");
		JoinData joinData = (JoinData) obj;
		checkId(joinData, errors);
		checkPw(joinData, errors);
		checkEmail(joinData, errors);
		checkName(joinData, errors);
		checkIdNo(joinData, errors);
		checkHabit(joinData, errors);
		checkMyInfo(joinData, errors);
	}

	private void checkId(JoinData joinData, Errors errors) {
		String id = joinData.getId();

		// 4~12�� ���̷� �Է�. ���鵵 ������
		if (id.length() < 4 || id.length() > 12) {
			System.out.println("id�� 4~12���̷� �Է�!");
			errors.rejectValue("id", "trouble");
		}

		// ���� ��ҹ��ڿ� ���ڸ� ����.
		for (int i = 0; i < id.length(); i++) {
			char charId = id.charAt(i);
			if (!((charId > 47 && charId < 59) || (charId > 64 && charId < 91) || (charId > 96 && charId < 123))) {
				System.out.println("ID�� ���� ��ҹ��ڿ� ���ڸ�!");
			}
		}
	}

	private void checkPw(JoinData joinData, Errors errors) {
		String pw = joinData.getPw();
		String pwCheck = joinData.getPw2();

		// 4~12�� ���̷� �Է�. ���鵵 ������
		if (pw.length() < 4 || pw.length() > 12) {
			System.out.println("pw�� 4~12���̷� �Է�!");
			errors.rejectValue("pw", "trouble");
		}

		// ���� ��ҹ��ڿ� ���ڸ� ����.
		for (int i = 0; i < pw.length(); i++) {
			char charPw = pw.charAt(i);
			if (!((charPw > 47 && charPw < 59) || (charPw > 64 && charPw < 91) || (charPw > 96 && charPw < 123))) {
				System.out.println("pw�� ���� ��ҹ��ڿ� ���ڸ�!");
			}
		}

		// pw1�� pw2�� ���ƾ���/
		if (!pw.equals(pwCheck)) {
			System.out.println("pw1 != pw2");
			errors.rejectValue("pw", "trouble");
		}
	}

	private void checkEmail(JoinData joinData, Errors errors) {

		String email = joinData.getEmail();

		int idx = email.indexOf("@");

		if (idx == -1 || idx == 0 || idx == email.length() - 1) {
			System.out.println("email�� id@domain.com ����!");
			errors.rejectValue("email", "trouble");
		}
	}

	private void checkName(JoinData joinData, Errors errors) {
		String name = joinData.getName();

		//�������
		if (name == null || name.trim().isEmpty()) {
			System.out.println("�̸��Է��ϼ���!");
			errors.rejectValue("name", "trouble");
		}
	}
	
	public void checkIdNo(JoinData joinData, Errors errors) {
		String idNo = joinData.getIdNo();
		if (idNo == null || idNo.trim().isEmpty()) {
			System.out.println("�ֹι�ȣ �������!");
			errors.rejectValue("idNo", "trouble");
		}

		if (idNo.length() != 13) {
			System.out.println("�ֹι�ȣ���̿���!");
			errors.rejectValue("idNo", "trouble");
		} else {
			String[] arr = idNo.split("", 13);
			int[] idNoArr = new int[13];
			int sum = 0;

			for (int i = 0; i < arr.length; i++) {
				idNoArr[i] = Integer.parseInt(arr[i]);
			}
			for (int i = 0; i <= 7; i++) {
				idNoArr[i] = idNoArr[i] * (i + 2);
			}
			for (int i = 8; i <= 11; i++) {
				idNoArr[i] = idNoArr[i] * (i - 6);
			}
			for (int i = 0; i < 12; i++) {
				sum += idNoArr[i];
			}

			int temp = 11 - (sum % 11);

			if (temp >= 10) {
				temp = temp - 10;
			}
			if (temp != idNoArr[12]) {
				System.out.println("�ùٸ� �ֹι�ȣ �Է�!");
				errors.rejectValue("idNo", "trouble");
			}
		}
		
	}
	
	private void checkHabit(JoinData joinData, Errors errors) {
		String habit = joinData.getHabit();

		//�������
		if (habit == null || habit.trim().isEmpty()) {
			System.out.println("���ɺо� �ϳ��̻���!");
			errors.rejectValue("habit", "trouble");
		}
	}
	
	private void checkMyInfo(JoinData joinData, Errors errors) {
		String myInfo = joinData.getMyInfo();

		//�������
		if (myInfo == null || myInfo.trim().isEmpty() || myInfo.length()<30) {
			System.out.println("myInfo�Է� �� 30���̻�!");
			errors.rejectValue("myInfo", "trouble");
		}
	}
}