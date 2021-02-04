package src.com.ralph;

import org.junit.Test;

import java.util.Scanner;

public class AllTest {

    public static void main(String[] args) {
        System.out.println("随便输入点东西吧");
        Scanner UserInput = new Scanner(System.in);
        String s = UserInput.nextLine();
        if (s.length() != 0){
            System.out.println(s);
            char X = s.charAt(0);
            if (X >= 65 && X<=90){
                int n = 0;
                char[] Arr = s.toCharArray();//字符串换数组
                for(int i = 0;i<=s.length()-1;i++){
                    if (Arr[i] >= 'A' && Arr[i] <= 'Z'){
                        System.out.println("[Input ]: " + Arr[i]);
                        n++;
                    }
                }
                System.out.println("[Input ]: " + n);

            }else {
                System.out.println("[Error] : 首字母非大写ZZ");
            }

        }else {
            System.out.println("[Error] : 什么都不输入吗？ZZ");
        }


    }


    @Test
    public void Test1(){
        String str1 = "尚硅谷";
        String str2 = "尚硅谷";
        String str3 = new String("尚硅谷");
        System.out.println(str1 == str2);//true
        System.out.println(str1 == str3);//false
        System.out.println(str1.equals(str3));//true
        str1 = "尚硅谷atguigu.com";
        String str4 = "atguigu.com";
        String str5 = "尚硅谷" + "atguigu.com";
        System.out.println(str1 == str5);//true

        String str6 = (str2 + str4).intern();
        System.out.println(str1 == str6);//拼接调用intern()方法，返回值就在常量池中 false  ---->true
    }

    @Test
    public void Test2(){
        System.out.println("随便输入点东西吧");
        Scanner UserInput = new Scanner(System.in);
        String s = UserInput.nextLine();
        if (s.length() != 0){
            System.out.println(s.length());
        }else {
            System.out.println("[Error] : 什么都不输入吗？ZZ");
        }
    }

}
