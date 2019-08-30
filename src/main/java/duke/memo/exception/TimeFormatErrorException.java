package duke.memo.exception;

public class TimeFormatErrorException extends DukeException {
    private String taskType;

    public TimeFormatErrorException(String taskType) {
        super();
        this.taskType = taskType;
    }

    public String getTaskType() {
        return taskType;
    }

    @Override
    public String getMessage() {
        return "OOPS!!! The time format of a " + taskType + " cannot be read.";
    }
}
