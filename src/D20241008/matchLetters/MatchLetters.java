package D20241008.matchLetters;

import java.util.Random;

public class MatchLetters {

    private final String letter;
    private final String mean;
    private final StringBuilder curLetter;
    private int cnt = 0;
    private final String[] words = {
            "apple", "banana", "cherry", "date", "elderberry",
            "fig", "grape", "honeydew", "kiwi", "lemon",
            "mango", "nectarine", "orange", "papaya", "quince",
            "raspberry", "strawberry", "tangerine", "ugli", "vanilla",
            "watermelon", "apricot", "blackberry", "cantaloupe", "dragonfruit",
            "eggplant", "grapefruit", "hazelnut", "kiwifruit", "lime",
            "melon", "nectar", "olive", "peach", "pear",
            "plum", "pomegranate", "quinoa", "radish", "spinach",
            "tomato", "zucchini", "asparagus", "broccoli", "carrot",
            "cucumber", "lettuce", "onion", "pepper", "potato",
            "pumpkin", "squash", "turnip", "beet", "cauliflower",
            "celery", "corn", "garlic", "ginger", "herb",
            "jalapeno", "leek", "mushroom", "parsnip", "sweet potato",
            "taro", "yam", "artichoke", "endive", "fennel",
            "kale", "radicchio", "sorrel", "shallot", "tamarind",
            "watercress", "arugula", "bok choy", "chard", "cabbage",
            "dandelion", "mustard", "purslane", "rhubarb", "sunchoke",
            "cassava", "plantain", "pistachio", "walnut", "cashew",
            "pecan", "hazelnut", "almond", "macadamia", "coconut",
            "red bell pepper", "green bean", "yellow squash", "butternut squash", "acorn squash",
            "baby spinach", "arugula", "beet greens", "broccoli rabe", "savory",
            "coriander", "dill", "fenugreek", "marjoram", "oregano",
            "parsley", "sage", "tarragon", "thyme", "wasabi",
            "zucchini blossom", "water chestnut", "almond butter", "peanut butter", "chocolate",
            "vanilla bean", "cinnamon", "nutmeg", "cloves", "allspice",
            "star anise", "cayenne pepper", "black pepper", "white pepper", "smoked paprika",
            "turmeric", "ginger root", "saffron", "cardamom", "lemongrass",
            "kefir", "quark", "ricotta", "feta", "mozzarella",
            "cheddar", "parmesan", "gruyere", "gorgonzola", "camembert",
            "brie", "cream cheese", "cottage cheese", "labneh", "blue cheese",
            "pecorino", "provolone", "string cheese", "cheese spread", "taco seasoning",
            "curry powder", "Italian seasoning", "Herbes de Provence", "chili powder", "cajun seasoning",
            "garam masala", "shichimi togarashi", "chili flakes", "Szechuan pepper", "black sesame",
            "white sesame", "chia seeds", "flax seeds", "pumpkin seeds", "sunflower seeds",
            "hemp seeds", "quinoa flakes", "oatmeal", "barley", "millet",
            "bulgur", "farro", "spelt", "buckwheat", "rice",
            "wild rice", "couscous", "cornmeal", "polenta", "tapioca",
            "sago", "yeast", "baking powder", "baking soda", "cornstarch",
            "gelatin", "agar-agar", "pectin", "sugar", "brown sugar",
            "powdered sugar", "honey", "maple syrup", "agave nectar", "molasses",
            "corn syrup", "coconut sugar", "date syrup", "stevia", "xylitol",
            "monk fruit", "sweetener", "salt", "sea salt", "kosher salt",
            "pink Himalayan salt", "smoked salt", "herb salt", "garlic salt", "onion salt",
            "seasoned salt", "fruit juice", "fruit smoothie", "vegetable juice", "carrot juice",
            "green juice", "almond milk", "soy milk", "oat milk", "coconut milk",
            "rice milk", "hemp milk", "cashew milk", "hazelnut milk", "flax milk",
            "quinoa milk", "buttermilk", "kefir", "yogurt", "cream",
            "half and half", "sour cream", "coconut cream", "heavy cream", "whipped cream",
            "coconut yogurt", "nut yogurt", "cheese sauce", "chocolate sauce", "caramel sauce",
            "barbecue sauce", "hot sauce", "soy sauce", "teriyaki sauce", "vinaigrette",
            "salad dressing", "salsa", "guacamole", "hummus", "tzatziki",
            "pesto", "mayo", "mustard", "ketchup", "relish",
            "tartar sauce", "chimichurri", "aioli", "romesco", "tikka masala",
            "curry sauce", "enchilada sauce", "coconut curry", "peanut sauce"
    };

    private final String[] meanings = {
            "사과", "바나나", "체리", "대추", "엘더베리",
            "무화과", "포도", "허니듀", "키위", "레몬",
            "망고", "넥타린", "오렌지", "파파야", "모과",
            "라즈베리", "딸기", "귤", "우글리", "바닐라",
            "수박", "살구", "블랙베리", "칸탈루프", "용과",
            "가지", "자몽", "헤이즐넛", "키위", "라임",
            "멜론", "꿀", "올리브", "복숭아", "배",
            "자두", "석류", "퀴노아", "무", "시금치",
            "토마토", "주키니", "아스파라거스", "브로콜리", "당근",
            "오이", "양상추", "양파", "고추", "감자",
            "호박", "스쿼시", "순무", "비트", "콜리플라워",
            "셀러리", "옥수수", "마늘", "생강", "허브",
            "할라피뇨", "리크", "버섯", "파슬리", "고구마",
            "타로", "얌", "아티초크", "엔다이브", "펜넬",
            "케일", "라디키오", "소렐", "샬롯", "타마린드",
            "워터크레세", "아루굴라", "청경채", "차드", "양배추",
            "민들레", "겨자", "포슬레인", "룸바르", "썬초크",
            "카사바", "플랜테인", "피스타치오", "호두", "캐슈",
            "피칸", "헤이즐넛", "아몬드", "마카다미아", "코코넛",
            "붉은 피망", "녹두", "노란 스쿼시", "버터넛 스쿼시", "밤호박",
            "베이비 시금치", "아루굴라", "비트 그린", "브로콜리 랍", "세이바리",
            "고수", "딜", "메리골드", "마조람", "오레가노",
            "파슬리", "세이지", "타라곤", "타임", "와사비",
            "주키니 꽃", "수수", "아몬드 버터", "땅콩 버터", "초콜릿",
            "바닐라 빈", "계피", "넛멕", "클로브", "올스파이스",
            "스타 아니스", "카이엔 페퍼", "블랙 페퍼", "화이트 페퍼", "훈제 파프리카",
            "강황", "생강 뿌리", "사프란", "카다멈", "레몬그라스",
            "케피르", "퀘르크", "리코타", "페타", "모짜렐라",
            "체다", "파르메산", "그뤼에르", "고르곤졸라", "카망베르",
            "브리", "크림치즈", "코티지 치즈", "라브네", "블루 치즈",
            "페코리노", "프로볼론", "스트링 치즈", "치즈 스프레드", "타코 시즈닝",
            "커리 파우더", "이탈리안 시즈닝", "프 Provence", "칠리 파우더", "카준 시즈닝",
            "가람 마살라", "시치미 토가라시", "칠리 플레이크", "스촨 페퍼", "블랙 참깨",
            "화이트 참깨", "치아 씨앗", "플랙스 씨앗", "호박 씨앗", "해바라기 씨앗",
            "헴프 씨앗", "퀴노아 플레이크", "오트밀", "보리", "기장",
            "불구르", "파로", "스펠트", "메밀", "쌀",
            "야생 쌀", "쿠스쿠스", "옥수수 가루", "폴렌타", "타피오카",
            "사고", "효모", "베이킹 파우더", "베이킹 소다", "옥수수 전분",
            "젤라틴", "아가 아가", "펙틴", "설탕", "갈색 설탕",
            "파우더 설탕", "꿀", "메이플 시럽", "아가베 넥타르", "당밀",
            "옥수수 시럽", "코코넛 설탕", "대추 시럽", "스테비아", "자일리톨",
            "몬크 프루트", "감미료", "소금", "바다 소금", "코셔 소금",
            "핑크 히말라야 소금", "훈제 소금", "허브 소금", "마늘 소금", "양파 소금",
            "시즈닝 소금", "과일 주스", "과일 스무디", "채소 주스", "당근 주스",
            "그린 주스", "아몬드 우유", "콩 우유", "오트 우유", "코코넛 우유",
            "쌀 우유", "헴프 우유", "캐슈 우유", "헤이즐넛 우유", "플랙스 우유",
            "퀴노아 우유", "버터밀크", "케피르", "요거트", "크림",
            "하프 앤 하프", "사워 크림", "코코넛 크림", "헤비 크림", "휘핑 크림",
            "코코넛 요거트", "넛 요거트", "치즈 소스", "초콜릿 소스", "카라멜 소스",
            "바비큐 소스", "핫 소스", "간장", "테리야키 소스", "비네그레트",
            "샐러드 드레싱", "살사", "과카몰리", "후무스", "차지키",
            "페스토", "마요", "머스타드", "케첩", "릴리시",
            "타르타르 소스", "치미추리", "아이올리", "로메스코", "티카 마살라",
            "커리 소스", "엔칠라다 소스", "코코넛 커리", "땅콩 소스"
    };


    public MatchLetters() {
        Random random = new Random();
        int rand = random.nextInt(words.length);
        this.letter = words[rand];
        this.mean = meanings[rand];
        this.curLetter = new StringBuilder(letter.replaceAll("[^ ]", "*"));
    }

    public String getCurLetter() {
        return curLetter.toString();
    }

    public int getCnt() {
        return cnt;
    }

    public String getMean() {
        return mean;
    }

    public int chkLetter(char c) {
        int result = -1;
        char[] cs = letter.toCharArray();


        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == c) {
                curLetter.setCharAt(i, c);
                result = 0;
            }
        }

        if (letter.equals(curLetter.toString())) {
            result = 1;
        }

        cnt++;
        return result;
    }
}
