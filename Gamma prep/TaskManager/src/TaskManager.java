import java.util.HashMap;
import java.util.Map;

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

    public int addTask(String title, String description) {
        this.taskCounter++;
        Task t = new Task(title, description, taskCounter);
        tasks.put(t.getID(),t);

        return t.getID();
    }

    public void completeTask(int ID) {
        tasks.get(ID).complete();
    }



    public void removeTask(int ID) {
        tasks.remove(ID);
    }
}
