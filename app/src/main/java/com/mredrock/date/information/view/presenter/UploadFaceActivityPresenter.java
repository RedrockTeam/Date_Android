package com.mredrock.date.information.view.presenter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android.http.RequestManager;
import com.ant.jobgod.imagetool.corpimage.CropImageIntentBuilder;
import com.ant.jobgod.imagetool.imageprovider.ImageElement;
import com.ant.jobgod.imagetool.imageprovider.ImageProvider;
import com.ant.jobgod.imagetool.imageprovider.OnImageSelectListener;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.mredrock.date.R;
import com.mredrock.date.app.APP;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.app.TokenParams;
import com.mredrock.date.home.presenter.DrawerFragmentPresenter;
import com.mredrock.date.model.FaceModel;
import com.mredrock.date.util.Utils;

import java.io.File;
import java.util.concurrent.Executor;

/**
 * Created by Administrator on 2015/6/20.
 */
public class UploadFaceActivityPresenter extends BaseActivityPresenter<UploadFaceActivityVu>{
    private ImageProvider mProvider;
    private String finalImagePath;
    private String finalImageFile;
    private String mFaceAddress;
    MaterialDialog dialog;
    private boolean isFaceChanged = false;
    boolean firstOk = false;
    private static final int REQUEST_CROP_PICTURE = 4;
    @Override
    public Class<UploadFaceActivityVu> getVuClass() {
        return UploadFaceActivityVu.class;
    }

    @Override
    public void onBindVu() {
        vu.setPresenter(this);
        String img_url = getIntent().getStringExtra("img_url");
        if(img_url!=null){
            vu.setImageURI(Uri.parse(img_url));
        }else if(DrawerFragmentPresenter.img_url!=null){
                img_url=DrawerFragmentPresenter.img_url;
                vu.setImageURI(Uri.parse(img_url));
            }
        mProvider = new ImageProvider(this);
        finalImagePath = getFilesDir() + "/corpimg/";
        Utils.fileDelete(new File(finalImagePath));
        new File(finalImagePath).mkdirs();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.meu_edti_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.infor_edit){
            if(isFaceChanged){
                upLoadFace();
            }else{
                Utils.Toast("请修改头像后再保存");
            }

        }
        return super.onOptionsItemSelected(item);

    }
    public void showDialog(){
         dialog = new MaterialDialog.Builder(this)
                .title("正在上传")
                .content("请稍后")
                .progress(true, 100)
                .cancelable(false)
                .show();
    }
    private void upLoadFace() {
        showDialog();
        FaceModel.upload(finalImageFile, new FaceModel.UploadFaceCallback() {
            @Override
            public void onSuccess(String info) {
                dialog.dismiss();
                Utils.Toast("上传成功");
                setResult(200, new Intent(info));
                UploadFaceActivityPresenter.this.finish();
            }

            @Override
            public void onError(String info) {
                Utils.Toast(info);
                dialog.dismiss();
            }
        });
    }

    public void getImageFromCamera(){
        mProvider.getImageFromCamera(new OnImageSelectListener<ImageElement>() {
            @Override
            public void onImageSelect(ImageElement imageElement) {
                finalImageFile = finalImagePath + imageElement.hashCode() + ".jpg";
                Utils.Log("fuck");
                startCrop(imageElement.getLargeImage(), Uri.fromFile(new File(finalImageFile)));
            }
        });
    }
    public void getImageFromAlbum(){
        mProvider.getImageFromAlbum(new OnImageSelectListener<ImageElement>() {
            @Override
            public void onImageSelect(ImageElement imageElement) {
                Utils.Toast("onImageSelect");
                finalImageFile = finalImagePath + imageElement.hashCode() + ".jpg";
                Utils.Log(new File(finalImageFile).exists());
                startCrop(imageElement.getLargeImage(), Uri.fromFile(new File(finalImageFile)));
            }
        });
    }
    public void getImageFromNet(){
        mProvider.getImageFromNet(ImageProvider.Searcher.SOSO, new OnImageSelectListener<ImageElement>() {
            @Override
            public void onImageSelect(ImageElement imageElement) {
                showDialog();
                ImagePipeline imagePipeline = Fresco.getImagePipeline();
                DataSource<CloseableReference<CloseableImage>>
                        dataSource = imagePipeline.fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(imageElement.getLargeImage()).build(), this);
                DataSubscriber dataSubscriber = new BaseBitmapDataSubscriber() {
                    @Override
                    protected void onNewResultImpl(Bitmap bitmap) {
                        dialog.dismiss();
                        finalImageFile = finalImagePath + bitmap.hashCode() + ".jpg";
                        Utils.BitmapSave(bitmap, finalImageFile);
                        startCrop(Uri.fromFile(new File(finalImageFile)));
                    }

                    @Override
                    protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> closeableReferenceDataSource) {
                       dialog.dismiss();
                        Utils.Toast("图片下载失败");
                    }
                };
                final Handler handler = new Handler();
                dataSource.subscribe(dataSubscriber, new Executor() {
                    @Override
                    public void execute(Runnable command) {
                        handler.post(command);
                    }
                });
            }
        });
    }

    public void startCrop(Uri data){
        startCrop(data, data);
    }

    public void startCrop(Uri data,Uri output){
        CropImageIntentBuilder cropImage = new CropImageIntentBuilder(960, 1080,960, 1080, output);
        cropImage.setSourceImage(data);
        startActivityForResult(cropImage.getIntent(this), REQUEST_CROP_PICTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mProvider.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CROP_PICTURE && resultCode == RESULT_OK){
            Utils.Toast("isExists: " + new File(finalImageFile).exists());
           // Utils.Log(new File(finalImageFile).exists());
           // mImg_face.setImageURI(Uri.fromFile(new File(finalImageFile)));
            vu.setImageURI(Uri.fromFile(new File(finalImageFile)));
            isFaceChanged = true;
        }
    }
}
