import java.util.Scanner;
class whileTrue{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pn = 0;
        int nn = 0;
        while(true){
            int n = scan.nextInt();
            if(n > 0){
                pn++;
            }else if(n <0){
                nn++;
            }else{
                break;
            }
        }
        System.out.println(pn);
        System.out.println(nn);
    }
}