package com.noprom.app;

/**
 * 电话号码类
 * @author noprom
 *
 */
public class Phone {

	private String area; // 区号
	private String number; // 号码

	public Phone(String area, String number) {
		this.area = area;
		this.number = number;
	}

	public Phone(String phoneNumber) {
		int index = phoneNumber.indexOf("-");
		this.area = phoneNumber.substring(0, index);
		this.number = phoneNumber.substring(index + 1, phoneNumber.length());
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Phone number = " + area + "-" + number;
	}

	public static void main(String[] args) {
		Phone phone = new Phone("010-68911205");
		System.out.println(phone.toString());

		phone.setArea("0817");
		System.out.println(phone.toString());

		phone.setNumber("85456352");
		System.out.println(phone.toString());

		System.out.println("Area = "+phone.getArea());
		System.out.println("Number = "+phone.getNumber());
	}

}
