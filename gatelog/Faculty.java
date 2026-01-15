// File: gatelog/Faculty.java
package gatelog;
import gatelog.StudentExitDAO;
import java.sql.SQLException;

public class Faculty {
    public void addStudentExit(StudentExit exit) throws SQLException {
        exit.setApprovedBy("Faculty");
        StudentExitDAO dao = new StudentExitDAO();
        dao.addStudentExit(exit);
    }
}