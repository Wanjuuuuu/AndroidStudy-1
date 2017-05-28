package org.osori.androidstudy.week3;

/**
 * Created by junsu on 2017-05-28.
 *
 * 참고 소스:
 * https://github.com/googlesamples/android-architecture/tree/todo-mvp/
 * https://github.com/clucle/Android/tree/master/MVP_pattern_tutor
 */



public interface CatContract {

    // 어떤 view control 이 필요한지 명시
    // 해당 interface 는 view 가 상속받는다.
    interface View {
        public void setCatName(String name);
        public void updateCatHp(int hp);
        public void shakeCat();
        public void showHungryMessage();
        public void showFullMessage();
    }

    // 어떤 notify 가 있는지 명시
    // 해당 interface 는 presenter 가 상속받는다.
    interface Presenter {
        public void feedCat();
        public void walkCat();
        public void initCat(String name);
    }
}
