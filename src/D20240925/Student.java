package D20240925;

public class Student {

    private int no;
    private String name;
    private int schoolYear;
    private int clazz;
    private int sno;
    private int korScore;
    private int engScore;
    private int mathScore;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public int getClazz() {
        return clazz;
    }

    public void setClazz(int clazz) {
        this.clazz = clazz;
    }

    public int getKorScore() {
        return korScore;
    }

    public void setKorScore(int korScore) {
        this.korScore = korScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    @Override
    public String toString() {
        return
                "no: " + no +
                ", name: '" + name + '\'' +
                ", schoolYear: " + schoolYear +
                ", clazz: " + clazz +
                ", sno: " + sno +
                ", korScore: " + korScore +
                ", engScore: " + engScore +
                ", mathScore: " + mathScore;
    }
}
