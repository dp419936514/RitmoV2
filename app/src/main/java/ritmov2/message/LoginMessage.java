package ritmov2.message;

import ritmov2.commonModule.command.Commands;
import ritmov2.commonModule.msg.CSGOV2Message;
import ritmov2.commonModule.protobuf.BFLogin;

import ritmov2.localState.User;

/**
 * Created by Derek.P.Dai on 2015/12/30.
 */
public class LoginMessage {
    /**
     * @From
     * @To
     * @Description
     * @parameters
     * @receive
     */
    public static CSGOV2Message Login_REQ(String name, String pwd) {
        User.getInstance().setName(name);
        User.getInstance().setPwd(pwd);
        BFLogin.LoginReq.Builder loginReqBuilder = BFLogin.LoginReq.newBuilder();
        loginReqBuilder.setAccount(User.getInstance().getName());
        loginReqBuilder.setPassword(User.getInstance().getPwd());
        BFLogin.LoginReq loginReq = loginReqBuilder.build();
        byte[] buf = loginReq.toByteArray();
        CSGOV2Message message = new CSGOV2Message();
        message.setProbuf(buf);
        message.setCmdId(Commands.LOGIN_REQ.getCmdValue());
        return message;
    }
}
