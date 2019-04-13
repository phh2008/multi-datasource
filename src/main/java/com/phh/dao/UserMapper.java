package com.phh.dao;


import com.phh.entity.User;

public interface UserMapper {
    /**
     * @mbg.generated 2019-04-05
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated 2019-04-05
     */
    int insert(User record);

    /**
     * @mbg.generated 2019-04-05
     */
    int insertSelective(User record);

    /**
     * @mbg.generated 2019-04-05
     */
    User selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated 2019-04-05
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * @mbg.generated 2019-04-05
     */
    int updateByPrimaryKey(User record);
}