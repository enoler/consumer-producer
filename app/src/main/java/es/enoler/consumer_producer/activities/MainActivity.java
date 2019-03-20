package es.enoler.consumer_producer.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.enoler.consumer_producer.R;
import es.enoler.consumer_producer.adapters.ItemsAdapter;
import es.enoler.consumer_producer.models.Consumer;
import es.enoler.consumer_producer.models.Item;
import es.enoler.consumer_producer.models.Person;
import es.enoler.consumer_producer.models.Producer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	private ArrayList<Person> mConsumers;
	private ArrayList<Person> mProducers;
	private static ArrayList<Item> mItems;
	private static ItemsAdapter mItemsAdapter;
	private static int mItemId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		initData();
		initUI();
	}

	public static void createItem(int idProducer) {
		if(mItems != null) {
			mItemId++;
			String name = "Item " + mItemId;
			Item item = new Item(mItemId, name, idProducer);
			mItems.add(item);
			mItemsAdapter.notifyDataSetChanged();
		}
	}

	private void initData() {
		mConsumers = new ArrayList<>();
		mProducers = new ArrayList<>();
		mItems = new ArrayList<>();
		mItemsAdapter = new ItemsAdapter(this, mItems);
		if(mItems.size() == 0) mItemId = 0;
		else mItemId = mItems.get(mItems.size() - 1).getId();
	}

	private void initUI() {
		Button btConsumer = findViewById(R.id.bt_add_consumer);
		Button btProducer = findViewById(R.id.bt_add_producer);
		RecyclerView rvItems = findViewById(R.id.rv_items);
		rvItems.setLayoutManager(new LinearLayoutManager(this));
		rvItems.setHasFixedSize(true);

		rvItems.setAdapter(mItemsAdapter);

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
			mItemsAdapter.notifyDataSetChanged();
		}
	}
}
