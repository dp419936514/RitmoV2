package ritmov2.commonModule.command;

/**
 * Created by Henry.Wu on 2015/8/26.
 */
// mCmdType=type;//4bit,0~15
public enum CmdType {
    Common(0), Login(1), Friend(2), Match(3), Fun(4), Chat(5), Game(6), AgentMaster(7), BroadCast(8);

    private int type;

    private CmdType(int _type) {
        this.type = _type;
    }

    public static Commands valueToCommand(int value) {
        Commands[] commands = Commands.values();
        for (Commands cmd : commands) {
            if (cmd.getCmdValue() == value) {
                return cmd;
            }
        }
        return null;
    }

    public int getValue() {
        return type;
    }
}
