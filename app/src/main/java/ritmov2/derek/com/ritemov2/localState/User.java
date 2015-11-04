package ritmov2.derek.com.ritemov2.localState;

/**
 * Created by Derek on 2015/11/3.
 */
public class User {
    private static String mEmail = "";
    private static String pwd = "";
    private static LoginState loginState = LoginState.LOGOUT;

    public enum LoginState {
        LOGON, LOGOUT
    }

    private static User user = null;

    private User() {
    }

    public static User getInstance() {

        if (user == null) {
            user = new User();
        }
        return user;
    }

    public void LoginSucc() {
        User.loginState = LoginState.LOGON;
    }

    public LoginState getLoginState() {
        return loginState;
    }

}
