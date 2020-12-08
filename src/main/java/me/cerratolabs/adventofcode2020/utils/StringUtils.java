package me.cerratolabs.adventofcode2020.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * This class will help with string operation such for example validating string contents.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtils {

    /**
     * Super fast checking of character content in a string.
     *
     * @param string String to prove.
     * @return true in case the provided string was a character. false otherwise.
     */
    public static boolean isCharacter(String string) {
        return (string != null && string.length() == 1);
    }

    /**
     * Super fast checking of integer content in a string.
     *
     * @param string String to prove.
     * @return true in case the provided string was an integer. false otherwise.
     */
    public static boolean isInteger(String string) {
        if (!isNonDecimalNumber(string)) return false;
        int maxIntLength = isNegative(string) ? 11 : 10;
        if (string.length() > maxIntLength) return false; // 10 characters = max 32 bit int value length
        if (string.length() == maxIntLength) return canBeParsedToInteger(string); // Avoid 10 digits values bigger than Integer limits.
        return true;
    }

    /**
     * Super fast checking of non decimal number content in a string.
     *
     * @param string String to prove.
     * @return true in case the provided string was a number. false otherwise.
     */
    public static boolean isNonDecimalNumber(String string) {
        if (string == null || string.isEmpty()) return false;
        int checkStartAt = isNegative(string) ? 1 : 0;
        for (int i = checkStartAt; i < string.length(); i++) { // Ignores first '-' character in case of negative values.
            char c = string.charAt(i);
            if (c <= '/' || c >= ':') return false;
        }
        return true;
    }

    /**
     * Internal method to retrieve if a number inside a string was positive or negative.
     * This method will not check anything else, it will not assert if the string was a number.
     *
     * @param string String to prove.
     * @return true when the string starts with a minus character.
     */
    private static boolean isNegative(String string) {
        return string.length() != 1 && string.charAt(0) == '-';
    }

    /**
     * Inefficient, not pretty but quick and easy way to check if a string contains a numeric integer value.
     *
     * @param string String value to check.
     * @return true if parsable, false otherwise.
     */
    private static boolean canBeParsedToInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (Exception er) {
            return false;
        }
    }

}