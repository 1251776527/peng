package 蓝桥杯.Homework;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Solution lost = new Solution();
        lost.lostShow(lost.array);//遍历已有失物

        Scanner input = new Scanner(System.in);
        System.out.println("是否添加失物");
        String choice = input.next();

        int count = 0;//用于存储添加的失物个数
        List<Lost> newLost = new ArrayList<>();
        while(choice.equals("是")){

            System.out.println("添加失物类型(书籍、一卡通)");
            String type = input.next();
            if(type.equals("一卡通")){

                System.out.println("请输入姓名");
                String name = input.next();

                System.out.println("请输入学号");
                String number = input.next();

                System.out.println("输入丢失时间(格式为'XXXX.XX.XX')");
                String time = "";
                boolean flag = true;
                while(flag) {//当格式错误时，提醒重新输入
                    time = input.next();
                    flag = false;
                    try {
                        newLost.add(new CardLost("一卡通",name, number, time)) ;
                        count++;
                    } catch (ParseException e) {
                        System.out.println("格式错误,请重新输入");
                        flag = true;
                    }
                }
            }else if(type.equals("书籍")){
                System.out.println("请输入书名");
                String name = input.next();

                System.out.println("请输入丢失地点");
                String place = input.next();

                System.out.println("输入丢失时间(格式为'XXXX.XX.XX')");
                String time = "";
                boolean flag = true;
                while(flag) {//当格式错误时，提醒重新输入
                    time = input.next();
                    flag = false;
                    try {
                        newLost.add(new BookLost("书籍",name, place, time));
                        count++;
                    } catch (ParseException e) {
                        System.out.println("格式错误,请重新输入");
                        flag = true;
                    }
                }
            } else {
                System.out.println("此类型暂时无法添加");
            }
            System.out.println("是否继续添加");
            choice = input.next();
        }

        Lost[] newArray = new Lost[lost.array.length + count];//新数组用于储存改变后的失物库
        System.arraycopy(lost.array,0,newArray,0,lost.array.length);

        if(count != 0){
            for(int i = 0; i < count; i++){
                newArray[lost.array.length + i] = newLost.get(i);
            }
            lost.lostShow(newArray);
        }


        boolean flag = true;
        while(flag){
            System.out.println("输入需要查找的失物特点");
            String keyword = input.next();
            System.out.println(lost.selectByKeyword(newArray,keyword).toString());



            System.out.println("是否再次查找");
            String ch = input.next();
            if(ch.equals("否")){
                flag = false;
            }else if(!ch.equals("是")){
                System.out.println("无法判断该命令");
            }
        }

    }
}
