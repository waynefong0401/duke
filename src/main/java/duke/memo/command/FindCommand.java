package duke.memo.command;

import duke.memo.data.TaskList;
import duke.memo.exception.DukeException;
import duke.memo.exception.TaskNotExistException;
import duke.memo.message.MessageGenerator;
import duke.memo.storage.Storage;
import duke.memo.task.Task;

import java.util.ArrayList;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String execute(TaskList taskList, MessageGenerator msgGenerator, Storage storage) throws DukeException {
        ArrayList<Task> resultTasks = new ArrayList<>(); //ArrayList to store the task that contain the keyword
        try {
            for (Task task : taskList) {
                if (task.getDescription().contains(keyword)) {
                    resultTasks.add(task);
                }
            }
            return msgGenerator.generateResultTaskMsg(resultTasks);
        } catch (IndexOutOfBoundsException e) {
            throw new TaskNotExistException();
        }
    }
}