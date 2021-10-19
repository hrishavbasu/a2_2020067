package com.hb;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
interface Aassign{
    void addassignment();
    void addquiz();
}
interface comment{
    void addcomments();
}
interface addmat{
    void addslides();
    void addvideos();
}
interface submit{
    void addfiles();
}

class classmaterial implements addmat{
     String lectureslide;
     ArrayList<String>con= new ArrayList<String>();
    String time;
     String contents;
     String video;
     int  noslides;
    @Override
    public void addslides() {
        System.out.println("Enter topic of slides: ");
        Scanner sc = new Scanner(System.in);
        lectureslide = sc.nextLine();
        System.out.println("Enter no.of slides: ");
        Scanner k= new Scanner(System.in);
         noslides= k.nextInt();
        System.out.println("Enter Content of slide");
        for(int i=0; i<noslides; i++){
            System.out.println("Content of slide"+i+1);
            Scanner j = new Scanner(System.in);
            contents= j.nextLine();
            con.add(contents);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        time=formatter.format(date);
        System.out.println("Welcome");
    }

    @Override
    public void addvideos() {
        System.out.print("Enter topic of video: ");
        Scanner sc= new Scanner(System.in);
        String videoname= sc.nextLine();
        System.out.print("Enter filename of video: ");
        Scanner k = new Scanner(System.in);
        video = k.nextLine();
    }
}
class assessment implements Aassign{
    String aproblem;
    String qproblem;
    int MM;
    int qMM=0;
    @Override
    public void addassignment() {
        System.out.print("Enter Problem Statement: ");
        Scanner sc = new Scanner(System.in);
        aproblem = sc.nextLine();
        System.out.print("Enter max marks: ");
        Scanner k =new Scanner(System.in);
        MM = k.nextInt();
        System.out.println("Welcome");
    }

    @Override
    public void addquiz() {
        System.out.print("Enter quiz question: ");
        Scanner sc = new Scanner(System.in);
        qproblem= sc.nextLine();
    }
}

class comments implements comment{
    String comment;
    String time;
    @Override
    public void addcomments() {
        System.out.print("Enter comment: ");
        Scanner sc = new Scanner(System.in);
        comment= sc.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        time=formatter.format(date);
    }

}
class submission{
    String filename;
    String studid;
    public  void sub(ArrayList a, String b){
        System.out.println("pending assessment");
        this.studid=b;
        for(int i=0; i<a.size();i++){
            System.out.println("ID: "+i+"Assignment: "+a.get(i)+"\n");
        }
        System.out.println("choose assessment: ");
        Scanner sc =new Scanner(System.in);
        int ch = sc.nextInt();
        a.remove(ch);
        System.out.println("Enter file name: ");
        Scanner sc1= new Scanner(System.in);
        filename=sc1.nextLine();
    }
}
class grade{
    String filename;
    int Marksscored;
    String stdid;

}
class Instructor{
     String id;
    void getid(int a){
        this.id="l"+a;
    }
}
class Student {
     String id;

    void getid(int a) {
        this.id = "S" + a;
    }

    public class Main {
        static ArrayList<Instructor> it = new ArrayList<Instructor>();
        static ArrayList<Student> std = new ArrayList<Student>();
        static ArrayList<classmaterial> cm = new ArrayList<classmaterial>();
        static ArrayList<assessment> as = new ArrayList<assessment>();
        static ArrayList<comments> com = new ArrayList<comments>();
        static ArrayList<String> ps =new ArrayList<String>();
        static ArrayList<submission> subm = new ArrayList<submission>();
        static ArrayList<grade> grd = new ArrayList<grade>();
        static int flag=0;


        public static void main(String[] args) {
            // write your code here
            System.out.println("Enter the no of Instructor: ");
            Scanner I = new Scanner(System.in);
            int inst = I.nextInt();
            for (int i = 0; i < inst; i++) {
                Instructor obj = new Instructor();
                obj.getid(i);
            }
            System.out.println("Enter the no of Student: ");
            Scanner S = new Scanner(System.in);
            int stud = S.nextInt();
            for (int i = 0; i < stud; i++) {
                Instructor obj = new Instructor();
                obj.getid(i);
            }
            while (true) {
                System.out.print("Welcome to Backpack\n" +
                        "1. Enter as instructor\n" +
                        "2. Enter as student\n" +
                        "3. Exit");
                Scanner sc = new Scanner(System.in);
                int a = sc.nextInt();
                if (a == 1) {
                    int k = 0;
                    System.out.println("Choose Instructor");
                    for(int i=0; i<it.size();i++){
                        System.out.println("Instructors: \n" +
                                i+it.get(i).id);
                    }
                    Scanner o= new Scanner(System.in);
                    int c = o.nextInt();
                    while (k != 1) {
                        String p = it.get(c).id;
                        System.out.println("INSTRUCTOR MENU\n" +
                                "1. Add class material\n" +
                                "2. Add assessments\n" +
                                "3. View lecture materials\n" +
                                "4. View assessments\n" +
                                "5. Grade assessments\n" +
                                "6. Close assessment\n" +
                                "7. View comments\n" +
                                "8. Add comments\n" +
                                "9. Logout");
                        Scanner d = new Scanner(System.in);
                        int j = d.nextInt();
                        if (j == 1) {
                            classmaterial obj = new classmaterial();
                            System.out.println("1. Add Lecture Slide\n" +
                                    "2. Add Lecture Video");
                            Scanner s = new Scanner(System.in);
                            int opt = s.nextInt();
                            if (opt == 1) {
                                obj.addslides();
                            } else if (opt == 2) {
                                obj.addvideos();
                            }
                        }
                        if (j == 2) {
                            assessment obj = new assessment();
                            System.out.println("1. Add Assignment \n" +
                                    "2. Add Quiz \n");
                            Scanner s = new Scanner(System.in);
                            int opt = s.nextInt();
                            if (opt == 1) {
                                obj.addassignment();
                            } else if (opt == 2) {
                                obj.addquiz();
                            }
                        }
                        if (j == 3) {
                            for (int i = 0; i < cm.size(); i++) {
                                System.out.println("Title: " + cm.get(i).lectureslide + "\n" +
                                        "Number of slides: " + cm.get(i).noslides + "\n" +
                                        "Date of upload: " + cm.get(i).time + "\n");
                                for (int l = 0; l < cm.get(i).con.size(); l++) {
                                    System.out.println("Slides: " + l + 1 + cm.get(i).con.get(l));
                                }

                            }
                        } else if (j == 4) {
                            for (int i = 0; i < as.size(); i++) {
                                System.out.println("ID: " + i + " Assignment: " + as.get(i).aproblem + "Max Marks: " + as.get(i).MM + "\n " +
                                        "---------------- \n" +
                                        "ID: " + i + 1 + " Question: " + as.get(i).qproblem + "\n" +
                                        "---------------- \n");
                            }
                        }
                        else if (j == 5) {
                            grade obj = new grade();
                            System.out.println("List of assessments: ");
                            for (int i = 0; i < as.size(); i++) {
                                System.out.println("ID: " + i + " Assignment: " + as.get(i).aproblem + "Max Marks: " + as.get(i).MM + "\n " +
                                        "---------------- \n" +
                                        "ID: " + i + 1 + " Question: " + as.get(i).qproblem + "\n" +
                                        "---------------- \n");

                        }
                            System.out.println("choose assessment: ");
                            Scanner f = new Scanner(System.in);
                            int ch = f.nextInt();
                            System.out.println("Choose ID of ungraded submission");
                            for(int i=0; i<subm.size();i++){
                                System.out.println(i+" "+subm.get(i).studid);
                            }
                            Scanner g =new Scanner(System.in);
                            int l = g.nextInt();
                            obj.filename= subm.get(l).filename;
                            obj.stdid= subm.get(l).studid;
                            System.out.println("Max Marks: ");
                            System.out.println("Marks Scored: ");
                            Scanner u = new Scanner(System.in);
                            obj.Marksscored=u.nextInt();
                            System.out.println("welcome"+p);

                        }
                        else if (j == 6) {
                            System.out.println("List of open assessments: ");
                            for (int i = 0; i < as.size(); i++) {
                                System.out.println("ID: " + i + " Assignment: " + as.get(i).aproblem + "Max Marks: " + as.get(i).MM + "\n " +
                                        "---------------- \n" +
                                        "ID: " + i + 1 + " Question: " + as.get(i).qproblem + "\n" +
                                        "---------------- \n");
                            }
                            System.out.println("Enter the Id of assignment to be closed");
                            Scanner f = new Scanner(System.in);
                            int ch = f.nextInt();
                            as.remove(ch);
                        }
                        else if (j == 7) {
                            for (int i = 0; i < com.size(); i++) {
                                System.out.println(com.get(i).comment);
                                System.out.println(com.get(i).time);
                            }
                        }
                        else if (j == 8) {
                            comments obj = new comments();
                            obj.addcomments();
                        }
                        else if (j == 9) {
                            k = 1;
                        }
                    }
                }
                else if (a == 2) {
                    System.out.println("Choose Student");
                    for(int i=0; i<std.size();i++){
                        System.out.println("Instructors: \n" +
                                i+std.get(i).id);
                    }
                    Scanner o= new Scanner(System.in);
                    int c = o.nextInt();
                    while (true) {
                        String p = std.get(c).id;
                        System.out.println("STUDENT MENU\n" +
                                "1. View lecture materials\n" +
                                "2. View assessments\n" +
                                "3. Submit assessment\n" +
                                "4. View grades\n" +
                                "5. View comments\n" +
                                "6. Add comments\n" +
                                "7. Logout");
                        int k = 0;
                        while (k != 0) {
                            Scanner d = new Scanner(System.in);
                            int j = d.nextInt();
                             if (j == 1) {
                                for (int i = 0; i < cm.size(); i++) {
                                    System.out.println("Title: " + cm.get(i).lectureslide + "\n" +
                                            "Number of slides: " + cm.get(i).noslides + "\n" +
                                            "Date of upload: " + cm.get(i).time + "\n");
                                    for (int l = 0; l < cm.get(i).con.size(); l++) {
                                        System.out.println("Slides: " + l + 1 + cm.get(i).con.get(l));
                                    }

                                }
                            }
                            else if (j == 2) {
                                for (int i = 0; i < as.size(); i++) {
                                    System.out.println("ID: " + i + " Assignment: " + as.get(i).aproblem + "Max Marks: " + as.get(i).MM + "\n " +
                                            "---------------- \n" +
                                            "ID: " + i + 1 + " Question: " + as.get(i).qproblem + "\n" +
                                            "---------------- \n");
                                }
                            }
                            else if (j == 3) {
                                String stid= p;
                                submission obj =new submission();
                                if(flag==0){
                                    for(int i=0; i<as.size(); i++){
                                        ps.add(as.get(i).aproblem);
                                        ps.add(as.get(i+1).qproblem);
                                    }
                                    obj.sub(ps,stid);
                                    flag=1;
                                }
                                else{
                                    obj.sub(ps,stid);
                                    flag=0;
                                }
                            }
                            else if (j == 4) {
                                for(int i=0; i<grd.size(); i++){
                                    if(grd.get(i).stdid==p && grd.get(i).stdid==subm.get(i).studid){
                                        System.out.println("graded submission");
                                        System.out.println("submissions:"+""+grd.get(i).filename);
                                        System.out.println("Marks Scored:"+""+grd.get(i).Marksscored);
                                    }
                                    else if(grd.get(i).stdid==p && grd.get(i).stdid!=subm.get(i).studid){
                                        System.out.println("ungraded");
                                        System.out.println("submissions:"+""+subm.get(i).filename);
                                    }
                                }
                            }
                            else if (j == 5) {
                                for (int i = 0; i < com.size(); i++) {
                                    System.out.println(com.get(i).comment);
                                    System.out.println(com.get(i).time);
                                }
                            } else if (j == 6) {
                                comments obj = new comments();
                                obj.addcomments();
                            } else if (j == 7) {
                                k = 1;
                            }
                        }
                    }
                }
                if (a == 3) {
                    System.out.println("Thanks for your Time");
                    break;
                }
            }
        }
    }
}
