package model;

import java.util.ArrayList;


public class University {

    private ArrayList<Student> students;

    public University() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String name, String id, int age) throws IDException{
        Student student = searchStudent(id);
        if(student== null){
            students.add(new Student(name, id, age));
        }else{
            throw  new IDException("id duplicado "+id);
        }
        
    }

    public void deleteStudent(String id){
        Student student = searchStudent(id);
        if (student!=null) students.remove(student);
    }

    public Student searchStudent(String id){
        for (Student student: students) {
            if (student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

    public int getUniversitySize(){
        return students.size();
    }

    
}
