package es.enoler.consumer_producer.activities;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import es.enoler.consumer_producer.R;
import es.enoler.consumer_producer.models.Consumer;
import es.enoler.consumer_producer.models.Person;
import es.enoler.consumer_producer.models.Producer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	private Context mContext;
	private ArrayList<Person> mConsumers;
	private ArrayList<Person> mProducers;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		mContext = getApplicationContext();

		mConsumers = new ArrayList<>();
		mProducers = new ArrayList<>();
	}
}
