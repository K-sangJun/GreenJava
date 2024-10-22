package D20241017;

public class SamsungTV implements TV {

    @Override
    public void turnOn() {
        System.out.println("SamSung TV is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("SamSung TV is turned off");
    }

    @Override
    public void volumeUp() {
        System.out.println("SamSung TV volume up");
    }

    @Override
    public void volumeDown() {
        System.out.println("SamSung TV volume down");
    }

}
