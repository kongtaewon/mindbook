package kr.co.dong.mindbook;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MdDTO {

    private int CALENDAR_NO;
    private String CALENDAR_TITLE;
    private String CALENDAR_MEMO;
    private Date CALENDAR_START;
    private Date CALENDAR_END;
    private String user_uid;

    public int getCALENDAR_NO() {
        return CALENDAR_NO;
    }

    public void setCALENDAR_NO(int cALENDAR_NO) {
        CALENDAR_NO = cALENDAR_NO;
    }

    public String getCALENDAR_TITLE() {
        return CALENDAR_TITLE;
    }

    public void setCALENDAR_TITLE(String cALENDAR_TITLE) {
        CALENDAR_TITLE = cALENDAR_TITLE;
    }

    public String getCALENDAR_MEMO() {
        return CALENDAR_MEMO;
    }

    public void setCALENDAR_MEMO(String cALENDAR_MEMO) {
        CALENDAR_MEMO = cALENDAR_MEMO;
    }

    public Date getCALENDAR_START() {
        return CALENDAR_START;
    }

    public void setCALENDAR_START(Date cALENDAR_START) {
        CALENDAR_START = cALENDAR_START;
    }

    public Date getCALENDAR_END() {
        return CALENDAR_END;
    }

    public void setCALENDAR_END(Date cALENDAR_END) {
        CALENDAR_END = cALENDAR_END;
    }

    public String getUser_uid() {
        return user_uid;
    }

    public void setUser_uid(String user_uid) {
        this.user_uid = user_uid;
    }

    // Add a method to get formatted string for CALENDAR_START
    public String getFormattedStartDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(CALENDAR_START);
    }

    // Modify the toString method to use the formatted date
    @Override
    public String toString() {
        return "MdDTO [CALENDAR_NO=" + CALENDAR_NO + ", CALENDAR_TITLE=" + CALENDAR_TITLE +
                ", CALENDAR_MEMO=" + CALENDAR_MEMO + ", CALENDAR_START=" + getFormattedStartDate() +
                ", CALENDAR_END=" + CALENDAR_END + ", user_uid=" + user_uid + "]";
    }
}
