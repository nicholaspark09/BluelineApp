package com.apps.nicholaspark.bluelineapp.ui.intro;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.apps.nicholaspark.bluelineapp.AppComponent;
import com.apps.nicholaspark.bluelineapp.R;
import com.apps.nicholaspark.bluelineapp.di.ApplicationScope;
import com.apps.nicholaspark.bluelineapp.ui.base.BaseController;
import com.bluelinelabs.conductor.Controller;



import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;

import static com.apps.nicholaspark.bluelineapp.util.Prescriptions.safeDispose;

/**
 * Created by nicholaspark on 10/23/16.
 */

public class IntroController extends BaseController implements IntroContract.View{
    @Inject IntroPresenter presenter;
    @BindView(R.id.view_pager) ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private int[] colors = new int[]{android.R.color.holo_blue_dark,android.R.color.holo_green_dark,android.R.color.holo_orange_dark};
    private int[] pagelayouts = new int[]{R.id.page_one_container,R.id.page_two_container,R.id.page_three_container,920};
    private Disposable disposable;

    @Override
    protected int layoutId() {
        return R.layout.controller_intro;
    }

    @Override
    protected void inject(AppComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    protected void onAttach(@NonNull View view) {
        super.onAttach(view);
        setPagerAdapter();
    }

    @Override
    protected void onDetach(@NonNull View view) {
        super.onDetach(view);

    }

    private void setPagerAdapter(){
        pagerAdapter = new DullPagerAdapter();
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public void showLoginUi() {

    }

    @Override
    public void showCreateAccountUi() {

    }
    //Static Layouts, change this to ControllerPagerAdapter if you want dynamic

    final class DullPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return pagelayouts.length;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int resId = R.id.page_one_container;
            switch(position){
                case 1:
                    resId = R.id.page_two_container;
                    break;
                case 2:
                    resId = R.id.page_three_container;
                    break;
                case 3:

                    return null;
                default:
                    break;
            }
            return container.findViewById(resId);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((View)object);
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }
    }

}
