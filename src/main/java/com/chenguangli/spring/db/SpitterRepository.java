package com.chenguangli.spring.db;

public interface SpitterRepository {

    void addSpitter(Spitter spitter);

    Spitter findOne(int id);
}
