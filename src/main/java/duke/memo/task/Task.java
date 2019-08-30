package duke.memo.task;

import duke.memo.exception.DukeException;
import duke.memo.exception.NoDescriptionException;

public abstract class Task {
    protected String description;
    protected boolean isDone;
    private String taskType;

    /**
     * Constructor for Task.
     * Throw error if there is no time description or wrong format.
     *
     * @param description  Description for the Task.
     * @param taskType  Task type for the Task.
     * @throws DukeException  If details missing or in wrong format.
     */
    public Task(String description,String taskType) throws DukeException {
        this.taskType = taskType;

        if (description.isBlank()) {
            throw new NoDescriptionException(taskType);
        } else {
            this.description = description;
        }

        this.isDone = false;
    }

    public Task(String taskType) {
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

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public abstract String getPrintableMsg();

    @Override
    public String toString() {
        return getStatusIcon() + " " + getDescription();
    }
}
