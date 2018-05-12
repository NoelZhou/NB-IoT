package com.swdegao.controller;

import com.swdegao.testMessagePush.HttpServer;

public class PushNotificationServiceController {
	
	
	public void messageback() {
		HttpServer.startServer(8888);
	}
}
