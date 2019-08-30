package duke.memo;

import duke.memo.command.Command;
import duke.memo.parser.Parser;
import duke.memo.storage.Storage;
import duke.memo.ui.Ui;
import duke.memo.exception.*;
import duke.memo.task.Task;
import duke.memo.data.TaskList;
import java.io.IOException;
import java.util.Iterator;

public class Duke {

    private Storage storage;
    private TaskList taskList;
    private Ui ui;

    public static void main(String[] args) {
        new Duke("data/duke.txt").run();
    }

    public Duke(String filePath) {

        try {
            ui = new Ui();
            storage = new Storage(filePath);

            taskList = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showError(e.getMessage());
            taskList = new TaskList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        ui.showWelcomeMsg();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readNextLine();
                ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(taskList, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

//    public void run() {
//        ui.showWelcomeMsg();
//
//        while (true) {
//            try{
//                String cmd = ui.readNextLine();
//                if (cmd.equalsIgnoreCase("bye")) {
//                    ui.showByeMsg();
//                    return;
//                } else if (cmd.equalsIgnoreCase("list")) {
//                    ui.showListMsg();
//                    Iterator<Task> iter = taskList.iterator();
//                    int curIndex = 1;
//                    while (iter.hasNext()) {
//                        ui.showMsg(String.valueOf(curIndex++) + "." + iter.next().toString());
//                    }
//                } else if (cmd.startsWith("done")) {
//                    if (!cmd.split(" ",2)[0].equalsIgnoreCase("done")) {
//                        taskList.addTask(cmd);
//                        continue;
//                    }
////                    Task doneTask = taskList.doneTask(cmd);
//                    ui.showDoneMsg(taskList.doneTask(cmd).toString());
//                } else if (cmd.startsWith("delete")){
//                    if (!cmd.split(" ",2)[0].equalsIgnoreCase("delete")) {
//                        taskList.addTask(cmd);
//                        continue;
//                    }
//                    Task deleteTask = taskList.deleteTask(cmd);
//                    ui.showDeleteMsg(deleteTask.toString(),taskList.size());
////                    System.out.println("Noted. I've removed this task: ");
////                    System.out.println(deleteTask.toString());
////                    System.out.println("Now you have " + taskList.size() + " tasks in the list.");
//                } else {
//                    ui.showAddedTask(taskList.addTask(cmd));
//                }
//            } catch (NoDescriptionException e) {
//                ui.showDescriptionError(e.getTaskType());
//            } catch (NoTimeException e) {
//                ui.showTimeError(e.getTaskType());
//            } catch (NotNumberException e) {
//                ui.showNotNumberError();
//            } catch (TaskNotExistException e) {
//                ui.showTaskNotExistError();
//            } catch (TimeFormatErrorException e) {
//                ui.showTimeFormatError(e.getTaskType());
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (TaskTypeError taskTypeError) {
//                ui.showTaskTypeError();
////                taskTypeError.printStackTrace();
//            }
//        }
//    }


}
