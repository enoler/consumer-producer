package es.enoler.consumer_producer.models;

public class Item {
	private int id;
	private String name;
	private int producer;

	public Item() {
		this.id = 0;
		this.name = "";
		this.producer = 0;
	}

	public Item(int id, String name, int producer) {
		this.id = id;
		this.name = name;
		this.producer = producer;
	}

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

	public int getProducer() {
		return producer;
	}

	public void setProducer(int producer) {
		this.producer = producer;
	}
}
