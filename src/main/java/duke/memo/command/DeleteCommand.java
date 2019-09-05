package duke.memo.command;

import duke.memo.exception.DukeException;
import duke.memo.exception.NotNumberException;
import duke.memo.exception.TaskNotExistException;
import duke.memo.storage.Storage;
import duke.memo.data.TaskList;
import duke.memo.task.Task;
import duke.memo.message.MessageGenerator;

public class DeleteCommand extends Command {
    private int targetTaskNo;

    /**
     * Constructor for DeleteCommand.
     * Throw error if no task index no enter or in wrong format.
     *
     * @param targetTaskNo  The target task index no.
     * @throws DukeException  If the input cannot be format to number.
     */
    public DeleteCommand(String targetTaskNo) throws DukeException {
        try {
            this.targetTaskNo = Integer.parseInt(targetTaskNo) - 1;
        } catch (NumberFormatException e) {
            throw new NotNumberException();
        }
    }

    @Override
    public String execute(TaskList taskList, MessageGenerator msgGenerator, Storage storage) throws DukeException {
        try {
            Task deletedTask = taskList.remove(targetTaskNo);

            storage.store(taskList);
            return msgGenerator.generateDeletedTaskMsg(deletedTask.toString(), taskList.size());
        } catch (IndexOutOfBoundsException e) {
            throw new TaskNotExistException();
        }
    }
}
