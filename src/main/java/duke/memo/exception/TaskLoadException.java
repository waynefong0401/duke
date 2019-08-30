package duke.memo.exception;

public class TaskLoadException extends DukeException {
    public TaskLoadException() {
        super();
    }

    @Override
    public String getMessage() {
        return "OOPS!!! I cannot load the history record.";
    }
}
