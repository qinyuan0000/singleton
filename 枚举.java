package com.happyeasygo.ota;

import java.util.concurrent.atomic.AtomicLong;

public enum IdGenerator {

    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Thread A = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(IdGenerator.INSTANCE.getId());
                }
            });
            A.start();
        }

    }

}
