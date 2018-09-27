/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniusapp;


import java.io.IOException;
import java.math.BigInteger;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import sun.misc.BASE64Decoder;

/**
 *
 * @author Administrator
 */
public class CryptWithMD5 {

       private static MessageDigest md;

  public static String crypt(String pass){
    try 
        {
            String text = pass;
            String key = "Bar12345Bar12345"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            String en=new String(encrypted);
           // JOptionPane.showMessageDialog(null,en);
           // System.err.println(new String(encrypted));
            // decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(encrypted));
           // JOptionPane.showMessageDialog(null,decrypted);
          // System.err.println(decrypted);
            return en;
        }
        catch(Exception e) 
        {
            e.printStackTrace();
            return null;
        }


   }
  public String Decrypt(String pass) {
       try 
        {
            String text = pass;
            String key = "Bar12345Bar12345"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            String en=new String(encrypted);
          //  JOptionPane.showMessageDialog(null,en);
           /// System.err.println(new String(encrypted));
            // decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(encrypted));
           // JOptionPane.showMessageDialog(null,decrypted);
            //System.err.println(decrypted);
            return decrypted;
        }
        catch(Exception e) 
        {
            e.printStackTrace();
            return null;
        }
  }
   
}
