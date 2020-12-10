/*
 * @Author: Ralph
 * @Type_file[python//GO//json//Yaml//Other]: [python//GO//json//Yaml//Other]
 * @Date: 2020-10-25 01:44:16
 * @LastEditTime: 2020-10-25 01:44:17
 * @FilePath: /code/code1/ifTest.java
 * @Effect: DO
 */
class ifTest{
    public static void main(String[] args) {
        int sum;
        for(int i = 1;i <= 100; i++){
            if(i % 2 != 0 ){
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println(sum);
    }
}