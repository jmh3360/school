package com.school.web.controller;

import java.util.Scanner;

import javax.swing.text.html.CSS;

import com.school.web.bean.StudentBean;
import com.school.web.service.StudentService;
import com.school.web.serviceImpl.StudentServiceImpl;

public class StudentController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("학생수 입력");
		int count = scanner.nextInt();
		StudentService studentService = new StudentServiceImpl(count);
		//StudentBean student = new StudentBean();이 위치에 있으면 오버라이드 된다.
		StudentBean student = null;
		while (true) {
			
			System.out.println("[메뉴] 0.종료  1.학생등록 2.성적 등록 3.총 학생수 4.학생 이름 리스트5.내정보 보기"
					+ "6.이름 검색");
			switch (scanner.nextInt()) {
			case 0:
				System.out.println("종료");
				return;
			case 1:
				//StudentBean student = new StudentBean(); 생성자명은 초기화 되지만
				//퍼포먼스 면에서 별로..
				student = new StudentBean();
				System.out.println("ID를 입력");
				student.setId(scanner.next());
				System.out.println("pw를 입력");
				student.setPw(scanner.next());
				System.out.println("이름 입력");
				student.setName(scanner.next());
				
				studentService.addStudent(student);
			break;
			case 2: 
				break;
			case 3: count = studentService.getCount();
			System.out.println("총학생 수는?"+ studentService.getCount());
				break;
			case 4: 
				StudentBean[] students = studentService.list();
				for(int i = 0; i<students.length;i++) {
					System.out.println(students[i].getName());
				}
				break;
			case 5: 
				
				String id = scanner.next();
				StudentBean temp = studentService.findStudentById(id);
				System.out.println(temp.getName());
				break;
			case 6:
				
				System.out.println("검색 이름 입력");
				StudentBean[] temp2 = studentService.findStudentByName(scanner.next());
				if(temp2 == null) {
					System.out.println("검색하려는 이름이 존재하지 않습니다.");
				}else {
					for(int i = 0; i < temp2.length; i++) {
					System.out.println(temp2[i].toString());
				}
					
				break;
			}
			
		}
	}
	}
	}
