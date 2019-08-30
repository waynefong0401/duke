package duke.memo.task;

//import duke.memo.exception.NoDescriptionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoTest {

    @Test
    void todoTest() throws Throwable {
        ToDo todo = new ToDo("read book");
        assertEquals("[T]\u2718 read book", todo.toString());
        todo.taskDone();
        assertEquals("[T]\u2713 read book", todo.toString());
    }


}