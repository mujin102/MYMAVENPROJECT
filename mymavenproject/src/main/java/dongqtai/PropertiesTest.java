package dongqtai;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @version: java version 1.7+
 * @Author : DaiDongqing
 * @Explain :
 * @contact: dongqingdai@creditease.cn
 * @Time : 2018/10/26 14:20
 * @File : PropertiesTest
 * @Software: IntelliJ IDEA 2017.3.2
 */

// 测试类，测试Properties类的使用
public class PropertiesTest {
    @Test
    public static void mian(String[] atgs){
        Properties pro =new Properties();
        try{
            //读取属性文件a.properties
            InputStream in = new BufferedInputStream (new FileInputStream("a.properties"));
            pro.load(in);     ///加载属性列表
            Iterator<String> it=pro.stringPropertyNames().iterator();
            while(it.hasNext()){
                String key=it.next();
                System.out.println(key+":"+pro.getProperty(key));
            }
            in.close();

            ///保存属性到b.properties文件
            FileOutputStream oFile = new FileOutputStream("b.properties", true);//true表示追加打开
            pro.setProperty("phone", "10086");
            pro.store(oFile, "The New properties file");
            oFile.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }


}

