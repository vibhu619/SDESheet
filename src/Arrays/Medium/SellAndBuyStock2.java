package Arrays.Medium;

import java.util.ArrayList;

//The cost of stock on each day is given in an array A[] of size N. Find all the segments of days on which you buy and sell
//        the stock such that the sum of difference between sell and buy prices is maximized. Each segment consists of indexes of two elements, first is index of day on which you buy stock and second is index of day on which you sell stock.
//        Note: Since there can be multiple solutions, the driver code will print 1 if your answer is correct,
//        otherwise, it will return 0. In case there's no profit the driver code will print the string "No Profit" for a correct solution.
//
//        Example 1:
//
//        Input:
//        N = 7
//        A[] = {100,180,260,310,40,535,695}
//        Output:
//        1
//        Explanation:
//        One possible solution is (0 3) (4 6)
//        We can buy stock on day 0,
//        and sell it on 3rd day, which will
//        give us maximum profit. Now, we buy
//        stock on day 4 and sell it on day 6.
public class SellAndBuyStock2 {
    public static void main(String[] args) {
        int A[] = {7,1,5,3,6,4};
        int n = A.length;


        ArrayList<Integer> buy = new ArrayList<>(); //to store local minima days on which we can buy
        ArrayList<Integer> sell = new ArrayList<>();  //to store local maxima days when we can sell


        boolean flag = false; //to keep track wether we r selling or buying, false=buying and true=selling
        for (int i = 0; i < n - 1; i++) {
            if (!flag && A[i] < A[i + 1]) { //local minima condition
                buy.add(i);
                flag = true; //if bought now sell
            }

            if (flag == true && A[i] > A[i + 1]) { //local maxima condition
                sell.add(i);
                flag = false; //if sell now you can bought
            }
        }
        sell.add(n - 1); //always add last element in sell as its a local maxima

        int s = Math.min(buy.size(), sell.size()); //keep min size
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < s; i++) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(buy.get(i));
            ans.add(sell.get(i));
            res.add(ans);

        }
        int maxProfit = 0;
        for (ArrayList<Integer> a : res) {
            System.out.println("Day on which i can buy: " + a.get(0));
            System.out.println("Day on which i can sell: " + a.get(1));
            maxProfit = maxProfit + (A[a.get(1)] - A[a.get(0)]);
            System.out.println("Maximum profit: " + maxProfit);
        }
    }
}
