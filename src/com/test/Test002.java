package com.test;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.log4j.PropertyConfigurator;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test002 {
	private static final Logger logger = LoggerFactory.getLogger(Test002.class); 
	private static String HOST = "127.0.0.1";
	private static int PORT = 3005;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String relativelyPath=System.getProperty("user.dir"); 
		PropertyConfigurator.configure( relativelyPath + "/config/log4j.properties" );
		// 创建一个非阻塞的客户端程序
		IoConnector connector = new NioSocketConnector();
		// 设置链接超时时间 
		connector.setConnectTimeoutMillis(30000);
		// 添加过滤器
		connector.getFilterChain().addLast("codec",new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));		
		// 添加业务逻辑处理器类
		connector.setHandler(new Test002ClientHandler());
		IoSession session = null;
		try 
		{     
			ConnectFuture future = connector.connect(new InetSocketAddress(HOST, PORT));// 创建连接
			future.awaitUninterruptibly();// 等待连接创建完成
			session = future.getSession();// 获得session
			session.write("mina");// 发送消息
			session.getCloseFuture().awaitUninterruptibly();// 等待连接断开
			connector.dispose();
		}
		catch (Exception e) 
		{ 
			logger.error("客户端链接异常...", e);
		}		
	}

}
