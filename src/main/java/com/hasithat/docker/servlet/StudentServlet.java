package com.hasithat.docker.servlet;

import com.hasithat.docker.dao.StudentDao;
import com.hasithat.docker.dao.StudentDaoImpl;
import com.hasithat.docker.model.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String lIST_STUDENT = "/listStudents.jsp";
	public static final String INSERT = "/student.jsp";
	private StudentDao dao = new StudentDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		 if (action.equalsIgnoreCase("insert")) {
			forward = INSERT;
		} else {
			forward = lIST_STUDENT;
			request.setAttribute("students", dao.getAllStudents());

		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Student student = new Student();
		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		student.setYear(Integer.parseInt(request.getParameter("year")));


		dao.addStudent(student);

		RequestDispatcher view = request.getRequestDispatcher(lIST_STUDENT);
		request.setAttribute("students", dao.getAllStudents());
		view.forward(request, response);
	}
}
