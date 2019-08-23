import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
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
                System.out.println("Bye. Hope to see you again soon!\n");
                return;
            } else {
                System.out.println(cmd);
            }
        }

    }
}
