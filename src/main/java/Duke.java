import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        Task[] inputRec = new Task[100];
        int inputNo = 0;
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
                for (int i = 0; i < inputNo;i++) {
                    Task curTask = inputRec[i];
                    System.out.println(String.valueOf(i + 1) + "." + curTask.getStatusIcon() + " " + curTask.getDescription());
                }
            } else if (cmd.startsWith("done ")) {
                //System.out.println(cmd.substring(5).trim());
                int inputIndex = Integer.parseInt(cmd.substring(5).trim());
                Task curTask = inputRec[inputIndex - 1];
                curTask.taskDone();
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println(curTask.getStatusIcon() + " " + curTask.getDescription());
            } else {
                inputRec[inputNo++] = new Task(cmd);
                System.out.println("added: " + cmd);
                //System.out.println(inputNo);
            }
        }

    }
}
