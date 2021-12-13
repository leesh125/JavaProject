package com.web.dbconn;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnect {
	
	private SqlSession sess = null;
	
	public MybatisConnect() {
		this.connect();
	}
	
	public void connect() {
		String resource = "resources/mybatis-config.xml";
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			this.sess = builder.build(is).openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void commit() {
		this.sess.commit();
	}
	
	public void rollback() {
		this.sess.rollback();
	}
	
	public void close() {
		this.sess.close();
	}

	public SqlSession getSession() {
		if(this.sess == null) {
			this.connect();
		}
		return this.sess;
	}
}
