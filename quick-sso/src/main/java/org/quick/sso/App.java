package org.quick.sso;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> callable = new Callable<String>() {

            @Override
            public String call() throws Exception {

                return "200";
            }
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(callable);
        String string = future.get();
        System.out.println(string);
    }
}
