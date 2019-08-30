package duke.memo.ui;

import duke.memo.task.Task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ui {
    public static final String WELCOMEMSG = "Hello from Weiwen\n What can I do for you?\n"
            + " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public String readNextLine() {
        return scanner.nextLine();
    }

    public void showLine() {
        System.out.println("_______________________________________");
    }

    public void showWelcomeMsg() {
        System.out.println(WELCOMEMSG);
    }

    public void showByeMsg() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void showListMsg() {
        System.out.println("Here are the tasks in your list:");
    }

    public void showMsg(String msg) {
        System.out.println(msg);
    }

    public void showDoneMsg(String taskDetails) {
        System.out.println("Nice! I've marked this task as done: \n" + taskDetails);
    }

    public void showDeleteMsg(String taskDetails, int taskNo) {
        System.out.println("Noted. I've removed this task: \n" + taskDetails
                + "\nNow you have " + taskNo + " tasks in the list.");
    }

    /**
     * Display the added task.
     *
     * @param addedTask  Details of the added task.
     * @param taskListLength  Length of the task list.
     */
    public void showAddedTask(String addedTask,int taskListLength) {
        System.out.println("Got it. I've added this task: ");
        System.out.println(addedTask);
        System.out.println("Now you have " + taskListLength + " tasks in the list.");
    }

    public void showError(String errMsg) {
        System.out.println(errMsg);
    }

    /**
     * Display the matched task.
     *
     * @param resultTasks  Details of the matched task.
     */
    public void showResult(ArrayList<Task> resultTasks) {
        System.out.println("Here are the matching tasks in your list:");
        Iterator<Task> iter = resultTasks.iterator();
        int i = 1;
        while (iter.hasNext()) {
            System.out.println(i + "." + iter.next());
        }
    }
}
