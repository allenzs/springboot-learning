package com.allen.sb_00_demo.dao.impl;

import com.allen.sb_00_demo.dao.BootDao;
import org.springframework.stereotype.Repository;

/**
 * @author allen
 * @create 2022/5/10 19:40
 */
@Repository
public class BootDaoImpl implements BootDao {

    @Override
    public void save() {
        System.out.println("save ok~");
    }
}
