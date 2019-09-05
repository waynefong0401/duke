package duke.memo.command;

import duke.memo.exception.DukeException;
import duke.memo.storage.Storage;
import duke.memo.data.TaskList;
import duke.memo.message.MessageGenerator;

public abstract class Command {
    public abstract String execute(TaskList taskList, MessageGenerator msgGenerator, Storage storage)  throws DukeException;



    public boolean isExit() {
        return false;
    }
}
