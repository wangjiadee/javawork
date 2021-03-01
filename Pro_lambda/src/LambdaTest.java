import org.junit.Test;

import java.util.Comparator;


public class LambdaTest {
    @Test
    public void Test1(){
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                System.out.println("WDNMD");
            }
        };

        runnable.run();


        Runnable runnable2 = () -> System.out.println("MDZZ");
        runnable2.run();
    }


    @Test
    public void Test2(){
        Comparator<Integer> integerComparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare = integerComparator.compare(12, 32);
        System.out.println(compare);


        Comparator<Integer> integerComparator1 = (o1, o2) -> Integer.compare(o1,o2);
        int compare2 = integerComparator1.compare(90,20);
        System.out.println(compare2);



    }



}
