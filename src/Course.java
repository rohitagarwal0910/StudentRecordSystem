import java.util.Iterator;

public class Course implements Entity_ {
    String name;
    String code;
    LinkedList<Student_> students;

    Course(String name, String code) {
        this.name = name;
        this.code = code;
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