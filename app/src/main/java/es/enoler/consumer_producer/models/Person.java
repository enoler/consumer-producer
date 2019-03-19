package es.enoler.consumer_producer.models;

import java.util.logging.Handler;

public class Person {

	private int id;
	private String name;
	private Handler timer;

	public Person() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Handler getTimer() {
		return timer;
	}

	public void setTimer(Handler timer) {
		this.timer = timer;
	}
}
