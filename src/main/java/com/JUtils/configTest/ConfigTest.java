package com.JUtils.configTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @Auther: ld
 * @Date: 2018/11/7 09:13
 * @Description:
 */
public class ConfigTest {
    public static void main(String[] args) {
        Properties pro = new Properties();
        try {
            FileInputStream in = new FileInputStream("src/main/config.properties");
            pro.load(in);
            String key = "name";
            String name = pro.getProperty(key);
            System.out.println(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
