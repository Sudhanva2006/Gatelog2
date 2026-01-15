// File: gatelog/StudentExit.java
package gatelog;

public class StudentExit {
    private String usn;
    private String studentName;
    private String department;
    private int year;
    private String reason;
    private String approvedBy;

    public StudentExit() {}

    public StudentExit(String usn, String studentName, String department, int year, String reason, String approvedBy) {
        this.usn = usn;
        this.studentName = studentName;
        this.department = department;
        this.year = year;
        this.reason = reason;
        this.approvedBy = approvedBy;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }
}