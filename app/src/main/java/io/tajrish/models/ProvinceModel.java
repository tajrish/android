package io.tajrish.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.tajrish.R;

/**
 * Created by root on 12/17/15.
 */
public class ProvinceModel {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String title;
    private int iconResourceId;
    private List<PinModel> pinList;
    private static List<ProvinceModel> provinceList;
    private String tips;
    private int numberOfVisitors;

    @SerializedName("is_done")
    private boolean isDone;

    private int progress;
    private int rate;


    public List<PinModel> getPinList() {

        if (pinList == null) {
            initializePinList();
        }

        return pinList;
    }

    public static List<ProvinceModel> getProvinceList() {

        if (provinceList == null) {
            initializeProvinceList();
        }

        return provinceList;
    }

    public void setPinList(List<PinModel> pinList) {
        this.pinList = pinList;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public int getNumberOfVisitors() {
        return numberOfVisitors;
    }

    public void setNumberOfVisitors(int numberOfVisitors) {
        this.numberOfVisitors = numberOfVisitors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconResourceId() {
        return iconResourceId;
    }

    public void setIconResourceId(int iconResourceId) {
        this.iconResourceId = iconResourceId;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    private void initializePinList() {
        pinList = new ArrayList<>();

        switch (id){
            case 1:
                PinModel pin1 = new PinModel();
                PinModel pin2 = new PinModel();
                PinModel pin3 = new PinModel();
                PinModel pin4 = new PinModel();
                PinModel pin5 = new PinModel();
                PinModel pin6 = new PinModel();

                pin1.setId(1);
                pin1.setTitle("آتشگاه اصفهان");
                pin1.setCategory(Category.getCategoryList().get(6));
                pin2.setId(2);
                pin2.setTitle("آرامگاه الراشد بالله");
                pin2.setCategory(Category.getCategoryList().get(6));
                pin3.setId(3);
                pin3.setTitle("آرامگاه پیربکران");
                pin3.setCategory(Category.getCategoryList().get(6));
                pin4.setId(4);
                pin4.setTitle("آتشگاه اصفهان");
                pin4.setCategory(Category.getCategoryList().get(6));
                pin5.setId(5);
                pin5.setTitle("آرامگاه سلطان بخت آقا");
                pin5.setCategory(Category.getCategoryList().get(6));
                pin6.setId(6);
                pin6.setTitle("سی و سه پل");
                pin6.setCategory(Category.getCategoryList().get(6));

                pinList.add(pin1);
                pinList.add(pin2);
                pinList.add(pin3);
                pinList.add(pin4);
                pinList.add(pin5);
                pinList.add(pin6);

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }

    private static void initializeProvinceList() {
        provinceList = new ArrayList<>();

        ProvinceModel province1 = new ProvinceModel();
        ProvinceModel province2 = new ProvinceModel();
        ProvinceModel province3 = new ProvinceModel();
        ProvinceModel province4 = new ProvinceModel();
        ProvinceModel province5 = new ProvinceModel();
        ProvinceModel province6 = new ProvinceModel();

        province1.setTitle("اصفهان");
        province1.setId(1);
        province1.setIconResourceId(R.drawable.province1);
        province2.setTitle("مشهد");
        province1.setId(2);
        province2.setIconResourceId(R.drawable.province2);
        province3.setTitle("تهران");
        province1.setId(3);
        province3.setIconResourceId(R.drawable.province3);
        province4.setTitle("خوزستان");
        province1.setId(4);
        province4.setIconResourceId(R.drawable.province4);
        province5.setTitle("فارس");
        province1.setId(5);
        province5.setIconResourceId(R.drawable.province5);
        province6.setTitle("همدان");
        province1.setId(6);
        province6.setIconResourceId(R.drawable.province6);

        provinceList.add(province1);
        provinceList.add(province2);
        provinceList.add(province3);
        provinceList.add(province4);
        provinceList.add(province5);
        provinceList.add(province6);
    }
}
