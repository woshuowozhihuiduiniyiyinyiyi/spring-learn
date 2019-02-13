package com.tj.spring.learn;

import com.tj.spring.learn.entity.Owner;
import com.tj.spring.learn.mapper.OwnerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


/**
 * @author tangj
 * @description
 * @since 2019/1/30 10:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MBeanServerTest {

    @Resource
    private OwnerMapper ownerMapper;

    @Test
    @Transactional
    public void testInsert() {
        Owner owner = new Owner();
        owner.setWxAccount("12354665474743");
        owner.setWxNickname("gdsgsghfdshfdhfsd");
        owner.setAvatarUrl("");
        owner.setCity("");
        owner.setCreatedAt(new Date());
        owner.setCreator("");
        owner.setGender(0);
        owner.setOpenId("");
        owner.setPhone("");
        owner.setProvince("");
        owner.setStatus(0);
        owner.setUpdater("");
        owner.setUpdatedAt(new Date());
        ownerMapper.save(owner);
    }
}
