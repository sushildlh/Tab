package tab.vectorx.com.tabapplications.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import tab.vectorx.com.tabapplications.R;
import tab.vectorx.com.tabapplications.fragments.OneFragment;
import tab.vectorx.com.tabapplications.fragments.ThreeFragment;
import tab.vectorx.com.tabapplications.fragments.TwoFragment;

public class FixTabActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.viewpager)
    ViewPager mPager;

    @BindView(R.id.tabs)
    TabLayout mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_tab);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        setTitle("Fix Tab");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupViewPager(mPager);

        mTabs.setupWithViewPager(mPager);


    }

    public void setupViewPager(ViewPager upViewPager) {
        ViewPagerAdapter adapter =new ViewPagerAdapter(getSupportFragmentManager(),false);
        adapter.addFragment(new OneFragment(),"Tab1");
        adapter.addFragment(new TwoFragment(),"Tab2");
        adapter.addFragment(new ThreeFragment(),"Tab3");
        upViewPager.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
