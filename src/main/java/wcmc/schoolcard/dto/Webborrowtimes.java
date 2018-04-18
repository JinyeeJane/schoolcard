package wcmc.schoolcard.dto;

import java.math.BigDecimal;

public class Webborrowtimes {
    private String studentId;

    private BigDecimal borrowTimes;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public BigDecimal getBorrowTimes() {
        return borrowTimes;
    }

    public void setBorrowTimes(BigDecimal borrowTimes) {
        this.borrowTimes = borrowTimes;
    }
}