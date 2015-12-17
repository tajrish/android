package io.tajrish.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 12/17/15.
 */
public class CategoryModel {

    private static List<CategoryModel> categoryList;
    private int id;
    private String title;
    private int imageResourceId;

    public static List<CategoryModel> getCategoryList(){
        if(categoryList == null){
            initializeCategoryList();
        }

        return categoryList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    private static void initializeCategoryList() {

        categoryList = new ArrayList<>();

        CategoryModel category1 = new CategoryModel();
        CategoryModel category2 = new CategoryModel();
        CategoryModel category3 = new CategoryModel();
        CategoryModel category4 = new CategoryModel();
        CategoryModel category5 = new CategoryModel();
        CategoryModel category6 = new CategoryModel();
        CategoryModel category7 = new CategoryModel();
        CategoryModel category8 = new CategoryModel();
        CategoryModel category9 = new CategoryModel();

        category1.setTitle("مرکز خرید");
        category1.setId(1);
        category1.setImageResourceId(1);
        category2.setTitle("مناظر طبیعی");
        category2.setId(2);
        category3.setTitle("کوه");
        category3.setId(3);
        category4.setTitle("بوستان");
        category4.setId(4);
        category5.setTitle("باغ وحش");
        category5.setId(5);
        category6.setTitle("اماکن تاریخی");
        category6.setId(6);
        category7.setTitle("استادیوم");
        category7.setId(7);
        category8.setTitle("مجموعه ورزشی");
        category8.setId(8);
        category9.setTitle("زیارتی");
        category9.setId(9);
    }
}
