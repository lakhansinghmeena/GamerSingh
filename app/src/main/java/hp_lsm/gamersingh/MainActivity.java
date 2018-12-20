package hp_lsm.gamersingh;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    private ViewPager mMainPager;
    private PagerViewAdaptor mPagerViewAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainPager = (ViewPager) findViewById(R.id.mainPager);
        mMainPager.setOffscreenPageLimit(2);

        mPagerViewAdaptor = new PagerViewAdaptor(getSupportFragmentManager());
        mMainPager.setAdapter(mPagerViewAdaptor);

        bottomNav = (BottomNavigationView) findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        mMainPager.setCurrentItem(0);
                        return true;
                    case R.id.nav_profile:
                        mMainPager.setCurrentItem(1);
                        return true;
                    case R.id.nav_rules:
                        mMainPager.setCurrentItem(2);
                        return true;
                    default:
                        return false;
                }
            }
        });


        mMainPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changetabs(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void changetabs(int position) {
        if (position == 0) {
            bottomNav.setSelectedItemId(R.id.nav_home);
        } else if (position == 1) {
            bottomNav.setSelectedItemId(R.id.nav_profile);
        } else if (position == 2) {
            bottomNav.setSelectedItemId(R.id.nav_rules);
        }
    }
}