package java.duke.memo.task;

import duke.memo.task.Event;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class EventTest {

    @Test
    void eventTest() throws Throwable {
        Event event = new Event("have meeting/1/9/2019 1400");
        assertEquals("[E]\u2718 have meeting (at: 01/09/2019 1400)", event.toString());
        event.taskDone();
        assertEquals("[E]\u2713 have meeting (at: 01/09/2019 1400)", event.toString());
    }

}