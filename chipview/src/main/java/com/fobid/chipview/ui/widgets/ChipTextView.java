package com.fobid.chipview.ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.ColorInt;
import android.support.annotation.Dimension;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.Gravity;

import com.fobid.chipview.R;

/**
 * Created by android01 on 2017. 8. 25..
 */

public class ChipTextView extends AppCompatTextView {

    private final Paint paint;
    private final Rect rect;
    private final RectF rectF;

    private int backgroundColor;
    private float radius;

    public ChipTextView(Context context) {
        this(context, null);
    }

    public ChipTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChipTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        radius = context.getResources().getDimension(R.dimen.chip_radius);

        paint = new Paint();
        rect = new Rect();
        rectF = new RectF();

        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ChipTextView);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.ChipTextView_chip_backgroundColor) {
                backgroundColor = a.getColor(attr, 0);
            } else if (attr == R.styleable.ChipTextView_chip_radius) {
                radius = a.getDimension(attr, radius);
            }
        }
        a.recycle();

        setGravity(Gravity.CENTER);
        setBackgroundColor(backgroundColor);
        setRadius(radius);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(backgroundColor);
        rect.set(0, 0, getWidth(), getHeight());
        rectF.set(rect);

        canvas.drawRoundRect(rectF, radius, radius, paint);

        super.onDraw(canvas);
    }

    public void setBackgroundColor(final @ColorInt int color) {
        this.backgroundColor = color;
    }

    public
    @ColorInt
    int getBackgroundColor() {
        return backgroundColor;
    }

    public void setRadius(final @Dimension float radius) {
        this.radius = radius;
    }

    public
    @Dimension
    float getRadius() {
        return radius;
    }
}
