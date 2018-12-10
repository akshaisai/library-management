package librarymanagement;

import java.util.*;
//Library which is responsible for storing and searching the students. 
public class StudentManager {

    private HashMap<Integer, Student> students;

    public StudentManager() {
        students = new HashMap<Integer, Student>();
    }

    public boolean addStudent(int id, String name, String dept) {
        if (students.containsKey(id)) {
            return false;
        }
        Student user = new Student(id, name, dept);
        students.put(id, user);
        return true;
    }

    public boolean addStudent(Student user) {
        if (students.containsKey(user.getId())) {
            return false;
        }

        students.put(user.getId(), user);
        return true;
    }

    public boolean remove(Student u) {
        return remove(u.getId());
    }

    public boolean remove(int id) {
        if (!students.containsKey(id)) {
            return false;
        }
        students.remove(id);
        return true;
    }

    public Student find(int id) {
        return students.get(id);
    }

    public ArrayList<Student> getStudentList() {
        return new ArrayList<Student>(students.values());

    }
}
class StuIdCompare implements Comparator<Student> {
    // Used for sorting in ascending order of id

    @Override
    public int compare(Student a, Student b) {
        return a.getId() - b.getId();
    }
}

class StuNameCompare implements Comparator<Student> {
    // Used for sorting in ascending order of names 

    @Override
    public int compare(Student a, Student b) {
        return a.getName().compareTo(b.getName());
    }
}

class StuDeptCompare implements Comparator<Student> {
    // Used for sorting in ascending order of author names

    @Override
    public int compare(Student a, Student b) {
        return a.getDept().compareTo(b.getDept());
    }
}
