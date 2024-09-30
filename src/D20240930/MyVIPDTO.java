package D20240930;

import java.sql.Date;
import java.sql.Timestamp;

public class MyVIPDTO {

    private String name;
    private Date birth;
    private Timestamp regDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "MyVIPDTO{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                ", regDate=" + regDate +
                '}';
    }
}
