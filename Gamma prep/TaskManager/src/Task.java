import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task {

    private int ID;
    private String title;
    private String description;
    private boolean completed;
    private Priority priority;
    private LocalDate dueDate;
    private List<String> tags;

    public Task(String title, String desc, int ID, Priority priority, LocalDate date) {

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Invalid title.");
        }

        if (desc == null || desc.isBlank()) {
            throw new IllegalArgumentException("Invalid description.");
        }

        if (priority == null) {
            throw new IllegalArgumentException("Invalid priority.");
        }

        if (date == null) {
            throw new IllegalArgumentException("Invalid due date.");
        }

        this.title = title;
        this.description = desc;
        this.ID = ID;
        this.priority = priority;
        this.dueDate = date;
        this.completed = false;
        this.tags = new ArrayList<>();
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

    public List<String> getTags() {
        List<String> tagsCopy = new ArrayList<>();
        tagsCopy.addAll(tags);
        return tagsCopy;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            System.out.println("Invalid title. Title remained " + this.title);
            return;
        }

        this.title = title;
    }

    public void setDescription(String description) {
        if (description == null || description.isBlank()) {
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
                p = Priority.valueOf(Input.reader.nextLine().toUpperCase());
                invalidPriority = false;
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
            int year = Input.reader.nextInt();
            Input.reader.nextLine();
            System.out.println("Task due date month: ");
            int month = Input.reader.nextInt();
            Input.reader.nextLine();
            System.out.println("Task due date day: ");
            int day = Input.reader.nextInt();
            Input.reader.nextLine();

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

    public void addTag(String tag) {
        if (tag == null || tag.isBlank()) {
            System.out.println("Invalid tag. No tag added.");
            return;
        }

        tags.add(tag.toUpperCase());
    }

    public boolean hasTag(String tag) {
        if (tag == null || tag.isBlank()) {
            System.out.println("Invalid tag.");
            return false;
        }

        return tags.contains(tag.toUpperCase());
    }

    @Override
    public String toString() {
        String state;
        if (completed) {
            state = "completed";
        } else {
            state = "pending";
        }

        return "[Task ID:" + this.ID
                + "\n Title: " + this.title
                + "\n Description: " + this.description
                + "\n Priority: " + this.priority
                + "\n State: " + state
                + "\n Due date: " + this.dueDate.toString()
                + "\nTags: " + tags.toString() + "]";
    }

}
