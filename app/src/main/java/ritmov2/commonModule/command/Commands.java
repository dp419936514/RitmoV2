package ritmov2.commonModule.command;

public enum Commands {

    //------- Common Server ------------------------
    COMMON_RSP(CmdType.Common, CmdAction.Common, 0, CmdDir.S2C),
    PING(CmdType.Common, CmdAction.Common, 1, CmdDir.C2S),
    PONG(CmdType.Common, CmdAction.Common, 1, CmdDir.S2C),
    COMMON_GET_KEY(CmdType.Common, CmdAction.Common, 2, CmdDir.S2C),

    //------- AgentMaster Server ------------------------
    AGENT_ASK_FOR_WORK_ADDRESS_REQ(CmdType.AgentMaster, CmdAction.Common, 0, CmdDir.C2S),
    AGENT_ASK_FOR_WORK_ADDRESS_RSP(CmdType.AgentMaster, CmdAction.Common, 0, CmdDir.S2C),

    //------- Login Server ------------------------
    LOGIN_REQ(CmdType.Login, CmdAction.Login, 0, CmdDir.C2S),
    LOGIN_RSP(CmdType.Login, CmdAction.Login, 0, CmdDir.S2C),

    LOGIN_CURRENT_STATE_NOTIFY(CmdType.Login, CmdAction.Login, 1, CmdDir.S2C),

    LOGIN_UPDATE_USER_INFO_REQ(CmdType.Login, CmdAction.Login, 2, CmdDir.C2S),
    LOGIN_UPDATE_USER_INFO_RSP(CmdType.Login, CmdAction.Login, 2, CmdDir.S2C),
    //用户上线后,缓存的消息通知(w-h-c)
    LOGIN_BUFFERED_MSG_NOTIFY(CmdType.Login, CmdAction.Login, 3, CmdDir.S2C),

    LOGIN_REPEAT_NOTIFY(CmdType.Login, CmdAction.Login, 4, CmdDir.S2C),

    //上传登录者的用户信息,qq,机器名等
    LOGIN_USERINFO_UPLOAD_REQ(CmdType.Login, CmdAction.Login, 5, CmdDir.C2S),
    LOGIN_USERINFO_UPLOAD_RSP(CmdType.Login, CmdAction.Login, 5, CmdDir.S2C),

    // Client 重新连接请求
    LOGIN_CLIENT_RECONNECT_REQ(CmdType.Login, CmdAction.Login, 6, CmdDir.C2S),
    //Client 重新连接请求,回复
    LOGIN_CLIENT_RECONNECT_RSP(CmdType.Login, CmdAction.Login, 6, CmdDir.S2C),

    // Client 断开,请求
    LOGIN_CLIENT_DISCONNECT_REQ(CmdType.Login, CmdAction.Exit, 4, CmdDir.C2S),
    //Client 断开,回复
    LOGIN_CLIENT_DISCONNECT_RSP(CmdType.Login, CmdAction.Exit, 4, CmdDir.S2C),

    // EXIT Client
    LOGIN_CLIENT_EXIT_REQ(CmdType.Login, CmdAction.Exit, 5, CmdDir.C2S),
    // EXIT Client,回复
    LOGIN_CLIENT_EXIT_RSP(CmdType.Login, CmdAction.Exit, 5, CmdDir.S2C),
    //-------- Friend Server ------------------------
    // 获取用户基本信息/回复
    USER_GET_USER_BASIC_INFO_REQ(CmdType.Friend, CmdAction.FriendStatus, 0, CmdDir.C2S),
    USER_GET_USER_BASIC_INFO_RSP(CmdType.Friend, CmdAction.FriendStatus, 0, CmdDir.S2C),

    // 用户状态更新请求
    USER_UPDATE_USER_STATUS_REQ(CmdType.Friend, CmdAction.FriendStatus, 1, CmdDir.C2S),

    // 好友状态更新通知,server-->通知用户
    USER_FRIEND_STATUS_UPDATE_NOTIFY(CmdType.Friend, CmdAction.FriendStatus, 1, CmdDir.S2C),

    //获取好友列表请求///获取好友列表回复
    USER_GET_FRIEND_LIST_REQ(CmdType.Friend, CmdAction.FriendStatus, 2, CmdDir.C2S),
    USER_GET_FRIEND_LIST_RSP(CmdType.Friend, CmdAction.FriendStatus, 2, CmdDir.S2C),

    //搜索好友
    USER_SEARCH_FRIEND_REQ(CmdType.Friend, CmdAction.FriendStatus, 3, CmdDir.C2S),
    USER_SEARCH_FRIEND_RSP(CmdType.Friend, CmdAction.FriendStatus, 3, CmdDir.S2C),

    //请求添加好友///请求添加好友回复
    USER_ASKFOR_ADD_FRIEND_REQ(CmdType.Friend, CmdAction.FriendModify, 0, CmdDir.C2S),
    USER_ASKFOR_ADD_FREIND_RSP(CmdType.Friend, CmdAction.FriendModify, 0, CmdDir.S2C),
    //告知用户被添加为好友
    USER_BEQUIRED_FRIEND_NOTIFY(CmdType.Friend, CmdAction.FriendModify, 1, CmdDir.S2C),
    // client B resp server,用户回复服务器通知,是否同意
    USER_BEQUIRED_FRIEND_NOTIFY_RSP(CmdType.Friend, CmdAction.FriendModify, 1, CmdDir.C2S),
    //server 再notify Client A,结果(改为Server 通知用户A/B添加结果)
    USER_FRIEND_ADD_RESULT_NOTIFY(CmdType.Friend, CmdAction.FriendModify, 2, CmdDir.S2C),

    //删除好友,或黑名单请求/回复
    USER_FRIEND_ACTION_REQ(CmdType.Friend, CmdAction.FriendModify, 3, CmdDir.C2S),
    USER_FRIEND_ACTION_RSP(CmdType.Friend, CmdAction.FriendModify, 3, CmdDir.S2C),
    
    //上传作弊信息
    USER_UPDATE_CHEAT_DATA_REQ(CmdType.Friend, CmdAction.FriendModify, 4, CmdDir.C2S),

    //----------------------- Match Server -----------------------
    MATCH_CREATE_ROOM_REQ(CmdType.Match, CmdAction.Room, 0, CmdDir.C2S),
    MATCH_CREATE_ROOM_RSP(CmdType.Match, CmdAction.Room, 0, CmdDir.S2C),
    MATCH_EXIT_ROOM_REQ(CmdType.Match, CmdAction.Room, 1, CmdDir.C2S),
    MATCH_EXIT_ROOM_RSP(CmdType.Match, CmdAction.Room, 1, CmdDir.S2C),
    //房间状态更新,通知
    MATCH_ROOM_UPDATE_STATE_NOTIFY(CmdType.Match, CmdAction.Room, 2, CmdDir.S2C),

    //被要求更新房间状态(4.11)
    MATCH_ROOM_UPDATE_STATE_REQ(CmdType.Match, CmdAction.Room, 3, CmdDir.C2S),
    MATCH_ROOM_UPDATE_STATE_RSP(CmdType.Match, CmdAction.Room, 3, CmdDir.S2C),

    // 选择地图上传
    MATCH_SUBMIT_MAP_REQ(CmdType.Match, CmdAction.Map, 0, CmdDir.C2S),
    MATCH_SUBMIT_MAP_RSP(CmdType.Match, CmdAction.Map, 0, CmdDir.S2C),


    // 邀请好友比赛 (tcp) c_l_h
    MATCH_INVITE_FRIEND_REQ(CmdType.Match, CmdAction.InviteFriendGame, 0, CmdDir.C2S),
    // 邀请好友比赛rsp
    MATCH_INVITE_FRIEND_RSP(CmdType.Match, CmdAction.InviteFriendGame, 0, CmdDir.S2C),
    // 被好友邀请比赛通知 h->c,server ->client B
    MATCH_INVITED_FROM_FRIEND_NOTIFY(CmdType.Match, CmdAction.InviteFriendGame, 1, CmdDir.S2C),
    // 回复好友比赛邀请c->h, client B->server
    MATCH_INVITED_FROM_FRIEND_NOTIFY_RSP(CmdType.Match, CmdAction.InviteFriendGame, 1, CmdDir.C2S),
    // 回复好友比赛邀请c->h, client B->server;server --> client A(告知B的结果)
    MATCH_INVITED_FINAL_RESULT_NOTIFY(CmdType.Match, CmdAction.InviteFriendGame, 2, CmdDir.S2C),
    // 回复好友比赛邀请h->c,server-> client B ;server告知clientB房间加入结果
    MATCH_INVITED_GAME_JOIN_RESULT_NOTIFY(CmdType.Match, CmdAction.InviteFriendGame, 3, CmdDir.S2C),


    // 匹配相关
    // 匹配请求
    MATCH_REQ(CmdType.Match, CmdAction.Match, 0, CmdDir.C2S),
    MATCH_RSP(CmdType.Match, CmdAction.Match, 0, CmdDir.S2C),
    // 匹配结果通知
    MATCH_RESULT_NOTIFY(CmdType.Match, CmdAction.Match, 1, CmdDir.S2C),
    // 取消匹配
    MATCH_CANCEL_REQ(CmdType.Match, CmdAction.Match, 2, CmdDir.C2S),
    MATCH_CANCEL_RSP(CmdType.Match, CmdAction.Match, 2, CmdDir.S2C),
    // 点击准备,后告知server
    MATCH_PREPARE_CLICK_REQ(CmdType.Match, CmdAction.Match, 3, CmdDir.C2S),

    //NOTE:cmdType
    // 准备完成:MatchServer-->GameServer
    MATCH_GAME_ENTER_READY_REQ(CmdType.Game, CmdAction.Game, 1, CmdDir.C2S),
    MATCH_GAME_ENTER_READY_RSP(CmdType.Match, CmdAction.Game, 1, CmdDir.S2C),
    //通知客户端启动cs go游戏命令，match server通知客户端
    MATCH_GAME_START_CS2GO_NOTIFY(CmdType.Match, CmdAction.Game, 2, CmdDir.S2C),
    //游戏服务器空闲通知:GameServer->MatchServer
    MATCH_GAME_SERVER_IDLE_NOTIFY(CmdType.Match, CmdAction.Game, 3, CmdDir.C2S),

    //匹配服务器发送的消息类型通知
    MATCH_MSG_NOTIFY(CmdType.Match, CmdAction.Chat, 0, CmdDir.S2C),

    //-----Fun server ---------------------------------------------
    //比赛列表
    FUN_GET_GAME_LIST_REQ(CmdType.Fun, CmdAction.Game, 0, CmdDir.C2S),
    FUN_GET_GAME_LIST_RSP(CmdType.Fun, CmdAction.Game, 0, CmdDir.S2C),

    //获取比赛详情
    FUN_GET_GAME_DETAIL_REQ(CmdType.Fun, CmdAction.Game, 1, CmdDir.C2S),
    FUN_GET_GAME_DETAIL_RSP(CmdType.Fun, CmdAction.Game, 1, CmdDir.S2C),

    //获取游戏平台服务列表
    FUN_GET_GAME_SERVER_LIST_REQ(CmdType.Fun, CmdAction.Game, 2, CmdDir.C2S),
    FUN_GET_GAME_SERVER_LIST_RSP(CmdType.Fun, CmdAction.Game, 2, CmdDir.S2C),

    //获取游戏平台模式列表,,,服务器模式分为大模式和小模式
    //    要根据大模式来筛选小模式，死亡是大模式   死亡爆头属于死亡模式
    FUN_GET_GAME_SERVER_MODE_LIST_REQ(CmdType.Fun, CmdAction.Game, 3, CmdDir.C2S),
    FUN_GET_GAME_SERVER_MODE_LIST_RSP(CmdType.Fun, CmdAction.Game, 3, CmdDir.S2C),

    //---------------------- 聊天 msg Server --------------------
    CHAT_SEND_ROOM_MESSAGE(CmdType.Chat, CmdAction.Chat, 0, CmdDir.C2S),

    CHAT_SEND_P2P_MESSAGE(CmdType.Chat, CmdAction.Chat, 1, CmdDir.C2S),

    CHAT_ROOM_MESSAGE_NOTIFY(CmdType.Chat, CmdAction.Chat, 2, CmdDir.S2C),

    CHAT_P2P_MESSAGE_NOTIFY(CmdType.Chat, CmdAction.Chat, 3, CmdDir.S2C),

    //-----Game server ---------------------------------------------
    //可以进入游戏通知
    GAME_ENTER_NOTIFY(CmdType.Game, CmdAction.Game, 0, CmdDir.S2C),
    // 游戏中断通知( result: 0:比赛正常结束 1：其他）
    GAME_INTERRUPT_MESSAGE_NOTIFY(CmdType.Game, CmdAction.Game, 1, CmdDir.S2C),
    // 扣除积分 -->COMMAND_ID_GAME_DEDUCT_SCORE_RSP
    GAME_DEDUCT_SCORE_REQ(CmdType.Game, CmdAction.Game, 2, CmdDir.C2S),
    GAME_DEDUCT_SCORE_RSP(CmdType.Game, CmdAction.Game, 2, CmdDir.S2C),
    // 比赛结束
    GAME_OVER_NOTIFY(CmdType.Game, CmdAction.Game, 3, CmdDir.S2C),
    // 创建比赛
    GAME_CREATE_MATCH(CmdType.Game, CmdAction.Game, 4, CmdDir.C2S),
    // 创建比赛回复
    GAME_CREATE_MATCH_RSP(CmdType.Game, CmdAction.Game, 4, CmdDir.S2C),

    //新增客户端通知gameserver重新登陆进入游戏命令
    GAME_ENTER_AGAIN_REQ(CmdType.Game, CmdAction.Game, 5, CmdDir.C2S),
    GAME_ENTER_AGAIN_RSP(CmdType.Game, CmdAction.Game, 5, CmdDir.S2C),

    // client A发起截图请求,c->server
    GAME_SCREEN_SHOT_REQ(CmdType.Game, CmdAction.ScreenShot, 0, CmdDir.C2S),
    GAME_SCREEN_SHOT_RSP(CmdType.Game, CmdAction.ScreenShot, 0, CmdDir.S2C),
    // server notify client B
    GAME_SCREEN_SHOT_REQUIED_NOTIFY(CmdType.Game, CmdAction.ScreenShot, 1, CmdDir.S2C),
    // client B resp server
    GAME_SCREEN_SHOT_REQUIED_NOTIFY_RSP(CmdType.Game, CmdAction.ScreenShot, 1, CmdDir.C2S),

    //广播指令
    BROADCAST_CLIENT_EXIT_REQ(CmdType.BroadCast, CmdAction.Common, 0, CmdDir.C2S);
//    // EXIT Client
//    GAME_CLIENT_EXIT_REQ(CmdType.Game,CmdAction.Exit,0, CmdDir.C2S),
//    // EXIT Client,回复
//    GAME_CLIENT_EXIT_RSP(CmdType.Game,CmdAction.Exit,0, CmdDir.S2C);
    //-------------------------------------------------

    private int mCmd;
    private CmdType mCmdType;
    private CmdAction mAction;
    private int mIndex;
    private CmdDir mCmdDir;

    private Commands(CmdType type, CmdAction action, int _index, CmdDir _dir) {
        mCmdType = type;//1 byte,
        mAction = action;//1 byte
        mIndex = _index;//15bit,(1byte+7bit)32768
        mCmdDir = _dir;//1bit,0~1

        //_index 支持256个
        this.mCmd = (type.getValue() << 24) | (action.getValue() << 16) | (_index << 1) | (_dir.getValue());
    }

    public static String getCmdName(int value) {
        Commands[] commands = Commands.values();
        for (Commands cmd : commands) {
            if (cmd.getCmdValue() == value)
                return cmd.getCmdName();
        }
        return "Unkonw defined command";
    }

    public static void dumpCommads() {
        Commands[] commands = Commands.values();
        for (Commands cmd : commands) {
            System.out.println(cmd.toString());
        }
    }

    public static boolean isValidCommand(int cmdValue) {
        Commands[] commands = Commands.values();
        for (Commands cmd : commands) {
            if (cmd.getCmdValue() == cmdValue)
                return true;
        }
        return false;
    }

    public static Commands valueToCommand(int value) {
        Commands[] commands = Commands.values();
        for (Commands cmd : commands) {
            if (cmd.getCmdValue() == value) {
                return cmd;
            }
        }
        return null;
    }

    public int getCmdValue() {
        return this.mCmd;
    }

    public CmdType getCmdType() {
        return this.mCmdType;
    }

    public CmdAction getCmdAction() {
        return this.mAction;
    }

    public String getCmdName() {
        return this.name();
    }

    @Override
    public String toString() {
        return "Command Name:" + this.name()
                + " Value:0x" + String.format("%x", this.mCmd)
                + " Value:" + String.format("%d", this.mCmd)
                + " Type:" + this.mCmdType.name()
                + " Action:" + this.mAction.name();
    }

}
