package duke.memo.command;

import duke.memo.data.TaskList;
import duke.memo.exception.DukeException;
import duke.memo.exception.TaskTypeError;
import duke.memo.storage.Storage;
import duke.memo.ui.Ui;

public class ErrorCommand extends Command{

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        throw new TaskTypeError();
    }
}
