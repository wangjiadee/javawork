package src.com.ralph.Exer;

import org.junit.Test;

public class StringExer {
    public static void main(String[] args) {

        String str1 = "  12312312  ";
        System.out.println(MyTrim(str1));

        String S1 = "abkkcadkabkebfkabkskab";
        String S2=S1.replace("ab","");
        System.out.println(S2);
        System.out.println("ab出现的次数为："+(S1.length()-S2.length())/2);


    }

    public static String MyTrim(String str){
        if (str != null) {
            int start = 0;// 用于记录从前往后首次索引位置不是空格的位置的索引
            int end = str.length() - 1;// 用于记录从后往前首次索引位置不是空格的位置的索引

            while (start < end && str.charAt(start) == ' ') {
                start++;
            }

            while (start < end && str.charAt(end) == ' ') {
                end--;
            }
            if (str.charAt(start) == ' ') {
                return "";
            }

            return str.substring(start, end + 1);
        }
        return null;

    }
}





