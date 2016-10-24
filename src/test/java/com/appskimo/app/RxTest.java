package com.appskimo.app;

import com.appskimo.app.domain.Dummy;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by dominic.lee on 2016. 10. 17..
 */
public class RxTest {

    public static void main(String[] args) {
        Observable<String> myObservable = Observable.create(
            subscriber -> {
                subscriber.onNext("Heelo, world!");
                subscriber.onCompleted();
            }
        );

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onStart() {
                System.out.println("onStart");
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };

        myObservable.subscribe(mySubscriber);

        Observable.just(
            Dummy.builder().id(1L).name("one"),
            Dummy.builder().id(2L).name("two"))
            .map(dummy -> {
                dummy.name("mapped");
                return dummy;
            })
            .subscribe(it -> {

            });


        Scheduler.Worker worker = Schedulers.newThread().createWorker();
        worker.schedule(new Action0() {
            @Override
            public void call() {
                myWorker();
                worker.schedule(this);
            }
        });

    }

    private static void myWorker() {
        System.out.println("myWorker()");
    }

}
