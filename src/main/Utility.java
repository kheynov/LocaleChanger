package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
    private final static char[] replaceable_en = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o',
            'p', '[', ']', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';', '\'', 'z',
            'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/', '?', ' ', '`'};
    private final static char[] replaceable_ru = {'й', 'ц', 'у', 'к', 'е', 'н', 'г', 'ш', 'щ',
            'з', 'х', 'ъ', 'ф', 'ы', 'в', 'а', 'п', 'р', 'о', 'л', 'д', 'ж', 'э', 'я',
            'ч', 'с', 'м', 'и', 'т', 'ь', 'б', 'ю', '.', ',', ' ', 'ё'};

    public static String changeLanguage(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean letterCase = Character.isUpperCase(ch);
            ch = Character.toLowerCase(ch);
            if (isInArray(replaceable_en, ch)) {
                int id = getIdOfCharacter(replaceable_en, ch);
                if (id == -1) {
                    System.out.println("error");
                }
                ch = replaceable_ru[id];
            } else {
                int id = getIdOfCharacter(replaceable_ru, ch);
                ch = replaceable_en[id];
            }
            if (letterCase) {
                ch = Character.toUpperCase(ch);
            }
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    private static boolean isInArray(char[] array, char ch) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ch) {
                return true;
            }
        }
        return false;
    }

    private static int getIdOfCharacter(char[] arr, char ch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ch) {
                return i;
            }
        }
        return -1;
    }
    public static String getTextFromHTML(String htmlText) {

        String result = "";

        Pattern pattern = Pattern.compile("<[^>]*>");
        Matcher matcher = pattern.matcher(htmlText);
        final StringBuffer text = new StringBuffer(htmlText.length());

        while (matcher.find()) {
            matcher.appendReplacement(
                    text,
                    " ");
        }

        matcher.appendTail(text);

        result = text.toString().trim();

        return result;
    }

}
class UtilityTest{
    public static void main(String[] args) {

        String text = "Шалящий фавн прикинул объём горячих звезд этих вьюжных царств.";
        text = Utility.changeLanguage(text);
        System.out.println(text);
    }
}