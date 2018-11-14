package com.yy.provider1;

import java.util.Random;

public class RandomStringUtils {

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public static String randomAlphanumeric(int count) {
        return random(count, true, true);
    }

    public static String random(int count, boolean letters, boolean numbers) {
        return random(count, 0, 0, letters, numbers, null);
    }

    private static String random(int count, int start, int end, boolean letters, boolean numbers,
            char[] chars) {
        if (count == 0) {
            return "";
        } else if (count < 0) {
            throw new IllegalArgumentException(
                    "Requested random string length " + count + " is less than 0.");
        }
        if ((start == 0) && (end == 0)) {
            end = 'z' + 1;
            start = ' ';
            if (!letters && !numbers) {
                start = 0;
                end = Integer.MAX_VALUE;
            }
        }

        char[] buffer = new char[count];
        int gap = end - start;

        while (count-- != 0) {
            char ch;
            if (chars == null) {
                ch = (char) (RANDOM.nextInt(gap) + start);
            } else {
                ch = chars[RANDOM.nextInt(gap) + start];
            }
            if ((letters && Character.isLetter(ch)) || (numbers && Character.isDigit(ch))
                    || (!letters && !numbers)) {
                if (ch >= 56320 && ch <= 57343) {
                    if (count == 0) {
                        count++;
                    } else {
                        // low surrogate, insert high surrogate after putting it
                        // in
                        buffer[count] = ch;
                        count--;
                        buffer[count] = (char) (55296 + RANDOM.nextInt(128));
                    }
                } else if (ch >= 55296 && ch <= 56191) {
                    if (count == 0) {
                        count++;
                    } else {
                        // high surrogate, insert low surrogate before putting
                        // it in
                        buffer[count] = (char) (56320 + RANDOM.nextInt(128));
                        count--;
                        buffer[count] = ch;
                    }
                } else if (ch >= 56192 && ch <= 56319) {
                    // private high surrogate, no effing clue, so skip it
                    count++;
                } else {
                    buffer[count] = ch;
                }
            } else {
                count++;
            }
        }
        return new String(buffer);
    }

}
