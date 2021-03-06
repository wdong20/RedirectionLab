import java.util.*;

public class PigLatin {
    public static void main(String[] aaa) {
        Scanner n = new Scanner(System.in);
        while (n.hasNextLine()) {
            Scanner l = new Scanner(n.nextLine());
            while (l.hasNext()) {
                System.out.print(PigLatin.pigLatinBest(l.next()));

                if (l.hasNext()) {
                    System.out.print(" ");
                }
            }

            if (n.hasNextLine()) {
                System.out.println("");
            }
        }

        // // simple
        // System.out.print(PigLatin.pigLatinSimple("mock"));
        // System.out.println(" = ockmay?");

        // System.out.print(PigLatin.pigLatinSimple("pie"));
        // System.out.println(" = iepay?");

        // System.out.print(PigLatin.pigLatinSimple("david"));
        // System.out.println(" = avidday?");

        // System.out.print(PigLatin.pigLatinSimple("aaron"));
        // System.out.println(" = aaronhay?");

        // // digraphs
        // System.out.print(PigLatin.pigLatin("the"));
        // System.out.println(" = ethay?");

        // System.out.print(PigLatin.pigLatin("check"));
        // System.out.println(" = eckchay?");

        // System.out.print(PigLatin.pigLatin("skee"));
        // System.out.println(" = eeskay?");

        // System.out.print(PigLatin.pigLatin("emu"));
        // System.out.println(" = emuhay?");

        // System.out.print(PigLatin.pigLatin("grade"));
        // System.out.println(" = adegray?");

        // // best
        // System.out.print(PigLatin.pigLatinBest("*emu"));
        // System.out.println(" = *emu?");

        // System.out.print(PigLatin.pigLatinBest("4chan"));
        // System.out.println(" = 4chan?");

        // System.out.print(PigLatin.pigLatinBest("fish!"));
        // System.out.println(" = ishfay!?");

        // System.out.print(PigLatin.pigLatinBest("fish"));
        // System.out.println(" = ishfay?");

        // System.out.print(PigLatin.pigLatinBest("the."));
        // System.out.println(" = ethay.?");

        // System.out.print(PigLatin.pigLatinBest("cat!"));
        // System.out.println(" = atcay!?");

        // System.out.print(PigLatin.pigLatinBest("amazing?"));
        // System.out.println(" = amazinghay??");

        // System.out.print(PigLatin.pigLatinBest("apple%"));
        // System.out.println(" = applehay%?");
    }

    public static String pigLatinSimple(String s) {
        s = s.toLowerCase();

        char firstChar = s.charAt(0);
        if (PigLatin.lowerIsVowel(firstChar)) {
            return s + "hay";
        } else {
            return s.substring(1) + firstChar + "ay";
        }
    }

    public static boolean lowerIsVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    public static String pigLatin(String s) {
        if (s.length() >= 2) {
            String digraph = s.substring(0, 2).toLowerCase();
            if (PigLatin.lowerIsDigraph(digraph)) {
                return s.substring(2).toLowerCase() + digraph + "ay"; // added toLowerCase here and two lines up for
                                                                      // insurance
            }
        }
        // if first two characters do not make a digraph,
        // just use the simple piglatin method
        return PigLatin.pigLatinSimple(s);
    }

    public static boolean lowerIsDigraph(String s) {
        String[] digraphs = { "bl", "br", "ch", "ck", "cl", "cr", "dr", "fl", "fr", "gh", "gl", "gr", "ng", "ph", "pl",
                "pr", "qu", "sc", "sh", "sk", "sl", "sm", "sn", "sp", "st", "sw", "th", "tr", "tw", "wh", "wr" };
        for (String digraph : digraphs) {
            if (s.equals(digraph)) {
                return true;
            }
        }
        return false;
    }

    public static String pigLatinBest(String s) {
        if (!Character.isLetter(s.charAt(0))) {
            return s.toLowerCase();
        }

        char lastChar = s.charAt(s.length() - 1);
        if (Character.isLetterOrDigit(lastChar)) { // no punctuation
            return PigLatin.pigLatin(s);
        }

        return PigLatin.pigLatin(s.substring(0, s.length() - 1)) + lastChar;
    }
}