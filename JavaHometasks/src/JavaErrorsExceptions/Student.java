package JavaErrorsExceptions;

import JavaErrorsExceptions.Exceptions.MarkOutOfBoundsException;
import JavaErrorsExceptions.Exceptions.NoDisciplinesForStudentException;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private int id;
    private String name;
    private Map<Exam,Integer> exams;

    Student (int id, String name) {
        this.id=id;
        this.name=name;
        exams=new HashMap<Exam, Integer>();
    }

    void addExamInfo (Exam exam, Integer mark) {
        try {
            if (mark<0 || mark>10 ) {
                System.out.println("Incorrect mark");
                throw new MarkOutOfBoundsException();
            }
            else exams.put(exam, mark);
        } catch (MarkOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    Map <Exam,Integer> getExams () {
        try {
            if (exams.isEmpty()) {
                System.out.println("No disciplines for a student");
                throw new NoDisciplinesForStudentException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exams;
    }
}
