package com.school.web.controller;

import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.text.html.CSS;

import com.school.web.bean.StudentBean;
import com.school.web.service.StudentService;
import com.school.web.serviceImpl.StudentServiceImpl;
import com.school.web.ui.MainPage;

public class StudentController {
	public static void main(String[] args) {
		StudentService studentService= new StudentServiceImpl(); 
		//= new StudentServiceImpl(Integer.parseInt(JOptionPane.showInputDialog("학생수 입력")));
		//StudentBean student = new StudentBean();이 위치에 있으면 오버라이드 된다.
		StudentBean student = null;
		String showMsg = null;
		StudentBean temp = null;
		StudentBean[] students = null;
		while (true) {
			switch (Integer.parseInt(JOptionPane.showInputDialog(
					"[메뉴] 0.종료 \n "
					+ "1.학생등록 2.성적 등록\n "
					+ "3.총 학생수 4.학생 이름 리스트5.내정보 보기"
					+ "6.이름 검색7.비번 변경8.계정 삭제 9. 화면보기"))) {
			case 0:
				JOptionPane.showMessageDialog(null, "종료");
				return;
			case 1:
				//StudentBean student = new StudentBean(); 생성자명은 초기화 되지만
				//퍼포먼스 면에서 별로..
				student = new StudentBean();
				student.setId(JOptionPane.showInputDialog("ID를 입력"));
				student.setPw(JOptionPane.showInputDialog("pw를 입력"));
				student.setName(JOptionPane.showInputDialog("이름 입력"));
				
				studentService.addStudent(student);
				JOptionPane.showMessageDialog(null, "가입완료");
				break;
			case 2: 
				break;
			case 3: //count = studentService.getCount();
			JOptionPane.showMessageDialog(null, "총학생 수는?" + studentService.getCount());
			break;
			case 4: 
				showMsg = "";
				students = studentService.list();
				
				for(int i = 0; i<students.length;i++) {
					if(students[i]!=null)
					showMsg += students[i].toString()+"\n";
				
				}
				JOptionPane.showMessageDialog(null, showMsg);
				break;
			case 5: 
				showMsg = "";
				temp = studentService.findStudentById(JOptionPane.showInputDialog("id"));
				
				showMsg += temp.getName()+ "\n";
				JOptionPane.showMessageDialog(null, showMsg);
				break;
			case 6:
				showMsg = "";
				students = studentService.findStudentByName(JOptionPane.showInputDialog("검색 이름 입력"));
				if(students == null) {
					showMsg += ("검색하려는 이름이 존재하지 않습니다.");
				}else {
					for(int i = 0; i < students.length; i++) {
						showMsg += students[i].toString() + "\n";
					}
					JOptionPane.showMessageDialog(null, showMsg);
				break;
			}
			
			case 7 : 
				student = new StudentBean();
				student.setId(JOptionPane.showInputDialog("id를 입력하세요"));
				student.setPw(JOptionPane.showInputDialog("수정할 비번"));
				studentService.updatePassword(student);
				StudentBean resStudent = studentService.findStudentById(student.getId());
				JOptionPane.showMessageDialog(null, resStudent.toString());
				
				
				
				
				
				/*System.out.println();
				String paramId = scanner.next();
				studentService.updatePassword();
				StudentBean resStudent = studentService.findStudentbyId(paramId);
				System.out.println(resStudent);
				*/
				break;
			case 8 : 
				studentService.delId(JOptionPane.showInputDialog("삭제할 id 입력하세요"));
				JOptionPane.showMessageDialog(null, "삭제완료");
				break;
			case 9 :
				MainPage mp = new MainPage();
				
				break;
			}
	}
	}
	}
