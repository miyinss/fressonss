package com.example.frescos;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.yj)
    Button yj;
    @BindView(R.id.yx)
    Button yx;
    @BindView(R.id.bl)
    Button bl;
    @BindView(R.id.jianjin)
    Button jianjin;
    @BindView(R.id.frecs)
    SimpleDraweeView frecs;
    @BindView(R.id.cipan)
    Button cipan;
    @BindView(R.id.dotu)
    Button dotu;
    @BindView(R.id.jiantin)
    Button jiantin;
    private RoundingParams roundingParams;
    private Uri uri;
    /* private SimpleDraweeView simple;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        uri = Uri.parse("http://img.netbian.com/file/2019/0201/5681dd297ad0175df37309419171ebd1.jpg");
        frecs.setImageURI(uri);
        frecs.setAspectRatio(1.33f);
        roundingParams = RoundingParams.fromCornersRadius(5f);

    }

    @OnClick({R.id.yj, R.id.yx, R.id.bl, R.id.jianjin,R.id.cipan, R.id.dotu, R.id.jiantin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.yj:
                roundingParams.setCornersRadius(10);
                frecs.getHierarchy().setRoundingParams(roundingParams);
                break;
            case R.id.yx:
                roundingParams.setRoundAsCircle(true);
                frecs.getHierarchy().setRoundingParams(roundingParams);
                break;
            case R.id.bl:
                frecs.setAspectRatio(3.33f);
                break;
            case R.id.jianjin:
                /*Uri uri;
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setProgressiveRenderingEnabled(true)
                        .build();
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(mSimpleDraweeView.getController())
                        .build();
                mSimpleDraweeView.setController(controller);*/
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri).setLocalThumbnailPreviewsEnabled(true).build();
                AbstractDraweeController builder = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(frecs.getController())
                        .build();
                frecs.setController(builder);
                break;
            case R.id.cipan:
               /* DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(this)
                        .setBaseDirectoryPath(new File(Environment.getExternalStorageDirectory().getAbsoluteFile(),"Moe Studio"))
                        .setBaseDirectoryName("fresco_sample")
                        .setMaxCacheSize(200*1024*1024)//200MB
                        .build();
                ImagePipelineConfig imagePipelineConfig = ImagePipelineConfig.newBuilder(this)  // 配置ImagePipeline
                    .setMainDiskCacheConfig(diskCacheConfig)
                    .build();
                Fresco.initialize(this,imagePipelineConfig);*/
                DiskCacheConfig newBuilder = DiskCacheConfig.newBuilder(this)
                        .setBaseDirectoryPath(new File(Environment.getExternalStorageDirectory().getAbsoluteFile(),"fresonstotio"))
                        .setBaseDirectoryName("fresco_sample")
                        .setMaxCacheSize(1024*1024*200)
                        .build();
                ImagePipelineConfig builder1 = ImagePipelineConfig.newBuilder(this)
                        .setMainDiskCacheConfig(newBuilder)
                        .build();
                Fresco.initialize(this,builder1);
                break;
            case R.id.dotu:
                break;
            case R.id.jiantin:
                break;
        }
    }

}
