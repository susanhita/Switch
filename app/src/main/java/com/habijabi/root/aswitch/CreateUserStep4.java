package com.habijabi.root.aswitch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreateUserStep4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_create4);
        overridePendingTransition(R.anim.transition,R.anim.transition_reverse);

    }
    public void next(View view){
        Intent intent=new Intent(this,CreateUserStep5.class);
        startActivity(intent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

}
