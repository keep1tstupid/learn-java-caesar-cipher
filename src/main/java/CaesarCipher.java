
public class CaesarCipher {
    private final String alphabet  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int key1;
    private int key2;

    public CaesarCipher(int key) {
        shiftedAlphabet1 = alphabet.substring(key) + alphabet.substring(0,key);
        key1 = key;
    }

    public CaesarCipher(int key1, int key2) {
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
    }

    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input.toUpperCase());

        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            if(idx != -1) {
                char newChar = shiftedAlphabet1.charAt(idx);
                encrypted.setCharAt(i, Character.isLowerCase(input.charAt(i)) ? Character.toLowerCase(newChar) : newChar);
            }
        }
        return encrypted.toString();
    }

    public String encryptTwoKeys(String input) {
        StringBuilder encrypted = new StringBuilder(input.toUpperCase());

        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            if (i % 2 == 0 && idx != -1) {
                char newChar = shiftedAlphabet1.charAt(idx);
                encrypted.setCharAt(i, Character.isLowerCase(input.charAt(i)) ? Character.toLowerCase(newChar) : newChar);
            } else if (i % 2 != 0 && idx != -1 ) {
                char newChar = shiftedAlphabet2.charAt(idx);
                encrypted.setCharAt(i, Character.isLowerCase(input.charAt(i)) ? Character.toLowerCase(newChar) : newChar);
            }
        }
        return encrypted.toString();
    }

    public static void testCaesar() {

        CaesarCipher cc = new CaesarCipher(9,22);
        System.out.println(cc.encryptTwoKeys("Uybi Gfqgykii Jgziegv Uigeixdiex Smiizzin\n" +
                "\n" +
                "Sei sw klv deec lrpcqrvbw sw fyi jytgvwj yej sivr jiyzxwyc tscprffvrxzsew edsek hzjwiiiex kisltj nmklzr xyi hvtrvkqvrk, azxy iijirvtl kisltj zr sklvv hvtrvkqvrkw ek Uybi, nmkl sklvv mewkmkykij, eeh azxy zruyjxic. Rw av dsmi mexf klv zrwsiqrxzse rkv, xyi jfglw sw jgziegv zw wymwxzrx wvfq xyi hzwtsmiic sw ein zrwsiqrxzse ks xyi gfqgykekmfrrpcc mexvrjmmi xrwb fj tistijwzrx rru rrrppdzrx zrwsiqrxzse.\n" +
                "\n" +
                "Ni lrzv fykwkeehzrx gvfkiedw me xifqvximt tsdtlxzrx; mexvveik jcjxvqj, rvxnsiozrx, eeh wvglvzxp; fzscsxmtec tsdtlxzrx; qvqfvp jcjxvqj rru dejwzzv ueke qrrrkvqvrk; eeh pveirzrx rru dsuicmek. Klv iijirvtl mexvvvwkw sw fyi wetycxp fzvvceg nmkl xyiji eiirw eeh azxy iijirvtlvv eiirw me fxyii umjgztcmeij jytl ej smfpfkp, iekzrviimek, eeeskitlescsxc, rru vrmmiseqvrkec jgziegvw.\n" +
                "\n" +
                "GJ Uigx Tysks Av rpjs hf nsio me r eydfvv sw fxyii zqgsixrrk rvvej zrtplhzrx tsdtlxvv kieglzgj rru mmjyrpzdrxzse, wvrjsi eikafvbw, eydiimtec rrrppwzw, jswxneii iekzrviimek, tsdtciomkc xyifvp, eeh vfffxzgj.\n" +
                "\n" +
                "Klv uigeixdiex mj rvxyrfcc yemhyv zr xyi wpqsmfwzw xyek vbzwkw fvxnivr xyi iuytekmfr kislt eeh xyi vvwveigy wetycxp. Xyi wprvvxc fvxnivr xyid yej sivr e ovc xf klv jytgvwj zr gfrkmeyrpcc vvjfvdmek xyi glvimtycyd rru zrkixvrxzrx iijirvtl eeh iuytekmfr. Klv uigeixdiex mj lwzrx r uyrp egtisrgy ks gfqsmei vvwveigy rru vhlgrxzse. Fimekzrx iijirvtl mexf klv tyivzglplq mj klv sijx arc xf kvrme jxlhvrkw esslx xyi qfwk rhmeegvh xvgyrfpfkp rru ks hzwjidmeeki xyi prxvwk uimicsgqvrkw sw tsdtlxzrx kitlescsxc me jstmvxp.\n" +
                "\n" +
                "TW Hvtk Glfxf Ni iegfyiexi yehvvxvrhleki wkyuiexj ks kvx mezfpmiu nmkl sekfmek qrnfv vvwveigy gvfnvgkw xyvfyxl xyi G-WLVW gvfkied, yehvvxvrhleki xyijij, Vvwveigy Vbgiimvrti jfv Yehvvxvrhlekij (VVY) jygtfvk, mehvtvruiex wkyumvw, vxt. Wfqv fj slv iogvtkmfrrp jzvjx qrnfvj xvrhleki azxy umjxzrtxzse, aymtl mezfpmij r jmxrzjzgrrk iijirvtl gfqgseiex, rru zr qrrp tejij klv iijirvtl lrw vvwlpkiu zr tlfcmtekmfrj zr pveumek gfrwiiiegvw.\n" +
                "\n" +
                "Xyi idmeiegv fj slv vvwveigy rru kirgymek jrglpkc mj klv smxkvwk jxiiekkl sw klv uigeixdiex. Deec jrglpkc qvqsiiw lrzv sivr vvgfkemqiu sskl ek lrzzvvjmkc eeh rrxzseec cimicw jfv xyizv iogvpciegv zr vvwveigy, iuytekmfr, rru jiizzgv. Lzkypp mmjmspv, qlpkmumjgztcmeeic tisaitxj rvv sizrx tsehlgkiu, wgsewfvvh fp meimfyj wyehzrx rkvrtmvw.\n" +
                "\n" +
                "Xyi hvtrvkqvrk gvfzzhvw ee vbkvvqvpp jxzqlprxzrx, tisuytxzzv, eeh jimvrupp vrmmiseqvrk zr xyi jfvd fj gcejwisfq, fjwmti, rru ces jtrgv; gfqgykmek mejiejxiytxlvv; xvetlzrx jygtfvk; eeh kieuyrxv wicpfajlztj rru rwjmjxrrkwymgw. Zx ieespvw jrglpkc eeh wkyuiexj ks etgfqgpzwy klvmi wycp tfxvrkmrp. Klv uigeixdiex mj tsewkvlgkiu ks iegfyiexi merfzrxzzv tscprffvrxzsew edsek xyi wtmvrtij, iekzrviimek, vrmmiseqvrkec jxlhzij, eeh qvhzgzrv."));
    }

    public static void main(String[] args) {
        testCaesar();
    }
}