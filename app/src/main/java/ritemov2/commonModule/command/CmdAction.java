package ritemov2.commonModule.command;

/**
 * Created by Henry.Wu on 2015/8/26.
 */

//mAction=action;//6bit,0~63
public enum CmdAction {
    Common(1),
    Login(2),
    FriendModify(3),
    FriendStatus(4),
    Chat(5),

    Room(6),
    Map(7),
    InviteFriendGame(8),
    ScreenShot(9),
    Match(10),
    Game(11),
    Exit(12);


    private int action;

    private CmdAction(int _direction) {
        this.action = _direction;
    }

    public int getValue() {
        return action;
    }
}
