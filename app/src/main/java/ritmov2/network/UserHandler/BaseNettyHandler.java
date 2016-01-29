package ritmov2.network.UserHandler;

import android.os.Messenger;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import ritmov2.commonModule.msg.CSGOV2Message;

/**
 * Created by Derek.P.Dai on 2016/1/29.
 */
public class BaseNettyHandler extends SimpleChannelInboundHandler<CSGOV2Message> {

    protected Messenger messenger ;

    public BaseNettyHandler(Messenger messenger) {
        this.messenger = messenger;
    }

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, CSGOV2Message message) throws Exception {

    }
}
