package duke.memo.command;

import duke.memo.data.TaskList;
import duke.memo.storage.Storage;
import duke.memo.task.Task;
import duke.memo.ui.Ui;

import java.util.Iterator;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showListMsg();
        Iterator<Task> iter = taskList.iterator();
        int curIndex = 1;
        while (iter.hasNext()) {
            ui.showMsg(curIndex++ + "." + iter.next().toString());
        }
    }
}
