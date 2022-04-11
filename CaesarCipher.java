/* The Caesar's Cipher Assignment: Programming 12 */
import java.io.*;
import java.util.*;

public class CaesarCipher
{
   public static final String alpha = "abcdefghijklmnopqrstuvwxyz";
   
   public static String cipher(String message, int offset)
   {
      message = message.toLowerCase();
      String m = "";
      for (int i = 0; i < message.length(); i++) {
        int charPosition = alpha.indexOf(message.charAt(i));
        int keyVal = (charPosition - offset) % 26;
        if (keyVal < 0) {
          keyVal = alpha.length() + keyVal;
      }
      char replaceVal = alpha.charAt(keyVal);
      m += replaceVal;
    }
    return m;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String m = new String();
    int key = 0;
    System.out.print("Enter the String for Encryption:");
    m = sc.next();

    System.out.println("\n\nEnter Shift Key:");
    key = sc.nextInt();
    System.out.println("\nEncrypted Message:" + cipher(m, key));

  }
}