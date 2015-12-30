package ritemov2.commonModule.msg;

/**
 * Agent与Client交互使用的密文，AES-256加密
 *
 * @author Derek.P.Dai
 */
public class CipherMessage {
    private byte[] cipherText;

    public CipherMessage(byte[] cipherText) {
        super();
        this.cipherText = cipherText;
    }

    public byte[] getCipherText() {
        return cipherText;
    }

}
