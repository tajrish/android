package io.tajrish.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 12/17/15.
 */
public class Category {

    private static List<Category> categoryList;
    private int id;
    private String title;
    private int imageResourceId;

    public static List<Category> getCategoryList(){
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

        Category category1 = new Category();
        Category category2 = new Category();
        Category category3 = new Category();
        Category category4 = new Category();
        Category category5 = new Category();
        Category category6 = new Category();
        Category category7 = new Category();
        Category category8 = new Category();
        Category category9 = new Category();

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

        categoryList.add(category1);
        categoryList.add(category2);
        categoryList.add(category3);
        categoryList.add(category4);
        categoryList.add(category5);
        categoryList.add(category6);
        categoryList.add(category7);
        categoryList.add(category8);
        categoryList.add(category9);
    }
}
