public class NoTimeException extends Exception{
    public NoTimeException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "OOPS!!! The time details of a " + getMessage() + " cannot be empty.";
    }
}
