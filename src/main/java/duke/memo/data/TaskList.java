package duke.memo.data;

import duke.memo.exception.NoDescriptionException;
import duke.memo.exception.NoTimeException;
import duke.memo.exception.TimeFormatErrorException;
import duke.memo.task.Deadline;
import duke.memo.task.Event;
import duke.memo.task.Task;
import duke.memo.task.ToDo;
import java.util.ArrayList;
import java.util.Iterator;

public class TaskList extends ArrayList<Task> {

    public TaskList() {
        super();
    }

    public TaskList(ArrayList<String> taskList) throws NoTimeException, TimeFormatErrorException, NoDescriptionException {
        super();
        Iterator<String> iter = taskList.iterator();
        while (iter.hasNext()) {
            add(readLog(iter.next()));
        }
    }

    public Task readLog(String log) throws NoDescriptionException, TimeFormatErrorException, NoTimeException {
        String[] taskDetails = log.split(" \\| ",4);
        switch (taskDetails[0]) {
        case "T" :
            return new ToDo(taskDetails);
        case "E" :
            return new Event(taskDetails);
        case "D" :
            return new Deadline(taskDetails);
        }
        return null;
    }
}
