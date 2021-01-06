package com.example.egzas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    class MyView extends View {

        public MyView(Context context) {
            super(context);
            p = new Paint();
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a);
            bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.b);
            bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.c);
            //bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.d);
            /*
            button.setText("Baigti");
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {

                    for (int i = 0; i < 3; i++) {
                        if (x[i] >= sx[i] && x[i] <= sx[i] + xx && y[i] >= yy1 && y[i] <= yy1 + yy2) {
                            kiek += 1;
                        }
                    }
                    Toast toast;
                    Context context = getApplicationContext();
                    switch (kiek) {
                        case 0:
                            CharSequence text = "NK nemoki";
                            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 100);
                            toast.show();
                            break;
                        case 1:
                            text = "yra buve ir blogeu";
                            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 100);
                            toast.show();
                            break;
                        case 2:
                            text = "close enough";
                            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 100);
                            toast.show();
                            break;
                        case 3:
                            text = "durnas";
                            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 100);
                            toast.show();
                            break;
                    }
                }
            });*/
        }

        Paint p;

        Button button;

        Bitmap bitmap;
        Bitmap bitmap1;
        Bitmap bitmap2;
        //Bitmap bitmap3;

        public float[] x = {1100, 1820, 340, 1820};
        public float[] y = {200, 200, 200, 700};
        public float[] sx = {310, 955, 1650};

        /*float x1 = 1100;
        float y1 = 200;
        float x2 = 1820;
        float y2 = 200;
        float x3 = 340;
        float y3 = 200;
        float ax= 310;// kairys kampas x
        float bx= 955;
        float cx= 1650;*/

        float xx = 400;//krastine
        float yy1 = 950;// kairys kampas y
        float yy2 = 550;// y krastine
        int sidex = 300;
        int sidey = 350;

        // perkelimo koordinates
        boolean drag1 = false;
        boolean drag2 = false;
        boolean drag3 = false;
        float dragX = 0;
        float dragY = 0;

        public int kiek = 0;

        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(40, 52, 224, 215);

            p.setTextSize(70);
            p.setColor(Color.BLACK);
            canvas.drawText("Ar gerai pasiruošei egzaminui?", 750, 85, p);
            p.setTextSize(50);
            canvas.drawText("Sujunkite autoriaus nuotrauką su jo aprašymu", 700, 170, p);
            p.setColor(Color.LTGRAY);
            p.setStrokeWidth(20);
            canvas.drawCircle(500, 1100, 270, p);
            canvas.drawCircle(1200, 1100, 270, p);
            canvas.drawCircle(1900, 1100, 270, p);
            p.setTextSize(50);
            p.setColor(Color.BLACK);

            canvas.drawText("XVIII a. rašytojas,", 310, 950, p);
            canvas.drawText(" pastorius, rašęs apie ", 260, 1030, p);
            canvas.drawText("lietuvninko buitį,", 310, 1110, p);
            canvas.drawText("jo ryšį su gamta", 320, 1190, p);
            canvas.drawText(" ir bendruomene", 310, 1270, p);

            canvas.drawText("XIX a. pabaigos", 1020, 950, p);
            canvas.drawText("XX a. pradžios lietuvių", 955, 1030, p);
            canvas.drawText("prozininkas, lyrinės", 988, 1110, p);
            canvas.drawText("prozos pradininkas", 990, 1190, p);
            canvas.drawText("Lietuvoje", 1105, 1270, p);

            canvas.drawText("Lietuvių išeivijos", 1710, 950, p);
            canvas.drawText("rašytojas, prozininkas,", 1655, 1030, p);
            canvas.drawText("modernizmo atstovas, ", 1650, 1110, p);
            canvas.drawText("didžiausias novatorius", 1645, 1190, p);
            canvas.drawText("lietuvių literatūroje", 1690, 1270, p);

            canvas.drawBitmap(bitmap, x[0], y[0], p);
            canvas.drawBitmap(bitmap1, x[1], y[1], p);
            canvas.drawBitmap(bitmap2, x[2], y[2], p);
            //canvas.drawBitmap(bitmap3, x[3], y[3], p);


        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            // prisilietimo koordinates
            float evX = event.getX();
            float evY = event.getY();

            switch (event.getAction()) {
                // prisilietimas
                case MotionEvent.ACTION_DOWN:
                    // jei ekranas paliestas kvadrato ribose
                {
                    for (int i = 0; i < 3; i++) {
                        if (evX >= x[i] && evX <= x[i] + sidex && evY >= y[i] && evY <= y[i] + sidey) {
                            switch (i) {
                                case 0:
                                    drag1 = true;
                                    break;
                                case 1:
                                    drag2 = true;
                                    break;
                                case 2:
                                    drag3 = true;
                                    break;
                            }
                            // skirtumas tarp kairiojo virsutinio kvadrato kampo ir lietimo tasko
                            dragX = evX - x[i];
                            dragY = evY - y[i];
                        }
                    }
                }
                break;
                // perkeliame
                case MotionEvent.ACTION_MOVE:
                    // jeigu perkelimo rezimas ijungtas
                    if (drag1) {
                        // nustatome naujas koordinates
                        x[0] = evX - dragX;
                        y[0] = evY - dragY;
                        // perpiesiame ekrana
                        invalidate();
                    } else if (drag2) {
                        // nustatome naujas koordinates
                        x[1] = evX - dragX;
                        y[1] = evY - dragY;
                        // perpiesiame ekrana
                        invalidate();
                    } else if (drag3) {
                        // nustatome naujas koordinates
                        x[2] = evX - dragX;
                        y[2] = evY - dragY;
                        // perpiesiame ekrana
                        invalidate();
                    }
                    break;
                // lietimas baigtas
                case MotionEvent.ACTION_UP:
                    // ijungiame perkelimo rezima
                    drag1 = false;
                    drag2 = false;
                    drag3 = false;
                    /*if (a && b && c)
                    {
                        Toast win = Toast.makeText(context, text, duration);
                        win.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 100);
                        win.show();
                    }*/
                    break;
            }
            return true;
        }


        /*public void atidarytiKitaLanga(View view){
            //Intent – ketinimas, kas turi startuoti atidarius langą
            Intent intent = new Intent(this, kitas);
            //objekto sukūrimas, this - šis langas, koks atidaromas langas
            startActivity(intent);//startuojame ketinima
        }*/

    }
}
//}


