package com.ralph.exer;

public class EcmDefTest {
    public static void main(String[] args) {
        try{
            int i = Integer.parseInt(args[0]);
            int j = Integer.parseInt(args[1]);

            int result = ecm(i,j);
            System.out.println(result);
        }catch(NumberFormatException e){
            System.out.println("Inconsistent data types");
        }catch(ArrayIndexOutOfBoundsException e ){
            System.out.println("Missing command line parameters");
        }catch(ArithmeticException e){
            System.out.println("by zero");
        }catch(EcmDefException e){
            System.out.println(e.getMessage());
        }
    }

    public static int ecm(int i,int j)throws EcmDefException{
        if(i < 0 || j < 0 ){
            throw new EcmDefException("[Info:] The numerator or denominator is negative");
        }
        return i/j;
    }
}


