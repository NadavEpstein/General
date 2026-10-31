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
                                + "2: Complete a task\n"
                                + "3: List all tasks\n"
                                + "4: List only pending tasks\n"
                                + "5: Delete a task");

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
                    userInterface.comleteTask();
                    break;
                case 3:
                    userInterface.listAllTasks();
                    break;
                case 4:
                    userInterface.listPendingTasks();
                case 5:
                    userInterface.removeTask();
                default:

            }
        }
    }
}
