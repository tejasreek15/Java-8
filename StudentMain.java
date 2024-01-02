import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentMain {

    public static void main(String args[]) {
        List<Student> studentList = Stream.of(new Student(1, "Riya", "female", 21, 1,"cse","tpt", Arrays.asList("7888905678", "9000561780")),
                new Student(2, "Reena", "female", 21,56,"civil", "hyd", Arrays.asList("9090136576")),
                new Student(3, "Sonu", "female", 22,12, "eee", "bang", Arrays.asList("7831705935")),
                new Student(4, "Ankit", "male", 20,110, "mech", "chennai", Arrays.asList("4056890231", "7846108374")),
                new Student(5, "Keerthana", "female", 22,90, "ece", "skht", Arrays.asList("8090562345")),
                new Student(6, "Fathima", "female", 21, 370, "cse", "mumbai", Arrays.asList("6790368213")),
                new Student(7, "Shubham", "male", 20, 97, "ece","delhi", Arrays.asList("7090903789", "7054378561")),
                new Student(8, "Lio", "male", 22, 203,  "mech", "bang", Arrays.asList("8934176398")),
                new Student(9, "Arun", "male", 21, 175, "civil", "hyd", Arrays.asList("8054389671")),
                new Student(10, "Rohit", "male", 20, 147, "ece","guntur", Arrays.asList("8050690817")))
                .collect(Collectors.toList());

        //1. find the list of students whose rank is in between 50 and 100
        List<Student> rankList = studentList.stream().filter(student -> student.getRank() > 50 && student.getRank()<100)
                .collect(Collectors.toList());
        System.out.println(rankList);

        //2. find the list of students whose stay in bang city and sort by their names
        List<Student> cityList = studentList.stream().filter(student -> student.getCity().equalsIgnoreCase("bang"))
                .sorted(Comparator.comparing(Student::getFirstName, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println((cityList));

        //3. find all departments names (if needed unique records use distinct or set)
        List<String> dept = studentList.stream().map(Student::getDepartment).distinct().collect(Collectors.toList());
        Set<String> deptinSet = studentList.stream().map(Student::getDepartment).collect(Collectors.toSet());
        System.out.println(dept);
        System.out.println(deptinSet);

        //4. find all contact numbers
        //if it is OneToOne use -> map
        //if it is OneToMany -> flatMap
        List<String> contactsList = studentList.stream().flatMap(student -> student.getContacts().stream()).collect(Collectors.toList());
        System.out.println(contactsList);

        //5. Group the student by department names and counting
       Map<String, List<Student>> deptMap = studentList.stream().collect(Collectors.groupingBy(Student::getDepartment));
       System.out.println(deptMap);

       Map<String, Long> deptMapCount = studentList.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
       System.out.println(deptMapCount);

       //6. find the dept who is having maximum number of students
        Map.Entry<String, Long> maxDept = studentList.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(maxDept);

        //7. find the avg age of male and female student
        Map<String, Double> avgAge = studentList.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println(avgAge);

        //8. find the highest rank in each dept
        Map<String, Optional<Student>> highestRank = studentList.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.minBy(Comparator.comparing(Student::getRank))));
        System.out.println(highestRank);

        //9. find the student who has second rank
        Student student = studentList.stream().sorted(Comparator.comparing(Student::getRank))
                .skip(1)
                .findFirst().get();
        System.out.println(student);

    }
}
