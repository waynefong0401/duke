package duke.memo.commands;

import duke.memo.task.TaskList;

public abstract class Command {
    public abstract void execute(TaskList taskList, Ui ui, Storage storage);
}
