package com.JUtils.configTest;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
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
            FileInputStream in = new FileInputStream("config.properties");
            pro.load(in);
            String key = "name";
            String name = pro.getProperty(key);
            System.out.println(name);
            in.close();
            ///保存属性到b.properties文件
            FileOutputStream oFile = new FileOutputStream("a.properties", true);//true表示追加打开
            pro.setProperty("phone", "10086");
            pro.store(oFile, null);
            oFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setProperty(Map<String, String> data) {
//第一步也是取得一个Properties对象
        Properties props = new Properties();
//第二步也是取得该配置文件的输入流
//		InputStream is = PropUtil.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            InputStream input = new FileInputStream("config.properties");
//第三步是把配置文件的输入流load到Properties对象中，
            props.load(input);
//接下来就可以随便往配置文件里面添加内容了
//			props.setProperty(key, value);
            if (data != null) {
            Iterator<Map.Entry<String, String>> iter = data.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, String> entry = iter.next();
                props.setProperty(entry.getKey().toString(), entry.getValue().toString());
            }
        }
//在保存配置文件之前还需要取得该配置文件的输出流，<span style="color: #ff0000; font-size: medium;">切记，</span>如果该项目是需要导出的且是一个非WEB项目，则该配置文件应当放在根目录下，否则会提示找不到配置文件
            OutputStream out = new FileOutputStream("config.properties");
//最后就是利用Properties对象保存配置文件的输出流到文件中;
            props.store(out, null);
            input.close();
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
