package edu.berkeley.zouxuan.tripbuddy;

/**
 * Created by zouxuan on 4/20/17.
 */

public class HistoryData {
    private int imageId;
    private String title;
    private String content;

    public HistoryData(int imageId, String title, String content) {
        this.imageId = imageId;
        this.title = title;
        this.content = content;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
