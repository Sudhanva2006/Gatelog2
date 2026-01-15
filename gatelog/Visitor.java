// File: gatelog/Visitor.java
package gatelog;

public class Visitor {
    private int id;
    private String name;
    private String phone;
    private String purpose;
    private String inTime;
    private String outTime;

    public Visitor() {}

    public Visitor(String name, String phone, String purpose, String inTime, String outTime) {
        this.name = name;
        this.phone = phone;
        this.purpose = purpose;
        this.inTime = inTime;
        this.outTime = outTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }
}