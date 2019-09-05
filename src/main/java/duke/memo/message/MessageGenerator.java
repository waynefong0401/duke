package duke.memo.message;

import duke.memo.data.TaskList;
import duke.memo.task.Task;

import java.util.ArrayList;
import java.util.Iterator;

public class MessageGenerator {

    public MessageGenerator() {
    }

    public String generateByeMsg() {
        return "Bye. Hope to see you again soon!";
    }

    /**
     * Display the added task.
     *
     * @param taskList ArrayList of task.
     * @return String contains all task details.
     */
    public String generateListTaskMsg(TaskList taskList) {
        int taskNum = taskList.size();
        String msg;
        if (taskNum == 0) {
            return "There is no task in your list.";
        } else if (taskNum == 1) {
            msg = "There is 1 tasks in your list:\n" + taskList.get(0).toString();
        } else {
            int curIndex = 1;
            msg = "There are " + taskList.size() + " tasks in your list:";
            for (Task task : taskList) {
                msg += "\n" + curIndex++ + "." + task.toString();
            }
        }
        return msg;
    }

    public String generateDoneTaskMsg(String taskDetails) {
        return "Nice! I've marked this task as done: \n" + taskDetails;
    }

    public String generateDeletedTaskMsg(String taskDetails, int taskNo) {
        return "Noted. I've removed this task: \n" + taskDetails
                + "\nNow you have " + taskNo + " tasks in the list.";
    }

    /**
     * Display the added task.
     *
     * @param addedTask  Details of the added task.
     * @param taskListLength  Length of the task list.
     * @return String This returns the details of the added task.
     */
    public String generateAddedTaskMsg(String addedTask, int taskListLength) {
        return "Got it. I've added this task: \n"
        + addedTask + "\n" + "Now you have " + taskListLength + " tasks in the list.";
    }

    public String generateErrorMsg(String errMsg) {
        return errMsg;
    }

    /**
     * Display the matched task.
     *
     * @param resultTasks  Details of the matched task.
     * @return String This returns details of the match tasks.
     */
    public String generateResultTaskMsg(ArrayList<Task> resultTasks) {
        String msg = "Here are the matching tasks in your list:";
        Iterator<Task> iter = resultTasks.iterator();
        while (iter.hasNext()) {
            msg += "\n" + iter.next().toString();
        }
        return  msg;
    }
}