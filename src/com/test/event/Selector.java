package com.test.event;

import java.util.ArrayList;
import java.util.List;

public class Selector {
	private static Selector sel = null;
	private List<EventSelector> list = new ArrayList<EventSelector>();
	private Selector()
	{		
	}
	
	public static Selector getInstance()
	{
		if(sel == null)
		{
			sel = new Selector();
		}
		return sel;
	}
	
	public void register(EventSelector sel)
	{
		if(sel != null)
			list.add(sel);
	}
	
	public void unregister(EventSelector sel)
	{
		if(sel != null)
			list.remove(sel);
	}
	
	public EventSelector find(EventType type)
	{
		for(EventSelector s : list)
		{
			if(s.getType() == type)
			{
				return s;
			}
		}
		return null;
	}
	
	public void select()
	{
		for(EventSelector s : list)
		{
			s.listen();
		}
	}
}
