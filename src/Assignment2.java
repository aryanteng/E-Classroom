import java.util.Objects;
import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner s = new Scanner(System.in).useDelimiter("\n");
        Instructor[] instructors;
        instructors = new Instructor[2];
        Student[] students;
        students = new Student[3];
        Comment[] comments;
        comments = new Comment[100];
        Lecture[] lectures;
        lectures = new Lecture[100];
        Assessment[] assessments;
        assessments = new Assessment[100];
        instructors[0] = new Instructor("IO");
        instructors[1] = new Instructor("I1");
        students[0] = new Student("S0");
        students[1] = new Student("S1");
        students[2] = new Student("S2");
        int ccount = 0;
        int lcount = 0;
        int acount = 0;
        int tag = 0;
        label:
        while (tag == 0) {
            System.out.println("Welcome to Backpack!");
            System.out.println("1.Enter as Instructor");
            System.out.println("2.Enter as Student");
            System.out.println("3.Exit");
            int option = sc.nextInt();
            if (option == 3) {
                System.out.println("Thank you for using Backpack!");
                System.out.println("---------------------------------------------------------------------------------");
                tag++;
            } else if (option == 1) {
                System.out.println("Instructors: ");
                int x = 0;
                for (int i = 0; i < instructors.length; i++) {
                    System.out.println(i + " - " + instructors[i].name);
                    x++;
                }
                System.out.print("Choose ID: ");
                int id = sc.nextInt();
                if (id >= x){
                    System.out.println("Please enter a valid Instructor ID!");
                    continue label;
                }
                int flag = 0;
                bagel:
                while (flag == 0) {
                    System.out.println("Welcome " + instructors[id].name + "!");
                    System.out.println("-------------------------");
                    System.out.println("INSTRUCTOR MENU\n" +
                            "-------------------------\n" +
                            "1. Add class material\n" +
                            "2. Add assessments\n" +
                            "3. View lecture materials\n" +
                            "4. View assessments\n" +
                            "5. Grade assessments\n" +
                            "6. Close assessment\n" +
                            "7. View comments\n" +
                            "8. Add comments\n" +
                            "9. Logout");
                    int choose = sc.nextInt();
                    if (choose == 9) {
                        continue label;
                    } else if (choose == 1) {
                        System.out.println("1. Add Lecture Slide");
                        System.out.println("2. Add Lecture Video");
                        int lecture = sc.nextInt();
                        if (lecture == 1) {
                            System.out.print("Enter topic of slides: ");
                            String topic = s.next();
                            System.out.print("Enter number of slides: ");
                            int number_of_slides = sc.nextInt();
                            System.out.println("Enter content of slides: ");
                            String[] content = new String[number_of_slides];
                            for (int i = 0; i < number_of_slides; i++) {
                                System.out.print("Content of Slide " + (i + 1) + ": ");
                                content[i] = s.next();
                            }
                            lectures[lcount] = new Slides(content, topic, instructors[id], number_of_slides);
                            lcount++;
                        } else if (lecture == 2) {
                            System.out.print("Enter topic of video: ");
                            String topic = s.next();
                            System.out.print("Enter filename of video: ");
                            String filename = s.next();
                            if (filename.length() < 5) {
                                System.out.println("You need to upload a file with .mp4 extension!");
                                continue bagel;
                            }
                            String[] str = filename.split("");
                            String format = "";
                            for (int i = str.length - 4; i < str.length; i++) {
                                format += str[i];
                            }
                            if (Objects.equals(format, ".mp4")) {
                                lectures[lcount] = new Videos(topic, filename, instructors[id]);
                                lcount++;
                            } else {
                                System.out.println("You need to upload a file with .mp4 extension!");
                            }
                        }
                    } else if (choose == 8) {
                        System.out.print("Enter Comment: ");
                        String comment = s.next();
                        comments[ccount] = new Comment(instructors[id].name, comment);
                        ccount++;
                    } else if (choose == 7) {
                        int val = 0;
                        for (int i = 0; i < ccount; i++) {
                            comments[i].view();
                            val++;
                        }
                        if (val == 0){
                            System.out.println("There are no comments!");
                        }
                    } else if (choose == 2) {
                        System.out.println("1. Add Assignment");
                        System.out.println("2. Add Quiz");
                        int achoose = sc.nextInt();
                        if (achoose == 1) {
                            System.out.print("Enter Problem Statement: ");
                            String ps = s.next();
                            System.out.print("Enter Max Marks: ");
                            int mmarks = sc.nextInt();
                            assessments[acount] = new Assignment(ps, instructors[id], "Assignment", mmarks);
                            for(int i = 0; i < students.length; i++) {
                                students[i].insert(assessments[acount]);
                            }
                            acount++;
                        } else if (achoose == 2) {
                            System.out.print("Enter Quiz Question: ");
                            String question = s.next();
                            assessments[acount] = new Quiz(question, instructors[id], "Quiz");
                            for(int i = 0; i < students.length; i++) {
                                students[i].insert(assessments[acount]);
                            }
                            acount++;
                        }
                        else{
                            System.out.println("Please enter a valid assessment!");
                        }
                    } else if (choose == 4) {
                        int val = 0;
                        for (int i = 0; i < acount; i++) {
                            System.out.print("ID: " + i + " ");
                            assessments[i].display();
                            System.out.println("----------------");
                            val++;
                        }
                        if (val == 0){
                            System.out.println("There are no assessments!");
                        }
                    } else if (choose == 3) {
                        int val = 0;
                        for (int i = 0; i < lcount; i++) {
                            lectures[i].display();
                            val++;
                        }
                        if (val == 0){
                            System.out.println("There are no lecture materials!");
                        }
                    } else if (choose == 6) {
                        System.out.println("List of Open Assignments: ");
                        int val = 0;
                        for (int i = 0; i < acount; i++) {
                            if (Objects.equals(assessments[i].get_status(), "Open")) {
                                System.out.print("ID: " + i + " ");
                                assessments[i].display();
                                System.out.println("----------------");
                                val++;
                            }
                        }
                        if (val == 0){
                            System.out.println("There are no open assignments!");
                        }
                        else if (val > 0){
                            System.out.print("Enter ID of assignment to close: ");
                            int choice = sc.nextInt();
                            assessments[choice].close();
                        }
                    }
                    else if (choose == 5){
                        System.out.println("List of Assessments: ");
                        int var = 0;
                        for(int i = 0; i < acount; i++){
                            System.out.print("ID: " + i + " ");
                            assessments[i].display();
                            System.out.println("----------------");
                            var++;
                        }
                        if (var == 0){
                            System.out.println("There are no assessments!");
                            continue bagel;
                        }
                        System.out.print("Enter ID of assessment to view submissions: ");
                        int enter = sc.nextInt();
                        if (enter > var){
                            System.out.println("Please enter a valid ID!");
                            continue bagel;
                        }
                        System.out.println("Choose ID from these ungraded submissions: ");
                        int val = 0;
                        for(int i = 0; i < students.length; i++){
                            if(students[i].arr[enter] != null && students[i].grades[enter] == 0){
                                System.out.println(i + ". " + students[i].name);
                                val++;
                            }
                        }
                        if (val > 0) {
                            int opt = sc.nextInt();
                            System.out.println("Submission: " + students[opt].arr[enter]);
                            System.out.println("-------------------------------");
                            if (Objects.equals(assessments[enter].type(), "Assignment")) {
                                System.out.println("Max Marks: " + assessments[enter].getmarks());
                                System.out.print("Marks Scored: ");
                                float score = sc.nextFloat();
                                if (score > assessments[enter].getmarks()) {
                                    System.out.println("Marks scored can not be greater than Max Marks!");
                                    continue bagel;
                                }
                                students[opt].mark(enter, score, instructors[id].name);
                            } else if (Objects.equals(assessments[enter].type(), "Quiz")) {
                                System.out.print("Marks Scored: ");
                                float score = sc.nextFloat();
                                if (0 <= score || score < 1){
                                    students[opt].mark(enter, score, instructors[id].name);
                                }
                                else{
                                    System.out.println("Maximum marks for Quiz is 1!");
                                }
                            }
                        }
                        else{
                            System.out.println("There are no ungraded submissions!");
                            System.out.println("----------------");
                        }
                    }
                    else{
                        System.out.println("Please enter a valid task!");
                    }
                }
            } else if (option == 2) {
                System.out.println("Students:");
                int x = 0;
                for (int i = 0; i < students.length; i++) {
                    System.out.println(i + " - " + students[i].name);
                    x++;
                }
                System.out.print("Choose ID: ");
                int id = sc.nextInt();
                if (id >= x){
                    System.out.println("Please enter a valid Student ID!");
                    continue label;
                }
                int flag = 0;
                label1:
                while (flag == 0) {
                    System.out.println("Welcome " + students[id].name + "!");
                    System.out.println("-------------------------");
                    System.out.println("STUDENT MENU\n" +
                            "-------------------------\n" +
                            "1. View lecture materials\n" +
                            "2. View assessments\n" +
                            "3. Submit assessment\n" +
                            "4. View grades\n" +
                            "5. View comments\n" +
                            "6. Add comments\n" +
                            "7. Logout");
                    int choose = sc.nextInt();
                    if (choose == 7) {
                        continue label;
                    } else if (choose == 6) {
                        System.out.print("Enter Comment: ");
                        String comment = s.next();
                        comments[ccount] = new Comment(students[id].name, comment);
                        ccount++;
                    } else if (choose == 5) {
                        int val = 0;
                        for (int i = 0; i < ccount; i++) {
                            comments[i].view();
                            System.out.println("\n");
                            val++;
                        }
                        if (val == 0){
                            System.out.println("There are no comments!");
                        }
                    } else if (choose == 1) {
                        int val = 0;
                        for (int i = 0; i < lcount; i++) {
                            lectures[i].display();
                            System.out.println("\n");
                            val++;
                        }
                        if (val == 0){
                            System.out.println("There are no lecture materials!");
                        }
                    } else if (choose == 2) {
                        int val = 0;
                        for (int i = 0; i < acount; i++) {
                            System.out.print("ID: " + i + " ");
                            assessments[i].display();
                            System.out.println("----------------");
                            val++;
                        }
                        if(val == 0){
                            System.out.println("There are no assessments!");
                        }
                    } else if (choose == 3) {
                        System.out.println("Pending Assessments:");
                        int var = 0;
                        for (int i = 0; i < acount; i++) {
                            if (Objects.equals(students[id].arr[i], null) && Objects.equals(assessments[i].get_status(), "Open")){
                                System.out.print("ID: " + i + " ");
                                students[id].assessments[i].display();
                                var++;
                            }
                        }
                        if (var > 0) {
                            System.out.print("Enter ID of assessment: ");
                            int choice = sc.nextInt();
                            if (choice > var){
                                System.out.println("Please enter a valid Assessment ID!");
                                continue label1;
                            }
                            if (Objects.equals(assessments[choice].type(), "Assignment")) {
                                System.out.print("Enter Filename of assignment: ");
                                String filename = s.next();
                                if (filename.length() < 5) {
                                    System.out.println("You need to submit a file with .zip extension!");
                                    continue label1;
                                }
                                String[] str = filename.split("");
                                String format = "";
                                for (int i = str.length - 4; i < str.length; i++) {
                                    format += str[i];
                                }
                                if (Objects.equals(format, ".zip")) {
                                    students[id].submit(choice,filename);
                                }
                                else {
                                    System.out.println("You need to submit a file with .zip extension!");
                                }

                            } else if (Objects.equals(assessments[choice].type(), "Quiz")) {
                                students[id].assessments[choice].display();
                                String answer = s.next();
                                students[id].submit(choice, answer);
                            }
                        }
                        else {
                            System.out.println("There are no pending assessments!");
                            continue label1;
                        }
                    }
                    else if (choose == 4){
                        System.out.println("Graded Submissions: ");
                        int val = 0;
                        for(int i = 0; i < acount; i++){
                            if (students[id].instructors[i] != null){
                                System.out.println("Submission: " + students[id].arr[i]);
                                System.out.println("Marks Scored: " + students[id].grades[i]);
                                System.out.println("Graded by: " + students[id].instructors[i]);
                                System.out.println("\n");
                                val++;
                            }
                        }
                        if(val == 0){
                            System.out.println("There are no graded submissions!");
                        }
                        System.out.println("----------------------------");
                        System.out.println("Ungraded Submissions: ");
                        int var = 0;
                        for(int i = 0; i < acount; i++){
                            if (students[id].instructors[i] == null && students[id].arr[i] != null){
                                System.out.println("Submission: " + students[id].arr[i]);
                                var++;
                            }
                        }
                        if(var == 0){
                            System.out.println("There are no ungraded submissions!");
                        }
                        System.out.println("----------------------------");
                    }
                    else{
                        System.out.println("Please enter a valid task!");
                    }
                }
            }
            else{
                System.out.println("Please enter a valid task!");
            }
        }
        sc.close();
        s.close();
    }
}
