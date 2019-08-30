package duke.memo.exception;

public class NoDescriptionException extends DukeException{
    private String taskType;

    public NoDescriptionException(String taskType) {
        super();
        this.taskType = taskType;
    }

    public String getTaskType() {
        return taskType;
    }

    @Override
    public String getMessage() {
        return "OOPS!!! The description of a " + taskType + " cannot be empty.";
    }
}
