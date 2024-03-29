package priv.just1984.deep.in.java.basic.concurrency;

import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-09-29 17:25
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            // throw new BusException();
        });
        future.whenComplete((ret, ex) -> {
            System.out.println(ex);
            System.out.println(ex.getClass());
        }).whenComplete((ret, ex) -> {
            System.out.println(1);
        });

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
