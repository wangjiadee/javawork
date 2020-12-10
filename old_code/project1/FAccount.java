class FAccount{
    public static void main(String[] args) {
        boolean Flag_status = true;
        String details = "收支\t账户金额\t收支金额\t 说明\n";
        int balance = 10000;
        while(Flag_status){
            System.out.println("--------------------收入支出记账APP--------------------\n");
            System.out.println("--------------------1.收支明细-----------------------");
            System.out.println("--------------------2.收入登记-----------------------");
            System.out.println("--------------------3.支出等级-----------------------");
            System.out.println("--------------------4.退    出-----------------------\n");
            System.out.print("--------------------请选择（1-4）：--------------------");

            char selection = Utility.readMenuSelection();
            switch (selection) {
            case '1':
                System.out.println("-----------------当前收支明细记录-----------------");
                System.out.println(details);
                System.out.println("--------------------------------------------------");
                break;
            case '2':
                System.out.print("本次收入金额：");
                int addMoney = Utility.readNumber();
                System.out.print("本次收入说明：");
                String addInfo = Utility.readString();
                balance += addMoney;
                details += ("收入\t" + balance + "\t\t" + addMoney + "\t\t" + addInfo + "\n");
                System.out.println("---------------------登记完成---------------------\n");
                break;    
            case '3':
                System.out.print("本次支出金额：");
                int minusMoney = Utility.readNumber();
                System.out.print("本次支出说明：");
                String minusInfo = Utility.readString();

                if(balance >= minusMoney){
                    balance -= minusMoney;
                    details += ("支出\t" + balance + "\t\t" + minusMoney + "\t\t" + minusInfo + "\n");
                }else {
                    System.out.println("支出超出账户额度，支付失败");
                }
                System.out.println("---------------------登记完成---------------------\n");
                break;
            case '4':
                System.out.println("确认是否退出（Y/N）：");
                char isExit = Utility.readConfirmSelection();
                if(isExit == 'Y'){
                    Flag_status = false;
                }
                
            }
        }
    }
}