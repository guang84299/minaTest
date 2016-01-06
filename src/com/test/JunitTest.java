package com.test;

import org.junit.Test;

import com.test.event.EventItem;
import com.test.event.EventSelector;
import com.test.event.EventType;
import com.test.event.Selector;

public class JunitTest {

	@Test
	public void test()
	{
		Selector sel = Selector.getInstance();
		sel.register(new EventSelector(new EventItem(), EventType.APP));
		int i = 0;
		while(i < 10)
		{
			sel.select();
			i++;
			if(i == 3)
			{
				EventSelector s = sel.find(EventType.APP);
				s.exc(EventType.IDLE);
			}
			else if(i == 5)
			{
				EventSelector s = sel.find(EventType.APP);
				s.exc(EventType.RUN);
			}
				
			try {
				Thread.sleep(1000);
				System.out.println("-------"+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
