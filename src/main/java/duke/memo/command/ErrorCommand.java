package duke.memo.command;

import duke.memo.data.TaskList;
import duke.memo.exception.DukeException;
import duke.memo.exception.TaskTypeError;
import duke.memo.storage.Storage;
import duke.memo.message.MessageGenerator;

public class ErrorCommand extends Command {
    @Override
    public String execute(TaskList taskList, MessageGenerator msgGenerator, Storage storage) throws DukeException {
        throw new TaskTypeError();
    }
}
