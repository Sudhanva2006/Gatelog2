// File: gatelog/Admin.java
package gatelog;

import java.sql.SQLException;
import java.util.List;

public class Admin {
    public void addVisitor(Visitor visitor) throws SQLException {
        VisitorDAO dao = new VisitorDAO();
        dao.addVisitor(visitor);
    }

    public List<Visitor> getAllVisitors() throws SQLException {
        VisitorDAO dao = new VisitorDAO();
        return dao.getAllVisitors();
    }

    public StudentExit verifyStudentExit(String usn) throws SQLException {
        StudentExitDAO dao = new StudentExitDAO();
        return dao.getStudentExit(usn);
    }
}