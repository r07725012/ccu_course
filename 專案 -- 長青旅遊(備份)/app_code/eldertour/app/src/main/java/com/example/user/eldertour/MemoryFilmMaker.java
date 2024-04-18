package com.example.user.eldertour;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

/**
 * Created by user on 2017/2/19.
 */

public class MemoryFilmMaker extends AppCompatActivity {

    private Bitmap bitmap;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_filmmaker);
        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getPackageManager().getLaunchIntentForPackage("com.appbasic.phototovideoconverter");
                startActivity(intent);

            }
        });

    }



    //不知道是不是要把圖片格式統一?(圖片,格式化寬,格式化高)
    public static Bitmap zoomBitmap(Bitmap bitmap, int width, int height) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float scaleWidth = ((float) width / w);
        float scaleHeight = ((float) height / h);
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
        return newbmp;
    }

    public byte[] Bitmap2Bytes(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }

    public Bitmap Bytes2Bimap(byte[] b) {
        if (b.length != 0) {
            return BitmapFactory.decodeByteArray(b, 0, b.length);
        }
        else {
            return null;
        }
    }

    void makeVideo(Bitmap[] bis){
        FileOutputStream outputStream=null;
        byte[]bys=null;
        //存檔
        try {
            //建檔
            outputStream=new FileOutputStream("/sdcard/mytaken.mp4",true);
            //圖片寫入檔案(把圖片轉成bytes後加到檔案串流(至於幾秒的定義等做出來再說好了))
            for(int i =0;i<bis.length;i++){
                bys=Bitmap2Bytes(bis[i]);
                outputStream.write(bys);
            }
            outputStream.close();

        } catch (Exception ex) {
            Toast.makeText(MemoryFilmMaker.this,"存檔錯誤!", Toast.LENGTH_LONG).show();
        }

    }

    void catchpicsinsdandmakevideo(){

    }


}
