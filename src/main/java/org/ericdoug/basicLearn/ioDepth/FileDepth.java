package org.ericdoug.basicLearn.ioDepth;

import java.io.File;
import java.io.IOException;

/**
 * @Author: EricDoug on 14-11-25.
 * @E-mail: liuxd6688@126.com
 *
 * File类
 * IO流的原理及概念
 * IO流类的分类
 * IO流类的体系
 * 字节流和字符流
 * 处理流
 * 文件拷贝
 * 文件分割与合并
 */
public class FileDepth {
    /*
    两个属性：
    1.路径分隔符
    2.文件分隔符
     */
    public void fileAttribute(){
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);
        //路径表现形式
        //String path = "E:\\test\\test.txt";
        // String path = "E:" + File.separator + "test" + File.separator + "test.txt";
        //推荐方式
        String path = "E:/test/test.txt";
    }
    /*
    相对路径与绝对路径构造File对象
     */
    public void filePath(){
        String parentPath = "/Users/playcrab/test";
        String filename = "test.txt";
        //以相对路径构造
        File src = new File(parentPath,filename);

        src = new File(new File(parentPath),filename);
        System.out.println(src.getName());
        System.out.println(src.getPath());
        System.out.println(src.getAbsolutePath());
        //绝对路径
        src = new File("/Users/playcrab/test/text.txt");

    }
    /*
    File 常用的方法
     */
    public void fileMethod(){
        File src =  new File("/Users/playcrab/test/test.txt");
        System.out.println(src.getName());
        System.out.println(src.getPath());
        System.out.println(src.getAbsolutePath());
        System.out.println(src.getParent());
        //文件是否存在
        System.out.println(src.exists());
        //是文件还是目录
        if(src.isFile()){
            System.out.println("file");
        }else {
            //没有真实存在的,默认是文件夹
            System.out.println("directory");
        }
        //文件是否可读写
        System.out.println(src.canWrite());
        //是否为绝对路径
        System.out.println(src.isAbsolute());
        //文件大小  不能读取文件夹长度
        System.out.println(src.length());

    }
    /*
    操作目录：
    1.mkdir()  创建目录，必须保证父目录存在，若不存在，创建失败。
    2.mkdirs()  创建目录，如果父目录不存在一同创建。
    3.list()  文件：目录字符串形式
    4.listFiles()
    5.static listRoot()

     */

    public void test(File f) throws IOException {
        if(!f.exists()) {
            try {
                //f.createTempFile(newFile,temp,"/User/playcrab/test/")
                f.createNewFile();
                System.out.println("Creant a new file!");

            }catch (Exception e){
                e.printStackTrace();
                System.out.println("Can not create a new file!");
            }
        }
        else{
            System.out.println("The file is exist!");
        }
    }


    public static void main(String[] args) throws IOException {
        FileDepth d01 = new FileDepth();
        //d01.filePath();
        //d01.fileMethod();
        d01.test(new File("/Users/playcrab/test/test.txt"));
    }

}
