package ritemov2.commonModule.netty;

import ritemov2.commonModule.command.Commands;
import ritemov2.commonModule.msg.CSGOV2Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class GameServerHeartBeatHandler extends SimpleChannelInboundHandler<CSGOV2Message> {
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, CSGOV2Message msg)
            throws Exception {
        if (msg == null) {
            return;
        } else if (((CSGOV2Message) msg).getCmdId() == Commands.PING.getCmdValue()) {
            System.out.println("Ping from " + ctx.channel().remoteAddress());
            ctx.channel().writeAndFlush(new CSGOV2Message(Commands.PONG.getCmdValue(), new byte[1]));
        } else {
            ctx.fireChannelRead(msg);
        }
    }
}
