public class GradeInfo implements GradeInfo_ {
    LetterGrade grade;

    GradeInfo(LetterGrade grade) {
        this.grade = grade;
    }

    @Override
    public LetterGrade grade() {
        return grade;
    }
}