package wcmc.schoolcard.dto;

import java.math.BigDecimal;

public class Webcanteen {
    private String studentId;

    private BigDecimal canteenTimes;

    private BigDecimal canteenSum;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public BigDecimal getCanteenTimes() {
        return canteenTimes;
    }

    public void setCanteenTimes(BigDecimal canteenTimes) {
        this.canteenTimes = canteenTimes;
    }

    public BigDecimal getCanteenSum() {
        return canteenSum;
    }

    public void setCanteenSum(BigDecimal canteenSum) {
        this.canteenSum = canteenSum;
    }
}