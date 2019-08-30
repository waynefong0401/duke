package duke.memo.command;

import duke.memo.exception.DukeException;
import duke.memo.exception.NotNumberException;
import duke.memo.exception.TaskNotExistException;
import duke.memo.storage.Storage;
import duke.memo.data.TaskList;
import duke.memo.task.Task;
import duke.memo.ui.Ui;

public class DeleteCommand extends Command{
    private int targetTaskNo;

    public DeleteCommand(String targetTaskNo) throws DukeException {
        try {
            this.targetTaskNo = Integer.parseInt(targetTaskNo) - 1;
        } catch (NumberFormatException e) {
            throw new NotNumberException();
        }
    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        try {
            Task deletedTask = taskList.remove(targetTaskNo);
            ui.showDeleteMsg(deletedTask.toString(),taskList.size());
            storage.store(taskList);
        } catch (IndexOutOfBoundsException e) {
            throw new TaskNotExistException();
        }
    }
}
