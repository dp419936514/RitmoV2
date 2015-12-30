package ritemov2.commonModule.netty;

import java.net.InetSocketAddress;
public abstract class AbstractNettyServer implements Runnable {
    protected int port;
    protected InetSocketAddress socketAddress;
    public AbstractNettyServer(int port) {
        this.port = port;
    }

}
