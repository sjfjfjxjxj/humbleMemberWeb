package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
//http://127.0.0.1:8888/member/remove.kh?member-id=khuser01
/**
 * Servlet implementation class RemoveServlet
 */
@WebServlet("/member/remove.kh")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("member-id");
		MemberService mService = new MemberService();
		int result = mService.deleteMember(memberId);
		if(result>0) {
			response.sendRedirect("/index.jsp"); //여기 바꿔야혀...
		}else {
			request.setAttribute("title", "삭제실패");
			request.setAttribute("msg", "다시혀");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
		
	}

}
