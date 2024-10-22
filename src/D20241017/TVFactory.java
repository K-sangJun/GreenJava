package D20241017;

public class TVFactory {

    static TV CreateTV(String brand){
        TV tv = null;
        switch(brand.toLowerCase().trim()){
            case "lg":
                tv = new LgTV();
                break;
            case  "samsung":
                tv = new SamsungTV();
                break;
        }
        return tv;
    }

}
