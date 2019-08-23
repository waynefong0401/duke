import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        String[] inputRec = new String[100];
        int inputNo = 0;
        inputRec[0] = "111";
        inputRec[1] = "111";
        inputRec[2] = "111";
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
                    System.out.println(String.valueOf(i + 1) + "." + inputRec[i]);
                }
            } else {
                inputRec[inputNo++] = cmd;
                System.out.println("added: " + cmd);
                //System.out.println(inputNo);
            }
        }

    }
}
