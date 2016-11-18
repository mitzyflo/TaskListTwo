package cl.mflo.tasklisttwo.views.giftList;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.mflo.tasklisttwo.R;
import cl.mflo.tasklisttwo.adapters.GiftAdapters;
import cl.mflo.tasklisttwo.models.Gift;
import cl.mflo.tasklisttwo.views.InfoActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class GiftListFragment extends Fragment implements ListClickListener{

    public static final String activity_info = "activity_info";

    private GiftAdapters giftAdapters;

    public GiftListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gift_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view;

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        giftAdapters = new GiftAdapters(this);

        recyclerView.setAdapter(giftAdapters);
    }


    public void addGift(Gift gift) {
        giftAdapters.add(gift);
    }

    @Override
    public void click (long id) {
        Intent intent = new Intent(getActivity(), InfoActivity.class);
        intent.putExtra(activity_info,id);
        startActivity(intent);
    }
}
