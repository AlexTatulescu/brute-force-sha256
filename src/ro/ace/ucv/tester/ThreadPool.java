package ro.ace.ucv.tester;

import ro.ace.ucv.thread.RunnableThread;

public class ThreadPool {

	public static Boolean found = false;

	public static void main(String args[]) {
		Thread[] threads = new Thread[114];
		Integer intervalStart = 10000000;
		Integer step = 789474;
		Integer finalThread = 0;

		for (Integer iterator = 0; iterator < threads.length; iterator++) {
			threads[iterator] = new RunnableThread(intervalStart + step * iterator,
					intervalStart + step * (iterator + 1), iterator.toString());
		}

		for (Integer iterator = 0; iterator < threads.length; iterator++) {
			if (!found) {
				threads[iterator].run();
			}else{
				finalThread = iterator;
			}
		}

		if (found) {
			for (Integer iterator = 0; iterator < finalThread; iterator++) {
				try {
					threads[iterator].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
