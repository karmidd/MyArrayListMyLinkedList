package Written;

import java.util.Scanner;

public class Polyalphabetic {
    public static String encode(String word, int key) {
        String cipher = "";
        for (int i = 0; i < word.length(); i++) {
            int encryptedChar = word.charAt(i) + key + (i%3);
            if (encryptedChar > 90){
                encryptedChar = encryptedChar - 90 + 64;
            }
            cipher = cipher + (char)(encryptedChar);
        }
        return cipher;
    }
    public static String decode(String cipher, int key) {
        String word = "";
        for (int i = 0; i < cipher.length(); i++) {
            int decryptedChar = cipher.charAt(i) - key - (i%3);
            if (decryptedChar < 65){
                decryptedChar = decryptedChar - 64 + 90;
            }
            word = word + (char)(decryptedChar);
        }
        return word;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = sc.nextLine();
        System.out.print("Enter a key: ");
        int key = sc.nextInt();
        System.out.println(Polyalphabetic.encode(word, key));
        System.out.println(Polyalphabetic.decode(Polyalphabetic.encode(word, key), key));
    }
}
