package com.school.web.controller;

import java.util.Scanner;

import com.school.web.serviceImpl.TeacherServiceImpl;

public class TeacherController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TeacherServiceImpl subject = new TeacherServiceImpl();
		
		while(true) {
			System.out.println("강사 모드입니다 id를 입력하세요");
			String id = scanner.next();
			System.out.println("pw를 입력하세요");
			String pw = scanner.next();
		}
	}
}
