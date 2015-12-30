package ritemov2.commonModule.netty;


import ritemov2.commonModule.msg.CSGOV2Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import java.nio.ByteOrder;

public class CSGOV2_Client_Agent_Decoder extends LengthFieldBasedFrameDecoder {

    public CSGOV2_Client_Agent_Decoder(ByteOrder byteOrder, int maxFrameLength,
                                       int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment,
                                       int initialBytesToStrip, boolean failFast) {
        super(byteOrder, maxFrameLength, lengthFieldOffset, lengthFieldLength,
                lengthAdjustment, initialBytesToStrip, failFast);

    }

    public CSGOV2_Client_Agent_Decoder() {
        this(ByteOrder.BIG_ENDIAN, 1000000000, 0, 4, 0, 4, true);
      //  this(ByteOrder.LITTLE_ENDIAN, 100000000, 0, 4, 0, 4, true);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in)
            throws Exception {

        ByteBuf frame = (ByteBuf) super.decode(ctx, in);
        if (frame == null) {
            return null;
        }

        int cmd = frame.readInt();
        //Little dndian convert
//        int bCmd=((cmd>>24)|((cmd>>16)&0xff)|((cmd>>8)&0xff)|(cmd&0xff));
//        int bCmd=((cmd>>24)|((cmd>>8)&0xff00))|((cmd<<8)&0xff0000)|((cmd<<24)&0xff000000);

        //
        byte[] data = new byte[frame.readableBytes()];
        frame.readBytes(data);

        CSGOV2Message msgVO = new CSGOV2Message(cmd, data);

        return msgVO;
    }

}
