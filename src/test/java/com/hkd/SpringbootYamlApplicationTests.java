package com.hkd;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hkd.mapper.UserMapper;
import com.hkd.pojo.Person;
import com.hkd.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class SpringbootYamlApplicationTests {

    @Autowired
    Person person;
    @Autowired
    DataSource dataSource;
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(person);
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection =  dataSource.getConnection();
        System.out.println(connection);

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

        //关闭连接
        connection.close();
    }
    @Test
    public void testList(){
        // 参数是一个 Wrapper ，条件构造器，这里我们先不用 null
        // 查询全部用户
//        List<User> users = userMapper.selectList(null);
//        users.forEach(System.out::println);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>();
        userQueryWrapper.select("username","password");
        List<User> user = userMapper.selectList(userQueryWrapper);
//        System.out.println(user.get(0));
//        System.out.println(user.get(2));
        for(int i = 0; i < user.size(); i++){
            System.out.println(user.get(i));
        }
        System.out.println(user.get(1));
    }

}
