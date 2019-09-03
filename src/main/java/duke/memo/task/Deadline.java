package duke.memo.task;

import duke.memo.exception.DukeException;
import duke.memo.exception.NoDescriptionException;
import duke.memo.exception.NoTimeException;
import duke.memo.exception.TimeFormatErrorException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
    protected Date by;
    private static String TASKTYPE = "event";
    private static SimpleDateFormat DATEFORMAT = new SimpleDateFormat("dd/MM/yyyy HHmm");

    /**
     * Constructor for Deadline Task.
     * Throw error if there is no time description or wrong format.
     *
     * @param desc  Description for the Deadline Task.
     * @throws DukeException  If details missing or in wrong format.
     */
    public Deadline(String desc) throws DukeException {
        super(TASKTYPE);
        if (desc.trim().isBlank()) {
            throw new NoDescriptionException(TASKTYPE);
        }
        try {
            String[] details = desc.split("/", 2);
            description = details[0];
            by = DATEFORMAT.parse(details[1]);
        } catch (ParseException e) {
            throw new TimeFormatErrorException(TASKTYPE);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoTimeException(TASKTYPE);
        }
    }

    /**
     * Constructor for Deadline Task.
     * Throw error if there is no time description or wrong format.
     *
     * @param taskDetails  Details for the Deadline Task.
     * @throws DukeException  If details missing or in wrong format.
     */
    public Deadline(String[] taskDetails) throws DukeException {
        super(taskDetails[2], TASKTYPE);
        isDone = taskDetails[1].equalsIgnoreCase("1");
        try {
            by = DATEFORMAT.parse(taskDetails[3]);
        } catch (ParseException e) {
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