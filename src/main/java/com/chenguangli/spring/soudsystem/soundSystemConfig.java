package com.chenguangli.spring.soudsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({CDPlayerConfig.class, CDConfig.class}) //也可以组合在一起
@ImportResource("classpath:spring.xml")
public class soundSystemConfig {
}
