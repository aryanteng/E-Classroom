import java.util.Date;

public class Videos implements Lecture{
    String topic;
    String filename;
    Instructor instructor;
    Date date;
    Videos(String vtopic, String vfile, Instructor Vinstructor){
        topic = vtopic;
        filename = vfile;
        instructor = Vinstructor;
        date = new Date();
    }
    @Override
    public void display(){
        System.out.println("Title of video: " + topic);
        System.out.println("Video File: " + filename);
        System.out.println("Date of Upload: " + date);
        System.out.println("Uploaded by: " + instructor.name);
    }
}
