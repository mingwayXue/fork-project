package com.xue.erp.service.user;

import com.alibaba.fastjson.JSONObject;
import com.xue.erp.datasource.entities.User;
import com.xue.erp.datasource.entities.UserExample;
import com.xue.erp.datasource.mappers.UserMapper;
import com.xue.erp.datasource.mappers.UserMapperEx;
import com.xue.erp.utils.ExceptionCodeConstants;
import com.xue.erp.utils.JshException;
import com.xue.erp.utils.StringUtil;
import com.xue.erp.utils.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserMapperEx userMapperEx;

    public User getUser(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> getUser() {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }

    public List<User> select(String userName, String loginName, int offset, int rows) {
        return userMapperEx.selectByConditionUser(userName, loginName, offset, rows);
    }

    public Long countUser(String userName, String loginName) {
        return userMapperEx.countsByUser(userName, loginName);
    }
    /**
     * create by: cjl
     * description:
     * 添加事务控制
     * create time: 2019/1/11 14:30
     * @Param: beanJson
     * @Param: request
     * @return int
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertUser(String beanJson, HttpServletRequest request) {
        User user = JSONObject.parseObject(beanJson, User.class);
        String password = "123456";
        //因密码用MD5加密，需要对密码进行转化
        try {
            password = Tools.md5Encryp(password);
            user.setPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error(">>>>>>>>>>>>>>转化MD5字符串错误 ：" + e.getMessage());
        }
        return userMapper.insertSelective(user);
    }
    /**
     * create by: cjl
     * description:
     * 添加事务控制
     * create time: 2019/1/11 14:31
     * @Param: beanJson
     * @Param: id
     * @return int
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateUser(String beanJson, Long id) {
        User user = JSONObject.parseObject(beanJson, User.class);
        user.setId(id);
        return userMapper.updateByPrimaryKeySelective(user);
    }
    /**
     * create by: cjl
     * description:
     * 添加事务控制
     * create time: 2019/1/11 14:32
     * @Param: user
     * @return int
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateUserByObj(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
    /**
     * create by: cjl
     * description:
     *  添加事务控制
     * create time: 2019/1/11 14:33
     * @Param: md5Pwd
     * @Param: id
     * @return int
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int resetPwd(String md5Pwd, Long id) {
        User user = new User();
        user.setId(id);
        user.setPassword(md5Pwd);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteUser(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteUser(String ids) {
        List<Long> idList = StringUtil.strToLongList(ids);
        UserExample example = new UserExample();
        example.createCriteria().andIdIn(idList);
        return userMapper.deleteByExample(example);
    }

    public int validateUser(String username, String password) throws JshException {
        try {
            /**默认是可以登录的*/
            List<User> list = null;
            try {
                UserExample example = new UserExample();
                example.createCriteria().andLoginameEqualTo(username);
                list = userMapper.selectByExample(example);
            } catch (Exception e) {
                logger.error(">>>>>>>>访问验证用户姓名是否存在后台信息异常", e);
                return ExceptionCodeConstants.UserExceptionCode.USER_ACCESS_EXCEPTION;
            }

            if (null != list && list.size() == 0) {
                return ExceptionCodeConstants.UserExceptionCode.USER_NOT_EXIST;
            }

            try {
                UserExample example = new UserExample();
                example.createCriteria().andLoginameEqualTo(username).andPasswordEqualTo(password);
                list = userMapper.selectByExample(example);
            } catch (Exception e) {
                logger.error(">>>>>>>>>>访问验证用户密码后台信息异常", e);
                return ExceptionCodeConstants.UserExceptionCode.USER_ACCESS_EXCEPTION;
            }

            if (null != list && list.size() == 0) {
                return ExceptionCodeConstants.UserExceptionCode.USER_PASSWORD_ERROR;
            }
            return ExceptionCodeConstants.UserExceptionCode.USER_CONDITION_FIT;
        } catch (Exception e) {
            throw new JshException("unknown exception", e);
        }
    }

    public User getUserByUserName(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andLoginameEqualTo(username);
        List<User> list = userMapper.selectByExample(example);
        User user = list.get(0);
        return user;
    }

    public int checkIsNameExist(Long id, String name) {
        UserExample example = new UserExample();
        example.createCriteria().andIdNotEqualTo(id).andLoginameEqualTo(name);
        List<User> list = userMapper.selectByExample(example);
        return list.size();
    }
    /**
     * create by: cjl
     * description:
     *  获取当前用户信息
     * create time: 2019/1/24 10:01
     * @Param:
     * @return com.xue.erp.datasource.entities.User
     */
    public User getCurrentUser(){
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        return (User)request.getSession().getAttribute("user");
    }
}
