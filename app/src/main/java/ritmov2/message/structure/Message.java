package ritmov2.message.structure;

/**
 * Created by Derek.P.Dai on 2015/11/3.
 */
public class Message {
    private int messageType;
    private String content;

    public Message(int messageType, String content) {
        this.messageType = messageType;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public int getMessageTypeInt() {
        return messageType;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType.getIntValue();
    }


}
