package com.ralph.util;
import java.util.*;

/**
 CMUtility tools:
 Encapsulating different functions as methods means that you can use its functions directly
 by calling the method without considering the specific function implementation details.
 */
public class CMUtility {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Description: Used for interface menu selection. This method reads the keyboard,
     *              If the user types any character from '1'-'5', the method returns.
     *              The return value is the character typed by the user.
     * params:
     * return:
     */
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' &&
                    c != '3' && c != '4' && c != '5') {
                System.out.print("[Info :] Selection error，please enter again：");
            } else break;
        }
        return c;
    }

    /**
     * Description: Read a character from the keyboard and use it
     *              as the return value of the method.
     * params:
     * return:
     */
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }


    /**
     * Description: Read a character from the keyboard and use it as the return value of the method.
     *              If the user does not enter a character and press Enter, the method will use defaultValue as the return value.
     * params:   defaultValue
     * return:   defaultValue
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    /**
     * Description: Read an integer with a length of no more than 2 digits from the keyboard and
     *              use it as the return value of the method.
     * params:
     * return: n
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("[Info :] Number input error,please enter again：");
            }
        }
        return n;
    }


    /**
     * Description: Read an integer with a length of no more than 2 digits from the keyboard and use it as the return value of the method.
     If the user does not enter a character and press Enter, the method will use defaultValue as the return value.
     * params:   defaultValue
     * return:   defaultValue
     */
    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, true);
            if (str.equals("")) {
                return defaultValue;
            }

            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("[Info :] Number input error,please enter again：");
            }
        }
        return n;
    }


    /**
     * Description: Read a character string whose length does not exceed limit from the keyboard and use it as the return value of the method.
     * params:
     * return:
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     * Description: Read a character string whose length does not exceed limit from the keyboard and use it as the return value of the method.
     If the user does not enter a character and press Enter, the method will use defaultValue as the return value.
     * params:   defaultValue
     * return:   defaultValue
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("")? defaultValue : str;
    }

    /**
     * Description:	Used to confirm the selected input. This method reads'Y' or'N' from the keyboard and uses it as the return value of the method.
     * params:
     * return:
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("[Info :] Number input error,please enter again：");
            }
        }
        return c;
    }




    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }
            if (line.length() < 1 || line.length() > limit) {
                System.out.print("[Info :] Input length（no greater than" + limit + "）error，please enter again：");
                continue;
            }
            break;
        }
        return line;
    }
}
