package src.com.ralph.TimeAPI;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("随便输入点东西吧");
        Scanner UserInput = new Scanner(System.in);
        String s = UserInput.nextLine();
        if (s.length() != 0){
            System.out.println(s.length());
            int j = s.length();
            for (int i = j-1 ;i >= 0;i--){
                System.out.println(s.charAt(i));
            }
        }else {
            System.out.println("[Error] : 什么都不输入吗？ZZ");
        }
    }
}
