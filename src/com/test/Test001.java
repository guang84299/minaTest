package com.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.log4j.PropertyConfigurator;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
public class Test001 {

	private static final int PORT = 3005;  
	private static final Logger logger = LoggerFactory.getLogger(Test001.class); 
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		String relativelyPath=System.getProperty("user.dir"); 
		PropertyConfigurator.configure( relativelyPath + "/config/log4j.properties" );
		IoAcceptor acceptor=new NioSocketAcceptor();    
		
		//acceptor.getFilterChain().addLast( "logger", new LoggingFilter() );  
        acceptor.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new TextLineCodecFactory( Charset.forName( "UTF-8" ))));  
       
        acceptor.setHandler(  new TimeServerHandler() );  
        acceptor.getSessionConfig().setReadBufferSize( 2048 );  
        acceptor.getSessionConfig().setIdleTime( IdleStatus.BOTH_IDLE, 10 );  

        try {
			acceptor.bind(new InetSocketAddress(PORT));
			logger.info("服务端启动成功...     端口号为：" + PORT);
		} catch (IOException e) {
			logger.error("服务端启动异常....", e);
			e.printStackTrace();
		}
	}

}
