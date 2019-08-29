import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {
    protected Date at;
    private static String TASKTYPE = "event";
    private static SimpleDateFormat DATEFORMAT = new SimpleDateFormat(("dd/MM/yyyy HHmm"));

    public Event(String[] curTask) throws NoDescriptionException, NoTimeException, ParseException {
        super(curTask[0],TASKTYPE);
        if (curTask[1].isBlank()) throw new NoTimeException(TASKTYPE);
        else {
            this.at = DATEFORMAT.parse(curTask[1]);
        }
    }

    @Override
    public String getPrintableMsg() {
        return "E" + " | " + (isDone ? "1" : "0") + " | " + description + " | " + at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + DATEFORMAT.format(at) + ")";
    }

}