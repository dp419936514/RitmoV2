package ritmov2.network;

import android.util.Log;

import ritmov2.commonModule.msg.CSGOV2Message;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class NettyServerHandler extends SimpleChannelInboundHandler<CSGOV2Message> {
    private static String TAG  = "NettyServerHandler";

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //LOG.debug("client channelActive:" + ctx.channel().remoteAddress().toString()+" No : "+ ++i);
        super.channelActive(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        Channel channel = ctx.channel();
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            if (e.state() == IdleState.READER_IDLE) {
                channel.close(); // call back
            } // because we are attaching more importance to the read_idle
            // time(timeout to rec)
            else if (e.state() == IdleState.WRITER_IDLE) { // No data was sent
                channel.close();
            }
        }
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, CSGOV2Message msg) throws Exception {

        Log.i(TAG , "receive message from server " + msg.toString());

    }
}
