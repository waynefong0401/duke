package duke.memo.storage;

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
    public Storage (String filePath) throws TaskLoadException {
        try {
            System.out.println(System.getProperty("user.dir") + "/" + filePath);
            this.fr = new FileReader(System.getProperty("user.dir") + "/" + filePath);
        } catch (FileNotFoundException e) {
            throw new TaskLoadException();
        }
    }

    public void store(TaskList taskList) {
        String filePath = System.getProperty("user.dir") + "/data/duke.txt";

        try
        {
            FileWriter fw = new FileWriter(filePath);
            Iterator<Task> iter = taskList.iterator();
            while (iter.hasNext()) {
                fw.write(iter.next().getPrintableMsg() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public ArrayList<String> load() throws IOException {
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> lineList = new ArrayList<String>();
        String line;
        while ((line = br.readLine()) != null) {
            lineList.add(line);
        }
        return lineList;
    }

}
