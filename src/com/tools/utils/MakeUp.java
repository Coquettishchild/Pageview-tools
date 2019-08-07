package com.tools.utils;

import java.util.List;

public class MakeUp {
	/*
	 * @param url 爬取的博客首页，注意不要分页以后的
	 * @param page 爬取的博客页数
	 * @time 间隔时间
	 * @count 刷的次数  -1为一直刷
	 */
	public static void makeUpCSDN(String url,int page,int time,int count) {
		List<String> urllist = GetUrls.CSDNparse(url, page);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String string : urllist) {
			Tools.addUrl(string);
		}
		System.out.println("构建路径成功");
		Tools.work(time, count);
		System.out.println("欢迎下次使用");
	}
}
