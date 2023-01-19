package student.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import student.model.vo.Student;

public class StudentDAO {

	public Student selectCheckLogin(Connection conn, Student student) {
		String sql="SELECT * FROM STUDENT_TBL WHERE ST_ID=? AND ST_PW=?";
		Student sOne = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getStudentId());
			pstmt.setString(2, student.getStudentPw());
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()) {
				sOne = new Student();
				sOne.setStudentId(rset.getString("ST_ID"));
				sOne.setStudentPw(rset.getString("ST_PW"));
				sOne.setStudentName(rset.getString("ST_NAME"));
				sOne.setStudentEmail(rset.getString("ST_EMAIL"));
				sOne.setStudentPhone(rset.getString("ST_PHONE"));
				sOne.setStudentAddress(rset.getString("ST_ADDR"));
				sOne.setStudentGender(rset.getString("ST_GENDER"));
				sOne.setStudentDate(rset.getDate("ST_DATE"));
				
			}
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sOne;
	}
	/**
	 * 회원가입DAO
	 * @param conn
	 * @param student
	 * @return
	 */
	public int insertStudent(Connection conn, Student student) {
		String sql="INSERT INTO STUDENT_TBL VALUES(?,?,?,?,?,?,?, DEFAULT)";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getStudentId());
			pstmt.setString(2, student.getStudentPw());
			pstmt.setString(3, student.getStudentName());
			pstmt.setString(4, student.getStudentEmail());
			pstmt.setString(5, student.getStudentPhone());
			pstmt.setString(6, student.getStudentAddress());
			pstmt.setString(7, student.getStudentGender());
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public Student selectOneById(Connection conn, String studentId) {
		String sql = "SELECT * FROM STUDENT_TBL WHERE ST_ID=?";
		Student student = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, studentId);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()) {
				student = new Student();
				student.setStudentId(rset.getNString(1));
				student.setStudentPw(rset.getNString(2));
				student.setStudentName(rset.getNString(3));
				student.setStudentEmail(rset.getNString(4));
				student.setStudentPhone(rset.getNString(5));
				student.setStudentAddress(rset.getNString(6));
				student.setStudentGender(rset.getNString(7));
				student.setStudentDate(rset.getDate(8));
			}
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

}
