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

public class IconTextActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.viewpager)
    ViewPager mPager;

    @BindView(R.id.tabs)
    TabLayout mTab;

    private int icons []={R.drawable.ic_home_black_24dp,R.drawable.ic_mail_black_24dp,R.drawable.ic_work_black_24dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_text);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        setTitle("Icon Text Tab");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setUpViewPager(mPager);

        mTab.setupWithViewPager(mPager);
        setUpTabIcons();

    }

    private void setUpTabIcons() {
        mTab.getTabAt(0).setIcon(icons[0]);
        mTab.getTabAt(1).setIcon(icons[1]);
        mTab.getTabAt(2).setIcon(icons[2]);
    }

    public void setUpViewPager(ViewPager upViewPager) {
        ViewPagerAdapter adapter =new ViewPagerAdapter(getSupportFragmentManager(),getIntent().getBooleanExtra("text",false));
        adapter.addFragment(new OneFragment(),"Home");
        adapter.addFragment(new TwoFragment(),"Message");
        adapter.addFragment(new ThreeFragment(),"Work");
        upViewPager.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
