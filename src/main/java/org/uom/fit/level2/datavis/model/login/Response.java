package org.uom.fit.level2.datavis.model.login;

/**
 * Created by asiri on 3/16/17.
 */
public class Response {
    private String state;

    public Response(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
