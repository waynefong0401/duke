public class NoDescriptionException extends Exception{
    public NoDescriptionException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "OOPS!!! The description of a " + getMessage() + " cannot be empty.";
    }
}
