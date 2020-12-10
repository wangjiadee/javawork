/*
 * @Author: Ralph
 * @Type_file[python//GO//json//Yaml//Other]: [python//GO//json//Yaml//Other]
 * @Date: 2020-10-25 02:22:41
 * @LastEditTime: 2020-10-25 02:26:04
 * @FilePath: /code/fundation/for-test/ForTest.java
 * @Effect: DO
 */
import java.util.Scanner;
class ForTest{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Pls input first number:");
        int first_number = scan.nextInt();

        System.out.println("Pls input second number:");
        int second_number = scan.nextInt();

        int min = (first_number <= second_number)? first_number : second_number;
        for(int i = min; i >= 1 ;i--){
            if (first_number % i == 0 && second_number % i == 0){
                System.out.println("最大公约数："+ i);            
                break;
            }
        }

        int max = (first_number >= second_number)? first_number : second_number;
        for(int i =max; i <= first_number * second_number;i++){
            if (i % first_number == 0 && i % second_number == 0){
                System.out.println("最小公倍数：" + i);
                break;
            }
        }
    }
}