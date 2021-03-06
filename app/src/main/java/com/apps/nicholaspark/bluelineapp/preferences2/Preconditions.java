package com.apps.nicholaspark.bluelineapp.preferences2;

final class Preconditions {
  private Preconditions() {
    throw new AssertionError("No instances");
  }

  static void checkNotNull(Object o, String message) {
    if (o == null) {
      throw new NullPointerException(message);
    }
  }
}