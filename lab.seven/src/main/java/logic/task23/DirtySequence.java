package logic.task23;
import java.util.*;
public class DirtySequence<T> {
    private List<Map.Entry<T, Integer>> mainSequence;
    private List<List<T>> sequences;
    private T mainSign;
    private int maxCountDirtySign = 0;
    private int countDirtySign = 0;
    private int countMainSign = 1;
    public DirtySequence(T mainSign, int firstIndex, int maxCountDirtySign){
        mainSequence = new ArrayList<>(Collections.singletonList(Map.entry(mainSign, firstIndex)));
        sequences = new ArrayList<>();
        this.mainSign = mainSign;
        this.maxCountDirtySign = maxCountDirtySign;
    }
    public void selectionSequences (List<Map.Entry<T, Integer>> possibleSignInSequence) {
        //если список пустой, основная последовательность является единственной
        if(possibleSignInSequence.size() == 0) {
            List<T> tempList  = new ArrayList<>();
            for (var entry : mainSequence) tempList.add(entry.getKey());
            sequences.add(tempList);
            return;
        };

        //составляем пары последовательностей

        possibleSignInSequence.addAll(mainSequence);
        possibleSignInSequence.sort(Comparator.comparing(Map.Entry::getValue));
        List<T> dirtySequence  = new ArrayList<>();
        for (var entry : possibleSignInSequence) dirtySequence.add(entry.getKey());
        for(int i = 0; true; i++){
            int lastIndex = ((mainSequence.size() + (maxCountDirtySign-countDirtySign))+i)-1;
            if(lastIndex <= dirtySequence.size()){
                sequences.add(dirtySequence.subList(i, lastIndex+1));
                if(dirtySequence.get(lastIndex).equals(dirtySequence.get(dirtySequence.size()-1))) break;
            }
        }
        System.out.println(sequences.toString());
    }
    public T getMainSign(){ return this.mainSign; }
    public List<List<T>> getSequences() {return sequences;}
    public int countDirtySign(int index){ return (index - mainSequence.get(mainSequence.size() - 1).getValue() - 1); }
    public boolean acceptableDistanceBetweenIndexes(int index){
        return index <= maxCountDirtySign;
    }
    public void enhancementCountDirtySign() { countDirtySign++; }
    public void addSignSequence(T sign, int index) {
        if(sign == mainSign) countMainSign++;
        mainSequence.add(Map.entry(sign, index));
    }
    public int getCountMainSign() { return countMainSign; }
    public int getCountDirtySign() { return countDirtySign; }
    public int getMaxCountDirtySign() { return maxCountDirtySign; }
    public int getStartIndexSequence() { return mainSequence.get(0).getValue(); }
    public int getEndIndexSequence() { return mainSequence.get(mainSequence.size()-1).getValue(); }
    @Override
    public String toString(){
        return "Main sign: " + mainSign + "\tSequence: " + mainSequence + "\tIndexes: " + mainSequence + "\tFree position: " + (maxCountDirtySign-countDirtySign) + "\tCount main sign: " + (countMainSign);
    }
}

