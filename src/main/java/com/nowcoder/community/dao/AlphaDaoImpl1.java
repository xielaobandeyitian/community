package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AlphaDaoImpl1 implements AlphaDao{
    @Override
    public String select() {
        return "Dao1";
    }
}
