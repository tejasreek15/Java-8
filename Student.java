import java.util.List;
import java.util.Objects;

public class Student {

    private int id;
    private String firstName;
    private String gender;

    private int age;

    private int rank;

    private String department;

    private String city;

    private List<String> contacts;

    public Student(int id, String firstName, String gender, int age, int rank, String department, String city, List<String> contacts) {
        this.id = id;
        this.firstName = firstName;
        this.gender = gender;
        this.age = age;
        this.rank = rank;
        this.department = department;
        this.city = city;
        this.contacts = contacts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getContacts() {
        return contacts;
    }

    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && rank == student.rank && Objects.equals(firstName, student.firstName) && Objects.equals(gender, student.gender) && Objects.equals(age, student.age) && Objects.equals(department, student.department) && Objects.equals(city, student.city) && Objects.equals(contacts, student.contacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, gender, age, rank, department, city, contacts);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", rank=" + rank +
                ", department='" + department + '\'' +
                ", city='" + city + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}

