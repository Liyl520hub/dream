package com.dream.common.baserx;


import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;


/**
 *  Created by Administrator on 2018/1/26 0026.
 *  @Desc :RxBinding点击事件的transformer
 */

public class RxClickTransformer {

    /**
     * @return
     */
    public static ObservableTransformer<Object, Object> getClickTransformer() {

        return new ObservableTransformer<Object, Object>() {

            @Override
            public ObservableSource<Object> apply(Observable<Object> upstream) {
                return upstream.
                        throttleFirst(1000, TimeUnit.MILLISECONDS).
                        observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
