import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        Task[] taskList = new Task[100];
        int taskNo = 0;
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from Weiwen\n What can I do for you?\n" + logo);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String cmd = scanner.nextLine();
            if (cmd.equalsIgnoreCase("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                return;
            } else if (cmd.equalsIgnoreCase("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < taskNo;i++) {
                    System.out.println(String.valueOf(i + 1) + "." + taskList[i].toString());
                }
            } else if (cmd.startsWith("done ")) {
                int inputIndex = Integer.parseInt(cmd.substring(5).trim());
                Task curTask = taskList[inputIndex - 1];
                curTask.taskDone();
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println(curTask.toString());
            } else {

                String[] curTask = cmd.split(" ",2);
                switch (curTask[0]) {
                case "todo" :
                    taskList[taskNo++] = new ToDo(curTask[1]);
                    break;
                case "deadline" :
                    String[] ddlDetails = curTask[1].split("/",2);
                    taskList[taskNo++] = new Deadline(ddlDetails[0],ddlDetails[1]);
                    break;
                case "event" :
                    String[] eventDetails = curTask[1].split("/",2);
                    taskList[taskNo++] = new Event(eventDetails[0],eventDetails[1]);
                    break;
                }
                System.out.println("Got it. I've added this task: ");
                System.out.println(taskList[taskNo-1].toString());
                System.out.println("Now you have " + taskNo + " tasks in the list.");
            }
        }
    }
}
