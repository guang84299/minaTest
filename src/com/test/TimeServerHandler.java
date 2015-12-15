package com.test;

import java.util.Date;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class TimeServerHandler implements IoHandler {

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		 System.out.println( "IDLE " + session.getIdleCount( status ));  

	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		 cause.printStackTrace();  

	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		 String str = message.toString();  
        if( str.trim().equalsIgnoreCase("quit") ) {  
            session.close();  
            return;  
        }  
        Date date = new Date();  
        session.write( date.toString() );  
        System.out.println("Message written...");  

	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub

	}

}
