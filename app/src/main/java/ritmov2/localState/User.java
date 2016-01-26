package ritmov2.localState;
/**
 * Created by Derek on 2015/11/3.
 */
public class User {
    private static String mEmail = "";

    public static String getPwd() {
        return pwd;
    }

    public static void setPwd(String pwd) {
        User.pwd = pwd;
    }

    private static String pwd = "";

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        User.name = name;
    }

    private static String name = "";
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
