public class Task {
    protected String description;
    protected boolean isDone;
    private String taskType;

    public Task(String description,String taskType) throws NoDescriptionException {
        this.taskType = taskType;

        if (description.isBlank()) throw new NoDescriptionException(taskType);
        else this.description = description;

        this.isDone = false;
    }

    public Task taskDone() {
        this.isDone = true;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    @Override
    public String toString() {
        return getStatusIcon() + " " + getDescription();
    }
}
