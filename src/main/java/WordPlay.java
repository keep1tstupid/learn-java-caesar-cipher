public class WordPlay {

    public static boolean isVowel(char ch) {
        char chLower = Character.toLowerCase(ch);
        switch (chLower) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    public static String replaceVowels(String phrase, char ch) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < phrase.length(); i++) {
            if (isVowel(phrase.charAt(i))) {
                res.append(ch);
            } else {
                res.append(phrase.charAt(i));
            }
        }
        return res.toString();
    }

    public static String emphasize(String phrase, char ch) {
        StringBuilder res = new StringBuilder();
        char chLower = Character.toLowerCase(ch);
        String str = phrase.toLowerCase();

        for (int i = 0; i < phrase.length(); i++) {
            if (str.charAt(i) == chLower && (i + 1) % 2 == 0) {
                res.append("+"); // even number location
            } else if (str.charAt(i) == chLower && (i + 1) % 2 != 0) {
                res.append("*"); // odd number location
            } else {
                res.append(phrase.charAt(i)); // other cases
            }
        }
        return res.toString();
    }

    public static void test() {
        String test = "ololololo olol lol";
        String test2 = replaceVowels(test, '*');
        System.out.println(test2);
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }

    public static void main(String[] args) {
        test();
    }
}


