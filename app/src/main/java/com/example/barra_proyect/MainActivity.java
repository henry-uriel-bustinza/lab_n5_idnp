package com.example.barra_proyect;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int[] a = {20, 25, 30 ,40, 10, 20, 25, 30 ,40, 10};
        String[] b = {"Juan", "Luis", "Pedro", "Mario", "Felix", "Juan", "Luis", "Pedro", "Mario", "Felix"};
        Barras vista= new Barras(this, b, a);
        setContentView(vista);
    }
}

class Barras extends View {

    private int alto, ancho;
    private int temp1, temp2;
    private int colorBar = Color.BLUE;
    private int[] vals;
    private String[] names;
    private int cant;
    //int[] a = {20, 25, 30 ,40, 10, 20, 25, 30 ,40, 10};
    //String[] b = {"Juan", "Luis", "Pedro", "Mario", "Felix", "Juan", "Luis", "Pedro", "Mario", "Felix"};

    public Barras(Context context, String[] nombres, int[] valores) {
        super(context);
        //setAtributos(b, a);
        setAtributos(nombres, valores);
    }

    public void setColor(int color) {
        colorBar = color;
    }

    private void setAtributos(String[] nombres, int[] valores) {
        names = nombres;
        vals = valores;

    }

    private void drawBars(Canvas canvas) {

        DibujarBase(canvas);
        setCant(names.length);
        /*DibujarBarra(canvas, 20, "Hola");*/


        for(int iN = 0; iN < names.length; ++iN){
            DibujarBarra(canvas, vals[iN], names[iN]);
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        drawBars(canvas);
    }

    public void DibujarBase(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        ancho = canvas.getWidth();
        alto = canvas.getHeight();
        canvas.drawRect(10, alto / 4, ancho - 10, alto - alto / 4, paint);
        int lineB = alto/3*2;
        paint.setStrokeWidth(5);
        canvas.drawLine(25, lineB,ancho-25, lineB, paint);
        canvas.drawLine(50, lineB+25,50, (alto/4)+ 30, paint);
        paint.setTextSize(30 - cant);
        for(int i=0;i<7;++i){
            canvas.drawText((i*10)+"", 20, lineB-(i*100), paint);
        }
    }

    public void DibujarBarra(Canvas canvas, int peso, String str) {
        Paint paint = new Paint();

        paint.setStrokeWidth(60);
        paint.setColor(Color.BLUE);
        //canvas.drawRect(temp1 - ancho, alto - alto / 3 - (peso * 10), temp1 + ancho, alto - alto / 3, paint);
        int lineB = alto/3*2;
        canvas.drawLine(temp1, lineB,temp1, lineB-(peso*10), paint);
        paint.setColor(Color.BLACK);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(40 - cant);
        canvas.drawText(str, temp1, lineB + 50, paint);
        temp1 += temp2;

    }

    public void setCant(int x) {
        temp1 = ancho / (x + 1) + 30;
        temp2 = ancho / (x + 1);
        cant = x;
    }
}

