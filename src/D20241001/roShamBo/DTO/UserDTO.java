package D20241001.roShamBo.DTO;


public class UserDTO {

  private String id;
  private String pw;
  private String userGbn;
  private String name;
  private String instId;
  private java.sql.Timestamp instDt;
  private String updtId;
  private java.sql.Timestamp updtDt;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getPw() {
    return pw;
  }

  public void setPw(String pw) {
    this.pw = pw;
  }


  public String getUserGbn() {
    return userGbn;
  }

  public void setUserGbn(String userGbn) {
    this.userGbn = userGbn;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
    return "[" +
            "id='" + id + '\'' +
            ", pw='" + pw + '\'' +
            ", userGbn='" + userGbn + '\'' +
            ", name='" + name + '\'' +
            ", instId='" + instId + '\'' +
            ", instDt=" + instDt +
            ", updtId='" + updtId + '\'' +
            ", updtDt=" + updtDt +
            ']';
  }
}
