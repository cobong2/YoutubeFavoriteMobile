package psw.com.youtubefavorite.models;

import com.google.gson.annotations.SerializedName;

public class YoutubeVO {
    @SerializedName("y_no")
    private int y_no;
    @SerializedName("y_url")
    private String y_url;
    @SerializedName("y_regdate")
    private String y_regdate;
    @SerializedName("y_title")
    private String y_title;

    public int getY_no() {
        return y_no;
    }

    public void setY_no(int y_no) {
        this.y_no = y_no;
    }

    public String getY_url() {
        return y_url;
    }

    public void setY_url(String y_url) {
        this.y_url = y_url;
    }

    public String getY_regdate() {
        return y_regdate;
    }

    public void setY_regdate(String y_regdate) {
        this.y_regdate = y_regdate;
    }

    public String getY_title() {
        return y_title;
    }

    public void setY_title(String y_title) {
        this.y_title = y_title;
    }
}
