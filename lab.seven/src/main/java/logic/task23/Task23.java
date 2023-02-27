package logic.task23;

import console.exception.ConsoleException;
import logic.ExecutionFactory;
import test.DataContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Task23 implements ExecutionFactory {
    private static final int COUNT_DIERTY_SIGN = 2;
    private final List<Integer[]> testArrays;
    public Task23(){ testArrays = DataContainer.getSelectedListTask23(); }
    @Override
    public List<String> execute() throws ConsoleException { return foundAllSequence(testArrays.get(0)); }
    public List<String> foundAllSequence(Integer[] arr) throws ConsoleException {
        List<DirtySequence<Integer>> sequences = new ArrayList<>();
        Map<Integer, Integer> mapSignIndex = new HashMap<>();
        //поиск грязных последовательностей
        for(int i = 0; i < arr.length; i++){
            if(mapSignIndex.containsKey(arr[i])){
                DirtySequence<Integer> currentSequence = sequenceWithMainSign(sequences, arr[i]);
                if(currentSequence == null) throw new ConsoleException(this.getClass(), "Неверные значения массива");
                int countDirtySign = currentSequence.countDirtySign(i);
                if(currentSequence.acceptableDistanceBetweenIndexes(countDirtySign)){
                    for (int j = i - countDirtySign; j < i; j++){
                        currentSequence.addSignSequence(arr[j], j);
                        currentSequence.enhancementCountDirtySign();
                    }
                    currentSequence.addSignSequence(arr[i], i);
                }
                else{
                    sequences.remove(currentSequence);
                    sequences.add(new DirtySequence<Integer>(arr[i], i, COUNT_DIERTY_SIGN));
                }
            }
            else{
                sequences.add(new DirtySequence<Integer>(arr[i], i, COUNT_DIERTY_SIGN));
                mapSignIndex.put(arr[i], i);
            }
        }
        //удаление последовательностей меньше 3
        sequences.removeIf(sequence -> (sequence.getCountMainSign() < 3));
        //подбор грязных последовательностей
        for(var sequence : sequences){
            List<Map.Entry<Integer, Integer>> possibleSignInSequence = new ArrayList<>();
            for(int i =sequence.getMaxCountDirtySign() - sequence.getCountDirtySign(); i > 0 ; i--){
                int startIndex = sequence.getStartIndexSequence() - i;
                if(startIndex >= 0)
                    possibleSignInSequence.add(Map.entry(arr[startIndex], startIndex));
                int endIndex = sequence.getEndIndexSequence() + i;
                if(endIndex <= arr.length-1)
                    possibleSignInSequence.add(Map.entry(arr[endIndex], endIndex));
            }
            sequence.selectionSequences(possibleSignInSequence);
        }
        List<String> toReturn = new ArrayList<>();
        sequences.forEach(sequence -> toReturn.add(sequence.toString()));
        return toReturn;
    }
    private static <T> DirtySequence<T> sequenceWithMainSign(List<DirtySequence<T>> list, T mainSign){
        for(var item : list){ if(item.getMainSign() == mainSign) return item; }
        return null;
    }
}
