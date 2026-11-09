
package com.example.project;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);

        TabPagerAdapter adapter = new TabPagerAdapter(this);

        ViewPager2 viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setAdapter(adapter);

        TabLayoutMediator mediator = new TabLayoutMediator(
                tabLayout,
                viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(
                            @NonNull TabLayout.Tab tab,
                            int position) {

                        switch (position) {
                            case 0:
                                tab.setText("BMI 계산기");
                                break;

                            case 1:
                                tab.setText("면적 계산기");
                                break;

                            case 2:
                                tab.setText("Naver");
                                break;
                        }
                    }
                }
        );

        mediator.attach();
    }
}
