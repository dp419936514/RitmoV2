package ritmov2.config;

/**
 * Created by Derek.P.Dai on 2015/12/30.
 */
public class ConfigurationSource {
    // Server Address
    public static String SERVER_IP = "120.24.218.184";
    public static int SERVER_PORT = 9199;

    //Local Client
    private static boolean Message_Encryption = true;
    private static boolean Client_Agent_Heartbeat = true;

    public enum LocalCommands{
        INIT(1)
        ;

        private int value ;
        LocalCommands(int value){
            this.value = value;
        }
    }


}
