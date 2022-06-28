public class Student {
    String name;
    Assessment[] assessments = new Assessment[100];
    String[] arr = new String[100];
    float[] grades = new float[100];
    String[] instructors = new String[100];
    int acount = 0;
    Student(String myname){
        name = myname;
    }
    void insert(Assessment Sassessments){
        assessments[acount] = Sassessments;
        acount++;
    }
    void submit(int count, String Sanswer){
        arr[count] = Sanswer;
    }
    void mark(int count, float marks, String name){
        grades[count] = marks;
        instructors[count] = name;
    }
}
