package ritmov2.derek.com.ritemov2.message.structure;

/**
 * Created by Derek.P.Dai on 2015/11/3.
 */
public enum Direction {
    SERVER_TO_CLIENT (0),
    CLIENT_TO_SERVER (1);

    private int dir ;
    private Direction(int dir){this.dir=dir;}

    public int getDir() {
        return dir;
    }
}
