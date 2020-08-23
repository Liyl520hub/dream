package com.dream.cleaner.ui.my.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.blankj.utilcode.util.ConvertUtils;
import com.dream.cleaner.R;
import com.dream.cleaner.utils.ShapeUtils;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.widget.ToolbarBackTitle;

import butterknife.BindView;

/**
 * @author : liyl
 * date   : 2020/8/23
 * desc   :
 */
public class UserInfoActivity extends BaseActivity {
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_mobile)
    TextView tvMobile;
    @BindView(R.id.rb_star)
    RatingBar rbStar;
    @BindView(R.id.cl_user_info)
    ConstraintLayout clUserInfo;
    @BindView(R.id.tv_work_info)
    TextView tvWorkInfo;
    @BindView(R.id.tv_user_id)
    TextView tvUserId;
    @BindView(R.id.tv_work)
    TextView tvWork;
    @BindView(R.id.tv_work_address)
    TextView tvWorkAddress;
    @BindView(R.id.tv_work_year)
    TextView tvWorkYear;
    @BindView(R.id.tv_work_time)
    TextView tvWorkTime;
    @BindView(R.id.tv_work_company)
    TextView tvWorkCompany;
    @BindView(R.id.tv_direct_leadership)
    TextView tvDirectLeadership;
    @BindView(R.id.tv_direct_leadership_mobile)
    TextView tvDirectLeadershipMobile;
    @BindView(R.id.tv_health_certificate)
    TextView tvHealthCertificate;
    @BindView(R.id.tv_health_certificate_date)
    TextView tvHealthCertificateDate;
    @BindView(R.id.tv_call_mobile)
    TextView tvCallMobile;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_info;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "个人资料");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

        tvCallMobile.setBackground(ShapeUtils.getDiyGradientDrawable(R.color.white,0, ConvertUtils.dp2px(1),R.color.color_F6B351));

        tvName.setText("李先生");
        tvMobile.setText("18888888888");
        rbStar.setRight(3);
        tvUserId.setText("员工编号   " + "200705464");
        tvWork.setText("工作岗位   " + "保洁员");
        tvWorkAddress.setText("所属区域   " + "回龙观区域");
        tvWorkYear.setText("入职时间   " + "2017-09-11");
        tvWorkTime.setText("工作时间   " + "6年");
        tvWorkCompany.setText("所属公司   " + "红星保洁（北京）有限公司");
        tvDirectLeadership.setText("直属领导   " + "李莉莉");
        tvDirectLeadershipMobile.setText("联系电话   " + "19999999999");
        tvHealthCertificate.setText("健康证号   " + "JK23568374743");
        tvHealthCertificateDate.setText("有效日期   " + "2028-01-16");


    }


}
