/*
package com.example.rectangularprogressbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    SurfaceHolder mSurfaceHolder;
    boolean isRun;

    */
/** Background of the progress bar **//*

    Bitmap bmpDes;
    */
/** Movement angle **//*

    float m = 0;
    */
/** The radius of the circle surrounding the background of the progress bar **//*

    float r;
    */
/** Moving speed**//*

    float speed;

    public MySurfaceView (Context context, AttributeSet attrs) {
        super (context, attrs);
        //TODO Auto-generated constructor stub
        mSurfaceHolder = this.getHolder ();
        mSurfaceHolder.addCallback (this);
        */
/** Load progress bar **//*

        bmpDes = BitmapFactory.decodeResource (getResources (), R.drawable.d1) .copy (Bitmap.Config.ARGB_8888, true);
        */
/** Calculated radius **//*

        r = (float) Math.sqrt (Math.pow (bmpDes.getWidth ()/2, 2) + Math.pow (bmpDes.getHeight ()/2, 2));
        */
/** Based on 25s, calculate the moving speed **//*

        speed = (float) (360/(25000/33.0));
    }

    @Override
    public void surfaceChanged (SurfaceHolder arg0, int arg1, int arg2, int arg3) {
        //TODO Auto-generated method stub

    }

    @Override
    public void surfaceCreated (SurfaceHolder arg0) {
        //TODO Auto-generated method stub
        isRun = true;
        new Thread () {
            public void run () {
                while (isRun) {
                    long start = System.currentTimeMillis ();
                    Canvas canvas = null;
                    synchronized (mSurfaceHolder) {
                        canvas = mSurfaceHolder.lockCanvas ();
                        if (canvas != null) {
                            onGameDraw (canvas);
                            if (canvas != null && mSurfaceHolder != null) {
                                mSurfaceHolder.unlockCanvasAndPost (canvas);
                            }
                            m += speed;
                            if (m >= 360)
                                m = 0;
                        }
                    }
                    long end = System.currentTimeMillis ()-start;
                    if (end <33) {
                        try {
                            Thread.sleep (end);
                        } catch (InterruptedException e) {
                            //TODO Auto-generated catch block
                            e.printStackTrace ();
                        }
                    }
                }
            }
        } .start ();
    }

    @Override
    public void surfaceDestroyed (SurfaceHolder arg0) {
        //TODO Auto-generated method stub
        isRun = false;
    }

    private void onGameDraw (Canvas canvas) {
*/
/* canvas.drawColor (Color.BLACK);
		c = new Canvas (bmpDes);
		Paint paint = new Paint ();
		paint.setAntiAlias ​​(true);
		paint.setXfermode (new PorterDuffXfermode (Mode.DST_OUT));
		int sc = c.saveLayer (0, 0, bmpDes.getWidth (), bmpDes.getHeight (), null, LAYER_FLAGS);
		c.drawArc (new RectF (-(r-bmpDes.getWidth ()/2),-(r-bmpDes.getHeight ()/2), r * 2, r * 2), 0, m, true, paint) ;
		c.restoreToCount (sc);
		canvas.drawBitmap (bmpDes, 0, 0, null); *//*


        canvas.drawColor (Color.BLACK);
        Paint paint = new Paint ();
        paint.setFilterBitmap (false);
        //draw the second layer
        int sc = canvas.saveLayer (0, 0, 0 + bmpDes.getWidth (), 0 + bmpDes.getHeight (), null,
                Canvas.ALL_SAVE_FLAG );
        //draw progress bar background
        canvas.drawBitmap (bmpDes, 0, 0, paint);
        //Set occlusion properties
        paint.setXfermode (new PorterDuffXfermode (Mode.DST_OUT));
        //draw occlusion fan
        canvas.drawArc (new RectF (-(r-bmpDes.getWidth ()/2),-(r-bmpDes.getHeight ()/2), r * 2, r * 2), 0, m, true, paint) ;
        //Feedback the second layer to the canvas
        canvas.restoreToCount (sc);
    }
}
*/
