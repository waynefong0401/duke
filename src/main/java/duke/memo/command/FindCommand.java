package duke.memo.command;

import duke.memo.exception.DukeException;
import duke.memo.exception.NotNumberException;
import duke.memo.exception.TaskNotExistException;
import duke.memo.storage.Storage;
import duke.memo.data.TaskList;
import duke.memo.task.Task;
import duke.memo.ui.Ui;

import java.util.ArrayList;
import java.util.Iterator;

public class FindCommand extends Command{
    private int targetTaskNo;
    private String keyword;

    public FindCommand(String keyword) throws DukeException {
        this.keyword = keyword;
    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        ArrayList<Task> resultTasks = new ArrayList<>();
        try {

            Iterator<Task> iter = taskList.iterator();
            while (iter.hasNext()) {
                Task curTask = iter.next();
                if (curTask.getDescription().contains(keyword)) {
                    resultTasks.add(curTask);
                }
            }
            ui.showResult(resultTasks);
        } catch (IndexOutOfBoundsException e) {
            throw new TaskNotExistException();
        }
    }
}