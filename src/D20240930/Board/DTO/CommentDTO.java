package D20240930.Board.DTO;


public class CommentDTO {

  private int cNo;
  private int bNo;
  private String cDetail;
  private String delYn;
  private String instId;
  private java.sql.Timestamp instDt;
  private String updtId;
  private java.sql.Timestamp updtDt;


  public int getCNo() {
    return cNo;
  }

  public void setCNo(int cNo) {
    this.cNo = cNo;
  }


  public int getBNo() {
    return bNo;
  }

  public void setBNo(int bNo) {
    this.bNo = bNo;
  }


  public String getCDetail() {
    return cDetail;
  }

  public void setCDetail(String cDetail) {
    this.cDetail = cDetail;
  }


  public String getDelYn() {
    return delYn;
  }

  public void setDelYn(String delYn) {
    this.delYn = delYn;
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

  @Override
  public String toString() {
    return "\t[ " +
            "번호: " + cNo +
            ", 게시판번호: " + bNo +
            ", 댓글내용: '" + cDetail + '\'' +
            ", 삭제여부: '" + delYn + '\'' +
            ", 작성자: '" + instId + '\'' +
            ", 작성일시: " + instDt +
            ", 수정자: '" + updtId + '\'' +
            ", 수정일시: " + updtDt +
            "] ";
  }
}
