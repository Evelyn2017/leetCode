package multi_threads;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author evelyn
 * @description thread pool demo
 * @date 2019-09-25 19:03
 **/
public class ThreadsPool {
    //  buffer
    private BlockingQueue<Runnable> blockingQueue;

    //  threads collection
    private List<Thread> workers;

    private volatile boolean isWorking = true;

    //  worker
    private static class Worker extends Thread {
        private ThreadsPool pool;

        public Worker(ThreadsPool pool) {
            this.pool = pool;
        }

        @Override
        public void run() {
            // take a task from buffer
            while (this.pool.isWorking || this.pool.blockingQueue.size() > 0) {
                Runnable task = null;

                try {
                    if (this.pool.isWorking)
                        task = this.pool.blockingQueue.take();
                    else
                        task = this.pool.blockingQueue.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (task != null) {
                    task.run();
                    System.out.println(Thread.currentThread().getName() + " finished");
                }
            }
        }
    }

    //  initialize
    public ThreadsPool(int pool_size, int task_size) {
        if (pool_size <= 0 || task_size <= 0)
            throw new IllegalArgumentException("pool size and task size should not be 0!");

        this.blockingQueue = new LinkedBlockingDeque<>(task_size);
        this.workers = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < pool_size; i++) {
            Worker worker = new Worker(this);
            worker.start();
            workers.add(worker);
        }
    }


    //  add task
    public boolean submit(Runnable task) {

        if (isWorking)
            return this.blockingQueue.offer(task);
        return false;
    }

    //  add task2
    public void execute(Runnable task) {
        if (isWorking) {
            try {
                this.blockingQueue.put(task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //  close
    public void shutdown() {
        this.isWorking = false;

        for (Thread t : workers) {
            if (t.getState().equals(Thread.State.WAITING) ||
                    t.getState().equals(Thread.State.BLOCKED))
                t.interrupt();
        }
    }
}

class TestThreadsPool {
    public static void main(String[] args) {
        ThreadsPool pool = new ThreadsPool(3, 6);
        for (int i = 0; i < 6; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("A thread is added to buffer!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("A thread is waken up!");
                    }
                }
            });
        }
        pool.shutdown();
    }
}
