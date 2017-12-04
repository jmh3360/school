package com.school.web.service;

import com.school.web.bean.StudentBean;

//로그인 기능
//학생 점수 확인하는 기능
//성적 update 기능
//삭제 기능 

public interface StudentService {
	public void addStudent(StudentBean student);
	public void addScore(StudentBean score);
	public StudentBean login(StudentBean login);//id와 pw둘다 필요하여 condition내에 빈을 사용함 
	public StudentBean find(String id);
	public void setCount(int count);
	public int getCount();
	public StudentBean[] list();
	public StudentBean findStudentById(String id);
	public StudentBean[] findStudentByName(String name);
}
