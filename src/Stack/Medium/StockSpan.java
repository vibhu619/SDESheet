package Stack.Medium;

import java.util.Stack;

//The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stocks price for all n days.
//        The span Si of the stocks price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the given day is less than or equal to its price on the current day.
//        For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.
//
//        Example 1:
//
//        Input:
//        N = 7, price[] = [100 80 60 70 60 75 85]
//        Output:
//        1 1 1 2 1 4 6
//        Explanation:
//        Traversing the given input span
//        100 is greater than equal to 100 and there are no more elements behind it so the span is 1,
//        80 is greater than equal to 80 and smaller than 100 so the span is 1,
//        60 is greater than equal to 60 and smaller than 80 so the span is 1,
//        70 is greater than equal to 60,70 and smaller than 80 so the span is 2,
//        60 is greater than equal to 60 and smaller than 70 so the span is 1,
//        75 is greater than equal to 60,70,60,75 and smaller than 100 so the span is 4,
//        85 is greater than equal to 80,60,70,60,75,85 and smaller than 100 so the span is 6.
//        Hence the output will be 1 1 1 2 1 4 6.
public class StockSpan {
    public static void main(String[] args) {

        int[] price = {10, 4, 5, 90, 120, 80};
        int[] res = stock(price, price.length);
        for (int x : res) {
            System.out.println(x + " ");
        }
    }

    private static int[] stock(int[] price, int n) {
        int[] span = new int[n];
        Stack<Integer> st = new Stack<>();
        //store index of price in stack
        //store 0th index in stack as its answer is always 1
        st.push(0);
        span[0] = 1;
        //iterate al prices from 1st index
        for (int i = 1; i < n; i++) {
            int currPrice = price[i];
            //find index of that price in stack which is bigger than current price
            while (!st.empty() && currPrice >= price[st.peek()]) {
                st.pop();
            }

            //if stack becomes empty means all prices before current price was smaller than this, hence store i+1 in ans
            if (st.empty()) {
                span[i] = i + 1;
            }
            //else , top of stack will have the index of that price hih is bigger than current price
            else {
                int prevIndex = st.peek();
                span[i] = i - prevIndex;  //just sub those two index to get width
            }
            st.push(i);
        }
        return span;
    }
}
