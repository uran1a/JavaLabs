package logic;

import console.exception.ConsoleException;

import java.util.Collections;
import java.util.List;

public interface ExecutionFactory {
    default List<String> execute() throws ConsoleException {
        return Collections.singletonList("Нет результатов!");
    }
}
