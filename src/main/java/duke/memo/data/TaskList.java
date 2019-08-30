package duke.memo.data;

import duke.memo.exception.NoDescriptionException;
import duke.memo.exception.NoTimeException;
import duke.memo.exception.TimeFormatErrorException;
import duke.memo.task.Deadline;
import duke.memo.task.Event;
import duke.memo.task.Task;
import duke.memo.task.ToDo;
import java.util.ArrayList;
import java.util.Iterator;

public class TaskList extends ArrayList<Task> {

    public TaskList() {
        super();
    }

    public TaskList(ArrayList<String> taskList) throws NoTimeException, TimeFormatErrorException, NoDescriptionException {
        super();
        Iterator<String> iter = taskList.iterator();
//        System.out.println(taskList.size());
        while (iter.hasNext()) {
//            String cur = iter.next();
//            System.out.println(cur);
            add(readLog(iter.next()));
        }
    }

    public Task readLog(String log) throws NoDescriptionException, TimeFormatErrorException, NoTimeException {
        String[] taskDetails = log.split(" \\| ",4);
        switch (taskDetails[0]) {
        case "T" :
            return new ToDo(taskDetails);
        case "E" :
            return new Event(taskDetails);
        case "D" :
            return new Deadline(taskDetails);
        }
        return null;
    }


//    public String[] addTask(String cmd) throws NoDescriptionException, NoTimeException, IOException, TimeFormatErrorException, TaskTypeError {
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
//            add(new Deadline(curTask[1]));
////            String[] ddlDetails = {"",""};
////            String[] tempDdlDetails = curTask[1].split("/", 2);
////            ddlDetails[0] = tempDdlDetails[0];
////            if (tempDdlDetails.length != 1) ddlDetails[1] = tempDdlDetails[1];
////            add(new Deadline(ddlDetails));
//            break;
//        case "event":
//            add(new Event(curTask[1]));
////            String[] eventDetails = {"",""};
////            String[] tempEventDetails = curTask[1].split("/", 2);
////            eventDetails[0] = tempEventDetails[0];
////            if (tempEventDetails.length != 1) eventDetails[1] = tempEventDetails[1];
////            add(new Event(eventDetails));
//            break;
//        default:
//            isTask = false;
////
////            System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
//        }
//        if (!isTask) {
//            throw new TaskTypeError();
//        }
//        saveTask();
//        return new String[] {get(size() - 1).toString(), String.valueOf(size())};
////        System.out.println("Got it. I've added this task: ");
////        System.out.println(get(size() - 1).toString());
////        System.out.println("Now you have " + String.valueOf(size()) + " tasks in the list.");
//
//    }

//    public Task doneTask(String cmd) throws TaskNotExistException {
//        try {
//            Task addedTask = get(Integer.parseInt(cmd.substring(4).trim()) - 1).taskDone();
//            saveTask();
//            return addedTask;
//        } catch (NumberFormatException e) {
//            throw new NotNumberException();
//        } catch (IndexOutOfBoundsException e) {
//            throw new TaskNotExistException();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public Task deleteTask(String cmd) throws TaskNotExistException {
//        try {
//            Task deletedTask = remove(Integer.parseInt(cmd.substring(6).trim()) - 1);
//            saveTask();
//            return deletedTask;
//        } catch (NumberFormatException e) {
//            throw new NotNumberException();
//        } catch (IndexOutOfBoundsException e) {
//            throw new TaskNotExistException();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

//    public void saveTask() throws IOException {
//        String filePath = System.getProperty("user.dir") + "/data/duke.txt";
//        FileWriter fw =  new FileWriter(filePath);
//        Iterator<Task> iter = iterator();
//        while (iter.hasNext()) {
//            fw.write(iter.next().getPrintableMsg() + System.lineSeparator());
//        }
//        fw.close();
//    }
}
