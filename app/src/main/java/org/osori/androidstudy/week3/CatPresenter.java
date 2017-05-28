package org.osori.androidstudy.week3;

/**
 * Created by junsu on 2017-05-28.
 */

public class CatPresenter implements CatContract.Presenter {

    private Cat cat;
    private CatContract.View view;

    private static final int FEED_POINT = 10;
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
