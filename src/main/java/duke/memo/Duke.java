package duke.memo;

import duke.memo.command.Command;
import duke.memo.data.TaskList;
import duke.memo.exception.DukeException;
import duke.memo.parser.Parser;
import duke.memo.storage.Storage;
import duke.memo.message.MessageGenerator;

import java.io.IOException;

public class Duke {

    private Storage storage;
    private TaskList taskList;
    private MessageGenerator msgGenerator;

    /**
     * Constructor for Duke.
     * Throw error if input/output goes wrong.
     */
    public Duke() {
        try {
            msgGenerator = new MessageGenerator();
            storage = new Storage("data/duke.txt");

            taskList = new TaskList(storage.load());
        } catch (DukeException e) {
            msgGenerator.generateErrorMsg(e.getMessage());
            taskList = new TaskList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructor for Duke.
     * Throw error if input/output goes wrong.
     *
     * @param filePath  Path to the log file.
     */
    public Duke(String filePath) {

        try {
            msgGenerator = new MessageGenerator();
            storage = new Storage(filePath);

            taskList = new TaskList(storage.load());
        } catch (DukeException e) {
            msgGenerator.generateErrorMsg(e.getMessage());
            taskList = new TaskList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get response for input.
     * @param input input from GUI.
     * @return return the result as a string
     */
    public String getResponse(String input)  {
        Command c;
        try {
            c = Parser.parse(input);
            return c.execute(taskList, msgGenerator,storage);
        } catch (DukeException e) {
            return e.getMessage();
        }
    }
}
