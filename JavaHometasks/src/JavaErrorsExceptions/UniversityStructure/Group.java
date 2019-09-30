package JavaErrorsExceptions.UniversityStructure;

import JavaErrorsExceptions.Exceptions.NoStudentsForGroupException;
import JavaErrorsExceptions.Student;

import java.util.HashSet;
import java.util.Set;

public class Group {
    private int id;
    private String name;
    private Set <Student> students;

    public Group(int id, String name) {
        this.id=id;
        this.name=name;
        students = new HashSet <Student>() ;
    }

    public void addStudent(Student student) { students.add(student); };

    public Set <Student> getStudents() {
        try {
            if (students.isEmpty()) {
                System.out.println("No students in a group");
                throw new NoStudentsForGroupException();
            }
        } catch (NoStudentsForGroupException e) {
            e.printStackTrace();
        }
        return students;
    }
}
