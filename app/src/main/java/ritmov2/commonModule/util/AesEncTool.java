package ritmov2.commonModule.util;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;


/**
 * Client与Agent通信时的加解密模块，AES-256算法加密
 *
 * @author Derek.P.Dai
 */
public class AesEncTool {

    private static Cipher cipher ;
    static{
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加密模块
     *
     * @param source     byte[] : 待加密的明文
     * @param rawKeyData byte[] : 加密密钥，长度必须是16的倍数
     * @return byte[] : 密文
     * @throws GeneralSecurityException 一切可能的安全异常
     */
    public static byte[] aesEncrypt(byte[] source, byte rawKeyData[]) throws GeneralSecurityException {
        // 处理密钥
        SecretKeySpec key = new SecretKeySpec(rawKeyData, "AES");
        // 加密

        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(source);
    }

    /**
     * 解密模块
     *
     * @param data       byte[] : 密文
     * @param rawKeyData byte[] : 加密密钥，长度必须是16的倍数
     * @return byte[] : 解出的明文
     * @throws GeneralSecurityException 一切可能的安全异常
     */
    public static byte[] aesDecrypt(byte[] data, byte rawKeyData[]) throws GeneralSecurityException {
        // 处理密钥
        SecretKeySpec key = new SecretKeySpec(rawKeyData, "AES");
        // 解密
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    public static byte[] keyGen(byte[] currentKey, int counter) {
        byte[] nextKey = new byte[16];

        return nextKey;
    }

}
