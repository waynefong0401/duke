package duke.memo.storage;

import duke.memo.Duke;
import duke.memo.exception.DukeException;
import duke.memo.exception.TaskLoadException;
import duke.memo.task.Task;
import duke.memo.data.TaskList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Storage {
    private FileReader fr;

    /**
     * Constructor for Storage.
     *
     * @param filePath  Path to the log file.
     * @throws DukeException File unable to load.
     */
    public Storage(String filePath) throws DukeException {
        try {
            System.out.println(System.getProperty("user.dir") + "/" + filePath);
            fr = new FileReader(System.getProperty("user.dir") + "/" + filePath);
        } catch (FileNotFoundException e) {
            throw new TaskLoadException();
        }
    }

    /**
     * Store file to local.
     *
     * @param taskList List of tasks.
     */
    public void store(TaskList taskList) {
        String filePath = System.getProperty("user.dir") + "/data/duke.txt";

        try {
            FileWriter fw = new FileWriter(filePath);
            Iterator<Task> iter = taskList.iterator();
            while (iter.hasNext()) {
                fw.write(iter.next().getPrintableMsg() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Load file to local.
     *
     * @throws IOException  File does not exist.
     */
    public ArrayList<String> load() throws IOException {
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> lineList = new ArrayList<String>();   //Store the records loaded from log
        String line;
        while ((line = br.readLine()) != null) {
            lineList.add(line);
        }
        return lineList;
    }

}
