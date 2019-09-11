package duke.memo.message;

import duke.memo.data.TaskList;
import duke.memo.task.Task;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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
            msg = "There is no task in your list.";
        } else if (taskNum == 1) {
            msg = String.format("There is 1 tasks in your list:\n%s", taskList.get(0).toString());
        } else {
            AtomicInteger index = new AtomicInteger();
            msg = String.format("There are %d tasks in your list:", taskList.size());
            msg += taskList.stream()
                    .map(t -> String.format("\n%d.%s", index.incrementAndGet(), t.toString()))
                    .collect(Collectors.joining());
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
        return String.format("Got it. I've added this task: \n%s\nNow you have %d tasks in the list.",
                addedTask, taskListLength);
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
    public String generateResultTaskMsg(List<Task> resultTasks) {
        String msg = "Here are the matching tasks in your list:";
        msg += resultTasks.stream()
                .map(t -> "\n" + t.toString())
                .collect(Collectors.joining());
        return  msg;
    }
}