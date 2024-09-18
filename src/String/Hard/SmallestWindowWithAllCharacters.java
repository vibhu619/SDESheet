package String.Hard;

public class SmallestWindowWithAllCharacters {
    public static void main(String[] args) {

        String str="timetoprvactice";
        String pat="toc";

        int l=findSmallestWindow(str,pat);
        System.out.println(l);
    }

    private static int findSmallestWindow(String str, String pat) {

        int len1=str.length();
        int len2=pat.length();

        if(len1<len2){
            return -1;
        }

        int[] strHash=new int[256];
        int[] patHash=new int[256];

        //1)Store pattern character's count in hash array
        for(int i=0;i<len2;i++){
            patHash[pat.charAt(i)]++;
        }
        int count=0;
        int start=0;
        int min_length=Integer.MAX_VALUE;
        int start_index=-1;
        //2. Iterate over string
        for(int i=0;i<len1;i++){
            //3. Store count of each char of str in str hash array
            strHash[str.charAt(i)]++;
            //4. process to find valid substring is in process till the time we get count of character in str equal to pat.length
            if(strHash[str.charAt(i)]<=patHash[str.charAt(i)]){ //if the char in str has count less or equal to count in pat
                count++;
            }

            //5.If count is matched with len2
            if(count==len2){
                //6. We got a potential ans from str[0-i], but need to minimize the window which has the smallest length with all pat's characters
                while(strHash[str.charAt(start)]>patHash[str.charAt(start)] || patHash[str.charAt(start)]==0) {
                    if (strHash[str.charAt(start)] > patHash[str.charAt(start)]) {
                        strHash[str.charAt(start)]--;  //remove that char
                    }
                    start++;
                }

                //7.update window size
                int len_window=i-start+1;
                if(len_window<min_length){
                    min_length=len_window;
                    start_index=start;
                }
            }
        }
        //if no answer found
        if(start_index==-1){
            return -1;
        }
        System.out.println("Substring with smallest windo : " + str.substring(start_index,start_index+min_length));
        return min_length;
    }
}
