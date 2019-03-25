package com.xue.myblog.dao;

import com.xue.myblog.WebApplication;
import com.xue.myblog.dao.UserVoMapper;
import com.xue.myblog.entity.Vo.UserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by 薛明卫 on Date:2018-07-21 16:14.
 * 修改记录
 * 修改后版本:     修改人：  修改日期:     修改内容:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserVoMapperTest {

	@Autowired
	private UserVoMapper userVoMapper;

	@Test
	public void selectByPrimaryKey() throws Exception {
		UserVo userVo = userVoMapper.selectByPrimaryKey(1);
		System.out.println(userVo);
	}

}