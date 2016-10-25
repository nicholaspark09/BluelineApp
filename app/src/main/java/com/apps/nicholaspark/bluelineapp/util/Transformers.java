package com.apps.nicholaspark.bluelineapp.util;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public final class Transformers {
  private Transformers() {
    throw new AssertionError("No instances");
  }

  public static <T> ObservableTransformer<T, T> distinctToMainThread() {
    return obs -> obs.subscribeOn(Schedulers.computation()).distinctUntilChanged().observeOn(AndroidSchedulers.mainThread());
  }

  public static <T, R> ObservableTransformer<T, R> mapDistinctToMainThread(Function<T, R> mapFunc) {
    return obs -> obs.subscribeOn(Schedulers.computation()).map(mapFunc).distinctUntilChanged().observeOn(AndroidSchedulers.mainThread());
  }
}

