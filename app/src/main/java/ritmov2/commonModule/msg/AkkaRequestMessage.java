package ritmov2.commonModule.msg;


import io.netty.channel.ChannelHandlerContext;

import java.nio.charset.Charset;

public class AkkaRequestMessage {

    private static final Charset charset_utf8 = Charset.forName("UTF-8");
    long id;
    CSGOV2Message incomingRequest;
    ChannelHandlerContext channelContext;
    volatile boolean flushed = false;

    public AkkaRequestMessage(long id, ChannelHandlerContext context, CSGOV2Message csgov2Message) {
        this.id = id;
        this.channelContext = context;
        this.incomingRequest = csgov2Message;
    }

    public long getId() {
        return id;
    }

    public CSGOV2Message getMsgBody() {
        return incomingRequest;
    }

    public ChannelHandlerContext getChannelContext() {
        return channelContext;
    }

    public void flush() {
        channelContext.flush();
        flushed = true;
    }

    public boolean isFlushed() {
        return flushed;
    }

}
