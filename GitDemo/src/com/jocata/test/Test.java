package com.jocata.test;

import java.time.LocalDate;

public class Test {
	
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.getCurrentDate());
	}
	
	public LocalDate getCurrentDate()	{
		return LocalDate.now();
	}
}
