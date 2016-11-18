package cl.mflo.tasklisttwo.models;

import com.orm.SugarRecord;

/**
 * Created by mitzyflores on 15-11-16.
 */

public class Gift extends SugarRecord{

    private String name, description;
    private boolean done;

    public Gift() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


}
