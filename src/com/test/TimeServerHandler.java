package com.test;

import java.util.Date;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeServerHandler implements IoHandler {
	private static final Logger logger = LoggerFactory.getLogger(TimeServerHandler.class); 
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		logger.info("服务端与客户端创建连接...");
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		logger.info("服务端与客户端连接打开...");
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		logger.info( "IDLE " + session.getIdleCount( status ));  

	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		logger.error("服务端发送异常...", cause);
	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		 String str = message.toString();  
		 logger.info("服务端接收信息："+str);
        if( str.trim().equalsIgnoreCase("quit") ) {  
            session.close();  
            return;  
        }  
        Date date = new Date();  
        session.write( date.toString() );  
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		logger.info("服务端发送信息成功..."); 
	}

	@Override
	public void inputClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub

	}

}
