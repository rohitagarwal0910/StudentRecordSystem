import java.io.*;
import java.util.Iterator;

public class Assingment1 {
    public static void main(String[] args) {
        getData(args[0], args[1]);
        answerQueries(args[2]);
    }

    static public LinkedList<Course> allCourses = new LinkedList<Course>();
    static public LinkedList<Hostel> allHostels = new LinkedList<Hostel>();
    static public LinkedList<Student> allStudents = new LinkedList<Student>();
    static public LinkedList<Department> allDepartments = new LinkedList<Department>();

    private static void getData(String sfile, String cfile) {
        String line;
        try {
            BufferedReader sbr = new BufferedReader(new FileReader(sfile));
            try {
                while ((line = sbr.readLine()) != null) {
                    String[] s = line.split(" ");
                    Student student = new Student(s[1], s[0], s[3], s[2]);
                    allStudents.add(student);
                }
                sbr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader cbr = new BufferedReader(new FileReader(cfile));
            try {
                while ((line = cbr.readLine()) != null) {
                    String[] s = line.split(" ", 4);
                    Course course = new Course(s[3], s[1]);
                    Student stta = null;
                    Iterator<Position_<Student>> students = allStudents.positions();
                    while (students.hasNext()) {
                        Student tempstudent = students.next().value();
                        if (tempstudent.entryNo().equals(s[0])) {
                            stta = tempstudent;
                            tempstudent.courses.add(new CourseGrade(s[1], s[3], GradeInfo_.LetterGrade.valueOf(s[2])));
                            if (!s[2].equals("I") || !s[2].equals("E") || !s[2].equals("F")) {
                                tempstudent.completedCredits += 3;
                                tempstudent.points += 3 * GradeInfo_.gradepoint(GradeInfo_.LetterGrade.valueOf(s[2]));
                            }
                            break;
                        }
                    }
                    Iterator<Position_<Course>> courseitr = Assingment1.allCourses.positions();
                    if (!courseitr.hasNext()) {
                        course.students.add(stta);
                        Assingment1.allCourses.add(course);
                    } else {
                        while (courseitr.hasNext()) {
                            Course itrc = courseitr.next().value();
                            if (!course.name().equals(itrc.name())) {
                                if (!courseitr.hasNext()) {
                                    course.students.add(stta);
                                    Assingment1.allCourses.add(course);
                                }
                            } else {
                                itrc.students.add(stta);
                                break;
                            }
                        }
                    }
                }
                cbr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void answerQueries(String qfile) {
        LinkedList<String> queries = new LinkedList<String>();
        try {
            BufferedReader qbr = new BufferedReader(new FileReader(qfile));
            String line;
            try {
                while ((line = qbr.readLine()) != null) {
                    queries.add(line);
                }
                qbr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // qbr.close();
        Iterator<Position_<String>> qitr = queries.positions();
        while (qitr.hasNext()) {
            String[] s = qitr.next().value().split(" ");
            if (s[0].equals("SHARE")) {
                LinkedList<String> result = new LinkedList<String>();
                Iterator<Position_<Student>> students = allStudents.positions();
                while (students.hasNext()) {
                    Student temps = students.next().value();
                    if (temps.entryNo().equals(s[1])) {
                        if (temps.hostel().equals(s[2])) {
                            Iterator<Position_<Student>> st = allStudents.positions();
                            while (st.hasNext()) {
                                Student tst = st.next().value();
                                if (tst.hostel().equals(s[2]) && !tst.entryNo().equals(s[1])) {
                                    result.add(tst.entryNo());
                                }
                            }
                        } else if (temps.department().equals(s[2])) {
                            Iterator<Position_<Student>> st = allStudents.positions();
                            while (st.hasNext()) {
                                Student tst = st.next().value();
                                if (tst.department().equals(s[2]) && !tst.entryNo().equals(s[1])) {
                                    result.add(tst.entryNo());
                                }
                            }
                        } else {
                            Iterator<Position_<Student>> st = allStudents.positions();
                            while (st.hasNext()) {
                                Student tst = st.next().value();
                                Iterator<CourseGrade_> citr = tst.courseList();
                                while (citr.hasNext()) {
                                    CourseGrade_ cg = citr.next();
                                    if (cg.coursenum().equals(s[2])) {
                                        if (!tst.entryNo().equals(s[1])) {
                                            result.add(tst.entryNo());
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
                String[] soutput = new String[result.count()];
                Iterator<Position_<String>> ritr = result.positions();
                int i = 0;
                while (ritr.hasNext()) {
                    soutput[i] = ritr.next().value();
                    i = i + 1;
                }
                while (true) {
                    int l = 0;
                    for (int a = 0; a < soutput.length-1; a++) {
                        if (soutput[a + 1].compareTo(soutput[a]) < 0) {
                            String c = soutput[a];
                            soutput[a] = soutput[a + 1];
                            soutput[a + 1] = c;
                            l++;
                        }
                    }
                    if (l == 0) {
                        break;
                    }
                }
                if (soutput.length > 0) {
                    System.out.print(soutput[0]);
                }
                for (int a = 1; a < soutput.length; a++) {
                    System.out.print(" " + soutput[a]);
                }
                System.out.println();
            } else if (s[0].equals("COURSEINFO")) {
                Iterator<Position_<Course>> courseitr = Assingment1.allCourses.positions();
                while (courseitr.hasNext()) {
                    Course tempc = courseitr.next().value();
                    if (tempc.code.equals(s[1])) {
                        System.out.print(tempc.name());
                        break;
                    }
                }
                System.out.println();
            } else {
                Iterator<Position_<Student>> students = allStudents.positions();
                while (students.hasNext()) {
                    Student temps = students.next().value();
                    if (temps.entryNo().equals(s[1]) || temps.name().equals(s[1])) {
                        Iterator<CourseGrade_> cgitr = temps.courseList();
                        CourseGrade_[] cglist = new CourseGrade_[temps.courses.count()];
                        int q = 0;
                        while (cgitr.hasNext()) {
                            cglist[q] = cgitr.next();
                            q++;
                        }
                        while (true) {
                            int l = 0;
                            for (int a = 0; a < cglist.length-1; a++) {
                                if (cglist[a + 1].coursenum().compareTo(cglist[a].coursenum()) < 0) {
                                    CourseGrade_ c = cglist[a];
                                    cglist[a] = cglist[a + 1];
                                    cglist[a + 1] = c;
                                    l++;
                                }
                            }
                            if (l == 0) {
                                break;
                            }
                        }
                        System.out.print(temps.entryNo() + " " + temps.name() + " " + temps.department() + " "
                                + temps.hostel() + " " + temps.cgpa());
                        for (int i = 0; i < cglist.length; i++) {
                            System.out.print(" " + cglist[i].coursenum() + " " + cglist[i].grade().grade());
                        }
                        System.out.println();
                        break;
                    }
                }
            }
        }
    }
}