package com.apps.nicholaspark.bluelineapp.util;


import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

/**
 * Created by nicholaspark on 10/23/16.
 */

public final class Prescriptions {
    private Prescriptions(){throw new AssertionError("Can't have instances");}

    public static Consumer<Throwable> onErrorLogAndRethrow(){
        return t->{
            Timber.e(t,t.getMessage());
            if (t instanceof RuntimeException) {
                throw(RuntimeException) t;
            }else if(t instanceof Error){
                throw(Error) t;
            }else{
                throw new RuntimeException(t);
            }
        };
    }

    public static void safeDispose(Disposable disposable){
        if(disposable != null && !disposable.isDisposed())
            disposable.dispose();
    }
}
