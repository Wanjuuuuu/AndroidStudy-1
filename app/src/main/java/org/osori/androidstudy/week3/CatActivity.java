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

    TextView catName;
    TextView catHpText;
    ProgressBar catHpBar;
    ImageView catImage;
    Button catFeedButton;
    Button catWalkButton;

    CatPresenter catPresenter;

    private final String CAT_NAME = "clucle";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);

        catName = (TextView) findViewById(R.id.cat_name);
        catHpText = (TextView) findViewById(R.id.cat_hp_text);
        catHpBar = (ProgressBar) findViewById(R.id.cat_hp_bar);
        catImage = (ImageView) findViewById(R.id.cat_image);
        catFeedButton = (Button) findViewById(R.id.cat_feed_button);
        catWalkButton = (Button) findViewById(R.id.cat_walk_button);

        catPresenter = new CatPresenter(this);

        catPresenter.initCat(CAT_NAME);

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
