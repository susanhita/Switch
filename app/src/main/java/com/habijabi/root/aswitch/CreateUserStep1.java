package com.habijabi.root.aswitch;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class CreateUserStep1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_create1);
        ActionBar actionBar=getActionBar();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        item.setVisible(true);
        if (id == R.id.gohome) {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




    @Override/*this thing creates the 3 circles on top*/
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_delete_later, menu);
        return true;
    }


    public void next(View view){
        Intent intent=new Intent(this,CreateUserStep2.class);
        startActivity(intent);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

}
