package duke.task;

import duke.exception.NoDescriptionException;
import duke.exception.NoTimeException;
import duke.exception.TimeFormatErrorException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
    protected Date by;
    private static String TASKTYPE= "event";
    private static SimpleDateFormat DATEFORMAT = new SimpleDateFormat(("dd/MM/yyyy HHmm"));

    public Deadline(String des) throws NoTimeException, TimeFormatErrorException, NoDescriptionException {
        super(TASKTYPE);
        if (des.trim().isBlank()) throw new NoDescriptionException(TASKTYPE);
        try {
            String[] details = des.split("/", 2);
            description = details[0];
            by = DATEFORMAT.parse(details[1]);
        } catch (ParseException e) {
            throw new TimeFormatErrorException(TASKTYPE);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoTimeException(TASKTYPE);
        }
    }

    public Deadline(String[] taskDetails) throws NoDescriptionException, TimeFormatErrorException {
        super(taskDetails[2],TASKTYPE);
        this.isDone = taskDetails[1].equalsIgnoreCase("1");
        try
        {
            this.by = DATEFORMAT.parse(taskDetails[3]);
        } catch (ParseException e)
        {
            throw new TimeFormatErrorException(TASKTYPE);
        }
    }

    @Override
    public String getPrintableMsg() {
        return "D" + " | " + (isDone ? "1" : "0") + " | " + description + " | " + DATEFORMAT.format(by);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + DATEFORMAT.format(by) + ")";
    }
}