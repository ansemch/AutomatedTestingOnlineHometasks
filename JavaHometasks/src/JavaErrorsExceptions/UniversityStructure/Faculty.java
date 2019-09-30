package JavaErrorsExceptions.UniversityStructure;

import JavaErrorsExceptions.Exceptions.NoGroupsForFacultyException;

import java.util.HashSet;
import java.util.Set;

public class Faculty {
    private int id;
    private String name;
    private Set <Group> groups;

    public Faculty(int id, String name) {
        this.id=id;
        this.name=name;
        groups = new HashSet <Group>();
    }

    public void addGroup(Group group) { groups.add(group); };

    public Set <Group> getGroups() {
        try {
            if (groups.isEmpty()) {
                System.out.println("No groups at a faculty");
                throw new NoGroupsForFacultyException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return groups;
    }

}
