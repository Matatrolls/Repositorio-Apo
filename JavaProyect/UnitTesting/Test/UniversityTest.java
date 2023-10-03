import junit.framework.TestCase;

import model.Student;
import model.University;

public class UniversityTest  extends TestCase {

    private University university;

    private void setUpStage1(){
        university = new University();
    }

    private void setUpStage2(){
        university = new University();
        try {
            university.addStudent("Carlos", "123", 20);
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void testAddStudent1(){
        setUpStage1();
        try {
            university.addStudent("Carlos", "123", 20);
        } catch (Exception e) {
            System.out.println(e);

        }
       
        assertEquals(1,university.getUniversitySize());
    }

    public void testAddStudent2() {
        setUpStage2();
        try {
            university.addStudent("Juan", "123", 30);
            fail(); //no levanto exception, entonces falla
            
        } catch (Exception e) {
            //Hay excepcion
           Student student = university.searchStudent("123");
           assertEquals("Carlos", student.getName());
           assertNull(student);
        }
    }

    public void testDeleteStudent1(){
        setUpStage2();
        university.deleteStudent("123");
        Student student = university.searchStudent("123");
        assertNull(student);
        assertEquals(0, university.getUniversitySize()); 
        
    }
}
