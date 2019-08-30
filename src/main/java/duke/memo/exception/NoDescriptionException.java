package duke.memo.exception;

public class NoDescriptionException extends Exception{
    private String taskType;

    public NoDescriptionException(String taskType) {
        super();
        this.taskType = taskType;
    }

    public String getTaskType() {
        return taskType;
    }
}
