import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    private Map<Integer, Task> tasks;

    public TaskManager () {
        this.tasks = new HashMap<>();
    }

    /*
    Create a task with a title and description.
    Complete a task by providing its ID.
    List all tasks.
    List only pending tasks.
    Delete a task by providing its ID.
     */

    public void addTask(String title, String description) {
        Task t = new Task(title, description);
        tasks.put(t.getID(),t);
    }

    public void completeTask(int ID) {
        tasks.get(ID).complete();
    }

    public void listAllTasks() {
        for (Task t : this.tasks.values()) {
            System.out.println(t.toString());
        }
    }

    public void listPendingTasks() {
        for (Task t: tasks.values()) {
            if (!t.isCompleted()) {
                System.out.println(t.toString());
            }
        }
    }

    public void removeTask(int ID) {
        tasks.remove(ID);
    }
}
