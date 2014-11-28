package org.ericdoug.basicLearn.ioDepth;

import com.javafx.tools.doclets.internal.toolkit.util.DocFinder;

import java.io.*;

/**
 * @Author: EricDoug on 14-11-26.
 * @E-mail: liuxd6688@126.com
 * 一、概念
 * 流：
 * 程序  与 文件/数组/网络连接/数据库，以程序为中心
 * 二、IO流分类
 * 1.流向：输入流与输出流
 * 2.数据：字节流：二进制，可以一切文件 包括 存文本 doc 音频 视频等等
 *        字符流:文本文件，只能处理纯文本
 * 3.功能：
 * 节点：包裹源头
 * 处理：增强功能，提高性能
 * 三、字符刘与字节流
 * 1.字节流
 * 输入流：InputStream()  FileInputStream()
 * ---read(byte)
 * 输出流：OutputStream()  FileOutputStream()
 * ---write()
 * ---flush()
 * ---close()
 * 2.字符流
 * 输入流：Read()  FileReader()
 * ---read(char)
 * 输出流:Write()  FileWriter()
 * ---write()
 * ---flush()
 * ---close()
 * 四、操作
 * 1.举例：搬家   --->读取文件
 * 1)关联房子   --->建立与文件联系
 * 2）选择搬家公司  --->选择对应流
 * 3）搬家         --->读取/写出
 *  a)卡车大小     --->数组大小
 *  b）运输        --->读取、写出
 * 4)打发over     --->释放资源
 */
public class IOstreaming {
    /*
    读取文件
     */
    public void readFile(String f){
        //1.建立联系  File对象
        //2.选择流
        File src = new File(f);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(src);
            //3.操作 不断读取  缓冲数组
            byte[] car = new byte[1024];
            int len = 0;
            while((len=fis.read(car)) != -1){
                //输出 字节数组转换为字符串
                String info = new String(car,0,len);
                System.out.println(info);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File read filed");
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("File is not exist!");
        }finally {
            try {


                if (null != fis) {
                    fis.close();
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("关闭数据流失败！");
            }
        }
    }

    public void writeFile(String f){
       File dest = new File(f);
        OutputStream os = null;
        try {
            os = new FileOutputStream(dest,true);
            String str = "Eric is a good programmer\r\n";
            //字符串转字节数组
            byte[] data = str.getBytes();
            os.write(data,0,data.length);
            os.flush();
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("The file" + f +"is not exist!");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("The file write exception!");
        }
    }



    public static void main(String[] args) throws IOException,FileNotFoundException {
        String path = "/Users/playcrab/test/test.txt";
       IOstreaming ioOpertor = new IOstreaming();
        ioOpertor.writeFile(path);
        ioOpertor.readFile(path);

    }
}
