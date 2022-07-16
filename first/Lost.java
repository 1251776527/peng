package first;

import java.util.Date;

public class Lost {
    private Date lostTime;
    private String type;

    public void setLostTime(Date lostTime){
        this.lostTime = lostTime;
    }
    //接收一个String类型，将其转换成Date类
    public Date getLostTime() {
        return lostTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "失物类：" + lostTime + "\t" + type ;
    }
}
