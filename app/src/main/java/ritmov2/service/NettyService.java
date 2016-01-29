package ritmov2.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ritmov2.commonModule.command.Commands;
import ritmov2.commonModule.msg.CSGOV2Message;
import ritmov2.config.MessageDirection;
import ritmov2.network.NettyClient;

public class NettyService extends Service {

    private static final String TAG = "NettyService";

    public HashMap<Integer,Messenger> messengerMap = new HashMap();

    private final Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            MessageDirection messageDirection = MessageDirection.valueOf(msg.arg1);
            if (messageDirection == null){
                return;
            }
            if (msg.arg1 == MessageDirection.ACTIVITY_TO_SERVICE.getIntValue()) {
                Commands cmd = Commands.valueToCommand(msg.what);
                if (cmd != null) {
                    Log.d(TAG, "Send CSGOV2Message via Netty Client : " + msg.obj);
                    client.sendMessage(((CSGOV2Message) msg.obj));
                    //the CmdType would be the key to get Messenger
                    messengerMap.put(cmd.getCmdType().getValue(), msg.replyTo);
                }
                super.handleMessage(msg);
            }
            else if (msg.arg1 == MessageDirection.CLIENT_TO_SERVICE.getIntValue()){
                Commands cmd = Commands.valueToCommand(msg.what);
                if (cmd != null) {
                    Log.d(TAG, "get CSGOV2Message from Netty Client : " + msg.obj);
                    try {
                        msg = obtainMessage(msg.what,msg.obj);
                        msg.arg1 = MessageDirection.SERVICE_TO_ACTIVITY.getIntValue();
                        messengerMap.get(cmd.getCmdType().getValue()).send(msg);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    };

    //Messenger
    private Messenger mMessenger = new Messenger(mHandler);

    private NettyClient client = new NettyClient(mMessenger);

    @Override
    public void onCreate() {
        Log.d(TAG,"Netty Service started !!");
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(client);
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "MessengerService.onBind()...");
        return mMessenger.getBinder();
    }

}
