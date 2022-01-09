package oops._3_Concepts._17_Associaction_HAS_A;

/*
    Association - HAS-A relationship
        - it relationship bw 2 different classes through their objects.

    2 forms:
        - Aggregation
        -

 */

import java.util.ArrayList;
import java.util.List;

class College{
    String name;
    private  List<Teacher> teachers;

    public College(String name, List<Teacher> teachers){
        this.name = name;
        this.teachers = teachers;
    }

    public void getTeachers(){
        System.out.println(teachers);
    }
}

class Teacher{
    String name;
    String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}

public class Aggregation {

    public static void main(String[] args) {
        Teacher t1 = new Teacher("James", "Physics");
        Teacher t2 = new Teacher("Adams", "Java");

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(t1);
        teachers.add(t2);

        College cllg = new College("NIT", teachers);
        cllg.getTeachers();

        // teacher object is passed to College object..
        // so now Teacher class HAS-A relationship w/ College class
    }
}
