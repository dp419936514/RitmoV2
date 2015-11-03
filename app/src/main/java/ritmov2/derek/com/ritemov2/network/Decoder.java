package ritmov2.derek.com.ritemov2.network;

import java.nio.ByteOrder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import ritmov2.derek.com.ritemov2.message.structure.MessageType;

/**
 * Created by Derek.P.Dai on 2015/11/3.
 */
public class Decoder extends LengthFieldBasedFrameDecoder {

    public Decoder(ByteOrder byteOrder, int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip, boolean failFast) {
        super(byteOrder, maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast);
    }

    public Decoder(){
        this(ByteOrder.BIG_ENDIAN,10000000,0,4,0,0,false);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        ByteBuf frame = (ByteBuf) super.decode(ctx, in);

        //TODO　complete decoder

        int messageType = frame.readInt();
        byte[] contentBytes = new byte[frame.readableBytes()];
        frame.readBytes(contentBytes);

       // String content = String.

        return null;
    }
}
