package com.java.basic;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Author Miracle.wcg
 * @Date 2020-01-12 14:04
 */
public class HelloRxChain {
    public static void main(String[] args) {
        Observable.create(new ObservableOnSubscribe<String>() {
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("hello");
                emitter.onNext("rxJava test ...");
            }
        }).observeOn(Schedulers.newThread()).subscribe(new Consumer<String>() {
            public void accept(String s) throws Exception {
                System.out.println(Thread.currentThread().getName() + " == consumer == " + s);
            }
        });


        Observable.create(new ObservableOnSubscribe<String>() {
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("hello");
                emitter.onNext("rxJava test ...");
            }
        }).observeOn(Schedulers.newThread()).subscribe(new Observer<String>() {
            public void onSubscribe(Disposable disposable) {

            }

            public void onNext(String s) {
                System.out.println(Thread.currentThread().getName() + " == observer == " + s);
            }

            public void onError(Throwable throwable) {

            }

            public void onComplete() {

            }
        });
        while (true) {
        }
    }
}
