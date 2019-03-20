package es.enoler.consumer_producer.models;

import android.util.Log;

public class Producer extends Person {

	private int producerActionTime;

	public Producer() {
		this.producerActionTime = 3000;
		actionProducer();
	}

	private boolean actionProducer() {
		return new android.os.Handler().postDelayed(new Runnable() {
			public void run() {
				Log.i("Test", "Adding item");
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
