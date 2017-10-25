package com.example.santiago.cuentosapp.models.modelsbusiness;

import java.io.Serializable;

/**
 * Created by Santiago on 10/21/17.
 */

public class AnswerModel implements Serializable {
    private String id;
    private String description;
    private boolean right;

    public AnswerModel() {
        id = "";
        description = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
}