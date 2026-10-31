public class Task {
    // since each task will be assigned an id, we will have the Id number
    // based on the chronological time when it was created
    private static int IDCounter = 0;

    private int ID;
    private String title;
    private String description;
    private boolean completed;


    public Task(String title, String desc, int ID) {
        if (title == null || desc == null) {
            System.out.println("NULL title or description. Task not created.");
            return;

        }
        this.title = title;
        this.description = desc;
        this.completed = false;

        this.ID = ID;
    }

    public Task copy () {
        return new Task(title, description, ID);
    }

    public int getID() {
        return this.ID;
    }

    public String getTitle() {
        return this.title;
    }

    public  String getDescription() {
        return this.description;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public void complete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        String state;
        if (completed) { state = "completed"; } else { state = "pending"; };
        return "[Task ID:" + this.ID
                + "\n Title: " + this.title
                + "\n Description: " + this.description
                + "\n State: " + state + "]";
    }

}
