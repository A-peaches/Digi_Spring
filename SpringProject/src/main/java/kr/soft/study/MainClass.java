package kr.soft.study;

public class MainClass {
	public static void main(String args[]) {
		Calculation cal = new Calculation();
		cal.setFirstNum(10);
		cal.setSecondNum(2);

		cal.addition();
		cal.subtraction();
		cal.multiplication();
		cal.division();
	}
}
