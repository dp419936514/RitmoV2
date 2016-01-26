package ritmov2.network;


import ritmov2.commonModule.command.Commands;
import ritmov2.commonModule.msg.CSGOV2Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerHeartBeatHandler extends SimpleChannelInboundHandler<CSGOV2Message> {

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, CSGOV2Message msg)
            throws Exception {
        if (msg == null) {
            return;
        } else if (msg.getCmdId() == Commands.PING.getCmdValue()) {
            ctx.channel().writeAndFlush(new CSGOV2Message(Commands.PONG.getCmdValue(), new byte[1]));
        }
        ctx.fireChannelRead(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }


}
