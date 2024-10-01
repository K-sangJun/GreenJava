package D20241001.roShamBo.DTO;


public class CodeinfoDTO {

  private String cd;
  private String upCd;
  private String cdNm;
  private String cdDtl;
  private String cdSet1;
  private String cdSet2;
  private String cdSet3;


  public String getCd() {
    return cd;
  }

  public void setCd(String cd) {
    this.cd = cd;
  }


  public String getUpCd() {
    return upCd;
  }

  public void setUpCd(String upCd) {
    this.upCd = upCd;
  }


  public String getCdNm() {
    return cdNm;
  }

  public void setCdNm(String cdNm) {
    this.cdNm = cdNm;
  }


  public String getCdDtl() {
    return cdDtl;
  }

  public void setCdDtl(String cdDtl) {
    this.cdDtl = cdDtl;
  }


  public String getCdSet1() {
    return cdSet1;
  }

  public void setCdSet1(String cdSet1) {
    this.cdSet1 = cdSet1;
  }


  public String getCdSet2() {
    return cdSet2;
  }

  public void setCdSet2(String cdSet2) {
    this.cdSet2 = cdSet2;
  }


  public String getCdSet3() {
    return cdSet3;
  }

  public void setCdSet3(String cdSet3) {
    this.cdSet3 = cdSet3;
  }

  @Override
  public String toString() {
    return "[ 코드: " + this.cd + ", 명: " + this.cdNm + " ]";
  }
}
