package fall.huihui.com;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by cmh on 2017/3/2.
 */
public class fallView extends View{

    private int w,h; // 界面宽高
    final static int NUM = 5 ;
    int snowSpeed = 50 ; //
    int snowSize = 50;

    int x[];//坐标
    int y[];
    Paint paint;//画笔


    public fallView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 初始化
        w = context.getResources().getDisplayMetrics().widthPixels;
        h = context.getResources().getDisplayMetrics().heightPixels;

        initPaint();

        new Thread(runnable).start(); // 开启线程
    }

    public void initPaint(){
        paint = new Paint() ;
        paint.setColor(Color.WHITE);
        paint.setTextSize(snowSize);


        x = new int[NUM];
        y = new int[NUM];
        for(int i =0 ; i < NUM;i++){
            x[i] = (int) (Math.random()*w);
            y[i] = (int) (Math.random()*h);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


//			canvas.drawText("PM2.5", x[i], y[i], paint);
        DrawLine(canvas,s, x, y, paint);



    }
    //存储的数据
    private String s ;

    public String getPollutant(){

        return s;
    }
    public void setPollutant(String s){

        this.s = s;
    }

    private void DrawLine(Canvas canvas,String s, int[] x2, int[] y2, Paint paint2) {

        for(int i =0 ; i<NUM;i++){

            canvas.drawText( s , x[i], y[i], paint);

        }
    }

    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        public void run()
        {
            for(int i =0 ; i < NUM;i++)
            {
                y[i] += 3 ;
                if(y[i] > h)
                    y[i] = 0 ;
            }
            fallView.this.invalidate(); // 刷新
            handler.postDelayed(runnable, snowSpeed); //延迟时间
        }
    };
}
