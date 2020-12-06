package test.threadpool;

public class ThreadPool {
	
	private TaskQuene quene = new TaskQuene();
	
	private int size = 3;
	
	public ThreadPool(int size) {
		this.size = size;
		for (int i = 0; i < this.size; i++) {
			new Thread(()->{
				while(true) {
					quene.take().run();
				}
			}).start();
		}
	}
	
	public void execute(Runnable task) {
		quene.offer(task);
	}

}
