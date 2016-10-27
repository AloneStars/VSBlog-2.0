package com.violentstone.Util;

import java.io.IOException;
import java.io.Reader;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * �������ݿ�
 * @author ҫ���µĹ���
 */
public class DBAccess {
	
	public SqlSession getSqlSession() throws IOException{
		
		//ͨ�������ļ���ȡ���ݿ�������Ϣ
		Reader reader = Resources.getResourceAsReader("com/violentstone/config/Configuration.xml");
		
		//ͨ��������Ϣ����һ��SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		//ͨ��sqlSessionFactory��һ�����ݿ�ػ�
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		
		return sqlSession;
		
	}

}
