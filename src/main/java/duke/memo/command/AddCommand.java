package duke.memo.command;

import duke.memo.data.TaskList;
import duke.memo.exception.DukeException;
import duke.memo.exception.NoDescriptionException;
import duke.memo.exception.TaskTypeError;
import duke.memo.storage.Storage;
import duke.memo.task.Deadline;
import duke.memo.task.Event;
import duke.memo.task.Task;
import duke.memo.task.ToDo;
import duke.memo.message.MessageGenerator;

public class AddCommand extends Command {
    private String cmd;

    public AddCommand(String cmd) {
        this.cmd = cmd;
    }

    @Override
    public String execute(TaskList taskList, MessageGenerator msgGenerator, Storage storage) throws DukeException {
        String[] curTaskDetails = cmd.split(" ", 2);

        try {
            Task curTask;
            switch (curTaskDetails[0]) {
            case "todo":
                curTask = new ToDo(curTaskDetails[1]);
                break;
            case "deadline":
                curTask = new Deadline(curTaskDetails[1]);
                break;
            case "event":
                curTask = new Event(curTaskDetails[1]);
                break;
            default:
                throw new TaskTypeError();
            }
            taskList.add(curTask);
            storage.store(taskList);
            return msgGenerator.generateAddedTaskMsg(curTask.toString(), taskList.size());
        } catch (DukeException e) {
            throw e;
        } catch (IndexOutOfBoundsException e) {
            throw new NoDescriptionException(curTaskDetails[0]);
        }

    }

}
