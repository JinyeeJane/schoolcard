package wcmc.schoolcard.dto;

/**
 * Created by Channings on 18/4/18.
 */
public class Result4Hotbook {
    String bookid;
    String title;
    String borrowtimes;

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBorrowtimes() {
        return borrowtimes;
    }

    public void setBorrowtimes(String borrowtimes) {
        this.borrowtimes = borrowtimes;
    }
}
