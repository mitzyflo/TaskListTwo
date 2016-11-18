package cl.mflo.tasklisttwo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import cl.mflo.tasklisttwo.R;
import cl.mflo.tasklisttwo.data.GiftsData;
import cl.mflo.tasklisttwo.models.Gift;
import cl.mflo.tasklisttwo.views.giftList.ListClickListener;

/**
 * Created by mitzyflores on 15-11-16.
 */

public class GiftAdapters extends RecyclerView.Adapter<GiftAdapters.ViewHolder>{

    private List<Gift> gifts = new GiftsData().notDone();

    private ListClickListener listener;

    public GiftAdapters(ListClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_gift, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Gift gift = gifts.get(position);
        holder.name.setText(gift.getName());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gifts.remove(position);
                gift.delete();
                notifyDataSetChanged();
            }
        });

        holder.info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.click(gift.getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return gifts.size();
    }

    public void add(Gift gift){
        gifts.add(gift);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton info, delete;
        TextView name;
        ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.nameGift);
            info = (ImageButton) view.findViewById(R.id.descriptionBtn);
            delete = (ImageButton) view.findViewById(R.id.deleteBtn);
        }

    }

}


