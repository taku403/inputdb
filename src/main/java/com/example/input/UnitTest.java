package com.example.input;

import com.example.input.domain.misc.admin.Admin;

public class UnitTest {

	public static Object test(Object obj) {

		return obj;
	}

	public static void main(String[] args) {


		Admin admin  = new Admin();
		Object obj = new Object();
		Admin admin2 =  (Admin)test(obj);

			System.out.println(admin.getClass());
			System.out.println(admin2.getClass());

	}
}
