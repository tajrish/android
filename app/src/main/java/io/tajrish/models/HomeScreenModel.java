package io.tajrish.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 12/17/15.
 */
public class HomeScreenModel {

    @SerializedName("active")
    private int activeProvince;
    private ChallengeModel challenge;
    private ProvinceModel province;

    public int getActiveProvince() {
        return activeProvince;
    }

    public void setActiveProvince(int activeProvince) {
        this.activeProvince = activeProvince;
    }

    public ChallengeModel getChallenge() {
        return challenge;
    }

    public void setChallenge(ChallengeModel challenge) {
        this.challenge = challenge;
    }

    public ProvinceModel getProvince() {
        return province;
    }

    public void setProvince(ProvinceModel province) {
        this.province = province;
    }
}
