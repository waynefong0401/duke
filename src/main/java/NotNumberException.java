public class NotNumberException extends NumberFormatException{
    public NotNumberException() {
        super();
    }

    @Override
    public String toString() {
        return "OOPS!!! there is no number entered";
    }
}
