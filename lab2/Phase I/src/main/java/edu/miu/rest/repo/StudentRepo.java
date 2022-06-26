package edu.miu.rest.repo;

import edu.miu.rest.entity.Course;
import edu.miu.rest.entity.Student;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepo {
    private  static List<Student> students = new ArrayList<>();
    private static List<Course> courseList = new ArrayList<>();

    public StudentRepo(){
       Student student1 = new Student(1,"Swe","Naing","snaing@miu.edu","ComPro","WAA",4, Arrays.asList(new Course(1, "WAA", "545"), new Course(2, "EA", "544")));
       Student student2 = new Student(2,"John","Smith","snaing@miu.edu","ComPro","WAA",4, Arrays.asList(new Course(1, "WAA", "545"), new Course(2, "EA", "544")));
         // Student student1 = new Student(1,"Swe","Naing","snaing@miu.edu","ComPro","WAA",4);
         // Student student2 = new Student(2,"John","Smith","jsmith@miu.edu","ComPro","WAA",4);

        students.add(student1);
        students.add(student2);
    }

    public List<Student> findAll(){return students;}

    public  Student getStudentById(int id){
        for(Student s:students){
            if(s.getId()== id)
                return s;
        }
        return  null;
    }

    public List<Student> getStudentByMajor(String major){
        List<Student> stu = new ArrayList<>();
        for(Student s:students){
            if(s.getMajor()== major)
                stu.add(s);

        }
        return stu;
    }

    public  List<Course> getCoursesByStudentId(int id){
        for(Student s:students){
            if(s.getId()== id)
                return s.getCourseList();
        }
        return  null;
    }
    public void create(Student s){
        students.add(s);
    }

    public void update(int id,Student s){
        Student student = getStudentById(id);
        student.setCoursesTaken(s.getCoursesTaken());
        student.setGpa(s.getGpa());
    }

    public void delete(int id){
        int index = 0;
        Student student = getStudentById(id);
        for(Student s:students){
            if(s.getId()== id){
                students.remove(index);
            }
            index++;
        }

    }
}
