package com.example.macbook.viewstudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.jude.swipbackhelper.SwipeBackHelper;

public class MainActivity extends BaseActivity {
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SwipeBackHelper.getCurrentPage(this)
            .setSwipeBackEnable(false);
        SwipeBackHelper.getCurrentPage(this).setDisallowInterceptTouchEvent(true);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("吐司", onClickListener)
                            .setCallback(callback)
                            .show();
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }
            });
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override public void onClick(View v) {
            Toast.makeText(MainActivity.this,"action",Toast.LENGTH_SHORT).show();
        }
    };

    Snackbar.Callback callback = new Snackbar.Callback() {
        @Override public void onDismissed(Snackbar snackbar, int event) {
            super.onDismissed(snackbar, event);
            Toast.makeText(MainActivity.this,"dismiss",Toast.LENGTH_SHORT).show();
        }


        @Override public void onShown(Snackbar snackbar) {
            super.onShown(snackbar);
            Toast.makeText(MainActivity.this,"shown",Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
