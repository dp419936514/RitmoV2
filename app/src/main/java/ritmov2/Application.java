package ritmov2;

import android.content.Intent;

import ritmov2.service.NettyService;

/**
 * Created by Derek.P.Dai on 2016/1/8.
 */
public class Application extends android.app.Application{

    @Override
    public void onCreate() {
        startService(new Intent(this,NettyService.class));
        super.onCreate();
    }

}
