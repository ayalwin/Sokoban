package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import model.data.LoadCommandReceiver;
import model.data.SaveCommandReceiver;
import model.data.levels.Level;
import model.data.objects.square;
import model.policy.MySokobanPolicy;
import model.services.Client;

public class MyModel extends Observable implements model {

	private Level level;

	@Override
	public void saveLevel(String filepath) throws IOException {
		SaveCommandReceiver sr = new SaveCommandReceiver();
		sr.Action(filepath, this.level);
	}

	@Override
	public void loadLevel(String filepath) throws Exception {
		LoadCommandReceiver lr = new LoadCommandReceiver();
		this.level = lr.Action(filepath);
		this.setChanged();
		LinkedList<String> params = new LinkedList<String>();
		params.add("Display");
		this.notifyObservers(params);
	}

	@Override
	public void exit() {
		System.out.println("Exiting...");
		System.exit(1);

	}

	@Override
	public Level getCurrentLevel() {
		return this.level;
	}

	@Override
	public void move(String direction) {
		MySokobanPolicy p = new MySokobanPolicy(this.level);
		switch (direction) {
		case "up":
			p.moveUp();
			break;
		case "down":
			p.moveDown();
			break;
		case "left":
			p.moveLeft();
			break;
		case "right":
			p.moveRight();
			break;

		}
		this.level = p.getLevel();
		this.setChanged();
		LinkedList<String> params = new LinkedList<String>();

		params.add("Display");
		this.notifyObservers(params);

	}

	@Override
	public void solve() {

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {

				func();
			}
		});
		t.start();
	}

	@Override

	public void getHint() {

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {

				func2();
			}
		});
		t.start();
	}

	public void func() {

		LinkedList<String> params = new LinkedList<String>();
		Client client = new Client();
		client.start("localhost", 5555, this.level);
		char[] solution = client.getSolution().toCharArray();
		if (solution != null) {
			String direction = null;
			for (char c : solution) {

				switch (c) {
				case 'u':
					direction = "up";
					break;
				case 'd':
					direction = "down";
					break;
				case 'l':
					direction = "left";
					break;
				case 'r':
					direction = "right";
					break;
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException ie) {
				}
				move(direction);

			}
		}

	}

	public void func2() {

		LinkedList<String> params = new LinkedList<String>();
		Client client = new Client();
		client.start("localhost", 5555, this.level);
		char[] solution = client.getSolution().toCharArray();
		if (solution != null) {
			String direction = null;
			for (int i = 0; i < 5; i++) {
				char c = solution[i];
				switch (c) {
				case 'u':
					direction = "up";
					break;
				case 'd':
					direction = "down";
					break;
				case 'l':
					direction = "left";
					break;
				case 'r':
					direction = "right";
					break;
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException ie) {
				}
				move(direction);

			}
		}

	}
}
