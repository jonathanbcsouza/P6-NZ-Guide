package com.tour.guide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Ache o layout da aba que mostra as abas
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        // Conecte o layout da aba com o view pager. Isto irá
        //   1. Atualizar o layout da aba quando o view pager for deslizado
        //   2. Atualizar o view pager quando uma aba for selecionada
        //   3. Definir os nomes da aba do layout da aba com os títulos do adapter do view pager
        //      chamando onPageTitle()
        tabLayout.setupWithViewPager(viewPager);
    }
}
