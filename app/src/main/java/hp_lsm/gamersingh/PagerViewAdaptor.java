package hp_lsm.gamersingh;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerViewAdaptor extends FragmentPagerAdapter {
    public PagerViewAdaptor(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0:
                HomeFragment homeFragment=new HomeFragment();
                return homeFragment;

            case 1:
                ProfileFragment profileFragment= new ProfileFragment();
                return profileFragment;

            case 2:
                RulesFragment rulesFragment= new RulesFragment();
                return rulesFragment;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
