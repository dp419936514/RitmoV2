package ritmov2;

import android.content.Intent;

import ritmov2.service.NettyService;

/**
 * Created by Derek.P.Dai on 2016/1/8.
 */
public class RitmoApplication extends android.app.Application{
    private Intent serviceCmd;
    @Override
    public void onCreate() {
        serviceCmd = new Intent(this,NettyService.class);
        startService(serviceCmd);
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        stopService(serviceCmd);
        super.onTerminate();
    }
}
