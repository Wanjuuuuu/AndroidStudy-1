package org.osori.androidstudy.week3;

/**
 * Created by junsu on 2017-05-28.
 */

public class CatPresenter implements CatContract.Presenter {

    /**
     * Presenter 는 실제 entity 와 control 할 view 를 가지고 있다.
     */

    private Cat cat;
    private CatContract.View view;

    // 먹이주면 hp 몇 올라갈지 ㅇㅇ
    private static final int FEED_POINT = 10;
    // 걸으면 hp 몇 떨어질지 ㅇㅇ
    private static final int WALK_POINT = 15;

    public CatPresenter(CatContract.View view) {
        this.view = view;
    }

    @Override
    public void initCat(String name) {
        // bring cat from db or create new cat
        cat = new Cat(name);

        view.setCatName(cat.getName());
        view.updateCatHp(cat.getHp());
    }

    @Override
    public void feedCat() {
        if (cat.getHp() >= Cat.MAX_HP) {
            view.showFullMessage();
        }
        else {
            if (cat.getHp() >= Cat.MAX_HP - FEED_POINT) {
                cat.setHp(Cat.MAX_HP);
            }
            else {
                cat.setHp(cat.getHp() + FEED_POINT);
            }

            view.updateCatHp(cat.getHp());
            view.shakeCat();
        }
    }

    @Override
    public void walkCat() {
        if (cat.getHp() <= WALK_POINT) {
            view.showHungryMessage();
        }
        else {
            cat.setHp(cat.getHp() - WALK_POINT);

            view.updateCatHp(cat.getHp());
            view.shakeCat();
        }
    }
}
