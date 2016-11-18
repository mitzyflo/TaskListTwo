package cl.mflo.tasklisttwo.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cl.mflo.tasklisttwo.R;
import cl.mflo.tasklisttwo.models.Gift;
import cl.mflo.tasklisttwo.views.giftList.GiftListFragment;

public class InfoActivity extends AppCompatActivity {

    private Gift gift;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        long id = getIntent().getLongExtra(GiftListFragment.activity_info, 0);
        gift = Gift.findById(Gift.class, id);
    }
}
