package com.example.input.aspect;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.ui.Model;

@Aspect
public class Some {

	@Before("execution(* *(..))")
	public void loginCheck(JoinPoint jp, Model model, HttpSession session){

		String loginId = (String) session.getAttribute("loginId");

		if(loginId != null) {

			model.addAttribute("loginId", loginId);
		}

		System.out.println("Call " + jp.toString());
	}
}
