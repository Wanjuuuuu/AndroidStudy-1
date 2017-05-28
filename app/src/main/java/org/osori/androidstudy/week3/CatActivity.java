package org.osori.androidstudy.week3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.osori.androidstudy.R;

/**
 * Created by junsu on 2017-05-28.
 */

public class CatActivity extends AppCompatActivity implements CatContract.View {

    // control 할 view 들을 class 변수로 정의한다.
    TextView catName;
    TextView catHpText;
    ProgressBar catHpBar;
    ImageView catImage;
    Button catFeedButton;
    Button catWalkButton;

    // user 의 action 을 control 할 presenter 선언
    CatPresenter catPresenter;

    private final String CAT_NAME = "clucle";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // layout 에 정의 해놓은 view 를 그려준다.
        setContentView(R.layout.activity_cat);

        // xml 의 view 와 view 객체를 binding 해준다.
        catName = (TextView) findViewById(R.id.cat_name);
        catHpText = (TextView) findViewById(R.id.cat_hp_text);
        catHpBar = (ProgressBar) findViewById(R.id.cat_hp_bar);
        catImage = (ImageView) findViewById(R.id.cat_image);
        catFeedButton = (Button) findViewById(R.id.cat_feed_button);
        catWalkButton = (Button) findViewById(R.id.cat_walk_button);

        // Presenter 초기화.. 인자로 들어간 값은 CatContract.View interface 이며
        // CatActivity 는 View 를 상속 받고 있다.
        catPresenter = new CatPresenter(this);

        // 처음에 시작했을 때 init notify 를 주고 싶어서 initCat() 을 만들었다. .. 사용함 ㅇㅇ
        catPresenter.initCat(CAT_NAME);

        // Button click event 에 대해 정의함
        // 1) 밥먹이기 버튼 누르면 밥먹게하고
        // 2) 걷기 버튼 누르면 걷게함
        catFeedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                catPresenter.feedCat();
            }
        });
        catWalkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                catPresenter.walkCat();
            }
        });
    }

    /**
     * 아래 있는 code 들은 모두 view 를 control 하는 코드 들이다.
     *
     * CatContract 에서 일어날 수 있는 모든 view 의 동작에 대해 명시 해 놓았다.
     * 그 내용을 실제 View class 를 implement 한 CatActivity 에서 구현함
     */

    @Override
    public void setCatName(String name) {
        catName.setText(name);
    }

    @Override
    public void updateCatHp(int hp) {
        catHpText.setText(String.valueOf(hp));
        catHpBar.setProgress(hp);
    }

    @Override
    public void shakeCat() {
        catImage.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake));
    }

    @Override
    public void showFullMessage() {
        Toast.makeText(this, "배불배불", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showHungryMessage() {
        Toast.makeText(this, "Not enough energy", Toast.LENGTH_SHORT).show();
    }
}
