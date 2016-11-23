package com.idea.quickstart.mapper;

import com.idea.quickstart.common.repository.MyBatisRepository;
import com.idea.quickstart.entity.AuthUser;

@MyBatisRepository
public interface AuthUserMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(AuthUser record);

    AuthUser selectByPrimaryKey(Long id);

    AuthUser selectByAccount(String account);

    int updateByPrimaryKeySelective(AuthUser record);

    int deleteAuthUserLogic(Long id);

    int lockAuthUserByAccount(String account);
}