package duke.memo.command;

import duke.memo.data.TaskList;
import duke.memo.storage.Storage;
import duke.memo.ui.Ui;

public class ErrorCommand extends Command{

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showTaskTypeError();
    }
}
