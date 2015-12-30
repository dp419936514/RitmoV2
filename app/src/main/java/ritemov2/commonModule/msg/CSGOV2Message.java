package ritemov2.commonModule.msg;

import ritemov2.commonModule.command.Commands;
import ritemov2.commonModule.util.Constant;
import ritemov2.commonModule.util.UUIDConvert;

import java.util.UUID;

public class CSGOV2Message {

    private byte[] chId;
    private int cmdId;
    private byte[] probuf;

    public CSGOV2Message() {
        chId = UUIDConvert.uuidToByteArray(UUID.randomUUID());
        cmdId = 0;
        probuf = new byte[0];
    }

    public CSGOV2Message(int commandId, byte[] _probuf) {
        this.chId = UUIDConvert.uuidToByteArray(UUID.randomUUID());
        this.cmdId = commandId;
        this.probuf = _probuf.clone();
    }

    public CSGOV2Message(UUID uuid, int commandId, byte[] _probuf) {
        this.chId = UUIDConvert.uuidToByteArray(uuid);
        this.cmdId = commandId;
        this.probuf = _probuf.clone();
    }

    public CSGOV2Message(byte[] _chId, int commandId, byte[] _probuf) {
        this.chId = _chId.clone();
        this.cmdId = commandId;
        this.probuf = _probuf.clone();
    }

    //------------------------------------------------
    public void setChId(byte[] chId) {
        this.chId = chId.clone();
    }

    public void setChIdInt(int steamId) {
        this.chId = getChId16Bytes(steamId);
    }

    public UUID getChIdUUID() {
        return UUIDConvert.byteArrayToUUID(chId);
    }

    public byte[] getChId() {
        return chId;
    }

    public void setChId(UUID chId) {
        this.chId = UUIDConvert.uuidToByteArray(chId).clone();
    }

    public int getSteamIdFromChId() {
        int steamId = (chId[0] << 24) | (chId[1] << 16) | (chId[2] << 8) | (chId[3] << 0);
        return steamId;
    }
//------------------------------------------------

    public int getCmdId() {
        return this.cmdId;
    }

    public void setCmdId(int cmdId) {
        this.cmdId = cmdId;
    }

    public byte[] getProbuf() {
        return this.probuf;
    }

    public void setProbuf(byte[] probuf) {
        this.probuf = probuf.clone();
    }

    private byte[] getChId16Bytes(int steamId) {
        byte[] id = new byte[Constant.ChannelIdLengthInMsg];
        byte[] intBytes = new byte[4];
        intBytes[0] = (byte) (steamId >> 24);
        intBytes[1] = (byte) (steamId >> 16);
        intBytes[2] = (byte) (steamId >> 8);
        intBytes[3] = (byte) (steamId >> 0);

        //check the length
        for (int i = 0; i < Constant.ChannelIdLengthInMsg && i < intBytes.length; i++) {
            id[i] = intBytes[i];
        }
        return id;
    }


    public String toString() {
        Commands cmd = Commands.valueToCommand(cmdId);
        return "\n" +
                "ChannelId: " + this.getChIdUUID() + "\n"
                + "CommandId: " + cmd.getCmdName() + "\n"
                + "content: " + this.probuf + "";
    }
}
