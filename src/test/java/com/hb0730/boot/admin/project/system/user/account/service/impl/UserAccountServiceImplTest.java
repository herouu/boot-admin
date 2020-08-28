package com.hb0730.boot.admin.project.system.user.account.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hb0730.boot.admin.commons.utils.PasswordSecurityUtils;
import com.hb0730.boot.admin.project.ProjectTest;
import com.hb0730.boot.admin.project.system.user.account.model.vo.UserAccountParams;
import com.hb0730.boot.admin.project.system.user.account.model.vo.UserAccountVO;
import com.hb0730.boot.admin.project.system.user.account.service.IUserAccountService;
import com.hb0730.commons.spring.SpringContextUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class UserAccountServiceImplTest extends ProjectTest {
    @Autowired
    private IUserAccountService service;
    @Autowired
    private ApplicationContext context;

    @Before
    public void init(){
        SpringContextUtils.setApplicationContext(context);
    }

    @Override
    @Test
    public void pageTest() {
        UserAccountParams params = new UserAccountParams();
        Page<UserAccountVO> page = service.page(params);
        Assert.assertNotNull(page);
    }

    @Override
    protected void listTest() {

    }

    @Override
    @Test
    public void save() {
        UserAccountVO vo = new UserAccountVO();
        vo.setUserId(-1L);
        vo.setUsername("Administrator");
        vo.setPassword("123456");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        vo.setPassword(PasswordSecurityUtils.encode(encoder, vo.getPassword()));
        service.save(vo);
    }

    @Test
    public void save1() {
        service.save((UserAccountVO) null);
    }

    @Test
    public void save2() {
        UserAccountVO vo = new UserAccountVO();
        service.save(vo);
    }

    @Override
    protected void updateById() {

    }

    @Override
    protected void removeById() {

    }

    @Test
    public void updatePasswordTest() {
        service.updatePassword(-1L, "123456", "123456");
    }
    @Test
    public void updatePasswordTest2(){
        service.updatePassword(-1L, "123456567", "123456");
    }
}
