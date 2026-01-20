public class Student extends Person {
    private int grade;

    public Student(String fName, String lName, String pNumber, int g) {
        super(fName,lName,pNumber);
        this.grade = g;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}
