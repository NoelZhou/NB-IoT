package com.swdegao.testMessagePush;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import com.swdegao.common.ExceptionUtil;

public class MessRunable implements Runnable {
	private SocketChannel socketChannel;
	
	private int msgCnt = 0;

	private static String recvString = null;

	public static String getRecvString() {
		return recvString;
	}
	
	public MessRunable(SocketChannel socketChannel) {
		this.socketChannel = socketChannel;
	}

	public void run() {
		handle(socketChannel);
	}

	private void handle(SocketChannel socketChannel) {
		try {
			ByteBuffer buffer = ByteBuffer.allocate(2048);
			socketChannel.read(buffer);
			buffer.flip();
			recvString = new String(buffer.array());

			String responseJsonBody = "";

			if (recvString != null) {

				try {
					responseJsonBody = recvString.substring(recvString.lastIndexOf("\n"));
				} catch (Exception e) {
					System.out.println("get responseJsonBody fail.");
				}
			}

			System.out.print("接收到平台推送的第" + msgCnt + "消息 :");
			System.out.println(responseJsonBody);

			msgCnt++;
			System.out.println();

		} catch (IOException e) {
			System.out.println(ExceptionUtil.getBriefExceptionStackTrace(e));
		} finally {
			try {
				if (socketChannel != null)
					socketChannel.close();
			} catch (IOException e) {
				System.out.println(ExceptionUtil.getBriefExceptionStackTrace(e));
			}
		}
	}

}
