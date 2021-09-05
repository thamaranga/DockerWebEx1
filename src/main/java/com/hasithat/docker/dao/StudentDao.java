package com.hasithat.docker.dao;

import com.hasithat.docker.model.Student;

import java.util.List;



public interface StudentDao {
	
	public void addStudent(Student student);

	public List<Student> getAllStudents();

	}
