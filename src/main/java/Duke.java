import java.util.Iterator;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from Weiwen\n What can I do for you?\n" + logo);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try{
                String cmd = scanner.nextLine();
                if (cmd.equalsIgnoreCase("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    return;
                } else if (cmd.equalsIgnoreCase("list")) {
                    System.out.println("Here are the tasks in your list:");
                    Iterator<TaskNew> iter = taskList.iterator();
                    int curIndex = 1;
                    while (iter.hasNext()) {
                        System.out.println(String.valueOf(curIndex++) + "." + iter.next().toString());
                    }
                } else if (cmd.startsWith("done")) {
                    if (!cmd.split(" ",2)[0].equalsIgnoreCase("done")) {
                        taskList.addTask(cmd);
                        continue;
                    }
                    TaskNew doneTask = taskList.doneTask(cmd);
                    System.out.println("Nice! I've marked this task as done: ");
                    System.out.println(doneTask.toString());
                } else if (cmd.startsWith("delete")){
                    if (!cmd.split(" ",2)[0].equalsIgnoreCase("delete")) {
                        taskList.addTask(cmd);
                        continue;
                    }
                    TaskNew deleteTask = taskList.deleteTask(cmd);
                    System.out.println("Noted. I've removed this task: ");
                    System.out.println(deleteTask.toString());
                    System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                } else {
                    taskList.addTask(cmd);
                }
            } catch (NoDescriptionException e) {
                System.out.println(e.toString());
            } catch (NoTimeException e) {
                System.out.println(e.toString());
            } catch (TaskNotExistException e) {
                System.out.println(e.toString());
            } catch (NumberFormatException e) {
                System.out.println(e.toString());
            }
        }
    }
}