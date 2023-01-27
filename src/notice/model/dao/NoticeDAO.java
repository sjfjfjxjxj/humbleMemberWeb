package notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import notice.model.vo.Notice;

public class NoticeDAO {

	/**
	 * 공지사항 등록 dao
	 * @param conn
	 * @param notice
	 * @return result
	 */
	public int insertNotice(Connection conn, Notice notice) {
		String sql="INSERT INTO NOTICE_TBL VALUES(SEQ_NOTICENO.NEXTVAL,?,?,?,DEFAULT,DEFAULT)";
		//에러: java.sql.SQLSyntaxErrorException: ORA-02289: sequence does not exist 시퀀스 만들어졌는지 확인할것ㅠ
		int result=0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice.getNoticeSubject());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setString(3, "admin");
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * 공지사항 전체목록 조회 dao
	 * @param conn
	 * @return nList
	 */													
	public List<Notice> sellectAllNotice(Connection conn, int currentPage/*, int recordCountPerPage*페이지에몇개씩보이게하기*/) {
		String sql="SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY NOTICE_NO DESC) AS NUM, NOTICE_TBL.* FROM NOTICE_TBL) WHERE NUM BETWEEN ? AND ?";
		//페이징처리하려고(글 열개씩 최신거부터 보이게하기)
		List<Notice> nList=null;
		int recordCountPerPage = 10;
		//커런트페이지: 한페이지에서 시작하는 글 no 
		//currentPage: 1, recordCountPerPage : 10 
		//currentPage: 11, recordCountPerPage : 20 
		//
		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage*recordCountPerPage;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rset = pstmt.executeQuery();
			
			nList = new ArrayList<Notice>();
			while(rset.next()) {
				Notice notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeSubject(rset.getString("NOTICE_SUBJECT"));
				notice.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				notice.setNoticeWriter(rset.getString("NOTICE_WRITER"));
				notice.setNoticeDate(rset.getTimestamp("NOTICE_DATE"));
				notice.setViewCount(rset.getInt("VIEW_COUNT"));
				nList.add(notice);
			}
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return nList;
	}

	//페이지 네비게이터 만들어주는 메소드
	public String generatePageNavi(Connection conn, int currentPage) {
		//커런트페이지: 한페이지에서 시작하는 글 no : 1, 11, 21...
				//currentPage: 1, recordCountPerPage : 10 
				//currentPage: 11, recordCountPerPage : 20 		 
		int totalCount = getRecordTotalCount(conn); //디비에서 갖고오기. 총 글 개수(밑에서 메소드 가져오기
		int recordCountPerPage = 10; //얜 고정(일단). 한페이지에 보여줄 글 개수
		int naviTotalCount = 0;
		if(totalCount%recordCountPerPage==0) {
			naviTotalCount=totalCount/recordCountPerPage;
		}else {
			naviTotalCount=totalCount/recordCountPerPage+1;
		}
		
		int naviCountPerPage = 5; //밑에 페이지 개수 표시
		//12345
		//678910
		//11
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage + 1; //(1->1, 11->3?, 21->, 31, 41)????수학ㅜㅜ
		int endNavi = startNavi + naviCountPerPage -1;//???????
		if(endNavi>naviTotalCount) {
			endNavi = naviTotalCount;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href = '/notice/list?page="+i+"'>"+i+"</a>");		
		}
		return sb.toString();
	}
	
	//페이지 전체 게시물 가져오는 메소드
	public int getRecordTotalCount(Connection conn) {
		String sql = "SELECT COUNT(*) AS TOTAL_COUNT FROM NOTICE_TBL";
		int recordTotalCount = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTAL_COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recordTotalCount;
	}
	
	
	/**
	 * 공지사항 상세조회(내용보기) dao
	 * @param conn
	 * @param noticeNo
	 * @return notice
	 */
	public Notice selectOneByNo(Connection conn, int noticeNo) {
		String sql = "SELECT * FROM NOTICE_TBL WHERE NOTICE_NO = ?";
		Notice notice = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()) {
				notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeSubject(rset.getString("NOTICE_SUBJECT"));
				notice.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				notice.setNoticeWriter(rset.getString("NOTICE_WRITER"));
				notice.setNoticeDate(rset.getTimestamp("NOTICE_DATE"));
				notice.setViewCount(rset.getInt("VIEW_COUNT"));
			}
			pstmt.close();
			rset.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}

	/**
	 * 공지사항 삭제 dao
	 * @param conn
	 * @param noticeNo
	 * @return result
	 */
	public int deleteNotice(Connection conn, int noticeNo) {
		String sql="DELETE FROM NOTICE_TBL WHERE NOTICE_NO=?";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 공지사항 수정dao
	 * @param conn
	 * @param notice
	 * @return result
	 */
	public int updateNotice(Connection conn, Notice notice) {
		String sql="UPDATE NOTICE_TBL SET NOTICE_SUBJECT =?, NOTICE_CONTENT=? WHERE NOTICE_NO=?";
		int result = 0;
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);		
			pstmt.setString(1, notice.getNoticeSubject());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setInt(3, notice.getNoticeNo());
			result = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
