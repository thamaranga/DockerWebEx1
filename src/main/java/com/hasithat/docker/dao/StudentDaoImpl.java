package com.hasithat.docker.dao;

import com.hasithat.docker.model.Student;
import com.hasithat.docker.util.DBConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class StudentDaoImpl implements StudentDao{

	@Override
	public void addStudent(Student student) {
		try(Connection conn = DBConnectionUtility.getDBConnection()) {
			String query = "insert into student (firstName, lastName, year) values (?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastName());
			preparedStatement.setInt(3, student.getYear());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}





	@Override
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		try(Connection conn = DBConnectionUtility.getDBConnection()) {			
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from student");
			while (resultSet.next()) {
				Student student = new Student();
				student.setFirstName(resultSet.getString("firstName"));
				student.setLastName(resultSet.getString("lastName"));
				student.setYear(resultSet.getInt("year"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}


}
