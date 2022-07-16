package 蓝桥杯.Homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Solution {
    //创建一个失物库
    public Lost[] array;

    {
        try {
            array = new Lost[]{
                    new BookLost("书籍","高等数学","食堂","2031.5.16"),
                    new BookLost("书籍","大学物理","垃圾桶","2031.3.16" ),
                    new BookLost("书籍","恋爱心理学","教室","2011.11.11"),
                    new BookLost("书籍","大学英语","操场","2100.4.23"),
                    new BookLost("书籍","线性代数","食堂","2018.9.12"),

                    new CardLost("一卡通","张三","2048222777","2022.7.25"),
                    new CardLost("一卡通","李四","1458987546","2021.5.14"),
                    new CardLost("一卡通","王五","7896325848","2019.4.13")
            };
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    /**
     * 失物排序方法
     * @param lostArray 待排序的失物数组
     */
    public void sortLost(Lost[] lostArray){
        sort(lostArray,0,lostArray.length-1);
    }

    public void sort(Lost[] lostArray, int left, int right){
        int L = left;
        int R = right;
        if(L >= R) return;
        Lost pivot = lostArray[L];//获取时间的毫秒值进行比较
        while(L < R){
            while(L < R && lostArray[R].getLostTime().getTime() >= pivot.getLostTime().getTime()){
                R--;
            }
            if(L < R) lostArray[L] = lostArray[R];

            while(L < R && lostArray[L].getLostTime().getTime() <= pivot.getLostTime().getTime()){
                L++;
            }
            if(L < R) lostArray[R] = lostArray[L];

            if(L >= R) lostArray[L] = pivot;
        }
        sort(lostArray,left,R-1);
        sort(lostArray,R+1,right);
    }

    /**根据关键字搜索失物
     * @param lostArray 失物数组
     * @param keyword 用户输入的关键字
     * @return 返回查找到的失物
     */
    public Lost selectByKeyword(Lost[] lostArray, String keyword) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        for(Lost e : lostArray){
            if(e instanceof BookLost){
                if(compare(sdf.format(e.getLostTime()), keyword)){
                    return e;
                }else if(compare(((BookLost) e).getBookName(),keyword)){
                    return e;
                }else if(compare(((BookLost) e).getLostPlace(),keyword)){
                    return e;
                }else if (compare(e.getType(),keyword)){
                    return e;
                }else {
                    System.out.println("查无此项");
                    return new BookLost();
                }
            }else if(e instanceof CardLost){
                if(compare(sdf.format(e.getLostTime()),keyword)){
                    return e;
                }else if(compare(((CardLost) e).getName(),keyword)){
                    return e;
                }else if(compare(((CardLost) e).getNumber(),keyword)){
                    return e;
                }else if(compare(e.getType(),keyword)){
                    return e;
                }else {
                    System.out.println("查无此项");
                    return new CardLost();
                }
            } else {
                System.out.println("类型不正确");
            }
        }
        System.out.println("查无此物");
        return new Lost();
    }
    private boolean compare(String str, String keyword){
        int length = keyword.length();
        if(length == 0){//关键字不存在
            return false;
        }else{//关键字存在
            for(int i = 0; i < str.length() - length + 1; i++) {
                if(str.substring(i,i+length-1).equals(keyword)){
                    return true;
                }
            }
        }
        return false;
    }
    //遍历失物
    public void lostShow(Lost[] lostArray){
        System.out.println("当前失物有：");
        sortLost(lostArray);
        for(Lost e: lostArray){
            System.out.println(e);
        }
    }
}
