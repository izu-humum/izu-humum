package com.bd;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG {

	@BeforeSuite
	public void beforesuite() {
		System.out.println("Before Suite");
	}

	@AfterSuite
	public void aftersuite() {
		System.out.println("After Suite");
	}

	@Test
	public void test() {
		System.out.println("This is a test");
	}


}
