package student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.model.service.StudentService;
import student.model.vo.Student;

/**
 * Servlet implementation class studentEnrollServlet
 */
@WebServlet("/student/enroll.do")
public class studentEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentEnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/student/enroll.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String studentId = request.getParameter("student-id");
		String studentPw = request.getParameter("student-pw");
		String studentName = request.getParameter("student-name");
		String studentEmail = request.getParameter("student-email");
		String studentPhone = request.getParameter("student-phone");
		String studentAddress = request.getParameter("student-address");
		String studentGender = request.getParameter("student-gender");
		Student student = new Student();
		student.setStudentId(studentId);
		student.setStudentPw(studentPw);
		student.setStudentName(studentName);
		student.setStudentEmail(studentEmail);
		student.setStudentPhone(studentPhone);
		student.setStudentAddress(studentAddress);
		student.setStudentGender(studentGender);
		StudentService sService = new StudentService();
		int result = sService.registerStudent(student);
		if(result>0){
			response.sendRedirect("/login1.jsp");
			
		}else {
			request.setAttribute("title", "????????????");
			request.setAttribute("msg", "???????????? ???????????? ?????????");
			request.getRequestDispatcher("/WEB-INF/views/student/error.jsp").forward(request, response);
		}
	}

}
