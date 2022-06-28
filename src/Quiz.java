public class Quiz implements Assessment{
    String question;
    Instructor instructor;
    String status = "Open";
    String submission = "Pending";
    String type;
    Quiz(String Qquestion, Instructor Qinstructor, String Qtype){
        question = Qquestion;
        instructor = Qinstructor;
        type = Qtype;
    }
    @Override
    public void display(){
        System.out.println("Question: " + question);
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
        return 0;
    }
}
