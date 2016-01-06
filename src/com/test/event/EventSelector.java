package com.test.event;

import java.util.ArrayList;
import java.util.List;


public class EventSelector {
	
	private EventType type;
	private EventItem item;
	private List<EventType> evens = new ArrayList<EventType>();
	
	public EventSelector(EventItem item,EventType type)
	{	
		this.type = type;
		this.item = item;
	}
	
	
	
	public void setType(EventType type) {
		this.type = type;
	}

	public void setItem(EventItem item) {
		this.item = item;
	}

	public EventType getType()
	{
		return this.type;
	}
	
	public EventItem getItem()
	{
		return this.item;
	}
	
	public void exc(EventType type)
	{
		evens.add(type);
	}
	
	public void listen()
	{
		for(EventType type : evens)
		{
			item.process(type);
		}
		
		evens.removeAll(evens);
	}
}
