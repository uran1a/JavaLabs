package release;
import console.exception.ConsoleException;

import static java.util.Map.entry;

import java.util.HashMap;
import java.util.Map;

class LabSix {
    private final double x;
    private final int numberOfOperation;
    private final double exp;

    LabSix() throws ConsoleException {this(0.5, 10, 0.001);}
    LabSix(double x, int numberOfOperation, double exp) throws ConsoleException {
        if(x<=-1.0 || x >= 1.0 || numberOfOperation <= 0){
            throw new ConsoleException(this.getClass(), "Неверные значения");
        }
        this.x = x; this.numberOfOperation = numberOfOperation; this.exp = exp;
    }

    Map<String, Double> calculateSumRow(Row row, boolean isAlternating, double firstMemberOfRow){
        double sumRow = firstMemberOfRow, sumRowMoreThanExp = firstMemberOfRow, sumRowMoreThanExpTen = firstMemberOfRow;
        int sign = 1;
        for(int i = 0; i <= numberOfOperation; i++){
            double nextMemberOfRow = row.sumMemberOfRow(x, i);
            if(isAlternating) sign = (i % 2 == 0) ? 1 : -1;
            sumRow += sign * nextMemberOfRow;
            if(nextMemberOfRow > exp) sumRowMoreThanExp += sign * nextMemberOfRow;
            if(nextMemberOfRow > exp/10) sumRowMoreThanExpTen += sign * nextMemberOfRow;
        }

        return Map.ofEntries(
                entry("sumRow", sumRow),
                entry("sumRowMoreThanExp", sumRowMoreThanExp),
                entry("sumRowMoreThanExpTen", sumRowMoreThanExpTen)
        );
    }

    Map<String, Double> selectRow(TaskNumber task){
        Map<String, Double> map = new HashMap<>();
        switch (task){
            case TASK_ONE : map = calculateSumRow((x, n) -> buildFunnyFraction(n+2) * (Math.pow(x, 3+2*n)/(3+2*n)), false, x);
            case TASK_TWO: map = calculateSumRow((x, n) -> (n+1)*Math.pow(x, n), true, 0);
        }
        return map;
    }
    private double buildFunnyFraction(int n){
        n = (n % 2 == 0) ? n : n+1;
        int sumNumerator = 0, sumDenominator = 0;
        for(int i = 1; i <= n; i++){
            if(i % 2 == 0) sumDenominator += i;
            else sumNumerator += i;
        }
        return ((double)sumNumerator) / sumDenominator;
    }
}
