import java.util.Date;

public class Comment {
    String cname;
    Date date;
    String message;
    Comment(String name, String comment){
        cname = name;
        message = comment;
        date = new Date();
    }
    void view(){
        System.out.println(message + " - " + cname);
        System.out.println(date);
    }
}
