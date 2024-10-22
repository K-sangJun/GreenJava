package D20241017;

public class LgTV implements TV{

    @Override
    public void turnOn() {
        System.out.println("LG TV is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("LG TV is turned off");
    }

    @Override
    public void volumeUp() {
        System.out.println("LG TV volume up");
    }

    @Override
    public void volumeDown() {
        System.out.println("LG TV volume down");
    }

}
