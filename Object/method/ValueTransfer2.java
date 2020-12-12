public class ValueTransfer2 {
    public static void main(String[] args) {
        Date date = new Date();
        date.m = 10;
        date.n = 20;
        System.out.println("m= "+ date.m +",n= " + date.n);

        ValueTransfer2 randoname =new ValueTransfer2();
        randoname.sawp(date);

        System.out.println("m= "+ date.m +",n= " + date.n);
    }

    public void sawp(Date date){
        int temp = date.m;
        date.m = date.n;
        date.n = temp;
    }
}

class Date {
    int m;
    int n;
}