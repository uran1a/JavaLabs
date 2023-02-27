package logic.task10;

import logic.ExecutionFactory;
import test.DataContainer;

import java.util.*;
import java.util.Map;

public class Task10 implements ExecutionFactory {

    private final List<Integer[]> testArrays;
    public Task10(){
        testArrays = DataContainer.getListTask10(); }
    @Override
    public List<String> execute (){
        List<String> toReturn = new ArrayList<>();
         int maxLength = 0;
        for(var arr : testArrays){ if(maxLength < arr.length) maxLength = arr.length; }
        for(var arr : testArrays){
            int countLocalMax = 0, countLocalMin = 0;
            if(arr[0] < arr[1] || arr[arr.length - 1] < arr[arr.length - 2]) countLocalMax++;
            if(arr[0] > arr[1] || arr[arr.length - 1] > arr[arr.length - 2]) countLocalMin++;
            for(int i = 1; i < arr.length - 1; i++){
                if(arr[i-1] > arr[i] && arr[i] < arr[i+1]) countLocalMin++;
                if(arr[i-1] < arr[i] && arr[i] > arr[i+1]) countLocalMax++;
            }
            String space = "\t\t\t\t\t\t\t\t\t\t" + "\t".repeat(Math.max(0, maxLength - arr.length-2));
            toReturn.add(Arrays.toString(arr) + space +"max: " + countLocalMax + "\tmin: " + countLocalMin);
        }
        return toReturn;
    }
}
