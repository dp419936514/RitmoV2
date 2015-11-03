package ritmov2.derek.com.ritemov2.message.structure;

/**
 * Created by Derek.P.Dai on 2015/11/3.
 */
public enum Colunm {

    COLUNM_0(0),
    COLUNM_1(1),
    COLUNM_2(2);

    private int colunm;
    private Colunm(int colunm){this.colunm = colunm;}

    public int getColunm() {
        return colunm;
    }
}
