package duke.memo.command;

import duke.memo.data.TaskList;
import duke.memo.exception.DukeException;
import duke.memo.exception.NotNumberException;
import duke.memo.exception.TaskNotExistException;
import duke.memo.storage.Storage;
import duke.memo.ui.Ui;

public class DoneCommand extends Command {
    private int targetTaskNo;

    /**
     * Constructor for DoneCommand.
     * Throw error if no task index no enter or in wrong format.
     *
     * @param targetTaskNo  The target task index no.
     * @throws DukeException  If the input cannot be format to number.
     */
    public DoneCommand(String targetTaskNo) throws DukeException {
        try {
            this.targetTaskNo = Integer.parseInt(targetTaskNo) - 1;
        } catch (NumberFormatException e) {
            throw new NotNumberException();
        }
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        try {
            ui.showDoneMsg(taskList.get(targetTaskNo).taskDone().toString());
            storage.store(taskList);
        } catch (IndexOutOfBoundsException e) {
            throw new TaskNotExistException();
        }
    }
}
