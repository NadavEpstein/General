import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Task {

    public static Scanner reader = new Scanner (System.in);

    private int ID;
    private String title;
    private String description;
    private boolean completed;
    private Priority priority;
    private LocalDate dueDate;


    public Task(String title, String desc, int ID, Priority priority, LocalDate date) {
        if (title == null || desc == null) {
            System.out.println("NULL title or description. Task not created.");
            return;
        }
        this.title = title;
        this.description = desc;
        this.completed = false;
        this.priority = priority;
        this.dueDate = date;

        this.ID = ID;
    }

    public Task copy () {
        Task copy =  new Task(title, description, ID, priority, dueDate);
        copy.completed = this.completed;
        return copy;
    }

    public int getID() {
        return this.ID;
    }

    public String getTitle() {
        return this.title;
    }

    public  String getDescription() {
        return this.description;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    //practically get completed
    public boolean isCompleted() {
        return this.completed;
    }

    public void setTitle(String title) {
        if (title == null) {
            System.out.println("Invalid title. Title remained " + this.title);
            return;
        }

        this.title = title;
    }

    public void setDescription(String description) {
        if (description == null) {
            System.out.println("Invalid description. description remained:\n" + this.description);
            return;
        }

        this.description = description;
    }

    //practically set completed
    public void complete() {
        this.completed = true;
    }

    public void setPriority() {
        Priority p = Priority.valueOf("LOW");
        boolean invalidPriority = true;
        while (invalidPriority) {
            System.out.println("Task priority: ");
            try {
                p = Priority.valueOf(reader.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid priority. Enter one of LOW, MEDIUM, HIGH.");
            }
        }

        this.priority = p;
    }

    public void setDueDate() {
        boolean invalidDate = true;
        while (invalidDate) {
            System.out.println("Task due date Year: ");
            int year = reader.nextInt();
            System.out.println("Task due date month: ");
            int month = reader.nextInt();
            System.out.println("Task due date day: ");
            int day = reader.nextInt();

            try {
                dueDate = LocalDate.of(year, month, day);
                invalidDate = false;
            } catch (DateTimeException e) {
                System.out.println("Invalid date. Try again.");
            }
        }
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate) && !completed;
    }

    @Override
    public String toString() {
        String state;
        if (completed) {
            state = "completed";
        } else {
            state = "pending";
        }
        ;
        return "[Task ID:" + this.ID
                + "\n Title: " + this.title
                + "\n Description: " + this.description
                + "\n Priority: " + this.priority
                + "\n State: " + state + "]";
    }

}
