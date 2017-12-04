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

	public StudentServiceImpl(int count) {
		this.count = 0;
		students = new StudentBean[count];

	}

	@Override
	public void addStudent(StudentBean student) {
		students[count] = student;
		count++;

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
}