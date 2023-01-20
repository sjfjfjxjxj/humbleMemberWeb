package student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.model.service.StudentService;
import student.model.vo.Student;

/**
 * Servlet implementation class StudentLoginServlet
 */
@WebServlet("/student/login.do")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/student/login.jsp").forward(request, response); //forward안쓰면 흰화면뜬다!!
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentId=request.getParameter("student-id");
		String studentPw=request.getParameter("student-pw");
		Student student = new Student(studentId, studentPw);
		StudentService stdService = new StudentService();
		Student sOne = stdService.selectCheckLogin(student);
		if(sOne != null) {
			HttpSession session = request.getSession();
			session.setAttribute("studentId", studentId);
			response.sendRedirect("/login1.jsp");
			//성공
			//request.getRequestDispatcher("/WEB-INF/views/student/loginSuccess.jsp").forward(request, response);
		}else {
			//실패
			request.setAttribute("title", "로그인실패...");
			request.setAttribute("msg", "아이디 비번 확인 바람...");
			request.getRequestDispatcher("/WEB-INF/views/student/error.jsp").forward(request, response);
		}
		
	}

}
