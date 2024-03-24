package org.example.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class CryptoUtils {
    private static final String ENCRYPTION_KEY = "Rabin12345678910";
    private static final Cipher cipher;

    static {
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize Cipher", e);
        }
    }

    public static String decrypt(String base64Data) {
        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(base64Data);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(ENCRYPTION_KEY.getBytes(), "AES"));
            return new String(cipher.doFinal(encryptedBytes), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Failed to decrypt input", e);
        }
    }
}
