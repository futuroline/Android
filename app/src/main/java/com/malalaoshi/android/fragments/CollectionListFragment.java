package com.malalaoshi.android.fragments;

import com.malalaoshi.android.R;
import com.malalaoshi.android.adapters.TeacherAdapter;
import com.malalaoshi.android.network.api.CollectionListApi;
import com.malalaoshi.android.network.api.MoreTeacherListApi;
import com.malalaoshi.android.core.base.BaseRecycleAdapter;
import com.malalaoshi.android.core.base.BaseRefreshFragment;
import com.malalaoshi.android.network.result.TeacherListResult;

/**
 * Created by kang on 16/8/3.
 */
public class CollectionListFragment  extends BaseRefreshFragment<TeacherListResult> {
    private String nextUrl;

    @Override
    public String getStatName() {
        return "收藏页列表";
    }

    @Override
    protected BaseRecycleAdapter createAdapter() {
        return new TeacherAdapter(getContext());
    }

    @Override
    protected TeacherListResult refreshRequest() throws Exception {
        return new CollectionListApi().getTeacherList();
    }

    @Override
    protected void refreshFinish(TeacherListResult response) {
        super.refreshFinish(response);
        if (response != null) {
            nextUrl = response.getNext();
        }
    }

    @Override
    protected TeacherListResult loadMoreRequest() throws Exception {
        return new MoreTeacherListApi().getTeacherList(nextUrl);
    }

    @Override
    protected void afterCreateView() {
        setEmptyViewText("您喜欢收藏的老师会在这里出现哦\n快去老师详情页收藏吧!");
        setEmptyViewIcon(R.drawable.ic_empty_collection);
    }

    public static CollectionListFragment newInstance() {
        CollectionListFragment f = new CollectionListFragment();
        return f;
    }
}
