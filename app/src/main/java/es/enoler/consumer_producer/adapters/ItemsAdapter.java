package es.enoler.consumer_producer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import es.enoler.consumer_producer.R;
import es.enoler.consumer_producer.models.Item;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

	private final Context mContext;
	private final List<Item> mItems;

	public ItemsAdapter(Context context, List<Item> items) {
		this.mContext = context;
		this.mItems = items;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(final ViewHolder holder, int position) {
		Item item = mItems.get(position);

		holder.mName.setText(item.getName());

		String name = mContext.getString(R.string.number_producer) + " " + item.getProducer();
		holder.mProducer.setText(name);
	}

	@Override
	public int getItemCount() { return mItems.size(); }

	class ViewHolder extends RecyclerView.ViewHolder {
		private final TextView mName;
		private final TextView mProducer;

		private ViewHolder(View view) {
			super(view);
			mName = view.findViewById(R.id.tv_name);
			mProducer = view.findViewById(R.id.tv_producer);
		}
	}
}
