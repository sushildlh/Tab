package tab.vectorx.com.tabapplications.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import tab.vectorx.com.tabapplications.R;
import tab.vectorx.com.tabapplications.fragments.OneFragment;
import tab.vectorx.com.tabapplications.fragments.ThreeFragment;
import tab.vectorx.com.tabapplications.fragments.TwoFragment;

public class CustomTabActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.viewpager)
    ViewPager mPager;

    @BindView(R.id.tabs)
    TabLayout mTab;

    private int [] icons={R.drawable.ic_home_black_24dp,R.drawable.ic_mail_black_24dp,R.drawable.ic_work_black_24dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tab);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        setTitle("Custom Tab");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setUpViewPager();

        mTab.setupWithViewPager(mPager);
        setUpTabsIcons();

    }

    private void setUpTabsIcons() {
        TextView one = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab,null);
        one.setText("Home");
        one.setCompoundDrawablesWithIntrinsicBounds(0,icons[0],0,0);
        mTab.getTabAt(0).setCustomView(one);

        TextView two = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab,null);
        two.setText("Message");
        two.setCompoundDrawablesWithIntrinsicBounds(0,icons[1],0,0);
        mTab.getTabAt(1).setCustomView(two);

        TextView three = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab,null);
        three.setText("Work");
        three.setCompoundDrawablesWithIntrinsicBounds(0,icons[2],0,0);
        mTab.getTabAt(2).setCustomView(three);


    }

    private void setUpViewPager() {
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager(),false);
        adapter.addFragment(new OneFragment(),"Home");
        adapter.addFragment(new TwoFragment(),"Message");
        adapter.addFragment(new ThreeFragment(),"Work");
        mPager.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
