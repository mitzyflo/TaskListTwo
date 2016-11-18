package cl.mflo.tasklisttwo.data;

import java.util.ArrayList;
import java.util.List;

import cl.mflo.tasklisttwo.models.Gift;

/**
 * Created by mitzyflores on 15-11-16.
 */

public class GiftsData {

    public List<Gift> notDone(){
        List<Gift> gifts = new ArrayList<>();
        List<Gift> pendingList = Gift.find(Gift.class, "done = 0");
        if (pendingList != null && pendingList.size() > 0) {
            gifts.addAll(pendingList);
        }

        return gifts;
    }
}
