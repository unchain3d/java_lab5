package ua.lviv.iot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ExSentenceFinder {

    public String deleteSentencesWithExclamationMark(final String text) {
        Pattern pattern = Pattern.compile("[А-Яа-яі,;'\"\\s]+"
                + "-[А-Яа-яі,;'\"\\s]+"
                + "-[А-Яа-яі,;'\"\\s]+"
                + "-[А-Яа-яі,;'\"\\s]+!");
        Matcher matcher = pattern.matcher(text);
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            matcher.appendReplacement(result, "");
        }
        matcher.appendTail(result);
        return result.toString().trim();
    }

    public static void main(final String[] args) {
        String text = "Цей міні-автобус схожий на зелено-жовту блок-схему! "
                + "Ти не маєш права! Це не має значення."
                + " Що ти робиш? Для чого це? "
                + "Водно-болотний колір найкращий для м'яко-світлих будь-яких!";

        ExSentenceFinder finder = new ExSentenceFinder();
        System.out.println("Очищений текст: " + finder.deleteSentencesWithExclamationMark(text));
    }
}
