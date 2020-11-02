
class Break_con {
    public static void main(String[] args) {

        for(int i = 0; i <= 10;i++){
            if (i % 4 == 0){
                // break;
                continue;
            }
            System.out.print(i);
        }
    }
}