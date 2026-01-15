// File: gatelog/StudentExitDAO.java
package gatelog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentExitDAO {
    public void addStudentExit(StudentExit exit) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO student_exit (usn, student_name, department, year, reason, approved_by) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, exit.getUsn());
        pstmt.setString(2, exit.getStudentName());
        pstmt.setString(3, exit.getDepartment());
        pstmt.setInt(4, exit.getYear());
        pstmt.setString(5, exit.getReason());
        pstmt.setString(6, exit.getApprovedBy());
        pstmt.executeUpdate();
    }

    public StudentExit getStudentExit(String usn) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM student_exit WHERE usn = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, usn);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            StudentExit s = new StudentExit();
            s.setUsn(rs.getString("usn"));
            s.setStudentName(rs.getString("student_name"));
            s.setDepartment(rs.getString("department"));
            s.setYear(rs.getInt("year"));
            s.setReason(rs.getString("reason"));
            s.setApprovedBy(rs.getString("approved_by"));
            return s;
        }
        return null;
    }
}