package com.hh1995.myroutine;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;

    TabLayout tabLayout;
    MyAdapter adapter;
    ViewPager pager;

    FrameLayout frameLayout;

    FragmentManager fragmentManager;
    T1Fragment t1Fragment;
    LinearLayout linearLayout;

    Context context;


    TextView tv;
    String we;




    PermissionListener permissionlistener = new PermissionListener() {
        @Override
        public void onPermissionGranted() {
            initView();
        }

        @Override
        public void onPermissionDenied(ArrayList<String> deniedPermissions) {
            Toast.makeText(MainActivity.this, "권한 허용을 하지 않으면 서비스를 이용할 수 없습니다.", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);

        drawerLayout = findViewById(R.id.drawer);


        pager = findViewById(R.id.pager);
        adapter = new MyAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        tabLayout.setupWithViewPager(pager);

        frameLayout = findViewById(R.id.container);

        BottomNavigationView bottomNavigationView = findViewById(R.id.botnav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.timer:
                        //getSupportFragmentManager().beginTransaction().replace(R.id.container, timerFragment).addToBackStack(null).commit();
                        Intent intent=new Intent(MainActivity.this,TimeActivity.class);
                        startActivity(intent);
                        return true;

                    case R.id.routine:
                       // getSupportFragmentManager().beginTransaction().replace(R.id.container, routineFragment).addToBackStack(null).commit();
                        Intent intent2=new Intent(MainActivity.this,RoutineActivity.class);
                        startActivity(intent2);
                        return true;

                    case R.id.youSearch:
                        //getSupportFragmentManager().beginTransaction().replace(R.id.container, youtubeFragment).addToBackStack(null).commit();
                        Intent intent3=new Intent(Intent.ACTION_VIEW);
                        intent3.setData(Uri.parse("https://www.youtube.com/"));
                        intent3.setPackage("com.google.android.youtube");
                        startActivity(intent3);



                };
                    return false;
            }
        });

        context = MainActivity.this;

        // 네트워크 연결상태 체크
        if (NetworkConnection() == false) NotConnected_showAlert();
        checkPermissions();

//        Intent intent=getIntent();
//        intent.putExtra("weather",we);
//        setResult(50,intent);


    }



    private void checkPermissions() {
        if (Build.VERSION.SDK_INT >= 23) { // 마시멜로(안드로이드 6.0) 이상 권한 체크
            TedPermission.with(MainActivity.this)
                    .setPermissionListener(permissionlistener)
                    .setRationaleMessage("앱을 이용하기 위해서는 접근 권한이 필요합니다")
                    .setDeniedMessage("앱에서 요구하는 권한설정이 필요합니다...\n [설정] > [권한] 에서 사용으로 활성화해주세요.")
                    .setPermissions(new String[]{
                            android.Manifest.permission.WRITE_CONTACTS, // 주소록 액세스 권한
                            android.Manifest.permission.READ_EXTERNAL_STORAGE,
                            android.Manifest.permission.WRITE_EXTERNAL_STORAGE // 기기, 사진, 미디어, 파일 엑세스 권한
                    })
                    .check();

        } else {
            initView();
        }
    }

    private void initView() {

        String path1 = "https://weather.naver.com/rgn/cityWetrCity.nhn?cityRgnCd=CT001013";
        new getData1().execute(path1);
    }

    public void weather(View view) {
        we=we.replace("오후","\n오후");
        Toast.makeText(context, we+"", Toast.LENGTH_LONG).show();

    }

    private class getData1 extends AsyncTask<String, Void, String> {
        // String 으로 값을 전달받은 값을 처리하고, Boolean 으로 doInBackground 결과를 넘겨준다.
        @Override
        protected String doInBackground(String... params) {
            try {
                Document document = Jsoup.connect(params[0].toString()).get(); // Web에서 내용을 가져온다.
                Elements elements = document.select("td"); // 내용중에서 원하는 부분을 가져온다.
                Element targetElement1 = elements.get(0);//1.현시간 2.온도 3.미세먼지
                Element targetElement2 = elements.get(1);//1.현시간 2.온도 3.미세먼지
                //Element targetElement3 = elements.get(2);//1.현시간 2.온도 3.미세먼지
                String text1 = targetElement1.text();
                String text2 = targetElement2.text();
                //String text3 = targetElement3.text();
                String text = "오늘 "+text1 + "\n" + "내일 "+text2;
                we=text;
                return text;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

//        @Override
//        protected void onPostExecute(String result) {
//            textView1.setText(result);
//        }
    }


    private void NotConnected_showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("네트워크 연결 오류");
        builder.setMessage("사용 가능한 무선네트워크가 없습니다.\n" + "먼저 무선네트워크 연결상태를 확인해 주세요.")
                .setCancelable(false)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish(); // exit
                        //application 프로세스를 강제 종료
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    private boolean NetworkConnection() {
        int[] networkTypes = {ConnectivityManager.TYPE_MOBILE, ConnectivityManager.TYPE_WIFI};
        try {
            ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            for (int networkType : networkTypes) {
                NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
                if (activeNetwork != null && activeNetwork.getType() == networkType) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

}
