package com.javatest.ex;

public class Student {

	private String name;
	private int age;
	private String gradeNum;
	private String classNum;
	
	public void getStudentInfo() { // 핵심기능
		System.out.println("이름 :" + getName());
		System.out.println("나이 :" + getAge());
		System.out.println("학년 :" + getGradeNum());
		System.out.println("반 :" + getGradeNum());
		
		// 강제로 에러 발생시켜 afterthrowadvice 확인
		//int i = 10/0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGradeNum() {
		return gradeNum;
	}
	public void setGradeNum(String gradeNum) {
		this.gradeNum = gradeNum;
	}
	public String getClassNum() {
		return classNum;
	}
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	
	
}
