package JavaErrorsExceptions;

import JavaErrorsExceptions.UniversityStructure.Faculty;
import JavaErrorsExceptions.UniversityStructure.Group;
import JavaErrorsExceptions.UniversityStructure.University;

import java.util.*;

public class JavaErrorsExceptions {

    static float averageStudentMark (Student student) {
        Iterator iterator = student.getExams().values().iterator();
        int averageMark=0;
        int numberOfExams=0;
        while (iterator.hasNext()) {
            averageMark+=(Integer)iterator.next();
            numberOfExams+=1;
        }
        return (float) averageMark/numberOfExams;
    }

    static float averageMarkForDisciplineInGroup (String discipline, Group group) {
        Iterator iterator = group.getStudents().iterator();
        int averageMark=0;
        int numberOfExams=0;
        while (iterator.hasNext()) {
            Student student=(Student) iterator.next();
            Iterator iteratorExams=student.getExams().keySet().iterator();
            while (iteratorExams.hasNext()) {
                Exam exam = (Exam) iteratorExams.next();
                    if (exam.getDiscipline().equals(discipline)) {
                        averageMark+=(Integer)student.getExams().get(exam);
                        numberOfExams+=1;
                    }
            }

    }
        return (float) averageMark/numberOfExams;
    }

    static float averageMarkForUniversity (University university) {
        Iterator iterator=university.getFaculties().iterator();
        int averageMark=0;
        int numberOfExams=0;
        while (iterator.hasNext()) {
            Iterator iteratorGroups = ((Faculty) iterator.next()).getGroups().iterator();
            while (iteratorGroups.hasNext()) {
                Iterator iteratorStudents=(((Group)iteratorGroups.next()).getStudents().iterator());
                while (iteratorStudents.hasNext()) {
                    Student student=(Student) iteratorStudents.next();
                    Iterator iteratorExams=student.getExams().values().iterator();
                    while (iteratorExams.hasNext()) {
                        averageMark+=(Integer)iteratorExams.next();
                        numberOfExams+=1;
                    }
                }
            }
        }
    return ((float)averageMark/numberOfExams);
    }

    public static void main(String[] args) {
        Student mathStudent1 = new Student(1,"Alex Ivanov");
        Student mathStudent2 = new Student(2,"Ivan Petrov");
        Student mathStudent3 = new Student(3,"Petr Sidorov");
        mathStudent1.addExamInfo(new Exam(1,"Higher mathematics"), 5);
        mathStudent1.addExamInfo(new Exam(2,"Higher mathematics"), 5);
        mathStudent1.addExamInfo(new Exam(3,"Physics"), 8);
        mathStudent2.addExamInfo(new Exam(4,"Physics"), 6);
        Group mathGroup1 = new Group (1, "MathGroup1");
        Group mathGroup2 = new Group (2, "MathGroup2");
        mathGroup1.addStudent(mathStudent1);
        mathGroup1.addStudent(mathStudent2);
        mathGroup2.addStudent(mathStudent3);
        Faculty mathFaculty = new Faculty(1, "Mathematical");
        mathFaculty.addGroup(mathGroup1);
        mathFaculty.addGroup(mathGroup2);
        University university = new University("Gomel State JavaErrorsExceptions.UniversityStructure.University");
        university.addFaculty(mathFaculty);
        Faculty biolFaculty = new Faculty(2, "Biological");
        university.addFaculty(biolFaculty);
        Group biolGroup1 = new Group (3, "BiolGroup1");
        biolFaculty.addGroup(biolGroup1);
        Student biolStudent1=new Student(4,"Andrei Kononovich");
        Student biolStudent2=new Student(5,"Alexei Rych");
        Student biolStudent3=new Student(6,"Alexander Tyi");
        biolStudent1.addExamInfo(new Exam(5,"Higher mathematics"), 5);
        biolStudent2.addExamInfo(new Exam(6,"Higher mathematics"), 5);
        biolStudent3.addExamInfo(new Exam(7,"Higher mathematics"), 5);
        biolGroup1.addStudent(biolStudent1);
        biolGroup1.addStudent(biolStudent2);
        biolGroup1.addStudent(biolStudent3);
        System.out.println("Средний балл по предметам студента Alex Ivanov");
        System.out.println (averageStudentMark (mathStudent1));
        System.out.println("Средний балл по предмету \"Higher mathematics\" в группе \"BiolGroup1\" факультета \"Biological\"");
        System.out.println (averageMarkForDisciplineInGroup("Higher mathematics", biolGroup1));
        System.out.println("Средний балл по университету");
        System.out.println (averageMarkForUniversity (university));
        mathStudent2.addExamInfo(new Exam(5,"Physics"), 16);
        new Student(7,"Alexey Petrenko").getExams();
        new Faculty(3,"Physical").getGroups();
        new Group (4,"BiolGroup1").getStudents();
        new University("Belarus State JavaErrorsExceptions.UniversityStructure.University").getFaculties();
    }
}