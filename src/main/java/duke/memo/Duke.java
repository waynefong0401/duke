package duke.memo;

import duke.memo.command.Command;
import duke.memo.data.TaskList;
import duke.memo.exception.DukeException;
import duke.memo.parser.Parser;
import duke.memo.storage.Storage;
import duke.memo.ui.Ui;
import java.io.IOException;

public class Duke {

    private Storage storage;
    private TaskList taskList;
    private Ui ui;

    public static void main(String[] args) {
        new Duke("data/duke.txt").run();
    }

    /**
     * Constructor for Duke.
     * Throw error if input/output goes wrong.
     *
     * @param filePath  Path to the log file.
     */
    public Duke(String filePath) {

        try {
            ui = new Ui();
            storage = new Storage(filePath);

            taskList = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showError(e.getMessage());
            taskList = new TaskList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Run the program body.
     */
    public void run() {
        ui.showWelcomeMsg();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readNextLine();
                ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(taskList, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }
}
