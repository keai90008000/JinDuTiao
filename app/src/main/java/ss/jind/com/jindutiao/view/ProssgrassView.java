package ss.jind.com.jindutiao.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 陈驰 on 2017/4/9.
 */

public class ProssgrassView extends View {
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0){
                if (progress<100) {
                    progress++;
                    invalidate();
                    sendEmptyMessageDelayed(0, 20);
                }
            }
        }
    };
    private  int progress;
    public ProssgrassView(Context context) {
        super(context);
    }

    public ProssgrassView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProssgrassView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        paint.setAntiAlias(true);
        canvas.drawCircle(100,100,100, paint);

        //绘制圆弧
        RectF rectF=new RectF(0,0,200,200);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        //不适用中间点
        canvas.drawArc(rectF,0,360*progress/100,false,paint);
        String text=progress+"%";
        //绘制文本1%-100%
        Rect rect=new Rect();
        paint.setTextSize(50);
        paint.getTextBounds(text,0,text.length(),rect);

        paint.setColor(Color.GRAY);
        canvas.drawText(text,100-rect.width()/2,100+rect.height()/2,paint);
    }
    public void start(){
        progress=0;
      handler.sendEmptyMessageDelayed(0,20);
    }
}
