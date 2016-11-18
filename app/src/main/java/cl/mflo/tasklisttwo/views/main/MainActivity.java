package cl.mflo.tasklisttwo.views.main;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import cl.mflo.tasklisttwo.R;
import cl.mflo.tasklisttwo.models.Gift;
import cl.mflo.tasklisttwo.views.giftList.GiftListFragment;

public class MainActivity extends AppCompatActivity  implements CreatedListGift {

    private Dialog gift;
    private GiftListFragment giftListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        giftListFragment = (GiftListFragment) getSupportFragmentManager().findFragmentById(R.id.list);

        setgiftList();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gift.show();
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.showSoftInput(getCurrentFocus(), InputMethodManager.SHOW_FORCED);
            }
        });
    }

    private void setgiftList(){
        gift = new Dialog(this);
        gift.requestWindowFeature(Window.FEATURE_NO_TITLE);
        gift.setContentView(R.layout.dialog_created_gift);
        gift.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        final EditText giftInput = (EditText) gift.findViewById(R.id.giftInput);
        ImageButton btnAdd = (ImageButton) gift.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String giftList = giftInput.getText().toString();
                createdList(giftList);
            }
        });

        giftInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT || actionId == EditorInfo.IME_ACTION_DONE) {
                    String giftList = giftInput.getText().toString();
                    createdList(giftList);
                    return true;
                }
                return false;
            }
        });
    }

    private void createdList(String name){
        GiftValidation giftValidation = new GiftValidation(MainActivity.this);
        giftValidation.init(name);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
        gift.dismiss();

    }

    @Override
    public void succes(Gift gift) {
        giftListFragment.addGift(gift);
    }

    @Override
    public void fail() {
        Toast.makeText(this, "Ingresa Tus Regalos", Toast.LENGTH_SHORT).show();
    }
}


