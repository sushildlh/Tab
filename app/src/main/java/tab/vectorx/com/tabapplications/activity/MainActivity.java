package tab.vectorx.com.tabapplications.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tab.vectorx.com.tabapplications.R;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Menu");
    }

    @OnClick({R.id.fix, R.id.scroll, R.id.icontext, R.id.icon, R.id.custom})
    void click(View view) {
        switch (view.getId()) {
            case R.id.fix:
                startActivity(new Intent(this,FixTabActivity.class));
                break;
            case R.id.scroll:
                startActivity(new Intent(this,ScrollTabActivity.class));
                break;
            case R.id.icontext:
                startActivity(new Intent(this,IconTextActivity.class));
                break;
            case R.id.icon:
                startActivity(new Intent(this,IconTextActivity.class).putExtra("text",true));
                break;
            default:
                startActivity(new Intent(this,CustomTabActivity.class));
        }

    }
}
