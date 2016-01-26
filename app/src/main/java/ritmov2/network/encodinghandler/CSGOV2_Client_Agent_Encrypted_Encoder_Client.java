package ritmov2.network.encodinghandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import ritmov2.commonModule.command.Commands;
import ritmov2.commonModule.msg.CSGOV2Message;
import ritmov2.commonModule.util.AesEncTool;

public class CSGOV2_Client_Agent_Encrypted_Encoder_Client extends
		MessageToByteEncoder<CSGOV2Message> {

	private byte[] key;

	@Override
	protected void encode(ChannelHandlerContext ctx, CSGOV2Message msg,
			ByteBuf out) throws Exception {
		
		if(CSGOV2_Client_Agent_Encrypted_Decoder_Client.public_key != null){
			key = CSGOV2_Client_Agent_Encrypted_Decoder_Client.public_key;
		}
		
		byte content[] = msg.getProbuf();
		// 先判断是不是请求密钥指令，是的话，明文传递
		if (msg.getCmdId() == Commands.COMMON_GET_KEY.getCmdValue()) {
			int dataLength1 = content.length;
			int packageLength1 = 4 + content.length;
			out.ensureWritable(packageLength1);
			out.writeInt(packageLength1);
			out.writeInt(msg.getCmdId());
			if (dataLength1 > 0) {
				out.writeBytes(content);
			}
			return;
		}

		if (key != null) {
			byte[] cipherText = AesEncTool.aesEncrypt(content, key);
			int dataLength = cipherText.length;
			int packageLength = 4 + cipherText.length;

			out.ensureWritable(packageLength);
			out.writeInt(packageLength);
			out.writeInt(msg.getCmdId());
			if (dataLength > 0) {
				out.writeBytes(cipherText);
			}
		}
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		/*while (key == null) {
			Attribute<byte[]> attribute = ctx.channel().attr(CSGOV2_Client_Agent_Encrypted_Decoder_Client.KEY);
			key = attribute.get();
			System.out.println("Encoder : get key when channel active");
			Thread.sleep(1000);
		}
		StringBuffer sBuffer = new StringBuffer("");
		for (int i = 0; i < key.length; i++) {
			sBuffer.append(key[i]);
		}
		System.out.println(sBuffer.toString());*/
		super.channelActive(ctx);
	}

}
