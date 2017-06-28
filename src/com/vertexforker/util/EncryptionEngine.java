/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vertexforker.util;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 *
 * @author d.jayasinghe
 */
public class EncryptionEngine {
    private static final String ALGO="AES";
     private static final byte[] keyValue
            = new byte[]{'C', 'd', 'a', 'P', 'S', 't', 'r', 'E', 'a', 'm', 'i', 'n', 'g', 'P', 'r', 'o'};
    private static Cipher cipher;

    public String encrypt(String plainText) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        Key secretKey=generateKey();
        byte[] plainTextByte=plainText.getBytes();
        cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder().withoutPadding();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText.replace("/", "*");
    }
    
    public String decrypt(String encryptedText) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        encryptedText = encryptedText.replace("*", "/");
        Key secretKey = generateKey();
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
        return decryptedText;
    }
    
    private Key generateKey(){
        return new SecretKeySpec(keyValue, ALGO);
    }
    
}
