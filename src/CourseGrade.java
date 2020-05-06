public class CourseGrade implements CourseGrade_ {
    GradeInfo_.LetterGrade grade;
    String num, title;

    CourseGrade(String num, String title, GradeInfo_.LetterGrade grade) {
        this.num = num;
        this.title = title;
        this.grade = grade;
    }

    @Override
    public String coursetitle() {
        return title;
    }

    @Override
    public String coursenum() {
        return num;
    }

    @Override
    public GradeInfo grade() {
        return new GradeInfo(grade);
    }
}