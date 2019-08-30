package duke.task;

import duke.exception.NoDescriptionException;
import duke.exception.NoTimeException;
import duke.exception.TimeFormatErrorException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {
    protected Date at;
    private static String TASKTYPE = "event";
    private static SimpleDateFormat DATEFORMAT = new SimpleDateFormat(("dd/MM/yyyy HHmm"));

    public Event(String des) throws NoTimeException, TimeFormatErrorException, NoDescriptionException {
        super(TASKTYPE);
        if (des.trim().isBlank()) throw new NoDescriptionException(TASKTYPE);
        try {
            String[] details = des.split("/", 2);
            description = details[0];
            at = DATEFORMAT.parse(details[1]);
        } catch (ParseException e) {
            throw new TimeFormatErrorException(TASKTYPE);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoTimeException(TASKTYPE);
        }
    }

    public Event(String[] taskDetails) throws NoDescriptionException, TimeFormatErrorException {
        super(taskDetails[2],TASKTYPE);
        this.isDone = taskDetails[1].equalsIgnoreCase("1");
        try
        {
            this.at = DATEFORMAT.parse(taskDetails[3]);
        } catch (ParseException e)
        {
            throw new TimeFormatErrorException(TASKTYPE);
        }
    }

    @Override
    public String getPrintableMsg() {
        return "E" + " | " + (isDone ? "1" : "0") + " | " + description + " | " + DATEFORMAT.format(at);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + DATEFORMAT.format(at) + ")";
    }

}