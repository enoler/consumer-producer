package es.enoler.consumer_producer.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import es.enoler.consumer_producer.R;
import es.enoler.consumer_producer.models.Consumer;
import es.enoler.consumer_producer.models.Person;
import es.enoler.consumer_producer.models.Producer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	private Context mContext;
	private ArrayList<Person> mConsumers;
	private ArrayList<Person> mProducers;
	private ArrayList<String> mItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		mContext = getApplicationContext();
		initData();
		initUI();
	}

	private void initData() {
		mConsumers = new ArrayList<>();
		mProducers = new ArrayList<>();
		mItems = new ArrayList<>();
	}

	private void initUI() {
		Button btConsumer = findViewById(R.id.bt_add_consumer);
		Button btProducer = findViewById(R.id.bt_add_producer);

		btProducer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mProducers.add(new Producer());
			}
		});

		btConsumer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mConsumers.add(new Consumer());
			}
		});
	}
}
