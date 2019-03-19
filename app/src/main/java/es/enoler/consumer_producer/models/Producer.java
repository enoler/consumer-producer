package es.enoler.consumer_producer.models;

import android.util.Log;

public class Producer extends Person {

	private int PRODUCER_ACTION_TIME = 3000;

	public Producer() {
		actionProducer();
	}

	private boolean actionProducer() {
		return new android.os.Handler().postDelayed(new Runnable() {
			public void run() {
				Log.i("Test", "Adding item");
				actionProducer();
			}
		}, PRODUCER_ACTION_TIME);
	}
}
