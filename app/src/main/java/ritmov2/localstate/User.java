package ritmov2.localstate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ritmov2.commonModule.protobuf.BFBaseDefine;
import ritmov2.commonModule.protobuf.BFFriend;

public class User {

    String name;
    String pwd;

    double elo;
    int pepoint;
    int userLevel;

    private User() {
    }
    private static User mUser;
    public static User getInstance(){
        if (mUser == null){
            mUser = new User();
        }
        return mUser;
    }

    public List<BFBaseDefine.MapInfo> getMapInfoList() {
        return MapInfoList;
    }

    public void setMapInfoList(List<BFBaseDefine.MapInfo> mapInfoList) {
        MapInfoList = mapInfoList;
    }

    List<BFBaseDefine.MapInfo> MapInfoList;

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        mUser.roomID = roomID;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        mUser.roomNumber = roomNumber;
    }

    String roomID;
    int roomNumber;

    public String getHeadIMG() {
        return headIMG;
    }

    public void setHeadIMG(String headIMG) {
        mUser.headIMG = headIMG;
    }

    String headIMG;

    int steamId;
    BFBaseDefine.GameState userState;
    BFBaseDefine.UserInRoomState inRoomState;

    BFBaseDefine.MatchRoomState mRoomState;
    boolean isLoginOn = false;
    private ArrayList<Friend> friendList = new ArrayList<>();

    public boolean isLoginOn() {
        return this.isLoginOn;
    }

    public void setLoginOn(boolean isLoginOn) {
        mUser.isLoginOn = isLoginOn;
    }


    public ArrayList<Friend> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<Friend> frindList) {
        mUser.friendList = frindList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        mUser.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        mUser.pwd = pwd;
    }

    public double getElo() {
        return elo;
    }

    public void setElo(double elo) {
        mUser.elo = elo;
    }

    public int getPepoint() {
        return pepoint;
    }

    public void setPepoint(int pepoint) {
        mUser.pepoint = pepoint;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        mUser.userLevel = userLevel;
    }

    public int getSteamId() {
        return steamId;
    }

    public void setSteamId(int steamId) {
        mUser.steamId = steamId;
    }

    public BFBaseDefine.GameState getUserState() {
        return userState;
    }

    public void setUserState(BFBaseDefine.GameState userState) {
        mUser.userState = userState;
    }

    public BFBaseDefine.UserInRoomState getInRoomState() {
        return inRoomState;
    }

    public void setInRoomState(BFBaseDefine.UserInRoomState inRoomState) {
        mUser.inRoomState = inRoomState;
    }


    public BFBaseDefine.MatchRoomState getmRoomState() {
        return mRoomState;
    }

    public void setmRoomState(BFBaseDefine.MatchRoomState mRoomState) {
        mUser.mRoomState = mRoomState;
    }

    @Override
    public String toString() {
        return " User state          \n\n"
                + " name      : \t" + mUser.name + "\n"
                + " steamId   : \t" + mUser.steamId + "\n"
                + " elo       : \t" + mUser.elo + "\n"
                + " pepoint   : \t" + mUser.pepoint + "\n"
                + " roomID    : \t" + mUser.roomID + "\n"
                + " userLevel : \t" + mUser.userLevel + "\n";
    }

    public boolean addFriend(BFFriend.FriendInfo friendInfo) {
        Friend newFriend = new Friend(friendInfo);

        if (friendList.contains(newFriend)) {
            return false;
        } else {
            mUser.friendList.add(newFriend);
            return true;
        }
    }

    public void updateFriendList(List<BFFriend.FriendInfo> friendInfoArr) {
        friendList.clear();
        int updateNum = 0;
        for (Iterator iterator = friendInfoArr.iterator(); iterator.hasNext(); ) {
            BFFriend.FriendInfo friendInfo = (BFFriend.FriendInfo) iterator.next();
            if (addFriend(friendInfo)) {
                updateNum++;
            }
        }
        System.out.println("更新好友列表成功 ！  成功更新了" + updateNum + "条信息");
    }

    public void showFriendList() {
        for (Friend friend : friendList) {
            System.out.println(friend);
        }
    }

    public class Friend {
        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        String nickName;
        BFFriend.FriendType friendType;
        int steamID;
        BFBaseDefine.GameState gameState;
        int userLevel;
        double elo;

        public Friend(BFFriend.FriendType friendType, int steamID, BFBaseDefine.GameState gameState, int userLevel, double elo) {
            super();
            this.friendType = friendType;
            this.steamID = steamID;
            this.gameState = gameState;
            this.userLevel = userLevel;
            this.elo = elo;
        }

        public Friend(BFFriend.FriendInfo friendInfo) {
            this.nickName = friendInfo.getUserinfo().getNickName();
            this.friendType = friendInfo.getType();
            BFFriend.PlayerStruct playerStruct = friendInfo.getUserinfo();
            this.steamID = playerStruct.getSteamid();
            this.gameState = BFBaseDefine.GameState.valueOf(playerStruct.getUserstatus());
            this.userLevel = playerStruct.getUserlevel();
            this.elo = playerStruct.getElo();
        }

        public BFFriend.FriendType getFriendType() {
            return friendType;
        }

        public void setFriendType(BFFriend.FriendType friendType) {
            this.friendType = friendType;
        }

        public int getSteamID() {
            return steamID;
        }

        public void setSteamID(int steamID) {
            this.steamID = steamID;
        }

        public BFBaseDefine.GameState getGameState() {
            return gameState;
        }

        public void setGameState(BFBaseDefine.GameState gameState) {
            this.gameState = gameState;
        }

        public int getUserLevel() {
            return userLevel;
        }

        public void setUserLevel(int userLevel) {
            this.userLevel = userLevel;
        }

        public double getElo() {
            return elo;
        }

        public void setElo(double elo) {
            this.elo = elo;
        }

        @Override
        public String toString() {
            return "Friend [friendType=" + friendType + ", steamID=" + steamID + ", gameState=" + gameState
                    + ", userLevel=" + userLevel + ", elo=" + elo + "]";
        }
    }

}
