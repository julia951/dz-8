import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentsGroup {
    private final Student headman;
    private final List<Student> students;
    private final List<String> tasks;
    private final List<String> completedTasks;

    public StudentsGroup(Student headman) {
        if (headman == null) {
            throw new IllegalArgumentException("Headman cannot be null");
        }
        this.headman = headman;
        this.students = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.completedTasks = new ArrayList<>();
    }

    public Student getHeadman() {
        return headman;
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public List<String> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public List<String> getCompletedTasks() {
        return Collections.unmodifiableList(completedTasks);
    }

    public StudentsGroup setHeadman(Student newHeadman) {
        if (newHeadman == null) {
            throw new IllegalArgumentException("New headman cannot be null");
        }
        return new StudentsGroup(newHeadman);
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        students.add(student);
    }

    public void removeStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        students.remove(student);
    }

    public void addTask(String task) {
        if (task == null || task.isEmpty()) {
            throw new IllegalArgumentException("Task cannot be null or empty");
        }
        tasks.add(task);
    }

    public void markTaskAsCompleted(Student student, String task) {
        if (student == null || task == null || task.isEmpty()) {
            throw new IllegalArgumentException("Student and task cannot be null or empty");
        }
        if (!students.contains(student)) {
            throw new IllegalArgumentException("Student is not in the group");
        }
        if (!tasks.contains(task)) {
            throw new IllegalArgumentException("Task does not exist for the group");
        }

        completedTasks.add(task);
        System.out.println("Task \"" + task + "\" completed by " + student.getName());
    }
}
