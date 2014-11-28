package org.ericdoug.basicLearn;

/**
 * @Author: EricDoug on 14-11-23.
 * @E-mail: liuxd6688@126.com
 */
public class Basic01 {

    public void substringTest(){
        /*
        str = str.substring(int beginIndex);截取掉str从首字母起长度为beginIndex的字符串，将剩余字符串赋值给str；
        str = str.substring(int beginIndex,int endIndex);截取str中从beginIndex开始到endIndex结束时的字符串，并将其赋值给str；
         */
        String str = "this is my original string";
        String toDelete = "original";

        if(str.startsWith(toDelete)){
            str = str.substring(toDelete.length());
        }else {
            int index = str.indexOf(toDelete);
            if(index != -1){
                String str1 = str.substring(0,index);
                String str2 = str.substring(index+toDelete.length()+1);
                str = str1 + str2;
            }else {
                System.out.println("string \""+toDelete+"\" not found");
            }

            System.out.println(str);
        }
    }
    public static void main(String args[]){
        Basic01 basic01 = new Basic01();
        basic01.substringTest();

    }
}
