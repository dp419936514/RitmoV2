package ritmov2.derek.com.ritemov2.message.structure;

/**
 * Created by Derek.P.Dai on 2015/11/3.
 */
public enum MessageType {

    LOGIN_REQUEST(ServerType.LoginServer, Colunm.COLUNM_0, Direction.CLIENT_TO_SERVER),
    LOGIN_RESPONSE(ServerType.LoginServer, Colunm.COLUNM_1, Direction.SERVER_TO_CLIENT);

    private ServerType serverType;
    private Colunm colunm;
    private Direction dir;


    private MessageType(ServerType serverType, Colunm colunm, Direction dir) {
        this.serverType = serverType;
        this.colunm = colunm;
        this.dir = dir;
    }

    public int getIntValue(){
        int value = 0;

        //value is divided into four section.
        value = value & (this.serverType.getServerType() << 24);
        value = value & (this.colunm.getColunm() << 8);
        value = value & this.dir.getDir();

        return value;
    }

/*    public MessageType parseFromInt (int src){

        int servertypeInt = src & 0xFF000000;
        int colunmInt     = src & 0x00FFFF00;
        int dirInt        = src & 0x000000FF;

        MessageType messageType = new MessageType();

    }*/
}


