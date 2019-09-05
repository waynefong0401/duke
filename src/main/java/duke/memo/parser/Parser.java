package duke.memo.parser;

import duke.memo.command.AddCommand;
import duke.memo.command.Command;
import duke.memo.command.DeleteCommand;
import duke.memo.command.DoneCommand;
import duke.memo.command.ErrorCommand;
import duke.memo.command.ExitCommand;
import duke.memo.command.FindCommand;
import duke.memo.command.ListCommand;
import duke.memo.exception.DukeException;

public class Parser {
    /**
     * Static method parse for Parser.
     * To parse the log into a command.
     *
     * @param cmd  Full command in log file.
     * @return parsed command
     * @throws DukeException Throw if there is a problem in the command.
     */
    public static Command parse(String cmd) throws DukeException {
        if (cmd.equalsIgnoreCase("bye")) {
            return new ExitCommand();
        } else if (cmd.equalsIgnoreCase("list")) {
            return new ListCommand();
        } else if (cmd.startsWith("find")) {
            if (cmd.split(" ", 2)[0].equalsIgnoreCase("find")) {
                return new FindCommand(cmd.substring(5));
            } else {
                return new ErrorCommand();
            }
        } else if (cmd.startsWith("done")) {
            if (cmd.split(" ", 2)[0].equalsIgnoreCase("done")) {
                return new DoneCommand(cmd.substring(4).trim());
            } else {
                return new ErrorCommand();
            }
        } else if (cmd.startsWith("delete")) {
            if (cmd.split(" ", 2)[0].equalsIgnoreCase("delete")) {
                return new DeleteCommand(cmd.substring(6).trim());
            } else {
                return new ErrorCommand();
            }
        } else {
            return new AddCommand(cmd);
        }
    }
}
