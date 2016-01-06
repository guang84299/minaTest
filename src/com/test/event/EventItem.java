package com.test.event;

public class EventItem {

	public void process(EventType type)
	{
		switch(type)
		{
			case EAT:
				System.out.println("eat");
				break;
			case WALK:
				System.out.println("WALK");
				break;
			case RUN:
				System.out.println("RUN");
				break;
			case IDLE:
				System.out.println("IDLE");
				break;
		}
	}
}
