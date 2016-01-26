package ritmov2.message.pojos;

import java.io.Serializable;

/**
 * Created by Derek.P.Dai on 2015/11/2.
 */
public class LoginRequest implements Serializable{

    public enum LoginType{
        REGISTER,SIGNUP
    }

    private final String Email;
    private final String pwd ;
    private final String reserveString  = "LoginDemo";
    private final int appVersion;
    private final LoginType loginType;

    public LoginRequest(String email, String pwd, int appVersion,LoginType loginType) {
        Email = email;
        this.pwd = pwd;
        this.appVersion = appVersion;
        this.loginType =loginType;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "Email='" + Email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", reserveString='" + reserveString + '\'' +
                ", appVersion=" + appVersion +
                ", loginType=" + loginType +
                '}';
    }
}
