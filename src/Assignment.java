import java.util.Date;

public class Assignment implements Assessment{
    String name;
    Instructor instructor;
    Date date;
    String status = "Open";
    String submission = "Pending";
    String type;
    int marks;
    Assignment(String aname, Instructor Qinstructor, String Atype, int Amarks){
        name = aname;
        instructor = Qinstructor;
        date = new Date();
        type = Atype;
        marks = Amarks;
    }
    @Override
    public void display(){
        System.out.println("Assignment: " + name + " Max Marks: " + marks);
    }
    @Override
    public void close(){
        status = "Closed";
    }
    @Override
    public String get_status(){
        return status;
    }
    @Override
    public String sub_status(){
        return submission;
    }
    @Override
    public void submit(){
        submission = "Submitted";
    }
    @Override
    public String type(){return type;}
    @Override
    public float getmarks(){
        return marks;
    }
}
