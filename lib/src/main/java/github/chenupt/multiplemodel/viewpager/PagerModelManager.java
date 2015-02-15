/*
 * Copyright 2015 chenupt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package github.chenupt.multiplemodel.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import github.chenupt.multiplemodel.ItemEntity;

/**
 * Created by chenupt@gmail.com on 2014/8/9.
 * Description TODO
 */
public class PagerModelManager {

    public final static String DATA = "data";

    private List<String> titleList;
    private List<Fragment> fragmentList;

    public PagerModelManager() {
        titleList = new ArrayList<String>();
        fragmentList = new ArrayList<Fragment>();
    }

    public Fragment getItem(int position){
        return fragmentList.get(position);
    }

    public int getFragmentCount(){
        return fragmentList.size();
    }

    public boolean hasTitles(){
        return titleList.size() != 0;
    }

    public CharSequence getTitle(int position){
        return titleList.get(position);
    }

    public PagerModelManager addFragment(Fragment fragment, String title){
        titleList.add(title);
        addFragment(fragment);
        return this;
    }

    public PagerModelManager addFragment(Fragment fragment){
        fragmentList.add(fragment);
        return this;
    }

    public PagerModelManager addFragment(List<ItemEntity> dataList){
        try {
            for (ItemEntity itemEntity : dataList) {
                Fragment fragment = (Fragment) itemEntity.getModelView().newInstance();
                Bundle bundle = new Bundle();
                bundle.putSerializable(DATA, itemEntity);
                fragment.setArguments(bundle);
                fragmentList.add(fragment);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return this;
    }


}
