package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
    private int id;
    private String title;
    private String author;
    private String date;
    private int views;
    private String content;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public int getViews() {
        return views;
    }

    public String getContent() {
        return content;
    }

    public Board(int id, String title, String author, String date, int views, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.date = date;
        this.views = views;
        this.content = content;
    }

    public Board(int id, String title, String author, String content) {
        this.id = id;
        long time = System.currentTimeMillis();
        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.date = dayTime.format(new Date(time));
        this.views = 1;
        this.title = title;
        this.author = author;
        this.content = content;
    }
}