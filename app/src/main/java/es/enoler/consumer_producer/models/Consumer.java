package es.enoler.consumer_producer.models;

import android.util.Log;

public class Consumer extends Person {

	private int consumerActionTime;

	public Consumer() {
		this.consumerActionTime = 4000;
		actionConsumer();
	}

	private boolean actionConsumer() {
		return new android.os.Handler().postDelayed(new Runnable() {
			public void run() {
				Log.i("Test", "Removing item");
				actionConsumer();
			}
		}, consumerActionTime);
	}

	public int getConsumerActionTime() {
		return consumerActionTime;
	}

	public void setConsumerActionTime(int consumerActionTime) {
		this.consumerActionTime = consumerActionTime;
	}
}
