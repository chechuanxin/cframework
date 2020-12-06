package test.threadpool;

import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) {
		ThreadPool threadPool = new ThreadPool(10);
		while(true) {
			threadPool.execute(()->{
				System.out.println("hello threadpool");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
	}

}
