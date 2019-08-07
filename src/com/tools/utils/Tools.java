package com.tools.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Tools {
	private ArrayList<URL> targets = new ArrayList<>();

	/*
	 * @param url 需要添加的地址
	 * 
	 * @return void
	 */
	public void addUrl(String url) {
		try {
			URL target = new URL(url);
			targets.add(target);
		} catch (MalformedURLException e) {
			System.err.println("url地址格式不正确");
		}
	}

	/*
	 * @param time 间隔时间，尽量不要大于一分钟一次 ，单位毫秒
	 * 
	 * @param count 刷取的次数 -1为一直刷
	 */
	public void work(int time, int count) {
		int num = 0;
		if (count == -1) {
			while (true) {
				for (int i = 0; i < targets.size(); i++) {
					try {
						targets.get(i).openStream();
					} catch (IOException e) {
						System.err.println("IO开启异常");
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					System.err.println("线程休眠异常");
					e.printStackTrace();
				}
				num += targets.size();
				System.out.println("共刷取" + num + "个访问量");
				
			}
		} else {
			for(int j=0;j<count;j++) {
				for (int i = 0; i < targets.size(); i++) {
					try {
						targets.get(i).openStream();
					} catch (IOException e) {
						System.err.println("IO开启异常");
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					System.err.println("线程休眠异常");
					e.printStackTrace();
				}
				num += targets.size();
				System.out.println("共刷取" + num + "个访问量");
				
			}
		}

	}
}
