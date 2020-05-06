import java.util.Iterator;

public class Student implements Student_ {
    String name, entryNo, department, hostel;
    LinkedList<CourseGrade_> courses = new LinkedList<CourseGrade_>();
    double completedCredits = 0;
    double points = 0;

    Student(String name, String entryNo, String hostel, String department) {
        this.name = name;
        this.entryNo = entryNo;
        this.hostel = hostel;
        this.department = department;
        // Iterator<Position_<Hostel>> itr2 = Assignment1.allHostels.positions();
        // if (!itr2.hasNext()) {
        // Hostel th = new Hostel(hostel);
        // th.students.add(this);
        // Assignment1.allHostels.add(th);
        // } else {
        // while (itr2.hasNext()) {
        // Hostel itrh = itr2.next().value();
        // if (!hostel.equals(itrh.name())) {
        // if (!itr2.hasNext()) {
        // Hostel th = new Hostel(hostel);
        // th.students.add(this);
        // Assignment1.allHostels.add(th);
        // }
        // }
        // else {
        // itrh.students.add(this);
        // }
        // }
        // }
        // Iterator<Position_<Department>> itr3 =
        // Assignment1.allDepartments.positions();
        // if (!itr3.hasNext()) {
        // Department td = new Department(department);
        // td.students.add(this);
        // Assignment1.allDepartments.add(td);
        // } else {
        // while (itr3.hasNext()) {
        // Department itrd = itr3.next().value();
        // if (!department.equals(itrd.name())) {
        // if (!itr3.hasNext()) {
        // Department td = new Department(department);
        // td.students.add(this);
        // Assignment1.allDepartments.add(td);
        // }
        // }
        // else {
        // itrd.students.add(this);
        // }
        // }
        // }
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String entryNo() {
        return entryNo;
    }

    @Override
    public String hostel() {
        return hostel;
    }

    @Override
    public String department() {
        return department;
    }

    @Override
    public String completedCredits() {
        return Double.toString(completedCredits);
    }

    @Override
    public String cgpa() {
        if (completedCredits == 0) {
            return "0.00";
        } else {
            double cg = points / completedCredits;
            cg = cg * 100;
            cg = (double) Math.round(cg);
            cg = cg / 100.00;
            return Double.toString(cg);
        }
    }

    @Override
    public Iterator<CourseGrade_> courseList() {
        return courses.values();
    }
}