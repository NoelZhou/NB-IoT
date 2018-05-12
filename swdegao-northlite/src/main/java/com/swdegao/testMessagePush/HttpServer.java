/*
 * File Name: com.huawei.m2m.nsse.j808.client.SimpleHttpServer.java
 *
 * Copyright Notice:
 *      Copyright  1998-2008, Huawei Technologies Co., Ltd.  ALL Rights Reserved.
 *
 *      Warning: This computer software sourcecode is protected by copyright law
 *      and international treaties. Unauthorized reproduction or distribution
 *      of this sourcecode, or any portion of it, may result in severe civil and
 *      criminal penalties, and will be prosecuted to the maximum extent
 *      possible under the law.
 */
package com.swdegao.testMessagePush;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.swdegao.common.ExceptionUtil;

public class HttpServer {

	private int port;
	private ServerSocketChannel serverSocketChannel = null;
	private ExecutorService executorService;
	private static final int POOL_MULTIPLE = 10;

	public HttpServer(int port) throws IOException {
		this.port = port;
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * POOL_MULTIPLE);
		serverSocketChannel = ServerSocketChannel.open();
		 
		serverSocketChannel.socket().setReuseAddress(true);
		serverSocketChannel.socket().bind(new InetSocketAddress(this.port));
	}

	public void service() {
		while (true) {
			SocketChannel socketChannel = null;
			try {
				socketChannel = serverSocketChannel.accept();
				executorService.execute(new MessRunable(socketChannel));
			} catch (IOException e) {
				System.out.println(ExceptionUtil.getBriefExceptionStackTrace(e));
			}
		}
	}

	public static void startServer(final int port) {
		System.out.println("开启服务器..， 服务端口 = " + port);
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					new HttpServer(port).service();
				} catch (Exception e) {
					System.out.println("开启服务器失败， 服务端口 = " + port);
					System.out.println(ExceptionUtil.getBriefExceptionStackTrace(e));
					System.out.println();
				}
			}
		});
		t.start();
	}

	public static String recvBuf;

	public static String getRecvBuf() {
		return recvBuf;
	}

	public static void setRecvBuf(String recvBuf) {
		HttpServer.recvBuf = recvBuf;
	}
}
