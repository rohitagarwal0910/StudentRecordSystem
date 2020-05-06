import java.util.Iterator;

public class Department implements Entity_ {
    String name;
    LinkedList<Student_> students;

    Department(String name) {
        this.name = name;
        students = new LinkedList<Student_>();
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Iterator<Student_> studentList() {
        return students.values();
    }
}