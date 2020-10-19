package pr9;
public class Student implements Comparable<Student> {
    private String name;
    private int grade;

    public int compareTo(Student o){
        return Integer.compare(this.grade, o.getGrade());
    }
    public Student(String name, int grade){
        this.name = name;
        this.grade = grade;
    }

    private int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
