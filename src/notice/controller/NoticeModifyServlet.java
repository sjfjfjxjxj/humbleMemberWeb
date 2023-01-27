package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeModifyServlet
 */
@WebServlet("/notice/modify")
public class NoticeModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 수정페이지 보여주기
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//NumberFormatException방지
		String strNo = request.getParameter("notice-no") != null? request.getParameter("notice-no"):"0";
		int noticeNo = Integer.parseInt(strNo);
		NoticeService nService = new NoticeService();
		Notice notice = nService.selectOneByNo(noticeNo);
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("/WEB-INF/views/notice/modify.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String noticeSubject= request.getParameter("subject");
		String noticeContent=request.getParameter("content");
		String strNo = request.getParameter("notice-no") != null ? request.getParameter("notice-no") : "0";
		//조건식 ? 참"거짓 (삼항연산자)
		int noticeNo = Integer.parseInt(strNo);
		Notice notice = new Notice(noticeNo, noticeSubject, noticeContent);
		NoticeService nService = new NoticeService();
		int result = nService.updateNotice(notice);
		if(result>0) {
			//성공하면 디테일페이지
			response.sendRedirect("/notice/detail?notice-no="+noticeNo); 
			//쿼리스트링(?이하값) 안받으면 오류남(수정은성공) //java.lang.NumberFormatException: null
		}else {
			//실패하면 에러페이지
			request.setAttribute("title", "공지사항수정실패");
			request.setAttribute("msg", "공지사항 수정이 완료되지 않았습니다");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

}
