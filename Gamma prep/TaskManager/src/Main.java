import java.util.Scanner;

public class Main {
    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {

        UserInterface userInterface = new UserInterface();
        boolean cont = true;
        while (cont) {
            System.out.println("Choose an option:\n"
                                + "0: exit\n"
                                + "1: Create a task\n"
                                + "2: Edit tasks\n"
                                + "3: Complete a task\n"
                                + "4: Delete a task\n"
                                + "5: List tasks in a specific order\n");

            int choice = reader.nextInt();
            if (0 > choice || choice > 5) {
                System.out.println("Invalid choice. please Enter another choice.");
                continue;
            }
            switch (choice) {
                case 0:
                    cont = false;
                    System.out.println("Goodbye.");
                    break;
                case 1:
                    userInterface.addTask();
                    break;
                case 2:
                    editTasks(userInterface);
                    break;
                case 3:
                    userInterface.comleteTask();
                case 4:
                    userInterface.removeTask();
                    break;
                case 5:
                    listTasks(userInterface);

                default:

            }
        }
    }

    public static void editTasks(UserInterface userInterface) {
        System.out.println("Choose an option to edit:\n"
                + "1: Task name\n"
                + "2: Task description\n"
                + "3: Task Priority\n"
                + "4: Task due date\n");
        int choice = reader.nextInt();
        if (0 > choice || choice > 4) {
            System.out.println("Invalid choice. please Enter another choice.");
        }
        switch (choice) {
            case 1:
                userInterface.changeTaskName();
            case 2:
                userInterface.changeTaskDescription();
            case 3:
                userInterface.changeTaskPriority();
            case 4:
                userInterface.changeTaskDueDate();
            default:

        }
    }

    public static void listTasks(UserInterface userInterface) {
        System.out.println("Choose an option to edit:\n"
                + "1: List all\n"
                + "2: List pending\n"
                + "3: List overdue\n"
                + "4: List by priority\n"
                + "5: List by urgency");
        int choice = reader.nextInt();
        if (0 > choice || choice > 5) {
            System.out.println("Invalid choice. please Enter another choice.");
        }
        switch (choice) {
            case 1:
                userInterface.listAllTasks();
            case 2:
                userInterface.listPendingTasks();
            case 3:
                userInterface.listOverdueTasks();
            case 4:
                userInterface.listPriorityTasks();
            case 5:
                userInterface.listOrderedTasks();
            default:
        }
    }
}
