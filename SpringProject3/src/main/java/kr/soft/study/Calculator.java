package kr.soft.study;

public class Calculator {
	
	
	public void add(int num1, int num2) {
		System.out.println("addition()");
		System.out.println(num1 + " + " + num2 + " = " + ( num1 + num2 ));

	}

	public void sub(int num1, int num2) {
		System.out.println("subtraction()");
		System.out.println(num1 + " - " + num2 + " = " + ( num1 - num2 ));
	}

	public void mul(int num1, int num2) {
		System.out.println("multiplication()");
		System.out.println(num1 + " * " + num2 + " = " + ( num1 * num2 ));
	}

	public void div(int num1, int num2) {
		System.out.println("division()");
		System.out.println(num1 + " / " + num2 + " = " + ( num1 / num2 ));
	}

}
