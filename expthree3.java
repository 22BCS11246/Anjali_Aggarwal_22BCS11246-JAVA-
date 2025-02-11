import java.util.*;

class CourseFullException extends Exception {
    public CourseFullException(String message) { super(message); }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) { super(message); }
}

class Course {
    String name, prerequisite;
    int maxStudents, enrolledStudents = 0;

    public Course(String name, int maxStudents, String prerequisite) {
        this.name = name;
        this.maxStudents = maxStudents;
        this.prerequisite = prerequisite;
    }

    public void enroll() throws CourseFullException {
        if (enrolledStudents >= maxStudents) throw new CourseFullException("Course is full: " + name);
        enrolledStudents++;
    }
}

class Student {
    String name;
    Set<String> completedCourses = new HashSet<>();

    public Student(String name) { this.name = name; }

    public void completeCourse(String course) { completedCourses.add(course); }

    public void enroll(Course course) throws CourseFullException, PrerequisiteNotMetException {
        if (!course.prerequisite.isEmpty() && !completedCourses.contains(course.prerequisite))
            throw new PrerequisiteNotMetException("Complete " + course.prerequisite + " before enrolling in " + course.name);
        course.enroll();
        System.out.println("Successfully enrolled in " + course.name);
    }
}

public class expthree3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Course> courses = new HashMap<>();
        courses.put("Core Java", new Course("Core Java", 2, ""));
        courses.put("Advanced Java", new Course("Advanced Java", 2, "Core Java"));

        System.out.print("Enter student name: ");
        Student student = new Student(sc.nextLine());

        while (true) {
            System.out.print("Enter course to enroll (or 'exit' to quit): ");
            String courseName = sc.nextLine();
            if (courseName.equalsIgnoreCase("exit")) break;

            Course course = courses.get(courseName);
            if (course == null) {
                System.out.println("Course not found.");
                continue;
            }

            try {
                student.enroll(course);
            } catch (CourseFullException | PrerequisiteNotMetException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("Mark course as completed? (yes/no): ");
            if (sc.nextLine().equalsIgnoreCase("yes")) student.completeCourse(courseName);
        }
        sc.close();
    }
}
