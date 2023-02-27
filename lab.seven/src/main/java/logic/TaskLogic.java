package logic;
import console.exception.ConsoleException;
import logic.task10.Task10;
import logic.task23.Task23;

import java.util.*;

public class TaskLogic {
    private List<String> resultTask;
    private TaskNumber taskNumber;
    public TaskLogic(TaskNumber taskNumber) {
        this.taskNumber = taskNumber;
    }
    public List<String> search(){
        try {
            ExecutionFactory executionFactory = null;
            switch (taskNumber) {
                case TASK_TEN -> executionFactory = new Task10();
                case TASK_TWENTY_THREE -> executionFactory = new Task23();
                default -> throw new IllegalArgumentException("Wrong task type:" + taskNumber);
            }
            resultTask = executionFactory.execute();
        } catch (Exception error) { System.out.println(error.getMessage()); }
        return resultTask;
    }
}

