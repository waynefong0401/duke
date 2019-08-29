import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
    protected Date by;
    private static String TASKTYPE= "event";
    private static SimpleDateFormat DATEFORMAT = new SimpleDateFormat(("dd/MM/yyyy HHmm"));

    public Deadline(String[] curTask) throws NoDescriptionException, NoTimeException, ParseException {
        super(curTask[0],TASKTYPE);
        if (curTask[1].isBlank()) throw new NoTimeException(TASKTYPE);
        else {
            this.by = DATEFORMAT.parse(curTask[1]);
        }
    }

    @Override
    public String getPrintableMsg() {
        return "D" + " | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + DATEFORMAT.format(by) + ")";
    }
}