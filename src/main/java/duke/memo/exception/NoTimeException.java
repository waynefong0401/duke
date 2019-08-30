package duke.memo.exception;

public class NoTimeException extends Exception{
    private String taskType;

    public NoTimeException(String taskType) {
        super();
        this.taskType = taskType;
    }

    public String getTaskType() {
        return taskType;
    }
}
