package member.model.service;

import java.sql.Connection;

import common.JDBCTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {
		
	private MemberDAO mDao;
	
	public MemberService() {
		mDao = new MemberDAO();
	}
	/**
	 * 회원로그인
	 * @param memberId
	 * @param memberPw
	 * @return result
	 */
	public int selectCheckLogin(String memberId, String memberPw) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();//DB 연결 생성 후
		result = mDao.selectCheckLogin(conn, memberId, memberPw); // DAO 에 전달
		return result;
	}
	/**
	 * 아이디로 조회 Service
	 * @param memberId
	 * @return
	 */
	public Member printOneById(String memberId) {
		Member member = null;
		Connection conn = JDBCTemplate.getConnection();
		member = mDao.selectOneById(conn, memberId);
		return member;
	}
	/**
	 * 회원 가입 Service
	 * @param member
	 * @return
	 */
	public int registerMember(Member member) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = mDao.insertMember(conn, member);
		if(result>0) {
			//커밋
			JDBCTemplate.commit(conn);
		}else {
			//롤백
			JDBCTemplate.rollback(conn);
		}
		//연결해제
		
		return result;
	}
}
