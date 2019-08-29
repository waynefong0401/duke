import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class TaskList extends ArrayList<Task> {

    public TaskList() {
        super();
    }

    public void addTask(String cmd) throws NoDescriptionException, NoTimeException, IOException {
        boolean isTask = true;
        String[] curTask = {"",""};
        String[] tempCurTask = cmd.split(" ", 2);
        curTask[0] = tempCurTask[0];
        if (tempCurTask.length != 1) curTask[1] = tempCurTask[1];
        switch (curTask[0]) {
        case "todo":
            add(new ToDo(curTask[1]));
            break;
        case "deadline":
            String[] ddlDetails = {"",""};
            String[] tempDdlDetails = curTask[1].split("/", 2);
            ddlDetails[0] = tempDdlDetails[0];
            if (tempDdlDetails.length != 1) ddlDetails[1] = tempDdlDetails[1];
            add(new Deadline(ddlDetails));
            break;
        case "event":
            String[] eventDetails = {"",""};
            String[] tempEventDetails = curTask[1].split("/", 2);
            eventDetails[0] = tempEventDetails[0];
            if (tempEventDetails.length != 1) eventDetails[1] = tempEventDetails[1];
            add(new Event(eventDetails));
            break;
        default:
            isTask = false;
            System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
        if (!isTask) return;
        System.out.println("Got it. I've added this task: ");
        System.out.println(get(size() - 1).toString());
        System.out.println("Now you have " + String.valueOf(size()) + " tasks in the list.");
        saveTask();
    }

    public Task doneTask(String cmd) throws TaskNotExistException {
        try {
            Task addedTask = get(Integer.parseInt(cmd.substring(4).trim()) - 1).taskDone();
            saveTask();
            return addedTask;
        } catch (NumberFormatException e) {
            throw new NotNumberException();
        } catch (IndexOutOfBoundsException e) {
            throw new TaskNotExistException();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Task deleteTask(String cmd) throws TaskNotExistException {
        try {
            Task deletedTask = remove(Integer.parseInt(cmd.substring(6).trim()) - 1);
            saveTask();
            return deletedTask;
        } catch (NumberFormatException e) {
            throw new NotNumberException();
        } catch (IndexOutOfBoundsException e) {
            throw new TaskNotExistException();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveTask() throws IOException {
        String filePath = System.getProperty("user.dir") + "/data/duke.txt";
        FileWriter fw =  new FileWriter(filePath);
        Iterator<Task> iter = iterator();
        while (iter.hasNext()) {
            fw.write(iter.next().getPrintableMsg() + System.lineSeparator());
        }
        fw.close();
    }

//    public String generateTaskListText() {
//        String
//
//    }
}
