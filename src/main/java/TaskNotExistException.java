public class TaskNotExistException extends Exception {
    public TaskNotExistException() {
        super();
    }

    @Override
    public String toString() {
        return "OOPS!!! I'm sorry, but there is no such task in the list";
    }
}
