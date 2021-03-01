import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;


import java.util.function.Consumer;

public class lambdaFunc {



    @Test
    public void Test1(){
        HappyTime(400,money -> System.out.println(money +"包夜"));
    }

    public  void HappyTime(double money, Consumer<Double> cons){
        cons.accept(money);

    }
}
