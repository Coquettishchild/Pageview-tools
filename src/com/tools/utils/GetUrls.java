package com.tools.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetUrls {
	private static List<String> list = new ArrayList<>();
	/*
	 * @param url 地址
	 * @param page 页数
	 */
	public static List<String>  CSDNparse(String url,int page) {
		try {
			for(int i=1;i<=page;i++) {
				String temp = url+"/article/list/"+i+"?";
				Document document = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(5000).get();
				Elements element = document.getElementsByAttributeValue("class", "article-item-box csdn-tracking-statistics");
				for (int j=1;j<element.size();j++) {
					list.add(url+"/article/details/"+element.get(j).attr("data-articleid"));
				}
			}
			System.out.println("获取目标成功");
		} catch (IOException e) {
			System.err.println("爬取目标网站失败");
			e.printStackTrace();
		}
		return list;
	}
	
}
