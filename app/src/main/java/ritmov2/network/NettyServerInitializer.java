package ritmov2.network;

import ritmov2.commonModule.netty.CSGOV2_Client_Agent_Decoder;
import ritmov2.commonModule.netty.CSGOV2_Client_Agent_Encoder;
import ritmov2.commonModule.netty.CSGOV2_Client_Agent_Encrypted_Decoder;
import ritmov2.commonModule.netty.CSGOV2_Client_Agent_Encrypted_Encoder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.net.SocketAddress;

public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {

    private static boolean Message_Encryption = true;
    private static boolean Client_Agent_Heartbeat = true;

    private int WRITER_IDLE_TIMEOUT = 10000;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();
        if (Message_Encryption) {
            p.addLast("decoder", new CSGOV2_Client_Agent_Encrypted_Decoder());
            p.addLast("encoder", new CSGOV2_Client_Agent_Encrypted_Encoder());
        } else {
            p.addLast("decoder", new CSGOV2_Client_Agent_Decoder());
            p.addLast("encoder", new CSGOV2_Client_Agent_Encoder());
        }

        p.addLast("idleStateHandler", new IdleStateHandler(0, WRITER_IDLE_TIMEOUT, 0));

        if (Client_Agent_Heartbeat) {
            p.addLast("HeatBeat", new ServerHeartBeatHandler());
        }
        p.addLast("Handler", new NettyServerHandler());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress,
                        ChannelPromise promise) throws Exception {
        super.connect(ctx, remoteAddress, localAddress, promise);
    }

    @Override
    public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        super.disconnect(ctx, promise);
    }

    @Override
    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        super.close(ctx, promise);
    }

}
