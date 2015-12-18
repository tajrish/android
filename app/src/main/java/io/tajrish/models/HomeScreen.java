package io.tajrish.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 12/17/15.
 */
public class HomeScreen {

    @SerializedName("active")
    private int activeProvince;
    private Challenge challenge;
    private Province province;

    public int getActiveProvince() {
        return activeProvince;
    }

    public void setActiveProvince(int activeProvince) {
        this.activeProvince = activeProvince;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
