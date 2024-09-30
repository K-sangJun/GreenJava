package D20240930.Board.DTO;


import java.util.ArrayList;

public class BoardDTO {

    private int bNo;
    private String bGbn;
    private String bGbn_nm;
    private String title;
    private String detail;
    private String instId;
    private java.sql.Timestamp instDt;
    private String updtId;
    private java.sql.Timestamp updtDt;
    private ArrayList<CommentDTO> comments = new ArrayList<>();

    public int getBNo() {
        return bNo;
    }

    public void setBNo(int bNo) {
        this.bNo = bNo;
    }


    public String getBGbn() {
        return bGbn;
    }

    public void setBGbn(String bGbn) {
        this.bGbn = bGbn;
    }

    public String getbGbn_nm() { return bGbn_nm;}

    public void setbGbn_nm(String bGbn_nm) {this.bGbn_nm = bGbn_nm;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
    }


    public java.sql.Timestamp getInstDt() {
        return instDt;
    }

    public void setInstDt(java.sql.Timestamp instDt) {
        this.instDt = instDt;
    }


    public String getUpdtId() {
        return updtId;
    }

    public void setUpdtId(String updtId) {
        this.updtId = updtId;
    }


    public java.sql.Timestamp getUpdtDt() {
        return updtDt;
    }

    public void setUpdtDt(java.sql.Timestamp updtDt) {
        this.updtDt = updtDt;
    }

    public ArrayList<CommentDTO> getComments() { return comments; }

    public void setComments(ArrayList<CommentDTO> comments) { this.comments = comments; }

    @Override
    public String toString() {
        return "[ " +
                "번호: " + bNo +
                ", 구분: '" + bGbn_nm + '\'' +
                ", 제목: '" + title + '\'' +
                ", 내용: '" + detail + '\'' +
                ", 작성자: '" + instId + '\'' +
                ", 작성일시: " + instDt +
                ", 수정자: '" + updtId + '\'' +
                ", 수정일시: " + updtDt +
                " ]";
    }
}
