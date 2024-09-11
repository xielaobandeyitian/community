package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;


@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser() {
        User user =  userMapper.selectById(11);
        System.out.println(user);

        user =  userMapper.selectByName("nowcoder11");
        System.out.println(user);

        user =  userMapper.selectByEmail("nowcoder11@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("tset");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUser() {
        int rows = userMapper.updateStatus(11, 0);
        System.out.println(rows);

        rows = userMapper.updateHeader(11, "http://www.nowcoder.com/101.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(11, "000000");
        System.out.println(rows);
    }

    @Test
    public void testSelectPosts(){
       List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(0,0,10);
       for(DiscussPost discussPost : discussPosts){
           System.out.println(discussPost);
       }
       int rows = discussPostMapper.selectDiscussPostRows(0);
       System.out.println(rows);
    }
}
