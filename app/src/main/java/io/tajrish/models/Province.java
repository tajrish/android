package io.tajrish.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.tajrish.R;

/**
 * Created by root on 12/17/15.
 */
public class Province {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String title;
    private int iconResourceId;
    private List<Pin> pinList;
    private static List<Province> provinceList;
    private String tips;
    private int numberOfVisitors;
    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @SerializedName("is_done")
    private boolean isDone;

    private int progress;
    private int rate;


    public List<Pin> getPinList() {

        if (pinList == null) {
            initializePinList();
        }

        return pinList;
    }

    public static List<Province> getProvinceList() {

        if (provinceList == null) {
            initializeProvinceList();
        }

        return provinceList;
    }

    public void setPinList(List<Pin> pinList) {
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
                Pin pin1 = new Pin();
                Pin pin2 = new Pin();
                Pin pin3 = new Pin();
                Pin pin4 = new Pin();
                Pin pin5 = new Pin();
                Pin pin6 = new Pin();

                pin1.setId(1);
                pin1.setTitle("میدان نقش جهان");
                pin1.setCategory(Category.getCategoryList().get(6));
                pin1.setLatitude(32.657299);
                pin1.setLongitude(51.677587);
                pin2.setId(2);
                pin2.setTitle("عمارت عالي قاپ");
                pin2.setCategory(Category.getCategoryList().get(6));
                pin3.setLatitude(32.657229);
                pin3.setLongitude(51.676662);
                pin3.setId(3);
                pin3.setTitle("بازار قيـصـريه اصفهان");
                pin3.setCategory(Category.getCategoryList().get(6));
                pin3.setLatitude(32.660248);
                pin3.setLongitude(51.676852);
                pin4.setId(4);
                pin4.setTitle("چهل ستون");
                pin4.setCategory(Category.getCategoryList().get(6));
                pin4.setLatitude(32.657470);
                pin4.setLongitude(51.671900);
                pin5.setId(5);
                pin5.setTitle("منار جنبان");
                pin5.setCategory(Category.getCategoryList().get(6));
                pin5.setLatitude(32.650461);
                pin5.setLongitude(51.594179);
                pin6.setId(6);
                pin6.setTitle("سی و سه پل");
                pin6.setCategory(Category.getCategoryList().get(6));
                pin6.setLatitude(32.644461);
                pin6.setLongitude(51.667467);

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

        Province province1 = new Province();
        Province province2 = new Province();
        Province province3 = new Province();
        Province province4 = new Province();
        Province province5 = new Province();
        Province province6 = new Province();

        province1.setTitle("اصفهان");
        province1.setId(1);
        province1.setIconResourceId(R.drawable.province1);
        province1.setLatitude(32.657810);
        province1.setLongitude(51.677490);
        province2.setTitle("مشهد");
        province2.setId(2);
        province2.setIconResourceId(R.drawable.province2);
        province2.setLatitude(36.288193);
        province2.setLongitude(59.615740);
        province3.setTitle("تهران");
        province3.setId(3);
        province3.setIconResourceId(R.drawable.province3);
        province3.setLatitude(35.745059);
        province3.setLongitude(51.375364);
        province4.setTitle("خوزستان");
        province4.setId(4);
        province4.setIconResourceId(R.drawable.province4);
        province4.setLatitude(32.190338);
        province4.setLongitude(48.243608);
        province5.setTitle("فارس");
        province5.setId(5);
        province5.setIconResourceId(R.drawable.province5);
        province5.setLatitude(29.625703);
        province5.setLongitude(52.558397);
        province6.setTitle("همدان");
        province6.setId(6);
        province6.setIconResourceId(R.drawable.province6);
        province6.setLatitude(34.801893);
        province6.setLongitude(48.509692);

        provinceList.add(province1);
        provinceList.add(province2);
        provinceList.add(province3);
        provinceList.add(province4);
        provinceList.add(province5);
        provinceList.add(province6);
    }
}
