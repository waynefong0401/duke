package duke.memo.command;

import duke.memo.data.TaskList;
import duke.memo.message.MessageGenerator;
import duke.memo.storage.Storage;
import duke.memo.task.Task;

import java.util.List;
import java.util.stream.Collectors;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String execute(TaskList taskList, MessageGenerator msgGenerator, Storage storage) {
        List<Task> resultTasks = taskList.stream()
                .filter(t -> t.getDescription().contains(keyword))
                .collect(Collectors.toList());
        return msgGenerator.generateResultTaskMsg(resultTasks);
    }
}