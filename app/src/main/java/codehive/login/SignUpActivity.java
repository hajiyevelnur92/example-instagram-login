package codehive.login;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity{

    Toolbar toolbar;

    AnimationDrawable anim;
    AssetManager am;

    Typeface typefaceLobster, typefaceArial;
    TextView lblHeader;

    EditText edtPassword, edtEmail, edtName;
    Button btnLogin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        toolbar = (Toolbar) findViewById(R.id.signedup);
        setupToolbar();

        am = this.getApplicationContext().getAssets();
        RelativeLayout container = (RelativeLayout) findViewById(R.id.containersup);
        anim = (AnimationDrawable) container.getBackground();
        anim.setEnterFadeDuration(100);
        anim.setExitFadeDuration(1000);


        typefaceLobster = Typeface.createFromAsset(getAssets(), "fonts/lobster.otf");
        typefaceArial = Typeface.createFromAsset(getAssets(), "fonts/arial.ttf");
        lblHeader = (TextView) findViewById(R.id.lblHeader);
        lblHeader.setTypeface(typefaceLobster);


        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtName = (EditText) findViewById(R.id.edtName);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        edtName.setTypeface(typefaceArial);
        edtPassword.setTypeface(typefaceArial);
        edtEmail.setTypeface(typefaceArial);
        btnLogin.setTypeface(typefaceArial);

    }

    private void setupToolbar() {
        toolbar.setTitle("Sign up");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (anim != null && !anim.isRunning())
            anim.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (anim != null && anim.isRunning())
            anim.stop();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("homeButton",item.getItemId() + " ");
        switch (item.getItemId()) {
            case 16908332:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
