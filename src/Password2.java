import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Created by Viacheslav on 28.11.2018.
 */
public class Password2  {
     static String pass = "";
     static int cntChars;



    public static String generate() {
        char ch = 0;

        Random r = new Random();
            for (int i = 0; i < cntChars; i++) {
            char next = 0;
            int range = 10;

            switch (r.nextInt(3)) {
                case 0: {
                    next = '0';
                    range = 10;
                }
                break;
                case 1: {
                    next = 'a';
                    range = 26;
                }
                break;
                case 2: {
                    next = 'A';
                    range = 26;
                }
                break;
            }
            pass += (char) (r.nextInt(range) + next);

        }

        return pass;

    }
     public static boolean isFieldNotEmpty(){
        if (cntChars!= 0) {
            return true;
        }
         return false;

    }
}

