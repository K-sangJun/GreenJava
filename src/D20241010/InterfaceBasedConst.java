package D20241010;

public class InterfaceBasedConst {

    public static void main(String[] args) {
        int sc = Scale.DO;
        
        switch (sc){
            case Scale.DO:
                System.out.println("도~");
                break;
            case Scale.RE:
                System.out.println("레~");
                break;
            case Scale.ME:
                System.out.println("미~");
                break;
            case Scale.FA:
                System.out.println("파~");
                break;
            case Scale.SO:
                System.out.println("솔~");
                break;
            case Scale.RA:
                System.out.println("라~");
                break;
            case Scale.TI:
                System.out.println("시~");
                break;
            default:
                System.out.println("음계에 없습니다.");
                break;
        }
        
    }
    
}
