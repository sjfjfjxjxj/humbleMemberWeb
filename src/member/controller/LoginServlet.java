package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/member/login.kh")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// 두겟은 넘기는 값이 보여서 안되고 두포스트로 안보이게 해야한대!
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("member-id");// 폼택 인풋택 네임값이 ""인 애를 가져와!
		String memberPw = request.getParameter("member-pw");
		// System.out.println(memberId+","+memberPw);

		MemberService mService = new MemberService();
		int result = mService.selectCheckLogin(memberId, memberPw);
		// System.out.println(result); //로그인 잘되면 콘솔창에 1이 나타나겠지...!
		if (result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("memberId", memberId);
			response.sendRedirect("/index.jsp");
			//로그인 성공!... 근데 로그인정보가 저장되지 않으므로 이건 쓸모없다 ㅠ
//			request.setAttribute("memberId", memberId);
//			RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
//			view.forward(request, response);
		} else {//실패!!
			request.setAttribute("title", "로그인 실패");
			request.setAttribute("msg", "아이디와 비밀번호를 확인해주세요!");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/error.jsp");
			view.forward(request, response);
		}
	}
}
