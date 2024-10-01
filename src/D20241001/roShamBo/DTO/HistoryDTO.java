package D20241001.roShamBo.DTO;

public class HistoryDTO {

    private int no;
    private String id;
    private int result;
    private int roshambo;
    private int point;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String name) {
        this.id = name;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getRoshambo() {
        return roshambo;
    }

    public void setRoshambo(int roshambo) {
        this.roshambo = roshambo;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
