public class Event extends Task {
    protected String at;
    private static String TASKTYPE = "event";

    public Event(String[] curTask) throws NoDescriptionException, NoTimeException {
        super(curTask[0],TASKTYPE);
        if (curTask[1].isBlank()) throw new NoTimeException(TASKTYPE);
        else this.at = curTask[1];
    }

    @Override
    public String getPrintableMsg() {
        return "E" + " | " + (isDone ? "1" : "0") + " | " + description + " | " + at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

}