package duke.memo.task;

import duke.memo.record.task.Deadline;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeadlineTest {
    @Test
    void deadlineTest() throws Throwable {
        Deadline deadline = new Deadline("return book/2/9/2019 2359");
        assertEquals("[D]✘ return book (by: 02/09/2019 2359)", deadline.toString());
        deadline.taskDone();
        assertEquals("[D]✓ return book (by: 02/09/2019 2359)", deadline.toString());
    }
}