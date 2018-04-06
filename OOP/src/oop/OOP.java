
package oop;


public class OOP {
    private String studentName;
    private long studentId;

    public OOP() {
    }

    public OOP(String studentName, long studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "OOP{" + "studentName=" + studentName + ", studentId=" + studentId + '}';
    }
    
}
