public class Main {
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

            int choice = Input.reader.nextInt();
            Input.reader.nextLine();
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
                    break;
                case 4:
                    userInterface.removeTask();
                    break;
                case 5:
                    listTasks(userInterface);
                    break;

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
        int choice = Input.reader.nextInt();
        Input.reader.nextLine();
        if (0 > choice || choice > 4) {
            System.out.println("Invalid choice. please Enter another choice.");
        }
        switch (choice) {
            case 1:
                userInterface.changeTaskName();
                break;
            case 2:
                userInterface.changeTaskDescription();
                break;
            case 3:
                userInterface.changeTaskPriority();
                break;
            case 4:
                userInterface.changeTaskDueDate();
                break;
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
        int choice = Input.reader.nextInt();
        Input.reader.nextLine();
        if (0 > choice || choice > 5) {
            System.out.println("Invalid choice. please Enter another choice.");
        }
        switch (choice) {
            case 1:
                userInterface.listAllTasks();
                break;
            case 2:
                userInterface.listPendingTasks();
                break;
            case 3:
                userInterface.listOverdueTasks();
                break;
            case 4:
                userInterface.listPriorityTasks();
                break;
            case 5:
                userInterface.listOrderedTasks();
                break;
            default:
        }
    }
}
