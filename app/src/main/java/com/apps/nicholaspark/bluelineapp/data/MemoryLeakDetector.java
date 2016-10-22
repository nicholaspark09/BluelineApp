package com.apps.nicholaspark.bluelineapp.data;

/**
 * Created by nicholaspark on 10/22/16.
 */

public interface MemoryLeakDetector {
    MemoryLeakDetector NOOP = leakable ->{};

    void watch(Object leakable);
}
