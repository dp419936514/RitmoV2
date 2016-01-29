package ritmov2.network.UserHandler;

import android.os.Message;
import android.os.Messenger;
import android.util.Log;

import io.netty.channel.ChannelHandlerContext;
import ritmov2.commonModule.msg.CSGOV2Message;
import ritmov2.config.MessageDirection;

public class LoginHandler extends BaseNettyHandler {

    private static final String TAG = "LoginHandler";

    public LoginHandler(Messenger messenger) {
        super(messenger);
    }

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, CSGOV2Message message) throws Exception {
        //TODO
        Log.d(TAG, "Login Handler receive something ");
        Message msg = new Message();
        msg.what = message.getCmdId();
        msg.obj = message;
        msg.arg1 = MessageDirection.CLIENT_TO_SERVICE.getIntValue();
        messenger.send(msg);
    }
}
