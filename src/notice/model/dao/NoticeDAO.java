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

	public List<Notice> sellectAllNotice(Connection conn) {
		String sql="SELECT * FROM NOTICE_TBL";
		List<Notice> nList=null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
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
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return nList;
	}

}
