public class Deadline extends Task {
    protected String by;
    private static String TASKTYPE= "event";

    public Deadline(String[] curTask) throws NoDescriptionException, NoTimeException {
        super(curTask[0],TASKTYPE);
        if (curTask[1].isBlank()) throw new NoTimeException(TASKTYPE);
        else this.by = curTask[1];
    }

    @Override
    public String getPrintableMsg() {
        return "D" + " | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}