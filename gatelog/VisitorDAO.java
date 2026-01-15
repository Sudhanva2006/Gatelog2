// File: gatelog/VisitorDAO.java
package gatelog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VisitorDAO {
    public void addVisitor(Visitor visitor) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO visitor_log (name, phone, purpose, in_time, out_time) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, visitor.getName());
        pstmt.setString(2, visitor.getPhone());
        pstmt.setString(3, visitor.getPurpose());
        pstmt.setString(4, visitor.getInTime());
        pstmt.setString(5, visitor.getOutTime());
        pstmt.executeUpdate();
    }

    public List<Visitor> getAllVisitors() throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM visitor_log";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Visitor> visitors = new ArrayList<>();
        while (rs.next()) {
            Visitor v = new Visitor();
            v.setId(rs.getInt("id"));
            v.setName(rs.getString("name"));
            v.setPhone(rs.getString("phone"));
            v.setPurpose(rs.getString("purpose"));
            v.setInTime(rs.getString("in_time"));
            v.setOutTime(rs.getString("out_time"));
            visitors.add(v);
        }
        return visitors;
    }
}