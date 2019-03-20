package es.enoler.consumer_producer.activities;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import es.enoler.consumer_producer.R;
import es.enoler.consumer_producer.models.Consumer;
import es.enoler.consumer_producer.models.Item;
import es.enoler.consumer_producer.models.Person;
import es.enoler.consumer_producer.models.Producer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	private Context mContext;
	private ArrayList<Person> mConsumers;
	private ArrayList<Person> mProducers;
	private static ArrayList<Item> mItems;

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

	public static void createItem(int idProducer) {
		if(mItems != null) {
			int id = mItems.size() + 1;
			String name = "Item " + id;
			Item item = new Item(id, name, idProducer);
			mItems.add(item);
			Log.d("Test", item.getName());
		}
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
				int id = mProducers.size() + 1;
				mProducers.add(new Producer(id));
			}
		});

		btConsumer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mConsumers.add(new Consumer());
			}
		});
	}

	public static void removeItem() {
		if(mItems != null && mItems.size() > 0) {
			mItems.remove(0);
		}
		Log.d("Test", "Items: " + mItems.size());
	}
}
