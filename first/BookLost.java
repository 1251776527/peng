package first;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BookLost extends Lost{
    private String bookName;
    private String lostPlace;

    public BookLost(){}

    public BookLost(String type,String bookName, String lostPlace, String lostTime) throws ParseException {
        setType(type);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        setLostTime(sdf.parse(lostTime));
        this.bookName = bookName;
        this.lostPlace = lostPlace;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getLostPlace() {
        return lostPlace;
    }

    public void setLostPlace(String lostPlace) {
        this.lostPlace = lostPlace;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return "书籍类：" + bookName + '\t'  + lostPlace + '\t' + sdf.format(getLostTime());
    }
}
