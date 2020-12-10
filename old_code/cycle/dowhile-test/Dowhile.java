/*
 * @Author: Ralph
 * @Type_file[python//GO//json//Yaml//Other]: [python//GO//json//Yaml//Other]
 * @Date: 2020-10-25 02:42:29
 * @LastEditTime: 2020-10-25 02:43:43
 * @FilePath: /code/cycle/dowhile-test/Dowhile.java
 * @Effect: DO
 */
class Dowhile{
    public static void main(String[] args) {
        int num = 1;
        int sum = 0;
        int count = 0;
        do{
            if(num % 2 == 0){
                System.out.println(num);
                sum += num;
                count ++;
            }
            num++; 
        }while(num < 101);
        System.out.println(sum);
        System.out.println(count);
    }
}