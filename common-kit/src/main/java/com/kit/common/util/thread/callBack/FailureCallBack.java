package com.kit.common.util.thread.callBack;

import com.google.common.util.concurrent.FutureCallback;

/**
 * @author Lucifer
 * @create 2017-10-23
 **/
public interface FailureCallBack<V> extends FutureCallback<V> {

    default void onFailure(V result) {
    }
}
