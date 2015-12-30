package ritemov2.commonModule.util;

import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * Created by Henry.Wu on 2015/9/6.
 */
public class UUIDConvert {

    public static byte[] uuidToByteArray(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }

    public static UUID byteArrayToUUID(byte[] data) {

        if (data != null) {
            if (data.length != 16) {
                System.out.println("data must be 16 bytes in length");
            }

            long msb = 0;
            long lsb = 0;

            for (int i = 0; i < 8; i++)
                msb = (msb << 8) | (data[i] & 0xff);
            for (int i = 8; i < 16; i++)
                lsb = (lsb << 8) | (data[i] & 0xff);

            return new UUID(msb, lsb);
        } else {
            return null;
        }
    }
}
