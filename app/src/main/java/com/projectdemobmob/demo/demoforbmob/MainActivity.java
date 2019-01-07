package com.projectdemobmob.demo.demoforbmob;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadBatchListener;
import cn.bmob.v3.listener.UploadFileListener;

public class MainActivity extends AppCompatActivity {
    private User user=new User();
    private String path=null;
    private String[] list=null;
    final List<String> permissionsList = new ArrayList<>();
    private int unok=-1;
    private String[] MANITEST ={Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "6efee115cb0d6e46cedd5a556ae2b9a0");
        //需要申请的权限列表
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { //判断版本号是否大于23
            if ((checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED)) //判断该权限是否获得授权
                permissionsList.add(Manifest.permission.READ_PHONE_STATE);

            if ((checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED))
                permissionsList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (permissionsList.size() == 0) {

            } else {
                requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
                        1); //进行权限申请
            }
        } else {

        }
//        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                City city = new City();
//                city.setName("山东");
//                city.setPhoto(null);
//                city.save(new SaveListener<String>() {
//                    @Override
//                    public void done(String s, BmobException e) {
//                        Toast.makeText(MainActivity.this, s.toString(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });
//        findViewById(R.id.upload).setOnClickListener(new View.OnClickListener() {
//            File file = new File(path);
//            BmobFile bmobFile = new BmobFile(file);
//
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                intent.setType("*/*");
//                intent.addCategory(Intent.CATEGORY_OPENABLE);
//                startActivityForResult(intent, 1);
//                Toast.makeText(MainActivity.this, file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
//                bmobFile.upload(new UploadFileListener() {
//                    @Override
//                    public void done(BmobException e) {
//                        System.out.printf("-------------------------------------------------\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n.");
//                        if (e == null) {
//                            Toast.makeText(MainActivity.this, "shangchaunSuccessed", Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(MainActivity.this, "error" + e.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//            }
//        });
//
//        }
//        private void savePhoto (BmobFile bmobFile){
//            City city = new City();
//            city.setObjectId("xZTNmmmo");
//            city.setPhoto(bmobFile);
//            city.update(new UpdateListener() {
//                @Override
//                public void done(BmobException e) {
//                    if (e == null)
//                        Toast.makeText(MainActivity.this, "关联成功", Toast.LENGTH_SHORT).show();
//                }
//            });
//    }
//        @Override
//        protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
//            super.onActivityResult(requestCode, resultCode, data);
//            Uri uri = data.getData();
//            ContentResolver cr = this.getContentResolver();
//            try {
//                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
//                File file = new File(getExternalCacheDir(), "photo.jpg");
//                FileOutputStream fos = new FileOutputStream(file);
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
//                fos.flush();
//                fos.close();
//                path = getExternalCacheDir().toString() + "photo.jpg";
//                Toast.makeText(this, getExternalCacheDir().toString() + "photo.jpg", Toast.LENGTH_SHORT).show();
//            } catch (Exception e) {
//                e.printStackTrace();
//                Log.e(e.toString(), e.getMessage());
//            }
//            /*Message msg = new Message();*/
//        /*msg.obj=b
//        handler.sendMessage(msg);
//        Toast.makeText(MainActivity.this, file.toString(), Toast.LENGTH_SHORT).show();*/
//        }
//        private void init(){
//
//        }
    }
}
