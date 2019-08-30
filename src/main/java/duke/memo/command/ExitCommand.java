package duke.memo.command;

import duke.memo.storage.Storage;
import duke.memo.data.TaskList;
import duke.memo.ui.Ui;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showByeMsg();
        System.exit(0);
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
