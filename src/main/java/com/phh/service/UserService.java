package com.phh.service;

import com.phh.annotation.DS;
import com.phh.config.DataSourceKey;
import com.phh.dao.UserMapper;
import com.phh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p> TODO
 *
 * @author phh
 * @version V1.0
 * @project: spring
 * @package com.phh.service
 * @date 2019/4/5
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 指定master数据源
     *
     * @param user
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @DS(DataSourceKey.MASTER)
    public void insert(User user) {
        userMapper.insert(user);
        i++;
        if ((i & 1) == 1) {
            throw new RuntimeException("模拟出错，测试事务回滚");
        }
    }

    int i = 0;

    /**
     * 不指定数据源，走默认的那个
     *
     * @param user
     */
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 指定slaver数据源
     *
     * @param id
     * @return
     */
    @DS(DataSourceKey.SLAVER)
    public User getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
