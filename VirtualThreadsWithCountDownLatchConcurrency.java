public class VirtualThreadsWithCountDownLatchConcurrency {

static AtomicInteger threadCount = new AtomicInteger();

public static void handleUserRequest() {

  int count = threadCount.incrementAndGet();

  System.out.println("Starting thread  " +count + " :" + Thread.currentThread());

  try {

        Thread.sleep(10000);

  } catch (InterruptedException e) { 

        e.printStackTrace();
    }

  System.out.println("ending thread :" + count + " :" + Thread.currentThread());

}

public static void main (String[] args) throws InterruptedException {

    int threadCount = 4000;
    CountDownLatch countDownLatch = new CountDownLatch(threadCount);

    long startTime = System.currentTimeMillis();

    for (int i = 1; i <= 4000; i++) {

        Thread.startVirtualThread( () -> {
                                            handleUserRequest();
                                            countDownLatch.countDown();
                                });

        // new Thread(() -> {
        //                  handleUserRequest();
        //                  countDownLatch.countDown();
        //                }).start();

    }

    countDownLatch.await();

    long endTime = System.currentTimeMillis();

    System.out.println("Time taken by virtual thread is " + endTime - startTime );

}


}
