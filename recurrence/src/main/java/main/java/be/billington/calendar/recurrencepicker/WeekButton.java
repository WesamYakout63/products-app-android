/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package main.java.be.billington.calendar.recurrencepicker;

import android.R;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class WeekButton extends android.widget.ToggleButton {

    private static int mWidth;

    public WeekButton(Context context) {
        super(context);
        initFont(context);
    }

    public WeekButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFont(context);
    }

    public WeekButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initFont(context);
    }

    private void initFont(Context context){
    	try {
    		Typeface fontTypeFace = Typeface.createFromAsset(context.getAssets(),
    				"fonts/GOTHICB.TTF");
    		this.setTypeface(fontTypeFace);
//    		this.setTextSize(context.getResources().getDimension(be.billington.calendar.recurrencepicker.R.dimen.add_apple_name_title_size));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void setSuggestedWidth(int w) {
        mWidth = w;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int h = getMeasuredHeight();
        int w = getMeasuredWidth();
        h=w;
//        if (h > 0 && w > 0) {
//            if (w < h) {
//                if (View.MeasureSpec.getMode(getMeasuredHeightAndState()) != MeasureSpec.EXACTLY) {
//                    h = w;
//                }
//            } else if (h < w) {
//                if (View.MeasureSpec.getMode(getMeasuredWidthAndState()) != MeasureSpec.EXACTLY) {
//                    w = h;
//                }
//            }
//        }
        setMeasuredDimension(w, h);
    }
}
