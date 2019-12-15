package com.chenguangli.spring.soudsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class) //测试开始的时候自动创建Spring的应用上下文
//@ContextConfiguration(locations = "classpath*:/spring.xml") //方式一
@ContextConfiguration(classes = CDPlayerConfig.class) //方式二
//@ActiveProfiles("dev") //设置测试中使用的bean environment
public class CDPlayerTest {

    @Autowired //注入方式一
//    @Inject  //注入方式二
    private CompactDisc cd;

    @Autowired
//    @Qualifier("cDPlayer") //当bean装配发生歧义时, 可以使用该注解来选定使用哪个bean
    private MediaPlayer player;


    @Test
    public void cdShouldNotBeNull() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //ObjectFactory<?> singletonFactory
        ObjectFactory<?> singletonFactory = new ObjectFactory<Object>() {
            @Override
            public Object getObject() throws BeansException {
                return null;
            }
        };

        assertNotNull(cd);
        cd.play();
    }

    @Test
    public void play() {
        player.play();
    }
}
