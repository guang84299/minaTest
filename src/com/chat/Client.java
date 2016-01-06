package com.chat;

import java.io.IOException;
import java.util.Scanner;

import net.sf.json.JSONObject;

import com.chat.bean.User;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void run() throws IOException
	{
		System.out.println("������ѡ��-> 1:��½ 2:ע��");

		Scanner sc = new Scanner(System.in);   
		if(sc.hasNextInt())
		{
			int type = sc.nextInt();
			if(type == 1)
			{				
				login();
			}
			else if(type == 2)
			{
				reg();
			}
			else
			{
				run();
			}
		}
		else
		{
			run();
		}
	}
	
	public static void login()
	{
		System.out.println("�������û�����");
	}

	public static void reg()
	{
		System.out.println("�������û�����");
		Scanner sc = new Scanner(System.in);   
		String name = sc.next();
		System.out.println("���������룺");
		String psw = sc.next();
		
		System.out.println("�û�����"+name + "  ���룺"+psw);
		
		User u = new User();
		u.setName(name);
		u.setPsw(psw);
		JSONObject obj = JSONObject.fromObject(u);
		String data = obj.toString();
		
		System.out.println(data);
	}
}
