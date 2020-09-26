package org.student;

import org.department.Department;

public class Student extends Department {

	public void studentName() {
		System.out.println("Student Name:Mithra Sridhar");

	}
	
	public void studentDept() {
		System.out.println("Student Dept: Chemistry");

	}
	
	public void studentID() {
		System.out.println("Student ID:706133");

	}
	
	
	public static void main(String[] args) {

		Student std = new Student();
		std.collegeCode();
		std.collegeName();
		std.collegeRank();
		std.deptName();
		std.studentName();
		std.studentDept();
		std.studentID();
		
	}

}
