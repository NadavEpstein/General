import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    public static Scanner reader = new Scanner(System.in);
    private TaskManager manager;

    public UserInterface() {
        manager = new TaskManager();
    }

    public void addTask() {
        String name= "", desc = "";
        Priority priority = Priority.LOW;
        LocalDate dueDate = LocalDate.of(1,1,1);

        boolean invalidName = true;
        while (invalidName) {
            System.out.println("Task name: ");
            name = reader.nextLine();
            if (name == null) {
                System.out.println("Invalid name. Enter valid name:");
            } else {
                invalidName = false;
            }
        }

        boolean invalidDesc = true;
        while (invalidDesc) {
            System.out.println("Task description (1 line only): ");
            desc = reader.nextLine();
            if (desc == null) {
                System.out.println("Invalid description. Enter valid description: ");
            } else {
                invalidDesc = false;
            }
        }

        boolean invalidPriority = true;
        while (invalidPriority) {
            System.out.println("Task priority (LOW, MEDIUM, HIGH): ");

            priority = Priority.valueOf(reader.nextLine());
            if (desc == null) {
                System.out.println("Invalid priority. Enter valid priority (LOW, MEDIUM, HIGH): ");
            } else {
                invalidPriority = false;
            }
        }

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

        int ID = manager.addTask(name, desc, priority, dueDate);
        System.out.println("Task created successfully. Task ID: " + ID);
    }

    public void comleteTask() {
        System.out.println("Enter task ID: ");
        int ID = reader.nextInt();
        if (!manager.exists(ID)) {
            System.out.println("Invalid task ID. No task Completed.");
        } else if (manager.getTask(ID).isCompleted()) {
            System.out.println("Task already completed.");
        } else {
            manager.completeTask(ID);
        }
    }

    public void listAllTasks() {
        for (Task t : manager.getTasks().values()) {
            System.out.println(t.toString());
        }
    }

    public void listPendingTasks() {
        for (Task t: manager.getPendingTasks().values()) {
            System.out.println(t.toString());
        }
    }

    public void removeTask() {
        System.out.println("Enter task ID: ");
        int ID = reader.nextInt();
        if (!manager.exists(ID)) {
            System.out.println("Invalid task ID. No task removed.");
        } else {
            manager.removeTask(ID);
        }
    }

    public void listOverdueTasks() {
        for (Task t: manager.getOverdueTasks().values()) {
            System.out.println(t.toString());
        }
    }

    public void listPriorityTasks() {
        Priority wantedPriority = Priority.valueOf("LOW");
        boolean invalidPriority = true;
        while (invalidPriority) {
            System.out.println("Enter wanted priority: ");
            String wanted = reader.nextLine();

            try {
                wantedPriority = Priority.valueOf(wanted.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid priority. Enter one of LOW, MEDIUM, HIGH.");
            }
        }

        for (Task t: manager.getPriorityTasks(wantedPriority).values()) {
            System.out.println(t.toString());
        }
    }

    public void listOrderedTasks() {
        for (Task t: manager.getOrderedTasks()) {
            System.out.println(t.toString());
        }
    }


}
