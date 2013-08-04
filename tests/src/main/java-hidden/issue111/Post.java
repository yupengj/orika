package issue111;

import java.sql.Timestamp;

public class Post {
    public Integer id;
    public String message;
    public Timestamp createdTime;
    public From from;
    public String link;
}