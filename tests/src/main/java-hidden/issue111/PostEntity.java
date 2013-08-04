package issue111;

import java.sql.Timestamp;

public class PostEntity {
    public Integer id;
    public String fromUser;
    public Timestamp creationTime;
    public String content;
    public String url;
    private Object user;
    
    public Object getUser() {
        return user;
    }
    
    public void setUser(Object user) {
        this.user = user;
    }
}