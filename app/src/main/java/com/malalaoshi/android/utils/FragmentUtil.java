package com.malalaoshi.android.utils;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.malalaoshi.android.R;

/**
 * Created by zl on 15/11/30.
 */
public final class FragmentUtil{
    public static void openFragment(int containerViewId,FragmentManager fragmentManager, Fragment pre, Fragment newFragment, String fragmentTag){
        if (newFragment==null) return;
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (pre!=null){
            if (!newFragment.isAdded()) {    // 先判断是否被add过
                transaction.hide(pre).add(containerViewId, newFragment,fragmentTag).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(pre).show(newFragment).commit(); // 隐藏当前的fragment，显示下一个
            }
        }else{
            transaction.add(containerViewId, newFragment, fragmentTag).commit(); // add下一个到Activity中
        }
    }

   /* public static void opFragmentMainActivity(FragmentManager fragmentManager, Fragment pre, Fragment newFragment, String fragmentTag){
        FragmentUtil.openFragment(R.id.content_layout, fragmentManager, pre, newFragment, fragmentTag);
    }*/

    public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, int frameId) {
        if (fragmentManager==null||fragment==null){
            throw new NullPointerException("fragmentManager or fragment is null");
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }
}
