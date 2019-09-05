package duke.memo.data;

import duke.memo.exception.DukeException;
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

    /**
     * Constructor for TaskList.
     *
     * @param taskList  list of tasks.
     * @throws DukeException throw if there is a problem in the command.
     */
    public TaskList(ArrayList<String> taskList) throws DukeException {
        super();
        Iterator<String> iter = taskList.iterator();
        while (iter.hasNext()) {
            add(readLog(iter.next()));
        }
    }

    /**
     * Convert raw log string to a task object.
     *
     * @param log  Raw log.
     * @return Task return the parsed log
     * @throws DukeException Throw if there is a problem in the log.
     */
    public Task readLog(String log) throws DukeException {
        String[] taskDetails = log.split(" \\| ",4);
        switch (taskDetails[0]) {
        case "T" :
            return new ToDo(taskDetails);
        case "E" :
            return new Event(taskDetails);
        case "D" :
            return new Deadline(taskDetails);
        default :
            break;
        }
        return null;
    }
}
