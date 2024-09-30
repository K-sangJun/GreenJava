package D20240926;

public class StudentDTO {

    private String stdName;
    private String addr;

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return  "이름: '" + stdName + ", 지역: " + addr + '}';
    }
}
