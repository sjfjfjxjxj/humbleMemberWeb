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
 * Servlet implementation class EnrollServlet
 */
@WebServlet("/member/enrollView.kh")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/WEB-INF/views/member/enroll.jsp").forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//한글로 입력한 이름, 주소, 취미가 깨지지않게 함
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String memberName = request.getParameter("member-name");
		int memberAge = Integer.parseInt(request.getParameter("member-age"));
		String memberEmail = request.getParameter("member-email");
		String memberPhone = request.getParameter("member-phone");
		String memberAddress = request.getParameter("member-address");
		String memberGender = request.getParameter("member-gender");
		String memberHobby = request.getParameter("member-hobby");
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setMemberName(memberName);
		member.setMemberAge(memberAge);
		member.setMemberEmail(memberEmail);
		member.setMemberPhone(memberPhone);
		member.setMemberAddress(memberAddress);
		member.setMemberGender(memberGender);
		member.setMemberHobby(memberHobby);
		MemberService mService = new MemberService();
		int result = mService.registerMember(member);
		if(result>0) {
			//가입성ㄱ송->index.jsp로 이동
			//방법1.
			//request.setAttribute("result", result);
			//request.getRequestDispatcher("/index.jsp").forward(request, response);이렇게 응답결과 보여줄필요 없음
			//방법2. 단순이동. 
			//전달값으로 페이지 경로 가능, URL(doGet으로 동작하는) 가능
			response.sendRedirect("/index.jsp");
		}else {
			//가입실패
			request.setAttribute("title", "회원가입 실패!");
			request.setAttribute("msg", "회원가입이 완료되지 않았습니다!");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

}
