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
 * Servlet implementation class StudentMyInfo
 */
@WebServlet("/student/myinfo.do")
public class StudentMyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentMyInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentId = request.getParameter("student-id");
		if(studentId != null) {
			StudentService sService = new StudentService();
			Student student = sService.printOneById(studentId);
			request.setAttribute("student", student);
			request.getRequestDispatcher("/WEB-INF/views/student/myinfo.jsp").forward(request, response);
		}else {
			request.setAttribute("title", "아이디 조회 실패");
			request.setAttribute("msg", "해당데이터 없음...");
			request.getRequestDispatcher("/WEB-INF/view/student/error.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
