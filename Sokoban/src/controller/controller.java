package controller;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import controller.Commands.ExitCommand;
import controller.Commands.command;

public class controller {

	private BlockingQueue<command> queue;
	private boolean stop=false;

	public controller() {
		queue=new ArrayBlockingQueue<command>(10);

	}

	public void insertCommand(command cmd)
	{

		try {
			queue.put(cmd);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}



	public void start() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (!stop) {
					try {
						command cmd = queue.poll(1, TimeUnit.SECONDS);
						if (cmd != null)
							try {
								cmd.execute();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
		thread.start();
	}


	public void stop() {
		stop = true;
		System.out.println("thread closed");
	}


}
