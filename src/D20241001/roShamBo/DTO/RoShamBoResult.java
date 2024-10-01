package D20241001.roShamBo.DTO;

public class RoShamBoResult {

    private String id;
    private String name;
    private int rWin;
    private int sWin;
    private int bWin;
    private int point;
    private float rPer;
    private float sPer;
    private float bPer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getrWin() {
        return rWin;
    }

    public void setrWin(int rWin) {
        this.rWin = rWin;
    }

    public int getsWin() {
        return sWin;
    }

    public void setsWin(int sWin) {
        this.sWin = sWin;
    }

    public int getbWin() {
        return bWin;
    }

    public void setbWin(int bWin) {
        this.bWin = bWin;
    }

    public float getrPer() {
        return rPer;
    }

    public void setrPer(float rPer) {
        this.rPer = rPer;
    }

    public float getsPer() {
        return sPer;
    }

    public void setsPer(float sPer) {
        this.sPer = sPer;
    }

    public float getbPer() {
        return bPer;
    }

    public void setbPer(float bPer) {
        this.bPer = bPer;
    }

    @Override
    public String toString() {
        return "[ " +
               "아이디: '" + id + '\'' +
               ", 이름: '" + name + '\'' +
               ", 점수: " + point +
               ", 바위승: " + rWin +
               ", 가위승: " + sWin +
               ", 보승: " + bWin +
               ", 바위승률: " + rPer +
               ", 가위승률: " + sPer +
               ", 보승률: " + bPer +
               "] ";
    }
}
