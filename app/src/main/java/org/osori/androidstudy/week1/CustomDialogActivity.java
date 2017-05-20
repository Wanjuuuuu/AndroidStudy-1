package org.osori.androidstudy.week1;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.osori.androidstudy.R;

/**
 * Created by junsu on 2017-05-18.
 */

public class CustomDialogActivity extends Activity {

    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        button = (Button) findViewById(R.id.dialog_pop_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(CustomDialogActivity.this);
                dialog.setContentView(R.layout.item_custom_dialog);
                dialog.setTitle("Custom dialog");

                Button dialogButton = (Button) dialog.findViewById(R.id.dialog_button);
                ImageView dialogImage = (ImageView) dialog.findViewById(R.id.dialog_image);

                dialogImage.setImageDrawable(ContextCompat.getDrawable(CustomDialogActivity.this, R.drawable.joy0));
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }
}
