/**
 * Write a description of CaesarCipher here.
 * Implementing Caesar Cipher algorithm
 * @author Tareq Khammash
 * @version (a version number or a date)
 */ 

import edu.duke.*;
public class CaesarCipher 
{
    public void testEncryptTwoKeys()
    {
        String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        int key1 = 8;
        int key2 = 21;
        String encrypted = encryptTwoKeys(message, key1, key2);
        System.out.println(encrypted);
    }
    public String encryptTwoKeys (String input, int key1, int key2) 
    {
        StringBuilder sb = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        int idx = 0;
        for (int i = 0 ; i < sb.length() ; i++)
        {
            char currChar = sb.charAt(i); 
            if (Character.isUpperCase(currChar))
            {
                idx = alphabet.indexOf(currChar);
            }
            else
            {
                idx = alphabet.toLowerCase().indexOf(currChar);
            }
            //idx = alphabet.indexOf(currChar);
            if(idx !=-1)
            {
                if(i%2 == 0)
                {
                   if (Character.isUpperCase(currChar))
                   {
                       char newChar = shiftedAlphabet1.charAt(idx);
                       sb.setCharAt(i,newChar); 
                   }
                   else
                   {
                       char newChar = shiftedAlphabet1.toLowerCase().charAt(idx);
                       sb.setCharAt(i,newChar); 
                   }
                }
                else
                {
                   if (Character.isUpperCase(currChar))
                   {
                       char newChar = shiftedAlphabet2.charAt(idx);
                       sb.setCharAt(i,newChar);
                   }
                   else
                   {
                       char newChar = shiftedAlphabet2.toLowerCase().charAt(idx);
                       sb.setCharAt(i,newChar);   
                   }
                }
            }
        }
        String encrypted = sb.toString();
        return encrypted;
    }
    public String encrypt(String input, int key)
    {
        StringBuilder sb = new StringBuilder(input) ; 
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        int idx = 0; // initializing the variable
        for(int i = 0 ; i < sb.length() ; i++)
        {
            char currChar = sb.charAt(i);
            if (Character.isUpperCase(currChar))
            {
                idx = alphabet.indexOf(currChar);
            }
            else
            {
                idx = alphabet.toLowerCase().indexOf(currChar);
            }
            if(idx != -1)
            {
               if (Character.isUpperCase(currChar))
               {   
                   char newChar = shiftedAlphabet.charAt(idx);
                   sb.setCharAt(i,newChar); 
               }
               else
               {
                   char newChar = shiftedAlphabet.toLowerCase().charAt(idx);
                   sb.setCharAt(i,newChar); 
               }
            }
        }
        String encrypted = sb.toString();
        return encrypted ;
    }
    public void testEncrypt()
    {
        //String encrypted = encrypt("FIRST LEGION ATTACK EAST FLANK!",23);
        String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        String encrypted = encrypt(message, 15);
        //String encrypted = encrypt("First Legion", 23); 
        System.out.println(encrypted);
    }
    public void testCaesar()
    {
        int key = 23;
        //int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }
}
