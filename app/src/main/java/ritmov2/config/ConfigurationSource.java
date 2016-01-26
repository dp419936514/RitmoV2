package ritmov2.config;

/**
 * Created by Derek.P.Dai on 2015/12/30.
 */
public class ConfigurationSource {
    public static String SERVER_IP = "192.168.1.201";
    public static int SERVER_PORT = 9199;


    public enum LocalCommands{
        INIT(1)
        ;

        private int value ;
        private LocalCommands(int value){
            this.value = value;
        }
    }


}
