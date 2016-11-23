package com.idea.quickstart.service.impl;

import com.idea.quickstart.entity.AuthUser;
import com.idea.quickstart.mapper.AuthUserMapper;
import com.idea.quickstart.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author andaicheng
 * @date 2016/4/17
 */
@Service("systemService")
public class SystemServiceImpl implements SystemService {

    @Autowired
    private AuthUserMapper authUserMapper;

    @Override
    public AuthUser findByAccount(String account) {
        return authUserMapper.selectByAccount(account);
    }

    @Override
    public boolean lockAuthUser(String account) {
        return authUserMapper.lockAuthUserByAccount(account) > 0;
    }
}
