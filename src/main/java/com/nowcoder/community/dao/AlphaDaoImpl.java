package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("BeanName")
@Primary
public class AlphaDaoImpl implements AlphaDao{
    @Override
    public String select() {
        return "Dao";
    }
}
