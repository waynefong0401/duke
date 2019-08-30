package duke.task;

import duke.exception.NoDescriptionException;

public abstract class Task {
    protected String description;
    protected boolean isDone;
    private String taskType;

    public Task(String description,String taskType) throws NoDescriptionException {
        this.taskType = taskType;

        if (description.isBlank()) throw new NoDescriptionException(taskType);
        else this.description = description;

        this.isDone = false;
    }

    public Task (String taskType) {
        this.taskType = taskType;
        this.isDone = false;
    }

    public Task taskDone() {
        this.isDone = true;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public String getTaskType() {
        return taskType;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public abstract String getPrintableMsg();

    @Override
    public String toString() {
        return getStatusIcon() + " " + getDescription();
    }
}
