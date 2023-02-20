package realise;

import console.exception.ConsoleException;

public class Main {
    public static void main(String[] args) throws ConsoleException {
        try {
            LabSix lab = new LabSix(0.5, 100, 0.1);
            var sumRows = lab.selectRow(TaskNumber.TASK_TWO);
            System.out.printf("Cумму n слагаемых заданного вида: %.3f\n", sumRows.get("sumRow"));
            System.out.printf("Cумму тех слагаемых, которые по абсолютной величине больше e: %.3f\n", sumRows.get("sumRowMoreThanExp"));
            System.out.printf("сумму тех слагаемых, которые по абсолютной величине больше e/10: %.3f\n", sumRows.get("sumRowMoreThanExpTen"));
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}