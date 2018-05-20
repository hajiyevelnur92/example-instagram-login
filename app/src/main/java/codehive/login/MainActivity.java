package codehive.login;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable anim;
    AssetManager am;

    Typeface typefaceLobster, typefaceArial;
    TextView lblHeader,nextpage;

    EditText edtPassword, edtEmail;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        am = this.getApplicationContext().getAssets();
        RelativeLayout container = (RelativeLayout) findViewById(R.id.container);
        anim = (AnimationDrawable) container.getBackground();
        anim.setEnterFadeDuration(100);
        anim.setExitFadeDuration(1000);


        typefaceLobster = Typeface.createFromAsset(getAssets(), "fonts/lobster.otf");
        typefaceArial = Typeface.createFromAsset(getAssets(), "fonts/arial.ttf");
        lblHeader = (TextView) findViewById(R.id.lblHeader);
        lblHeader.setTypeface(typefaceLobster);

        nextpage = (TextView) findViewById(R.id.nextpage);
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SignUpActivity.class));
                overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
            }
        });

        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        edtPassword.setTypeface(typefaceArial);
        edtEmail.setTypeface(typefaceArial);
        btnLogin.setTypeface(typefaceArial);

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
}