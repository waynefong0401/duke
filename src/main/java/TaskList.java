import java.util.ArrayList;

public class TaskList extends ArrayList<TaskNew> {

    public TaskList() {
        super();
    }

    public void addTask(String cmd) throws NoDescriptionException, NoTimeException {
        TaskNew curTask = TaskNew.valueOf(cmd.split(" ",2)[0]);
        curTask.setTask(cmd);
        add(curTask);
        System.out.println("Got it. I've added this task: ");
        System.out.println(curTask);
        System.out.println("Now you have " + size() + " tasks in the list.");
//        boolean isTask = true;
//        String[] curTask = {"",""};
//        String[] tempCurTask = cmd.split(" ", 2);
//        curTask[0] = tempCurTask[0];
//        if (tempCurTask.length != 1) curTask[1] = tempCurTask[1];
//        switch (curTask[0]) {
//        case "todo":
//            add(new ToDo(curTask[1]));
//            break;
//        case "deadline":
//            String[] ddlDetails = {"",""};
//            String[] tempDdlDetails = curTask[1].split("/", 2);
//            ddlDetails[0] = tempDdlDetails[0];
//            if (tempDdlDetails.length != 1) ddlDetails[1] = tempDdlDetails[1];
//            add(new Deadline(ddlDetails));
//            break;
//        case "event":
//            String[] eventDetails = {"",""};
//            String[] tempEventDetails = curTask[1].split("/", 2);
//            eventDetails[0] = tempEventDetails[0];
//            if (tempEventDetails.length != 1) eventDetails[1] = tempEventDetails[1];
//            add(new Event(eventDetails));
//            break;
//        default:
//            isTask = false;
//            System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
//        }
//        if (!isTask) return;
//        System.out.println("Got it. I've added this task: ");
//        System.out.println(get(size() - 1).toString());
//        System.out.println("Now you have " + String.valueOf(size()) + " tasks in the list.");
    }

    public TaskNew doneTask(String cmd) throws TaskNotExistException {
        try {
            return get(Integer.parseInt(cmd.substring(4).trim()) - 1).taskDone();
        } catch (NumberFormatException e) {
            throw new NotNumberException();
        } catch (IndexOutOfBoundsException e) {
            throw new TaskNotExistException();
        }
    }

    public TaskNew deleteTask(String cmd) throws TaskNotExistException {
        try {
            return remove(Integer.parseInt(cmd.substring(6).trim()) - 1);
        } catch (NumberFormatException e) {
            throw new NotNumberException();
        } catch (IndexOutOfBoundsException e) {
            throw new TaskNotExistException();
        }
    }
}

enum TaskNew {
    todo(false,"[T]"),event(true,"[E]","at"),deadline(true,"[D]","by");

    private String description, details, prep,abbreviation;
    private boolean hasDetails, isAt, isDone;

    TaskNew(boolean hasDetails,String abbreviation) {
        this.hasDetails = hasDetails;
        this.abbreviation = abbreviation;
        this.isDone = false;
    }

    TaskNew(boolean hasDetails, String abbreviation,String prep) {
        this.hasDetails = hasDetails;
        this.abbreviation = abbreviation;
        this.prep = prep;
        this.isDone = false;
    }

    public TaskNew setTask (String cmd) throws NoDescriptionException, NoTimeException {
        String[] curTask = cmd.split(" ", 2);
        if (curTask.length == 1)
            throw new NoDescriptionException(name());
        if (curTask[1].isBlank())
            throw new NoDescriptionException(name());
        if (hasDetails) {
            String[] eventDetails = curTask[1].split("/", 2);
            if (eventDetails.length == 1)
                throw new NoTimeException(name());
            if (eventDetails[1].isBlank())
                throw new NoTimeException(name());
            this.description = eventDetails[0];
            this.details = eventDetails[1];
        } else {
            this.description = curTask[1];
        }
        return this;
    }

    public TaskNew taskDone() {
        this.isDone = true;
        return this;
    }

    @Override
    public String toString() {
        return abbreviation + (isDone ? "\u2713 " : "\u2718 ") + description + (hasDetails ? " (" + prep + " " + details + ")" : "");
//        if (hasDetails) {
//            return abbreviation + description + " (" + prep + " " + details + ")";
//        } else {
//            return abbreviation + description;
//        }
    }
}

