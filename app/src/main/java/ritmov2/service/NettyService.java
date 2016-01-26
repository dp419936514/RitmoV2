package ritmov2.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

import ritmov2.network.NettyClient;

public class NettyService extends Service {
    private NettyClient client;
    private final String TAG = "NettyService";


    @Override
    public void onCreate() {
        client = new NettyClient();
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "MessengerService.onBind()...");
        return mMessenger.getBinder();
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                default:

                    break;
            }
        }
    };
    //It's the messenger of server
    private Messenger mMessenger = new Messenger(mHandler);



}
