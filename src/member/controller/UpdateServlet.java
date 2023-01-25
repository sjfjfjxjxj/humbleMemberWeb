package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/member/update.kh")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//비번 이멜 주소 폰 취미 +아이디
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String memberEmail = request.getParameter("member-email");
		String memberPhone = request.getParameter("member-phone");
		String memberAddress = request.getParameter("member-address");
		String memberHobby = request.getParameter("member-hobby");
		Member member = new Member(memberId, memberPw, memberEmail, memberPhone, memberAddress, memberHobby); //여기 순서 조심혀ㅕㅕㅕㅕㅕㅕㅕㅕㅕ
		MemberService mService = new MemberService();
		int result = mService.updateMember(member);
		if(result>0) {
			response.sendRedirect("/index.jsp");
		}else {
			//실패 에러페이지
			request.setAttribute("title", "정보수정실패");
			request.setAttribute("msg", "정보 수정 완료 안됐엄");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
		
	}

}
