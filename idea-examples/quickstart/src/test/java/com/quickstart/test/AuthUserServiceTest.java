package com.quickstart.test;

import com.idea.quickstart.entity.AuthUser;
import com.idea.quickstart.mapper.AuthUserMapper;
import com.idea.quickstart.security.PasswordHelper;
import com.idea.quickstart.security.UserTokenGenerator;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author andaicheng
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class AuthUserServiceTest {

    @Autowired
    private AuthUserMapper authUserMapper;
    @Autowired
    private PasswordHelper passwordHelper;
    @Autowired
    private UserTokenGenerator generator;

    @Ignore
    @Test
    public void testToken() {
        System.out.println(generator.generatorToken(12123L));
    }

    @Ignore
    @Test
    public void test001() {
        System.out.println(authUserMapper.selectByPrimaryKey(1L));
    }

    @Ignore
    @Test
    public void testPassword() {
        long l1 = System.currentTimeMillis();
        AuthUser user = new AuthUser();
        user.setAccount("admin");
        user.setPassword("123456");
        passwordHelper.encryptPassword(user);
        System.out.println();
        System.out.println(user.getPassword());//ce0e0d64376843535ccb711bbfc5d60efd586639
        System.out.println(user.getSalt());//5b236033c3439099cd9cea44aba78952
        System.out.println(System.currentTimeMillis() - l1);
    }

    @Ignore
    @Test
    public void testPassword2() {
        long l1 = System.currentTimeMillis();
        AuthUser user = new AuthUser();
        user.setAccount("admin");
        user.setPassword("ce0e0d64376843535ccb711bbfc5d60efd586639");
        user.setSalt("5b236033c3439099cd9cea44aba78952");
        System.out.println();
        System.out.println(passwordHelper.verifyPassword(user, "123456"));
        System.out.println(System.currentTimeMillis() - l1);
    }

    @Test
    @Ignore
    public void test003() {
        System.out.println(authUserMapper.deleteAuthUserLogic(1L));
    }

    @Test
    @Ignore
    public void test002() {
        AuthUser user = new AuthUser();
        user.setId(1L);
        user.setPhone("666666");
        authUserMapper.updateByPrimaryKeySelective(user);
    }
}
