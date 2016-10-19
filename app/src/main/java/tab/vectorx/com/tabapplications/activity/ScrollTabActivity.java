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
import tab.vectorx.com.tabapplications.fragments.EightFragment;
import tab.vectorx.com.tabapplications.fragments.FiveFragment;
import tab.vectorx.com.tabapplications.fragments.FourFragment;
import tab.vectorx.com.tabapplications.fragments.NineFragment;
import tab.vectorx.com.tabapplications.fragments.OneFragment;
import tab.vectorx.com.tabapplications.fragments.SevenFragment;
import tab.vectorx.com.tabapplications.fragments.SixFragment;
import tab.vectorx.com.tabapplications.fragments.TenFragment;
import tab.vectorx.com.tabapplications.fragments.ThreeFragment;
import tab.vectorx.com.tabapplications.fragments.TwoFragment;

public class ScrollTabActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.viewpager)
    ViewPager mPager;

    @BindView(R.id.tabs)
    TabLayout mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_tab);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        setTitle("Scroll Tab");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setUpViewPager(mPager);

        mTab.setupWithViewPager(mPager);

    }

    public void setUpViewPager(ViewPager upViewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),false);
        adapter.addFragment(new OneFragment(),"Tab1");
        adapter.addFragment(new TwoFragment(),"Tab2");
        adapter.addFragment(new ThreeFragment(),"Tab3");
        adapter.addFragment(new FourFragment(),"Tab4");
        adapter.addFragment(new FiveFragment(),"Tab5");
        adapter.addFragment(new SixFragment(),"Tab6");
        adapter.addFragment(new SevenFragment(),"Tab7");
        adapter.addFragment(new EightFragment(),"Tab8");
        adapter.addFragment(new NineFragment(),"Tab9");
        adapter.addFragment(new TenFragment(),"Tab10");
        upViewPager.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
