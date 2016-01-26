package ritmov2.network.encodinghandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import ritmov2.commonModule.command.Commands;
import ritmov2.commonModule.msg.CSGOV2Message;
import ritmov2.commonModule.util.AesEncTool;

import java.nio.ByteOrder;


public class CSGOV2_Client_Agent_Encrypted_Decoder_Client extends LengthFieldBasedFrameDecoder{

	public static byte[] public_key ;
	
	 public static final AttributeKey<byte[]> KEY = AttributeKey.valueOf("KEY");

	    public CSGOV2_Client_Agent_Encrypted_Decoder_Client(ByteOrder byteOrder, int maxFrameLength, int lengthFieldOffset,
	                                                 int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip, boolean failFast) {
	        super(byteOrder, maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip,
	                failFast);
	    }

	    public CSGOV2_Client_Agent_Encrypted_Decoder_Client() {
	        this(ByteOrder.BIG_ENDIAN, 100000000, 0, 4, 0, 4, true);
	        // this(ByteOrder.LITTLE_ENDIAN, 100000000, 0, 4, 0, 4, true);
	    }

	    @Override
	    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {

	        System.err.println("receive something");
	        ByteBuf frame = (ByteBuf) super.decode(ctx, in);
	        if (frame == null) {
	            return null;
	        }
	        int cmd = frame.readInt();
	        if(cmd== Commands.COMMON_GET_KEY.getCmdValue()){
	        	Attribute<byte[]> attribute = ctx.channel().attr(KEY);
	        	byte[] key = new byte[16];
	        	frame.readBytes(key);
		        attribute.set(key);
		        public_key = key;
		        return null;
	        }else if (public_key != null) {
	            byte[] cipherText = new byte[frame.readableBytes()];
	            frame.readBytes(cipherText);
	            byte[] msgBody = AesEncTool.aesDecrypt(cipherText, public_key);
	//
//	            //显示msg
//	            StringBuffer sBuffer = new StringBuffer("");
//	            for (int i = 0; i < message.length; i++) {
//	                sBuffer.append(message[i]);
//	            }
//	            System.out.println(sBuffer.toString());
	//
//	            int cmd = message[0] << 24 | message[1] << 16 | message[2] | message[3];

//	            byte[] data = new byte[message.length - 4];
//	            for (int i = 0; i < data.length; i++) {
//	                data[i] = message[i + 4];
//	            }

	            CSGOV2Message msgVO = new CSGOV2Message(cmd, msgBody);
	            return msgVO;
	        } else {
	            return null;
	        }
	    }

	    @Override
	    public void channelActive(ChannelHandlerContext ctx) throws Exception {
	        // 生成了随机的16位密钥,连接断开之前不会改变
/*	        Random random = new Random();
	        byte[] key = new byte[16];
	        random.nextBytes(key);
	        Attribute<byte[]> attribute = ctx.channel().attr(KEY);
	        attribute.set(key);
	        System.out.println("Decoder : create new key when channel active");
	        StringBuffer sBuffer = new StringBuffer("");
	        for (int i = 0; i < key.length; i++) {
	            sBuffer.append(key[i]);
	        }
	        System.out.println(sBuffer.toString());*/
	        super.channelActive(ctx);
	    }

}
