package ritmov2.derek.com.ritemov2.message.structure;

/**
 * Created by Derek.P.Dai on 2015/11/3.
 */
public enum MessageType {
    //reserve type for no match
    NO_MATCH(ServerType.NONE, Colunm.NONE, Direction.NONE),

    LOGIN_REQUEST(ServerType.LoginServer, Colunm.COLUNM_1, Direction.CLIENT_TO_SERVER),
    LOGIN_RESPONSE(ServerType.LoginServer, Colunm.COLUNM_2, Direction.SERVER_TO_CLIENT);

    private ServerType serverType;
    private Colunm colunm;
    private Direction dir;


    private MessageType(ServerType serverType, Colunm colunm, Direction dir) {
        this.serverType = serverType;
        this.colunm = colunm;
        this.dir = dir;
    }

    public int getIntValue() {
        int value = 0;

        //value is divided into four section.
        value = value & (this.serverType.getServerType() << 24);
        value = value & (this.colunm.getColunm() << 8);
        value = value & this.dir.getDir();

        return value;
    }

    public class MessageTypeMismatchException extends Exception {
        public MessageTypeMismatchException(String detailMessage) {
            super(detailMessage);
        }
    }

    public static MessageType parseFromInt(int src) throws MessageTypeMismatchException {

        for (MessageType type : MessageType.values()) {
            if (type.getIntValue() == src) {
                return type;
            }
        }

        return NO_MATCH;

    }
}


