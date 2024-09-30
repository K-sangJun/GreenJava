package D20240926;

public class ClubDTO {

    private String clubName;
    private String roomNo;

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return  "clubName=" + clubName + ", roomNo=" + roomNo + '}';
    }
}
