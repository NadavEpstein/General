import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskManager {
    public static Scanner reader = new Scanner(System.in);
    private Map<Integer, Task> tasks;
    private int taskCounter;

    public TaskManager () {
        this.tasks = new HashMap<>();
        this.taskCounter = 0;
    }

    public Map<Integer, Task> getTasks() {
        Map<Integer, Task> tasksCopy = new HashMap<>();
        for (Task t : tasks.values()) {
            tasksCopy.put(t.getID(), t.copy());
        }
        return tasksCopy;
    }

    public boolean exists(int ID) {
        return tasks.get(ID) != null;
    }

    public Task getTask(int ID) {
        if (!exists(ID)) {
            return null;
        } else {
            return tasks.get(ID).copy();
        }
    }

    public int addTask(String title, String description, Priority priority, LocalDate dueDate) {
        this.taskCounter++;
        Task t = new Task(title, description, taskCounter, priority, dueDate);
        tasks.put(t.getID(),t);

        return t.getID();
    }

    public void completeTask(int ID) {
        if (!exists(ID)) {
            System.out.println("Invalid ID. No task completed.");
        } else {
            tasks.get(ID).complete();
        }
    }

    public void removeTask(int ID) {
        tasks.remove(ID);
    }

    public Map<Integer, Task> getPendingTasks() {
        Map<Integer, Task> tasksCopy = new HashMap<>();
        for (Task t : tasks.values()) {
            if (!t.isCompleted()){
                tasksCopy.put(t.getID(), t.copy());
            }
        }
        return tasksCopy;
    }

    public Map<Integer, Task> getOverdueTasks() {
        Map<Integer, Task> tasksCopy = new HashMap<>();
        for (Task t : tasks.values()) {
            if (t.isOverdue()){
                tasksCopy.put(t.getID(), t.copy());
            }
        }
        return tasksCopy;
    }

    public Map<Integer, Task> getPriorityTasks(Priority priority) {
        if (priority == null) {
            System.out.println("Invalid priority.");
            return null;
        }

        Map<Integer, Task> tasksCopy = new HashMap<>();
        for (Task t : tasks.values()) {
            if (t.getPriority().equals(priority)){
                tasksCopy.put(t.getID(), t.copy());
            }
        }
        return tasksCopy;
    }

    public Collection<Task> getOrderedTasks() {
        // i need a copy to not harm the original tasks in the process.
        Collection<Task> tasks = this.getTasks().values();

        Task[] orderedTasks = new Task[tasks.size()];
        int index = 0;

        Task mostUrgent = null;
        for (Task t : tasks) {
            mostUrgent = t;
            for (Task other : tasks) {
                if (mostUrgent.getID() == t.getID()) continue;

                if (other.getDueDate().isBefore(t.getDueDate())) {
                    mostUrgent = other;
                }
            }

            tasks.remove(mostUrgent);
            orderedTasks[index] = mostUrgent;
            index++;
        }

        return tasks;
    }

    public void changeTaskName(int ID) {
        System.out.println("Enter task title: ");
        String newTitle = reader.nextLine();
        if (newTitle != null) {
            tasks.get(ID).setTitle(newTitle);
        }
    }

    public void changeTaskDescription(int ID) {
        System.out.println("Enter task description: ");
        String newDesc = reader.nextLine();
        if (newDesc != null) {
            tasks.get(ID).setTitle(newDesc);
        }
    }

    public void changeTaskPriority(int ID) {
        System.out.println("Enter task title: ");
        String newTitle = reader.nextLine();
        if (newTitle != null) {
            tasks.get(ID).setPriority();
        }
    }

    public void changeTaskDueDate(int ID) {
        System.out.println("Enter task title: ");
        String newTitle = reader.nextLine();
        if (newTitle != null) {
            tasks.get(ID).setDueDate();
        }
    }
}
