package com.school.web.serviceImpl;

import com.school.web.bean.StudentBean;
import com.school.web.controller.StudentController;
import com.school.web.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private int count;
	private StudentBean[] students;

	@Override
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int getCount() {
		return this.count;
	}

	// void setter 저장의 의미

	public StudentServiceImpl() {
		this.count = 0;
		students = new StudentBean[2];

	}

	@Override
	public void addStudent(StudentBean student) {
		if(count == students.length) {
		StudentBean[] newArr = new StudentBean[count + 2];
		System.arraycopy(students, 0, newArr, 0, count);
		students = newArr;
		}
		students[count++] = student;
		
		/*if(this.count == students.length) {
			StudentBean[] newStudent = new StudentBean[count + 2];
		//newStudent = students;
		System.arraycopy(students, 0, newStudent, 0, count);
		//students는 초기값, 몇번째 자리까지 복사 할 것인가,복사할 곳, newstudent의 복사될 위치, 원본의 총 길이
		*/
		

	}

	@Override
	public void addScore(StudentBean score) {

	}

	@Override
	public StudentBean login(StudentBean login) {

		return null;
	}

	@Override
	public StudentBean find(String id) {
		return null;
	}

	@Override
	public StudentBean[] list() {

		return students;
	}

	@Override
	public StudentBean findStudentById(String id) {
		StudentBean student = new StudentBean();
		for (int i = 0; i < count; i++) {
			// 검색엔지의 기본은 외부에서 넘어온 정보를 가지고 나머지 변수들을 비교하는 것이 기본이다.
			if (id.equals(students[i].getId())) {
				student = students[i];
				break;
			}
		}
		return student;
	}

	@Override
	public StudentBean[] findStudentByName(String name) {
		int limit = 0;
		for (int i = 0; i < count; i++) {
			if (name.equals(students[i].getName())) {
				// student[j] = students[i];
				limit++;

			}
		}
		StudentBean[] student = new StudentBean[limit];
		if (limit != 0) {
			int j = 0;
			for (int i = 0; i < count; i++) {
				if (name.equals(students[i].getName())) {
					student[j] = students[i];
					j++;
					if(j == limit) {
						break;
					}
				}
			}
		}
		return student;
	}

	@Override
	public void updatePassword(StudentBean student) {
		
		for(int i = 0; i < count; i++) {
			if(student.getId().equals(students[i].getId())) {
			this.students[i].setPw(student.getPw()); 
		break;
		
			}
		
		}
		//StudentBean t = findStudentById(student.getId());
		//t.setPw(student.getPw());
		//findStudentById(student.getId()).setPw(student.getPw());	
	}

	@Override
	public void delId(String id) {
		for(int i = 0; i < count; i++) {
			if(id.equals(students[i].getId())) {
			this.students[i] = null;
			this.students[i] = this.students[count-1]; 
			students[count-1]=null;
			count--;
			break;			
		}
		}
	}

}