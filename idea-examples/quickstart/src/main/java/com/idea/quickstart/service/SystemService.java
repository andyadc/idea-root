package com.idea.quickstart.service;

import com.idea.quickstart.entity.AuthUser;

/**
 * @author andaicheng
 */
public interface SystemService {

    AuthUser findByAccount(String account);

    boolean lockAuthUser(String account);
}
