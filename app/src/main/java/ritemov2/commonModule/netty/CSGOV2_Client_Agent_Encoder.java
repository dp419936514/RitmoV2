package ritemov2.commonModule.netty;

import ritemov2.commonModule.msg.CSGOV2Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class CSGOV2_Client_Agent_Encoder extends MessageToByteEncoder<CSGOV2Message> {

    @Override
    protected void encode(ChannelHandlerContext ctx, CSGOV2Message msg,
                          ByteBuf out) throws Exception {

        //        int bCmd=((cmd>>24)|((cmd>>8)&0xff00))|((cmd<<8)&0xff0000)|((cmd<<24)&0xff000000);
        byte content[] = msg.getProbuf();

        int dataLength = content.length;
        int packageLength = 4 + content.length;

        out.ensureWritable(packageLength);
        out.writeInt(packageLength);
        out.writeInt(msg.getCmdId());
        if (dataLength > 0) {
            out.writeBytes(content);
        }
    }
}
