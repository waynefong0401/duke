package duke.memo.command;

import duke.memo.exception.DukeException;
import duke.memo.storage.Storage;
import duke.memo.data.TaskList;
import duke.memo.ui.Ui;

public abstract class Command {
    public abstract void execute(TaskList taskList, Ui ui, Storage storage)  throws DukeException;
    public boolean isExit() { return false;}
}
