package com.chenguangli.spring.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EncoreableIntroducer {

    @DeclareParents(value = "com.chenguangli.spring.concert.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
