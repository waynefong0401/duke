package duke.memo.task;

import duke.memo.record.task.ToDo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ToDoTest {

    @Test
    void todoTest() throws Throwable {
        ToDo todo = new ToDo("read book");
        Assertions.assertEquals("[T]✘ read book", todo.toString());
        todo.taskDone();
        Assertions.assertEquals("[T]✓ read book", todo.toString());
    }


}