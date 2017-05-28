package org.osori.androidstudy.week3;

/**
 * Created by junsu on 2017-05-28.
 */

public interface CatContract {
    interface View {
        public void setCatName(String name);
        public void updateCatHp(int hp);
        public void shakeCat();
        public void showHungryMessage();
        public void showFullMessage();
    }

    interface Presenter {
        public void feedCat();
        public void walkCat();
        public void initCat(String name);
    }
}
