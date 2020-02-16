package com.ydgk.ssm.test;

import com.ydgk.ssm.entities.Admin;
import com.ydgk.ssm.mappers.AdminMapper;
import org.junit.Test;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author kfstart
 * @descrption
 * @create 2019-10-17 15:39
 */
public class TestMybatis {

    SqlSessionFactory sqlSessionFactory;

    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        sqlSessionFactory = ac.getBean(SqlSessionFactory.class);
    }

    @Test
    public void test(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);

        Admin admin = mapper.selectByPrimaryKey(1);


        System.out.println(admin);

    }

/*//运用逆向工程自动生成
    public static void main(String[] args) throws InterruptedException, SQLException, IOException, InvalidConfigurationException, XMLParserException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }*/
}
