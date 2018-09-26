package cristiapp.sepazxing;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int ZBAR_CAMERA_PERMISSION = 1;
    private Class<?> mClss;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_main);
        setupToolbar();

        Intent intent = getIntent();
        String result = intent.getStringExtra("Contents");
        if (result != null) {
            Toast.makeText(this, "Contents = " + result, Toast.LENGTH_SHORT).show();
            //the layout on which you are working
            LinearLayout layout = (LinearLayout) findViewById(R.id.parent);

            //set the properties for button
            Button btnTag = new Button(this);
           // btnTag.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            btnTag.setText("Button New");
            btnTag.setTop(798);
            btnTag.setBottom(894);
            btnTag.setRight(LinearLayout.LayoutParams.MATCH_PARENT);
            btnTag.setLeft(LinearLayout.LayoutParams.MATCH_PARENT);
          //  btnTag.setId(Integer.parseInt("cancel"));

            //add button to the layout
            layout.addView(btnTag);

        }
    }

    public void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    public void launchSimpleFragmentActivity(View v) {
        launchActivity(SimpleScannerFragmentActivity.class);
    }


    public void launchFullFragmentActivity(View v) {
        //launchActivity(FullScannerFragmentActivity.class);
        Fragment newFragment = new FullScannerFragment();

        // consider using Java coding conventions (upper first char class names!!!)
        //FragmentTransaction transaction = getFragmentManager().beginTransaction();
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        ft.add(R.id.fragment_container_activity, newFragment);
        ft.addToBackStack(null);

        // Commit the transaction
        ft.commit();
    }

    public void launchActivity(Class<?> clss) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            mClss = clss;
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA}, ZBAR_CAMERA_PERMISSION);
        } else {
            Intent intent = new Intent(this, clss);
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case ZBAR_CAMERA_PERMISSION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (mClss != null) {
                        Intent intent = new Intent(this, mClss);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(this, "Please grant camera permission to use the QR Scanner", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }
}