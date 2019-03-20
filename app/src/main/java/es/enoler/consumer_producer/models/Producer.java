package es.enoler.consumer_producer.models;

import es.enoler.consumer_producer.activities.MainActivity;

public class Producer extends Person {

	private int producerActionTime;

	public Producer() {
		this.setId(0);
		this.producerActionTime = 3000;
		actionProducer();
	}

	public Producer(int id) {
		this.setId(id);
		this.producerActionTime = 3000;
		actionProducer();
	}

	private boolean actionProducer() {
		return new android.os.Handler().postDelayed(new Runnable() {
			public void run() {
				MainActivity.createItem(getId());
				actionProducer();
			}
		}, producerActionTime);
	}

	public int getProducerActionTime() {
		return producerActionTime;
	}

	public void setProducerActionTime(int producerActionTime) {
		this.producerActionTime = producerActionTime;
	}
}
