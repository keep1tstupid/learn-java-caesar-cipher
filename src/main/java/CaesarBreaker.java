import java.util.Arrays;

public class CaesarBreaker {
    private static final String alphabet  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static int[] countLetters(String message) {
        int[] letters = new int[26];
        message = message.toUpperCase();

        for (char c : message.toCharArray()) {
            if (!Character.isLetter(c)) {
                continue;
            }

            int index = alphabet.indexOf(c);
            int charCount = 0;

            for (int i = 0; i < message.length(); i++) {
                if (c == message.charAt(i)) {
                    charCount++;
                }
                letters[index] = charCount;
            }
        }
        return letters;
    }

    public static int indexOfIntArray(int[] array, int key) {
        int returnvalue = -1;
        for (int i = 0; i < array.length; ++i) {
            if (key == array[i]) {
                returnvalue = i;
                break;
            }
        }
        return returnvalue;
    }

    public static int maxIndex(int[] values) {
        int[] arr = new int[values.length - 1];
        System.arraycopy(values, 0, arr, 0, values.length - 1);
        Arrays.sort(arr);
        int x = arr.length - 1;
        return indexOfIntArray(values, arr[x]);
    }

    public static String decrypt(String encrypted) {

        int[] letters = countLetters(encrypted);
        int maxInd = maxIndex(letters);
        int distance = maxInd - 4; //distance to the most frequent letter 'e' (4 is index for 'e' in alphabet array)
        if (maxInd < 4) {
            distance = 26 - (4 - distance);
        }

        CaesarCipher cc = new CaesarCipher(26 - distance);
        return cc.encrypt(encrypted);
    }

    public static String halfOfString(String message, int start) {
        StringBuilder substr = new StringBuilder();

        for (int i = 0; i < message.length(); i++ ) {
            if ( i % 2 == start) {
                substr.append(message.charAt(i));
            }
        }
        return substr.toString();
    }

    public static int getKey(String s) {
        int key;
        int[] array = countLetters(s);
        int maxInd = maxIndex(array);
        int distance = maxInd - 4; //distance to the most frequent letter 'e' - 4 is index for 'e' in alphabet array

        if (maxInd < 4) {
            distance = 26 - (4 - distance);
        }

        key = 26 - distance;

        return key;
    }

    public static String decryptTwoKeys(String encrypted) {
        String substr1 = halfOfString(encrypted, 0);
        String substr2 =  halfOfString(encrypted, 1);

        int key1 = getKey(substr1);
        int key2 = getKey(substr2);

        CaesarCipher cc = new CaesarCipher(key1, key2);
        //System.out.println("Key1 is " + key1 + ", key2 is " + key2);
        return cc.encryptTwoKeys(encrypted);
    }

    public static void main(String[] args) {
        System.out.println(decryptTwoKeys("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!"));

        System.out.println(halfOfString("12121212", 1));

        System.out.println("Double decrypted text: \n"+ decryptTwoKeys("Xifqvximt tsdtlxzrx iijirvtl ek Uybi afvbw yehvv xyi gfqdse iekmfrrpzdrxzse fj xyi jzich sw tsdtlxrxzseec xifqvxic, fjkie xmmie zr xyi trwk, xyek klv nsipu rvfyeh yj zw xyvvi-hzqvrjmfrrp eeh ulijxzsew lfa xymekj zr xymj nsipu iiceki xf vetl sklvv eii melvvvrkpp xifqvximt. Xrov dsmmek e tzees xyvfyxl e hfsi-wvrqv rru gprremek e jcmxlk-gekl xyek rzfmuw gfpcmjmfrj nmkl sklvv ezvgprrvw ej kaf vbrqgpvw. Zx wyslpu klvvvjfvv esk jyitimji xyek tsdtlxzrx gvftvvkmvw esslx xyiji kvsdikvzg xymekj rru klvmi zrkiietxzse rvv tsdqfr-tceti eeh mdtfvkeex. Nlzpv klzw mj jxzpc r mecmu rvxydiex, ni afych pzov ks edieh xyek dsjx sw klv xifqvximt hyvwkmfrj giftci gfrtiir xyidwvpmij nmkl lrzv ks hf nmkl lfa xymekj rvv tservgkiu. Mk zw mdtfvkeex xyek ymxlnepw eii wljwmtmvrkpp jxiezkyx eeh wdsfxy ks wltgsix xyi himmmek sw wejx grvj, flx eesklvv ijwvrkmrp tisgiixp, aymtl av lwlecpp kebi jfv kieexvh, zw xyek ymxlnepw eii gfrkmeyfyj, mehviu tservgkmek E xf S, eeh rfx nlwk rtgvfbzqrxvpp. Xyi gfviijtfrumek wlfwmvpu fj gfqgykekmfrrp kvsdikvp zw swxvr vvjvviiu ks ej tsdtlxrxzseec ksgscsxc. R xsfh tfvkmfr sw fyi vjwsixj dep si gcejwzjziu ks fvpfrx ks xymj jysjzich eeh eii himmie sc egtcmtekmfrj zr e zrvzikc sw fxyii wmvpuw, klv gvvhzgkmfr sw klv jxiytxlvv fj jfpuiu gvfxvmew eeh xyi vvgfrjxiytxzse fj llqrr sikrrj sizrx kaf. Xyi lrpcqrvb fj slv afvb zw jrwk rpxsimkldw xyek zqgpvqvrk deklvqrxzgrp qfhvpj ks swjvv mewzkyxj zrks eeh eewniiw xf jytl ulijxzsew.\n" +
                "\n" +
                "Av rvv vbgpfvzrx zwjyvw wlgy rw lfa xvgyrzulij wsi jsczzrx gvffcidw grr fv umjgfzvvvh, zqgvfzvh, rrrppdvh, rru uidsewkvrxvh xf si gfviitx si ftkmdec. Av vbgitx xf debi pveumek gfrkvzflxzsew me tsdtlxrxzseec xifqvxic, xifqvximt dsuicmek, ueke wkvlgkyiij, lzky-giijfvdeegv tsdtlxzrx, M/S-iwjzgziegp wsi vbkiirrp qvqfvp, kvsxvrtymt zrwsiqrxzse jcjxvqj (KZW), fzscsxmtec tsdtlxzrx, eeh hrxr tsdtiijwzse.\n" +
                "\n" +
                "Sitelwv fj xyi kvsdikvzg rrxlvv fj xyi tycjmtec nsipu zr aymtl av cmmi, xifqvximt gvffcidw eimji me rrp rvve xyek zrkiietxj nmkl xyi tycjmtec nsipu. Kvsdikvzg gfqgykmek jfglwvw se uijmxrzrx, eeeccqmek, rru zqgpvqvrkmek iwjzgziex eckfvzxyqj wsi xifqvximt gvffcidw. Klv xifqvximt tsdtlxzrx xvfyg fj xyi hvtrvkqvrk zw mexvveekmfrrpcc vvrfaeiu wsi zxj tseximsykmfrj ks xyi jlruediexrp tisspvqj zr gfqgykekmfrrp kvsdikvp, euhiijwzrx dejwzzv ueke qrrrkvqvrk zwjyvw me xifqvximt gvffcidw, rru rtgppmek kvsdikvzg xvgyrzulij ks e zrvzikc sw rvvej, megcyumek qfpvglprv fzscsxc, xifqvximt dsuicmek, issskmtw, xifkieglzg mejfvdekmfr wpwkidw, vgfpfkp, eeh tysksemtw.\n" +
                "\n" +
                "Xyi kislt etxzzvpp tscprffvrxvw azxy fxyii xvfygw azxyme klv uigeixdiex eeh azxy klv iijirvtlvvj zr sklvv hvtrvkqvrkw ek Uybi. Klvc gfpcessieki azxy wetycxp zr Qrxyidekmtw, Smfpfkp, Fzstlvqzwkvp, Icitximtec rru Tsdtlxvv Iekzrviimek, rru klv Emtlfprw Wtlfsc fj Iezzvfrdiex. Sipseh Hlov, xyi kislt ecwf tscprffvrxvw azxy iijirvtlvvj rx zrvzslw xft mewkmkykij. Fvgryji sw zxj uigxy rru svveuxy, xyi kvsdikvzg gfqgykmek kislt ek Uybi mj rvxyrfcc xyi xft kvsdikvzg gfqgykmek kislt me klv eekmfr."));
    }
}