package com.wsc.service.impl;

import com.wsc.dto.DBMess;
import com.wsc.service.inter.IInitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by wsc on 17-1-30.
 */
@Service
public class InitServiceImpl implements IInitService {
    private static final Logger LOGGER= LoggerFactory.getLogger(InitServiceImpl.class);

    @Override
    public void setDBMess(DBMess dbMess) throws IOException {
        Properties properties=new Properties();
        properties.setProperty("jdbc.driver",dbMess.getDriver());
        properties.setProperty("jdbc.url",dbMess.getUrl());
        properties.setProperty("jdbc.username",dbMess.getUsername());
        properties.setProperty("jdbc.password",dbMess.getPassword());
        String classpath=System.getenv("PWD")+"/src/main/resources/test.properties";
        properties.store(new FileWriter(classpath),"classpath");
    }
}
