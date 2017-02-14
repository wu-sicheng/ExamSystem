package com.wsc.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by wsc on 17-2-13.
 */
public final class Encryption {
    private final static Logger LOGGER= LoggerFactory.getLogger(Encryption.class);
    public static String md5En(String str){
        LOGGER.info("进入md5加密");
        String salt=null;
        try {
            Properties properties= new Properties();
            String url=System.getProperty("user.dir").replace("/bin","/webapps/ExamSystem/WEB-INF/classes/md5.properties");
            LOGGER.info("md5读取文件路径为:"+url);
            properties.load(new FileReader(url));
            salt=properties.getProperty("salt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Md5Hash(str,salt).toString();
    }
}
