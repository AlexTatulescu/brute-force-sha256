package ro.ace.ucv.tester;

import ro.ace.ucv.thread.RunnableThread;

public class ThreadPool {

	public static Boolean found = false;

	public static void main(String args[]) {
		Thread[] threads = new Thread[114];
		Integer intervalStart = 10000000;
		Integer step = 789474;

		for (Integer iterator = 0; iterator < threads.length; iterator++) {
			threads[iterator] = new RunnableThread(intervalStart + step * (iterator + 1),
					intervalStart + step * (iterator + 2), iterator.toString());
		}

		for (Integer iterator = 0; iterator < threads.length; iterator++) {
			threads[iterator].run();
		}

		if (found) {
			for (Integer iterator = 0; iterator < threads.length; iterator++) {
				try {
					threads[iterator].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
