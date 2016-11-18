package cl.mflo.tasklisttwo.views.main;

import cl.mflo.tasklisttwo.models.Gift;

/**
 * Created by mitzyflores on 15-11-16.
 */

public class GiftValidation {

    private CreatedListGift listGift;

    public GiftValidation(CreatedListGift listGift) {
        this.listGift = listGift;
    }
    public void init(String name){
        if (name.trim().length()>0) {
            Gift pending = new Gift();
            pending.setName(name);
            pending.setDone(false);
            pending.save();
            listGift.succes(pending);
        }else{
            listGift.fail();
        }
    }
}

