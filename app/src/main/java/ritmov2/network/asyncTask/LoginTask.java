package ritmov2.network.asyncTask;
import java.util.concurrent.Callable;

import ritmov2.localstate.User;


/**
 * Created by Derek.P.Dai on 2015/11/4.
 */
public class LoginTask implements Callable<Boolean> {


    @Override
    public Boolean call() throws Exception {

      /*  User user = User.getInstance();
        while(User.LoginState.LOGOUT == user.getLoginState()){
            Thread.sleep(500);
        }*/
        return true;
    }
}
