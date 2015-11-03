package ritmov2.derek.com.ritemov2.message.structure;

/**
 * Created by Derek.P.Dai on 2015/11/3.
 */
public enum ServerType {
    NONE(0),
    LoginServer(1);

    private int serverType;
    private ServerType(int serverType){this.serverType = serverType;}

    public int getServerType() {
        return serverType;
    }
}
