package Arrays.Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class UniqueRowInMatrix {
    public static void main(String[] args) {
        int[][] a={{1 ,1 ,0 ,1},{1, 0 ,0 ,1},{1, 1, 0 ,1}};

        int r=3;
        int c=4;

        ArrayList<ArrayList<Integer>> ans= uniqueRow(a,r,c);
        for(ArrayList<Integer> x: ans){
            System.out.println(x);
        }
    }
    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][], int r, int c)
    {
        //add code here.
        LinkedHashSet<ArrayList<Integer>> hs=new LinkedHashSet<>();

        for(int i=0;i<r;i++){
            ArrayList<Integer> arr=new ArrayList<>();
            for(int j=0;j<c;j++){
                arr.add(a[i][j]);
            }
            hs.add(arr);

        }

        ArrayList<ArrayList<Integer>> res=new ArrayList<>();

        for(ArrayList<Integer> x: hs){
            res.add(x);
        }
        return res;
    }
}
