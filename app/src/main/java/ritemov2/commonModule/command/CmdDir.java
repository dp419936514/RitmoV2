package ritemov2.commonModule.command;

/**
 * Created by Henry.Wu on 2015/8/26.
 */

//mCmdDir=_dir;//1bit,0~1
public enum CmdDir {
    C2S(0),
    S2C(1);

    private int direction;

    private CmdDir(int _direction) {
        this.direction = _direction;
    }

    public int getValue() {
        return direction;
    }
}
