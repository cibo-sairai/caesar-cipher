import java.io.*;
import java.util.*;

public class CaesarCipher2{
   public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

   public static String cipher(String message, int offset)
   {  
      StringBuilder result = new StringBuilder();
      for (char character : message.toCharArray()) {
          if (character != ' ') {
              int originalAlphabetPosition = character - 'a';
              int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
              char newCharacter = (char) ('a' + newAlphabetPosition);
              result.append(newCharacter);
          } else {
              result.append(character);
       }
    }
    return result.toString();
    }

   public static String decrypt(String cipherText, int shiftKey) {
     cipherText = cipherText.toLowerCase();
     String message = "";
     for (int ii = 0; ii < cipherText.length(); ii++) {
       int charPosition = ALPHABET.indexOf(cipherText.charAt(ii));
       int keyVal = (charPosition - shiftKey) % 26;
       if (keyVal < 0) {
         keyVal = ALPHABET.length() + keyVal;
       }
       char replaceVal = ALPHABET.charAt(keyVal);
       message += replaceVal;
     }
     return message;
   }
    
    public static void main(String[] args)
    {
      Scanner sc = new Scanner(System.in);
      String m = new String();
      int key = 0;
      System.out.print("Enter the String for Encryption:");
      m = sc.next();
   
      System.out.println("\n\nEnter Shift Key:");
      key = sc.nextInt();
      System.out.println("\nEncrypted Message:" + cipher(m, key));
      System.out.println("\nDecrypted Message:" +decrypt(m,key));

    }
   
}

