package ritmov2.config;

/**
 * Created by Derek.P.Dai on 2016/1/29.
 */
public enum MessageDirection {
    ACTIVITY_TO_SERVICE(0), SERVICE_TO_CLIENT(1), CLIENT_TO_SERVICE(2),SERVICE_TO_ACTIVITY(3)
    ;
    private int value;

    MessageDirection(int value) {
        this.value = value;
    }

    public int getIntValue(){
        return this.value;
    }

    public static MessageDirection valueOf(int value) {
        MessageDirection[] values = MessageDirection.values();
        for (MessageDirection messageDirection : values) {
            if (messageDirection.getIntValue() == value) {
                return messageDirection;
            }
        }
        return null;
    }
}
