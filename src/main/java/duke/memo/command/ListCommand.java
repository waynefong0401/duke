package duke.memo.command;

import duke.memo.data.TaskList;
import duke.memo.storage.Storage;
import duke.memo.message.MessageGenerator;

public class ListCommand extends Command {
    @Override
    public String  execute(TaskList taskList, MessageGenerator msgGenerator, Storage storage) {
        return msgGenerator.generateListTaskMsg(taskList);
    }
}
