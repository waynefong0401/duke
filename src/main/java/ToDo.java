public class ToDo extends Task {
    private static String TASKTYPE = "todo";
    
    public ToDo(String des) throws NoDescriptionException {
            super(des,TASKTYPE);
    }

    @Override
    public String getPrintableMsg() {
        return "T" + " | " + (isDone ? "1" : "0") + " | " + description;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
