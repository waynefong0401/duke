package duke.memo.parser;

import duke.memo.command.*;
import duke.memo.exception.DukeException;
import duke.memo.task.Task;

import java.util.Iterator;

public class Parser {
    public static Command parse(String cmd) throws DukeException {
        if (cmd.equalsIgnoreCase("bye")) {
            return new ExitCommand();
        } else if (cmd.equalsIgnoreCase("list")) {
            return new ListCommand();
        } else if (cmd.startsWith("done")) {
            if (cmd.split(" ",2)[0].equalsIgnoreCase("done")) {
                return new DoneCommand(cmd.substring(4).trim());
            } else {
                return new ErrorCommand();
            }
        } else if (cmd.startsWith("delete")){
            if (cmd.split(" ",2)[0].equalsIgnoreCase("delete")) {
                return new DeleteCommand(cmd.substring(6).trim());
            } else {
                return new ErrorCommand();
            }
        } else {
            return new AddCommand(cmd);
        }
    }
}
