/*
 * Delta CONFIDENTIAL
 *
 * (C) Copyright Delta Electronics, Inc. 2016 All Rights Reserved
 *
 * NOTICE:  All information contained herein is, and remains the
 * property of Delta Electronics. The intellectual and technical
 * concepts contained herein are proprietary to Delta Electronics
 * and are protected by trade secret, patent law or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Delta Electronics.
 */

package com.fcf.pagehelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TScmSmtConfigureMapper;
import com.taotao.pojo.TScmSmtConfigure;
import com.taotao.pojo.TScmSmtConfigureExample;
import com.taotao.pojo.TScmSmtConfigureExample.Criteria;

/**
 * @author V.Caifeng.Fan
 * @param <E>
 *            db entity
 * @param <I>
 *            dao interface
 *
 */
public class TestPageHelper {

	 private static final String resource = "mybatis_config.xml";
	//private static final String resource = "mybatis_config_druid.xml";


	private SqlSessionFactory sqlSessionFactory;

	public TestPageHelper() {

		initSqlSessionFactory();
	}


	private void initSqlSessionFactory() {

		InputStream inputStream = null;
		if (sqlSessionFactory == null) {
			synchronized (SqlSessionFactory.class) {
				if (sqlSessionFactory == null) {
					try {
						inputStream = Resources.getResourceAsStream(resource);
					} catch (IOException e) {
						e.printStackTrace();
					}
					sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				}
			}
		}
	}

	@Test
	public void page(){
		initSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			TScmSmtConfigureMapper mapper = session.getMapper(TScmSmtConfigureMapper.class);
			TScmSmtConfigureExample example = new TScmSmtConfigureExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andActiveEqualTo("N");
	        //分页处理，显示第一页的10条数据
	        PageHelper.startPage(1, 10);
	        List<TScmSmtConfigure> list = mapper.selectByExample(example);//查询
	        // 取商品列表
	        for(TScmSmtConfigure item : list) {
	            System.out.println(item.getLineNumber());
	        }
	        System.out.println("当前获取条数:"+list.size());
	        // 取分页信息
	        PageInfo<TScmSmtConfigure> pageInfo = new PageInfo<TScmSmtConfigure>(list);
	        long total = pageInfo.getTotal(); //获取总记录数
	        System.out.println("共有商品信息：" + total);
			session.commit();
		} catch (Exception e1) {
			session.rollback();
			e1.printStackTrace();
		} finally {
			session.close();
		}
		
	}

}
