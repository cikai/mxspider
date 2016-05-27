package com.mxnavi.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mxnavi.spider.model.CrawlDatums;
import com.mxnavi.spider.model.Page;
import com.mxnavi.spider.plugin.berkeley.BreadthCrawler;
import com.mysql.jdbc.PreparedStatement;

public class NewsCrawler extends BreadthCrawler {

	public NewsCrawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		/* start page */
		this.addSeed("http://www.pcauto.com.cn/drivers/yongpin/");

		/* fetch url like http://news.hfut.edu.cn/show-xxxxxxhtml */
		this.addRegex("http://www.pcauto.com.cn/drivers/.*html");
		/* do not fetch jpg|png|gif */
		this.addRegex("-.*\\.(jpg|png|gif).*");
		/* do not fetch url contains # */
		this.addRegex("-.*#.*");
	}
	
	private static Connection getConn() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mxspider?useUnicode=true&characterEncoding=utf-8";
		String username = "root";
		String password = "root";
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public void visit(Page page, CrawlDatums next) {
		String url = page.getUrl();
		/* if page is news page */
		if (page.matchUrl("http://www.pcauto.com.cn/drivers/8.*html")) {

			/* extract title and content of news by css selector */
			String title = page.select("div[class=artTop]>h1").first().text();
			String content = page.select("div.artText", 0).text();

			Connection conn = getConn();
			int i = 0;
			String sql = "insert into `content`(`url`,`title`,`content`) values (?,?,?)";
			PreparedStatement pstmt;
			try {
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
				pstmt.setString(1, String.valueOf(url));
				pstmt.setString(2, String.valueOf(title));
				pstmt.setString(3, String.valueOf(content));
				i = pstmt.executeUpdate();
				pstmt.close();
				conn.close();
				
				// System.out.println("--------->"+i);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			// next.add("http://www.pcauto.com.cn/drivers/8.*html");
		}
	}

	public void spider() throws Exception {
		NewsCrawler crawler = new NewsCrawler("crawl", true);
		crawler.setThreads(50);
		crawler.setTopN(100);
		// crawler.setResumable(true);
		/* start crawl with depth of 4 */
		crawler.start(4);
	}

}