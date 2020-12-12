/*
while(a1){
    t1;
    t2;
}
 */

class While_Test{
    public static void main(String[] args) {
        int i= 1;
        while(i <= 100){
            if (i %2 == 0){
                System.out.println(i);
            }
            i++;
        }
    }
}