package first;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CardLost extends Lost{
    private String name;
    private String number;


    public CardLost(){}

    public CardLost(String type, String name, String number, String lostTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        setLostTime(sdf.parse(lostTime));
        setType(type);
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return "一卡通：" + name + '\t' + number + '\t' + sdf.format(getLostTime());
    }
}
