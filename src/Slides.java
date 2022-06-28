import java.util.Date;

public class Slides implements Lecture{
    String[] content;
    int number;
    String topic;
    Instructor instructor;
    Date date;
    Slides(String[] scontent, String stopic, Instructor Sinstructor, int snumber){
        content = scontent;
        topic = stopic;
        instructor = Sinstructor;
        number = snumber;
        date = new Date();
    }
    @Override
    public void display(){
        System.out.println("Title: " + topic);
        for(int i = 0; i < content.length; i++){
            System.out.println("Slide " + (i+1) + ": " + content[i]);
        }
        System.out.println("Number of Slides: " + number);
        System.out.println("Date of Upload: " + date);
        System.out.println("Uploaded by: " + instructor.name);
    }
}
