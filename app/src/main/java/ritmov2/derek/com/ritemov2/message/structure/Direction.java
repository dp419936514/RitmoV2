package ritmov2.derek.com.ritemov2.message.structure;

/**
 * Created by Derek.P.Dai on 2015/11/3.
 */
public enum Direction {
    NONE(0),
    SERVER_TO_CLIENT (1),
    CLIENT_TO_SERVER (2);

    private int dir ;
    private Direction(int dir){this.dir=dir;}

    public int getDir() {
        return dir;
    }
}
