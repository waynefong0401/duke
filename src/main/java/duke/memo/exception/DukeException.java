package duke.memo.exception;

public class DukeException extends Throwable{
    private String msg;

    public DukeException(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
