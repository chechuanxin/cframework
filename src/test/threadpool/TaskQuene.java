package test.threadpool;

import java.util.LinkedList;

public class TaskQuene {
	
	private LinkedList<Runnable> quene = new LinkedList<>();
	
	private int limit = 10;
	
	public TaskQuene(int limit) {
		this.limit = limit;
	}
	
	public TaskQuene() {}
	
	public void offer(Runnable task) {
		synchronized (quene) {
			while(quene.size() >= limit) {
				try {
					quene.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			quene.addLast(task);
			quene.notifyAll();
		}
	}
	
	public Runnable take() {
		synchronized (quene) {
			while(quene.isEmpty()) {
				try {
					quene.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Runnable task = quene.remove();
			quene.notifyAll();
			return task;
		}
	}
	
	public int size() {
		return quene.size();
	}

}
