package wcmc.schoolcard.dto;

import java.util.Date;

public class Webcollection extends WebcollectionKey {
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}