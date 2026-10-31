import java.time.LocalDate;
import java.util.*;

public class TaskManager {
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
        try {
            Task t = new Task(title, description, taskCounter + 1, priority, dueDate);
            this.taskCounter++;
            tasks.put(t.getID(),t);
            return t.getID();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return -1;
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

    public List<Task> getOrderedTasks() {
        Comparator<Task> byDueDate =
                (t1, t2) -> t1.getDueDate().compareTo(t2.getDueDate());

        List<Task> tasks = new ArrayList<>();
        for (Task t : this.tasks.values()) {
            tasks.add(t.copy());
        }

        tasks.sort(byDueDate);
        return tasks;
    }

    public void changeTaskName(int ID, String title) {
        tasks.get(ID).setTitle(title);
    }

    public void changeTaskDescription(int ID, String desc) {
        tasks.get(ID).setDescription(desc);
    }

    public void changeTaskPriority(int ID) {
        if (exists(ID)) {
            tasks.get(ID).setPriority();
        }
    }

    public void changeTaskDueDate(int ID) {
        if (exists(ID)) {
            tasks.get(ID).setDueDate();
        }
    }
}
