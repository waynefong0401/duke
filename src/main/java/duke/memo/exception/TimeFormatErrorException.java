package duke.memo.exception;

public class TimeFormatErrorException extends Exception {
    private String taskType;

    public TimeFormatErrorException(String taskType) {
        super();
        this.taskType = taskType;
    }

    public String getTaskType() {
        return taskType;
    }
}
