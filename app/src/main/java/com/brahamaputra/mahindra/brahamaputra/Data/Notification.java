package com.brahamaputra.mahindra.brahamaputra.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notification {

    public static final String TABLE_NAME = "notifications";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_MESSAGE = "message";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_ISREAD = "isRead";

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_TITLE + " TEXT,"
                    + COLUMN_MESSAGE + " TEXT,"
                    + COLUMN_TIMESTAMP + " TEXT,"
                    + COLUMN_ISREAD + " INTEGER DEFAULT 0"
                    + ");";

    private int id;
    private int isRead;



    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("is_background")
    @Expose
    private Boolean isBackground;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("image")
    @Expose
    private String image;
    /*@SerializedName("payload")
    @Expose
    private Payload payload;*/
    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getIsBackground() {
        return isBackground;
    }

    public void setIsBackground(Boolean isBackground) {
        this.isBackground = isBackground;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /*public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }*/

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public Notification(){}

    public Notification(String title, Boolean isBackground, String message, String image, String timestamp) {
        this.title = title;
        this.isBackground = isBackground;
        this.message = message;
        this.image = image;
        this.timestamp = timestamp;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
