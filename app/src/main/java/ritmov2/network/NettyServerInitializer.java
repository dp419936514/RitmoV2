package ritmov2.network;

import android.os.Messenger;

import java.net.SocketAddress;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import ritmov2.commonModule.netty.CSGOV2_Client_Agent_Encrypted_Decoder;
import ritmov2.commonModule.netty.CSGOV2_Client_Agent_Encrypted_Encoder;
import ritmov2.network.UserHandler.LoginHandler;
import ritmov2.network.encodinghandler.CSGOV2_Client_Agent_Encrypted_Decoder_Client;
import ritmov2.network.encodinghandler.CSGOV2_Client_Agent_Encrypted_Encoder_Client;
import ritmov2.service.NettyService;

public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {

    private Messenger messenger;

    public NettyServerInitializer(Messenger messenger) {
        this.messenger = messenger;
    }
    private int WRITER_IDLE_TIMEOUT = 10000;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline p = ch.pipeline().addLast("decoder", new CSGOV2_Client_Agent_Encrypted_Decoder_Client())
            .addLast("encoder", new CSGOV2_Client_Agent_Encrypted_Encoder_Client())
            .addLast("idleStateHandler", new IdleStateHandler(0, WRITER_IDLE_TIMEOUT, 0))
            .addLast("HeatBeat", new ServerHeartBeatHandler())
            .addLast("Login", new LoginHandler(messenger))
            .addLast("Handler", new NettyServerHandler());
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
