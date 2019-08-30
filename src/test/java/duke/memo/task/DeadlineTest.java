package java.duke.memo.task;

import duke.memo.task.Deadline;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadlineTest {
    @Test
    void deadlineTest() throws Throwable {
        Deadline deadline = new Deadline("return book/2/9/2019 2359");
        assertEquals("[D]\u2718 return book (by: 02/09/2019 2359)", deadline.toString());
        deadline.taskDone();
        assertEquals("[D]\u2713 return book (by: 02/09/2019 2359)", deadline.toString());
    }
}