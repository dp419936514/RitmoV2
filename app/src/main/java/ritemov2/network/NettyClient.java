package ritemov2.network;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import ritemov2.ConfigurationSource;
import ritemov2.commonModule.msg.CSGOV2Message;

/**
 * Created by Derek.P.Dai on 2015/11/3.
 */
public class NettyClient implements Runnable {

    private static final String TAG = "NettyClient";

    private Channel ch;

    private SocketAddress serverAddress = new InetSocketAddress(ConfigurationSource.SERVER_IP, ConfigurationSource.SERVER_PORT);

    @Override
    public void run() {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        NettyServerInitializer nettyServerInitializer = new NettyServerInitializer();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .handler(nettyServerInitializer);
        try {
            ChannelFuture channelFuture = bootstrap.connect(serverAddress).sync();
            if (channelFuture.isSuccess()) {
                this.ch = channelFuture.channel();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ChannelFuture sendMessage(CSGOV2Message message ) {
        if (message == null) {
            return null;
        }
        if (this.ch == null){
            return null;
        }
       return this.ch.writeAndFlush(message);
    }
}
