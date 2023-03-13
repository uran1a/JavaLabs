package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataContainer {
     private static List<Integer[]> listTask10 = new ArrayList<>(List.of(
        new Integer[] {100, 180, 260, 310, 40, 535, 695},
        new Integer[] {100, 180},
        new Integer[] {100, 180, 260, 310},
        new Integer[] {40, 535, 695},
        new Integer[] {23, 13, 25, 29, 33, 19, 34, 45, 65, 67}
     ));

     private static List<Integer[]> listTask23 = new ArrayList<>(List.of(
       new Integer[] {4, 5, 3, 3, 7, 3, 3, 7, 6, 4, 6, 7, 7, 7, 7, 1},
       new Integer[] {4, 5, 3, 3, 4, 3}
     ));
     private static Integer[] currentArrayListTask24;

     public static List<Integer[]> getListTask10(){ return listTask10; }
     public static List<String> getListStringTask10(){
          List<String> toReturn = new ArrayList<>();
          for(int i = 0; i < DataContainer.getListTask10().size(); i++)
               toReturn.add(Arrays.toString(DataContainer.getListTask10().get(i)));
          return toReturn;
     }
     public static List<Integer[]> getListTask23(){ return listTask23; }
     public static List<String> getListStringTask(List<Integer[]> list){
          List<String> toReturn = new ArrayList<>();
          for (Integer[] integers : list)
               toReturn.add(Arrays.toString(integers));
          return toReturn;
     }
     public static List<Integer[]> getSelectedListTask23(){ return Collections.singletonList(listTask23.get(0)); }
     public static void addListTask10(Integer[] array) { listTask10.add(new Integer[]{10, 20, 30}); }
     public static void setCurrentArrayListTask24(Integer[] array) { currentArrayListTask24 = array; }
     public static Integer[] getCurrentArrayListTask24() { return currentArrayListTask24; }
}
