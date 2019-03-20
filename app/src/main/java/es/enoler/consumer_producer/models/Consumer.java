package es.enoler.consumer_producer.models;

import android.util.Log;

public class Consumer extends Person {

	private int CONSUMER_ACTION_TIME = 4000;

	public Consumer() {
		actionConsumer();
	}

	private boolean actionConsumer() {
		return new android.os.Handler().postDelayed(new Runnable() {
			public void run() {
				Log.i("Test", "Removing consumer");
				actionConsumer();
			}
		}, CONSUMER_ACTION_TIME);
	}
}
