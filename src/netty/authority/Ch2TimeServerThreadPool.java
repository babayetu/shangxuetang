package netty.authority;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Ch2TimeServerThreadPool {

	private ExecutorService executor;
	
	public Ch2TimeServerThreadPool(int maxPoolSize, int maxQueueSize) {
		executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
				maxPoolSize,120L,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(maxQueueSize));
	}
	
	public void execute(Runnable task) {
		executor.execute(task);
	}
	
	
}
