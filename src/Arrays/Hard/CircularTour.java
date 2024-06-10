package Arrays.Hard;
//Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
//        1. The amount of petrol that every petrol pump has.
//        2. Distance from that petrol pump to the next petrol pump.
//        Find a starting point where the truck can start to get through the complete circle without exhausting its petrol in between.
//        Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.
//
//        Example 1:
//
//        Input:
//        N = 4
//        Petrol = 4 6 7 4
//        Distance = 6 5 3 5
//        Output: 1
//        Explanation: There are 4 petrol pumps with
//        amount of petrol and distance to next
//        petrol pump value pairs as {4, 6}, {6, 5},
//        {7, 3} and {4, 5}. The first point from
//        where truck can make a circular tour is
//        2nd petrol pump. Output in this case is 1
//        (index of 2nd petrol pump).
public class CircularTour {
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int [] distance = {6 ,5 ,3 ,5};
        System.out.print("Truck needs to start from index: ");
        System.out.println(tour(petrol,distance));

    }

    static int tour(int petrol[], int distance[])
    {
        // Your code here
        int n=petrol.length;
        int start=0;
        int balance=0;
        int def=0;

        for(int i=0;i<n;i++){
            //find total balance petrol everytime u move
            balance=balance+petrol[i]-distance[i];
            //if balance becomes negative means we cant go further , hence change start point to i+1 and balance 0. We will start tour again
            // and negative balance is defecit petrol we require to go from 0 to current ith index
            if(balance<0){
                def=def+balance;
                start=i+1;
                balance=0;
            }
        }
        //if we are able to reach to the end of distance, i.e n-1
        //means we had enough petrol to go from start to n-1
        //and we also know that to go from 0 to start-1 index we have a defecit. If balance petrol after going from start to n-1 , is more than this defecit--> Our start point is OK
        if(def+balance>=0){
            return start;
        }
        else{
            return -1;
        }
    }
}
