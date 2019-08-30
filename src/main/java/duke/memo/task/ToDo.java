package duke.memo.task;

import duke.memo.exception.DukeException;

public class ToDo extends Task {
    private static String TASKTYPE = "todo";

    /**
     * Constructor for ToDo Task.
     * Throw error if there is no description.
     *
     * @param des  Description for the ToDo Task.
     * @throws DukeException  If detail is missing.
     */
    public ToDo(String des) throws DukeException {
        super(des,TASKTYPE);
    }

    /**
     * Constructor for ToDo Task.
     * Throw error if there is no description.
     *
     * @param taskDetails  Details for the Deadline Task.
     * @throws DukeException  If detail is missing.
     */
    public ToDo(String[] taskDetails) throws DukeException {
        super(taskDetails[2],TASKTYPE);
        this.isDone = taskDetails[1].equalsIgnoreCase("1");
    }

    @Override
    public String getPrintableMsg() {
        return "T" + " | " + (isDone ? "1" : "0") + " | " + description;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
