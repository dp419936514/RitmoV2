package ritmov2.derek.com.ritemov2.network;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import ritmov2.derek.com.ritemov2.message.ServiceMessage;
import ritmov2.derek.com.ritemov2.message.structure.MessageType;

/**
 * Created by Derek.P.Dai on 2015/11/3.
 */
public class LoginHandler extends SimpleChannelInboundHandler<ServiceMessage.Message> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Channel Active : \n LocalAddress : " + ctx.channel().localAddress() + "remoteAddress : " + ctx.channel().remoteAddress());
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, ServiceMessage.Message msg) throws Exception {
        int messageTypeInt = msg.getMessagetype();
        MessageType messageType = MessageType.parseFromInt(messageTypeInt);

        switch (messageType) {
            case LOGIN_REQUEST:


                break;

            case NO_MATCH:
                System.err.println("");
                break;
            default:
                break;
        }
    }
}
