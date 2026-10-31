import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
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
            name = Input.reader.nextLine();
            if (name.isBlank()) {
                System.out.println("Invalid name. Enter valid name:");
            } else {
                invalidName = false;
            }
        }

        boolean invalidDesc = true;
        while (invalidDesc) {
            System.out.println("Task description (1 line only): ");
            desc = Input.reader.nextLine();
            if (desc.isBlank()) {
                System.out.println("Invalid description. Enter valid description: ");
            } else {
                invalidDesc = false;
            }
        }

        boolean invalidPriority = true;
        while (invalidPriority) {
            System.out.println("Task priority (LOW, MEDIUM, HIGH): ");

            String input = Input.reader.nextLine();
            try {
                priority = Priority.valueOf(input.toUpperCase());
                if (priority == null) {
                    System.out.println("Invalid priority. Enter valid priority (LOW, MEDIUM, HIGH): ");
                } else {
                    invalidPriority = false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid priority. Enter one of LOW, MEDIUM, HIGH.");
            }

        }

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

        int ID = manager.addTask(name, desc, priority, dueDate);
        System.out.println("Task created successfully. Task ID: " + ID);
    }

    public void comleteTask() {
        System.out.println("Enter task ID: ");
        int ID = Input.reader.nextInt();
        Input.reader.nextLine();
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
        int ID = Input.reader.nextInt();
        Input.reader.nextLine();
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
            String wanted = Input.reader.nextLine();

            try {
                wantedPriority = Priority.valueOf(wanted.toUpperCase());
                invalidPriority = false;
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

    public void changeTaskName() {
        System.out.println("Enter task ID: ");
        int ID = Input.reader.nextInt();
        Input.reader.nextLine();
        if (!manager.exists(ID)) {
            System.out.println("Invalid task ID.");
            return;
        }

        System.out.println("Enter task description: ");
        String newTitle = Input.reader.nextLine();
        if (!newTitle.isBlank()) {
            manager.changeTaskName(ID, newTitle);
        } else {
            System.out.println("Invalid title. Title not changed.");
        }
    }

    public void changeTaskDescription() {
        System.out.println("Enter task ID: ");
        int ID = Input.reader.nextInt();
        Input.reader.nextLine();
        if (!manager.exists(ID)) {
            System.out.println("Invalid task ID.");
            return;
        }

        System.out.println("Enter task description: ");
        String newDesc = Input.reader.nextLine();
        if (!newDesc.isBlank()) {
            manager.changeTaskDescription(ID, newDesc);
        } else {
            System.out.println("Invalid description. Description not changed.");
        }
    }

    public void changeTaskPriority() {
        System.out.println("Enter task ID: ");
        int ID = Input.reader.nextInt();
        Input.reader.nextLine();
        if (!manager.exists(ID)) {
            System.out.println("Invalid task ID.");
        } else {
            manager.changeTaskPriority(ID);
        }
    }

    public void changeTaskDueDate() {
        System.out.println("Enter task ID: ");
        int ID = Input.reader.nextInt();
        Input.reader.nextLine();
        if (!manager.exists(ID)) {
            System.out.println("Invalid task ID.");
        } else {
            manager.changeTaskDueDate(ID);
        }
    }

}
