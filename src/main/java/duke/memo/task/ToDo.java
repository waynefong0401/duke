package duke.task;

import duke.exception.NoDescriptionException;

public class ToDo extends Task {
    private static String TASKTYPE = "todo";
    
    public ToDo(String des) throws NoDescriptionException {
            super(des,TASKTYPE);
    }

    public ToDo(String[] taskDetails) throws NoDescriptionException {
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
