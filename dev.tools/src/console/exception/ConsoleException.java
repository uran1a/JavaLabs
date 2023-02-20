package console.exception;

public class ConsoleException extends Exception {
    private String taskName = "";
    public ConsoleException(Class<?> lab, String message){
        super("Lab: "+lab.getName()+"\terror: "+message);
        this.taskName = lab.getName();
    }

    public String getTaskName() {
        return taskName;
    }
}
