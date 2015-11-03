package ritmov2.derek.com.ritemov2.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import ritmov2.derek.com.ritemov2.message.structure.Message;

/**
 * Created by Derek.P.Dai on 2015/11/3.
 */
public class Encoder extends MessageToByteEncoder<Message> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {

        String content = msg.getContent();
        byte[] src    = content.getBytes();


        out.writeInt(src.length + 4); // length = message content length + a int(message type)
        out.writeInt(msg.getMessageTypeInt());

        out.writeBytes(src);

    }
}
