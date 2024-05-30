package kr.soft.study;

public class MyCalculator {
	Calculator cal;
	private int firstNum;
	private int secondNum;

	public int getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public int getSecondNum() {
		return secondNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}

	public void setCalculator(Calculator cal) {
		this.cal = cal;
	}
	
	public void add() {
		cal.add(firstNum, secondNum);
	}
	
	public void sub() {
		cal.sub(firstNum, secondNum);
	}
	
	public void mul() {
		cal.mul(firstNum, secondNum);
	}
	
	public void div() {
		cal.div(firstNum, secondNum);
	}

}
