package cn.jclick.libs;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class LvProgressBar extends RelativeLayout {
    private TextView progressHint;
    private ProgressBar progressBar;
    private View footerTopDivider;

    public LvProgressBar(Context context) {
        super(context);
        init(context);
    }

    public LvProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View progressBarItemView = (View) inflater.inflate(R.layout.progressbar_item, null);
        addView(progressBarItemView);
        progressBar = (ProgressBar) progressBarItemView.findViewById(R.id.lv_progress_bar);
        progressHint = (TextView) progressBarItemView.findViewById(R.id.progress_item_text);
        footerTopDivider = progressBarItemView.findViewById(R.id.footer_top_divider);
    }

    public void setHintSize(float size) {
        progressHint.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
    }

    public void setHintColor(int resId) {
        progressHint.setTextColor(resId);
    }

    public void setHintColorList(ColorStateList list) {
        progressHint.setTextColor(list);
    }

    public void setHintVisibility(int visibility) {
        progressHint.setVisibility(visibility);
    }

    public void setHintText(int resId) {
        progressHint.setText(resId);
    }

    public void setAnimImageVisibility(int visibility) {
        if (visibility == View.GONE) {
            progressBar.setVisibility(visibility);
        } else if (visibility == View.VISIBLE) {
            progressBar.setVisibility(visibility);
        }
    }

    public void setAnimImageSize(int size) {
        LayoutParams params = new LayoutParams(size, size);
        progressBar.setLayoutParams(params);
    }

    public void setTopDividerVisible(boolean visible) {
        footerTopDivider.setVisibility(visible ? View.VISIBLE : View.GONE);
    }
}
