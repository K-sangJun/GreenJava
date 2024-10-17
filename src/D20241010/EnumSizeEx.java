package D20241010;

public class EnumSizeEx {
    enum CoffeeSize{
        //커피사이즈는 소 중 대 가있다
        //소는 100milliliters, 중은 200milliliters, 대는 300milliliters
        //커피사이즈를 정하면 enum 필드에 해당하는 milliliter 값이 저장된다.
        //
        S(100), M(200), L(300);

        private int ml;

        CoffeeSize(int size) {
            ml = size;
        }

        public int getMl() {
            return ml;
        }
    }

    public static void main(String[] args) {
        //중간사이즈를 생성하고
        CoffeeSize mSize = CoffeeSize.M;

        //선택한 사이즈를 콘솔에 출력하고,
        System.out.println(mSize);

        //선택한 사이즈의 milliliter 값을 출력
        System.out.println(mSize.getMl());
    }
}
