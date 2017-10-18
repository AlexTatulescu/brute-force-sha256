package ro.ace.ucv.thread;

import ro.ace.ucv.sha256.Sha256;
import ro.ace.ucv.tester.ThreadPool;

public class RunnableThread extends Thread {
	
	private Integer start;
	private Integer end;
	private String hash = "";
	private String name = "";
	
	public RunnableThread(Integer start, Integer end, String name) {
		super();
		this.start = start;
		this.end = end;
		this.name = name;
		this.hash = "7617CD7AB5F6C9C74F66A385DCB1946DED089B55A19A17D9A163DCE0991A913F";
	}

	@Override
	public void run() {
		
		System.out.println("Starting thread: "+ name);
		
		Integer iterator = 0;
		Sha256 sha256 = new Sha256();
		for(iterator = start; iterator <= end ; iterator++){
			if( sha256.hashing(iterator).equals(hash) ){
				ThreadPool.found = true;
				System.out.println("Found password: " + iterator + " on thread " + Thread.currentThread().getId());
			}
		}
	}
	
}
