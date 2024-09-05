package lesson20240827.semaphore;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import lesson20240827.closertoreallife.Process;
import lesson20240827.closertoreallife.Read;
import lesson20240827.closertoreallife.Write;

public class ConcurrentSem {
	private static final int CYCLES = 100_000;

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService reader = Executors.newSingleThreadExecutor();
		ExecutorService processor = Executors.newSingleThreadExecutor();
		ExecutorService writer = Executors.newSingleThreadExecutor();
		
		Queue<String> read = new LinkedBlockingQueue<>(); 
		Queue<String> processed = new LinkedBlockingQueue<>();
		
		Semaphore sem = new Semaphore(10);
		
		AtomicInteger counter = new AtomicInteger();

		long start = System.currentTimeMillis();
		
		for (int i = 0; i < CYCLES; i++) {
			if (i 
					% 100 == 0) {
				
				System.out.println(i);
			}
			reader.submit(()-> {
				String data = new Read(1).doWork();
				sem.acquireUninterruptibly();
				read.add(data);
			});
			processor.submit(() -> {
				String data = new Process(10, (BlockingQueue<String>) read).doWork();
				processed.add(data);
				sem.release();
			});
			writer.submit(()-> new Write(10, (BlockingQueue<String>) processed).doWork());
		}
		
		reader.shutdown();
		processor.shutdown();
		writer.shutdown();
		
		boolean successful = writer.awaitTermination(1, TimeUnit.MINUTES);
		long stop = System.currentTimeMillis();
		
		System.out.println(successful ? "normal termination" : "timeout");
		
		
		System.out.println("Elapsed: " + (stop - start));
	}
}
