package com.apps.nicholaspark.bluelineapp.util;

public final class Strings {

  private Strings() {
    throw new AssertionError("No instances");
  }

  public static boolean isBlank(final CharSequence cs) {
    if (cs == null) {
      return true;
    }
    int strLen = cs.length();
    if (strLen == 0) {
      return true;
    }
    for (int i = 0; i < strLen; i++) {
      if (!Character.isWhitespace(cs.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  public static String titleize(final String str) {
    if (isBlank(str)) {
      return str;
    }
    final char[] buffer = str.toCharArray();
    boolean capitalizeNext = true;
    for (int i = 0; i < buffer.length; i++) {
      final char ch = buffer[i];
      if (Character.isWhitespace(ch)) {
        capitalizeNext = true;
      } else if (capitalizeNext) {
        buffer[i] = Character.toTitleCase(ch);
        capitalizeNext = false;
      } else {
        buffer[i] = Character.toLowerCase(ch);
        capitalizeNext = false;
      }
    }
    return new String(buffer);
  }

  public static String truncateAt(String string, int length) {
    return string.length() > length ? string.substring(0, length) : string;
  }
}
