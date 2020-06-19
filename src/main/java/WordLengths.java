import edu.duke.*;

public class WordLengths {

    public static void countWordLengths(FileResource resource, int[] counts) {
        for (String word : resource.words()) {
            word = word.toLowerCase();
            int charCount = 0;
            for (int i = 0; i < word.length(); i++) {
                if (((i == 0 || i == (word.length()-1))) && !Character.isLetter(word.charAt(i))) {
                    continue;
                }
                charCount++;
            }
            if (charCount >= counts.length) {
                counts[counts.length] += 1;
            } else {
                counts[charCount] += 1;
            }
        }
    }

    public static int indexOfMax(int[] values) {
        int max = -1;

        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] > values[i + 1]) {
                max = i;
            }
        }
        return max;
    }

    public static void testCountWordLengths() {
        FileResource fr = new FileResource();
        int[] counts = new int[31];

        countWordLengths(fr, counts);

        for (int i = 0; i < counts.length; i++) {
            System.out.println(counts[i] + " words with " + i + " letters.");
        }
        System.out.println("max index is " + indexOfMax(counts));
    }

    public static void main(String[] args) {
        testCountWordLengths();
    }
}

