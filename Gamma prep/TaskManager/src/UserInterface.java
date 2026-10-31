import java.util.Scanner;

public class UserInterface {
    public static Scanner reader = new Scanner(System.in);
    private TaskManager manager;

    public UserInterface() {
        manager = new TaskManager();
    }

    public void addTask() {
        String name= "", desc = "";
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

        int ID = manager.addTask(name, desc);
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
        for (Task t: manager.getTasks().values()) {
            if (!t.isCompleted()) {
                System.out.println(t.toString());
            }
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
}
