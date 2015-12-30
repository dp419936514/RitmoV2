package ritemov2.commonModule.netty;

import ritemov2.commonModule.msg.CSGOV2Message;
import ritemov2.commonModule.util.Constant;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class CSGOV2_Agent_GameServer_Encoder extends MessageToByteEncoder<CSGOV2Message> {

    @Override
    protected void encode(ChannelHandlerContext ctx, CSGOV2Message msg,
                          ByteBuf out) throws Exception {

        //        int bCmd=((cmd>>24)|((cmd>>8)&0xff00))|((cmd<<8)&0xff0000)|((cmd<<24)&0xff000000);

        byte content[] = msg.getProbuf();

        int dataLength = content.length;
        //4+16+xx
        int packageLength = 4 + Constant.ChannelIdLengthInMsg + content.length;

        out.ensureWritable(packageLength);
        out.writeInt(packageLength);//4
        out.writeBytes(msg.getChId());//16
        if (msg.getChId().length < Constant.ChannelIdLengthInMsg) {
            int dumLen = Constant.ChannelIdLengthInMsg - msg.getChId().length;
            out.writeBytes(new byte[dumLen]);//16
            throw new Exception("Chid length excceds Constant.ChannelIdLengthInMsg");
            //NOTE:should never not run here,but if run here,we do as below
        }

        out.writeInt(msg.getCmdId());//4
        if (dataLength > 0) {//xx
            out.writeBytes(content);
        }
    }
}
