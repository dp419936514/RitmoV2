package ritmov2.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;


import ritmov2.commonModule.command.Commands;
import ritmov2.commonModule.msg.CSGOV2Message;
import ritmov2.network.NettyClient;

public class NettyService extends Service {
    private static NettyClient client = new NettyClient();
    private final String TAG = "NettyService";


    @Override
    public void onCreate() {

        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "MessengerService.onBind()...");
        return mMessenger.getBinder();
    }

    private static final Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Commands cmd = Commands.valueToCommand(msg.what);
            switch (cmd) {
                case LOGIN_REQ:
                    client.sendMessage(((CSGOV2Message)msg.obj));
                    break;
                default:

                    break;
            }
        }
    };
    //It's the messenger of server
    private Messenger mMessenger = new Messenger(mHandler);



}
