package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.model.vo.Member;

public class MemberDAO {

	public int selectCheckLogin(Connection conn, String memberId, String memberPw) {
		String query ="SELECT COUNT(*) AS M_COUNT FROM MEMBER_TBL WHERE MEMBER_ID = ? AND MEMBER_PW= ?";
		int result = 0;
		//커리문 실행준비
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId); //member로 받아서 member!=null로 확인해도 됨
			pstmt.setString(2, memberPw); //완료
			//쿼리문 실행
			//결과받기
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("M_COUNT");
			}
			//자원해제
			pstmt.close();
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return result; //서블렛으로 가유
	}
	/**
	 * 아이디로 조회 DAO
	 * @param conn
	 * @param memberId
	 * @return
	 */
	public Member selectOneById(Connection conn, String memberId) {
		String sql = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID=?";
		Member member = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPw(rset.getString("MEMBER_PW"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberAge(rset.getInt("MEMBER_AGE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberAddress(rset.getString("MEMBER_ADDR"));
				member.setMemberGender(rset.getString("MEMBER_GENDER"));
				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
				member.setMemberDate(rset.getTimestamp("MEMBER_DATE"));
			}
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	/**
	 * 회원가입 DAO
	 * @param conn
	 * @param member
	 * @return
	 */
	public int insertMember(Connection conn, Member member) {
		String sql="INSERT INTO MEMBER_TBL VALUES(?,?,?,?,?,?,?,?,?,DEFAULT)";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setInt(4, member.getMemberAge());
			pstmt.setString(5, member.getMemberEmail());
			pstmt.setString(6, member.getMemberPhone());
			pstmt.setString(7, member.getMemberAddress());
			pstmt.setString(8, member.getMemberGender());
			pstmt.setString(9, member.getMemberHobby());
			result = pstmt.executeUpdate(); //DML은 Update....
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
