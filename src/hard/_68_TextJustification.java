package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _68_TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        List<String> temp = new ArrayList<>();
        String currentWord;
        int count = 0;
        int currentWordsCount = 0;
        int currentLen = 0;
        for (; count < words.length; count++) {
            currentWord = words[count];
            if (currentLen + currentWord.length() < maxWidth - 1) {
                currentLen += currentWord.length();
                if (currentWordsCount > 0) {
                    currentLen++;
                }
                temp.add(currentWord);
                currentWordsCount++;
            } else if (currentLen + currentWord.length() == maxWidth - 1) {
                temp.add(currentWord);
                StringBuilder line = new StringBuilder();

                line.append(String.join(" ", temp.toArray(new String[0])));
                while (line.length() < maxWidth) {
                    line.append(' ');
                }
                result.add(line.toString());
                temp.clear();
                currentLen = 0;
                currentWordsCount = 0;
            } else {
                if (currentLen == 0) {
                    StringBuilder line = new StringBuilder();
                    line.append(currentWord);
                    result.add(line.toString());
                } else {
                    if (temp.size() == 1) {
                        StringBuilder line = new StringBuilder();
                        line.append(temp.get(0));
                        while (line.length() < maxWidth) {
                            line.append(' ');
                        }
                        result.add(line.toString());

                    } else {
                        StringBuilder line = new StringBuilder();
                        int spaces = (maxWidth - currentLen + currentWordsCount - 1) / (currentWordsCount - 1);
                        StringBuilder space = new StringBuilder();
                        while (spaces-- > 0) {
                            space.append(' ');
                        }
                        int exspaces = (maxWidth - currentLen + currentWordsCount - 1) % (currentWordsCount - 1);

                        for (int i = 0; i < temp.size() - 1; i++) {
                            line.append(temp.get(i));
                            line.append(space.toString());
                            if (exspaces-- > 0) {
                                line.append(' ');
                            }
                        }

                        line.append(temp.get(temp.size() - 1));
                        result.add(line.toString());
                    }
                    temp.clear();

                    temp.add(currentWord);
                    currentLen = currentWord.length();
                    currentWordsCount = 1;
                }
            }

        }
        if (temp.size() > 0) {
            StringBuilder line = new StringBuilder();
            line.append(String.join(" ", temp.toArray(new String[0])));
            while (line.length() < maxWidth) {
                line.append(' ');
            }
            result.add(line.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        _68_TextJustification s = new _68_TextJustification();
        String[] words = { "a" };
        int maxWidth = 2;

        System.out.println(Arrays.toString(s.fullJustify(words, maxWidth).toArray()));
        System.out.println("enough to explain to".length());
        // ["Science is what we","understand well","enough to explain to","a computer.
        // Art is","everything else we","do "]
    }
}
