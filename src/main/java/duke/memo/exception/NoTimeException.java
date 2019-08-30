package duke.memo.exception;

public class NoTimeException extends DukeException{
    private String taskType;

    public NoTimeException(String taskType) {
        super();
        this.taskType = taskType;
    }

    public String getTaskType() {
        return taskType;
    }

    @Override
    public String getMessage() {
        return "OOPS!!! The time details of a " + taskType + " cannot be empty.";
    }
}
