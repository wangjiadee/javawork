package org.ralph.java;

import java.util.Scanner;
import java.util.Vector;

public class ScoreTest {
    public static void main(String[] args) {
    // 1.Instantiate Scanner to get student scores from the keyboard
        Scanner scan = new Scanner(System.in);

    // 2.Create a Vector object: Vector v=new Vector(); equivalent to the original array
        Vector v = new Vector();

    // 3.Add an array to Vector through for(;;) or while(true)
        int maxScore = 0;
        for(;;){
            System.out.println("Pls input student score: " );
            int score = scan.nextInt();
            if(score < 0 ){
                break;
            }
            if(score > 100){
                System.out.println("[info: ] Illegal data entered");
                continue;
            }
//            Integer inScore = new Integer(score);
            v.addElement(score);

            if (maxScore < score){
                maxScore = score;
            }
        }

        char level;
        for(int i = 0;i < v.size();i++){
            Object obj = v.elementAt(i);
            //jdk 5.0之前：
//			Integer inScore = (Integer)obj;
//			int score = inScore.intValue();
            //jdk 5.0之后：
            int score = (int)obj;

            if(maxScore - score <= 10){
                level = 'A';
            }else if(maxScore - score <= 20){
                level = 'B';
            }else if(maxScore - score <= 30){
                level = 'C';
            }else{
                level = 'D';
            }

            System.out.println("studentnumber" + i + " score is " + score + ",level is " + level);

        }
    }
}
