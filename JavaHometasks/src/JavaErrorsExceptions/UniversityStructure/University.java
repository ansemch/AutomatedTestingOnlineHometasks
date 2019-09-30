package JavaErrorsExceptions.UniversityStructure;

import JavaErrorsExceptions.Exceptions.NoFacultiesForUniversityException;

import java.util.HashSet;
import java.util.Set;

public class University {
    private String name;
    private Set<Faculty> faculties;
    public University(String name) {
        this.name=name;
        faculties = new HashSet <Faculty>();
    }

    public void addFaculty(Faculty faculty) { faculties.add(faculty); };

    public Set <Faculty> getFaculties() {
        try {
            if (faculties.isEmpty()) {
                System.out.println("No faculties at the university ");
                throw new NoFacultiesForUniversityException();
            }
        } catch (Exception e) {
                e.printStackTrace();
        }
        return faculties;
    }
}
