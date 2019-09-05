package duke.memo.command;

import duke.memo.exception.DukeException;
import duke.memo.exception.TaskNotExistException;
import duke.memo.storage.Storage;
import duke.memo.data.TaskList;
import duke.memo.task.Task;
import duke.memo.message.MessageGenerator;

import java.util.ArrayList;
import java.util.Iterator;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String execute(TaskList taskList, MessageGenerator msgGenerator, Storage storage) throws DukeException {
        ArrayList<Task> resultTasks = new ArrayList<>(); //ArrayList to store the task that contain the keyword
        try {
            Iterator<Task> iter = taskList.iterator();
            while (iter.hasNext()) {
                Task curTask = iter.next();
                if (curTask.getDescription().contains(keyword)) {
                    resultTasks.add(curTask);
                }
            }
            return msgGenerator.generateResultTaskMsg(resultTasks);
        } catch (IndexOutOfBoundsException e) {
            throw new TaskNotExistException();
        }
    }
}