package wcmc.schoolcard.dto;

import java.math.BigDecimal;

public class Webztc {
    private BigDecimal id;

    private String ztc;

    private BigDecimal nums;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getZtc() {
        return ztc;
    }

    public void setZtc(String ztc) {
        this.ztc = ztc;
    }

    public BigDecimal getNums() {
        return nums;
    }

    public void setNums(BigDecimal nums) {
        this.nums = nums;
    }
}