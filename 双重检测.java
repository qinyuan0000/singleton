package com.happyeasygo.ota;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private AtomicLong id = new AtomicLong(0);
    private static IdGenerator instance;

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        if (instance == null) {
            synchronized(IdGenerator.class) {
                if(instance == null) {
                    instance = new IdGenerator();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Thread A = new Thread(new Runnable() {
                @Override
                public void run() {
                    IdGenerator idGenerator = IdGenerator.getInstance();
                    System.out.println(idGenerator.getId());
                }
            });
            A.start();
        }

    }

}
