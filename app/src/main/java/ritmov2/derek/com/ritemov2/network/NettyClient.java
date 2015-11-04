package ritmov2.derek.com.ritemov2.network;

import android.util.Log;

import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.TimeoutException;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import ritmov2.derek.com.ritemov2.message.ServiceMessage;

/**
 * Created by Derek.P.Dai on 2015/11/3.
 */
public class NettyClient implements Runnable {

    private static final String TAG = "NettyClient";

    private Channel ch;

    private SocketAddress serverAddress = new InetSocketAddress("192.168.1.201", 9001);

    @Override
    public void run() {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast("frameDecoder", new ProtobufVarint32FrameDecoder())
                                .addLast("protobufDecoder", new ProtobufDecoder(ServiceMessage.Message.getDefaultInstance()))
                                .addLast("frameEncoder", new ProtobufVarint32LengthFieldPrepender())
                                .addLast("protobufEncoder", new ProtobufEncoder())
                                .addLast("handler", new LoginHandler());
                    }
                });

        try {
            ChannelFuture channelFuture = bootstrap.connect(serverAddress).sync();
            if (channelFuture.isSuccess()) {
                this.ch = channelFuture.channel();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ChannelFuture sendMessage(ServiceMessage.Message message) {
        if (message == null) {
            System.err.println("Message to send is null");
            return null;
        }
        if (this.ch == null){
            Log.e(TAG,"Channel is null");
            return null;
        }
       return this.ch.writeAndFlush(message);
    }
}
