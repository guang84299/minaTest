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
		// ����һ���������Ŀͻ��˳���
		IoConnector connector = new NioSocketConnector();
		// �������ӳ�ʱʱ�� 
		connector.setConnectTimeoutMillis(30000);
		// ��ӹ�����
		connector.getFilterChain().addLast("codec",new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));		
		// ���ҵ���߼���������
		connector.setHandler(new Test002ClientHandler());
		IoSession session = null;
		try 
		{     
			ConnectFuture future = connector.connect(new InetSocketAddress(HOST, PORT));// ��������
			future.awaitUninterruptibly();// �ȴ����Ӵ������
			session = future.getSession();// ���session
			session.write("mina");// ������Ϣ
			session.getCloseFuture().awaitUninterruptibly();// �ȴ����ӶϿ�
			connector.dispose();
		}
		catch (Exception e) 
		{ 
			logger.error("�ͻ��������쳣...", e);
		}		
	}

}
