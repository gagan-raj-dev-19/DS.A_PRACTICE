package Arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {

   public static List<List<Integer>> pascalTriangle(int numRows){
       List<List<Integer>> triangle = new ArrayList<>();
       if (numRows <= 0){
           return triangle;
       }
       triangle.add(new ArrayList<>());
       triangle.get(0).add(1);

       for (int i=1;i<numRows;i++){
           List<Integer>prevRow = triangle.get(i-1);
           List<Integer>currRow = new ArrayList<>();
           currRow.add(1);
           for (int j=1;j<prevRow.size();j++){
               currRow.add(prevRow.get(j-1)+ prevRow.get(j));
           }
           currRow.add(1);
           triangle.add(currRow);
       }
       return triangle;
   }

    public static void main(String[] args) {
        int numRow = 5;
        List<List<Integer>> res= pascalTriangle(numRow);
        System.out.println(res);
    }

}
