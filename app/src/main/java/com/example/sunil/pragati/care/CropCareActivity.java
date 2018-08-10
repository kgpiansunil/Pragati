package com.example.sunil.pragati.care;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.sunil.pragati.R;
import com.example.sunil.pragati.VolleySingleton;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class CropCareActivity extends AppCompatActivity {


    static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final String TAG = "CropCare";
    private int PICK_IMAGE_REQUEST = 2;
    private AppCompatImageButton cameraBtn, selectBtn;
    private Bitmap imageBitmap;
    private Button mUploadBtn;
    private ImageView mPreviewImage;
    private ProgressDialog loader;
    LinearLayout imageUploadContainer, responseContainer;

    CountDownTimer CDT;
    int i = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_care);

        cameraBtn = (AppCompatImageButton) findViewById(R.id.crop_camera_btn);
        selectBtn = (AppCompatImageButton) findViewById(R.id.crop_select_btn);
        mUploadBtn = (Button) findViewById(R.id.crop_upload_btn);
        mPreviewImage = (ImageView) findViewById(R.id.crop_preview_imageView);
        loader = new ProgressDialog(CropCareActivity.this);

        loader.setMessage("Please wait...");
        loader.setCancelable(true);
        loader.setProgress(i);


        imageUploadContainer = (LinearLayout) findViewById(R.id.img_upload_container);
        responseContainer = (LinearLayout) findViewById(R.id.response_container);

        responseContainer.setVisibility(View.GONE);


        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dispatchTakePictureIntent();

            }
        });

        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectPictureIntent();


            }
        });

        mUploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (imageBitmap != null) {
                    //  upload_image(imageBitmap);

                    loader.show();

                    CDT = new CountDownTimer(5000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            loader.setMessage("Please wait.." + i + " sec");

                            --i;
                        }

                        public void onFinish() {
                            loader.dismiss();
                            Intent intent = new Intent(CropCareActivity.this, LeafTesting.class);
                            startActivity(intent);
                        }
                    }.start();


                } else
                    Toast.makeText(CropCareActivity.this, R.string.no_image_warning_msg, Toast.LENGTH_SHORT).show();

            }


        });

    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }


    private void selectPictureIntent() {
        Intent intent = new Intent();
        // Show only images, no videos or anything else
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        // Always show the chooser (if there are multiple options available)
        startActivityForResult(Intent.createChooser(intent, getString(R.string.pic_chooser_msg)), PICK_IMAGE_REQUEST);
    }

    private void upload_image(final Bitmap imageBitmap) {

//        Toast.makeText(this, "Uploading...", Toast.LENGTH_LONG).show();
        loader.setMessage(getString(R.string.upload_progress_msg));
        loader.show();


        String image_upload_url = "http://13.90.149.69";

        //Converting Bitmap to String

        final String image = getStringImage(imageBitmap);

        Log.i(TAG, "upload_image: " + image);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, image_upload_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG, "onResponse: " + response);
                        Toast.makeText(CropCareActivity.this, response, Toast.LENGTH_SHORT).show();
                        loader.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        loader.dismiss();
                        Log.i(TAG, "onErrorResponse: " + volleyError.toString());
                        Toast.makeText(CropCareActivity.this, R.string.something_went_wrong_msg, Toast.LENGTH_SHORT)
                                .show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Creating parameters
                Map<String, String> params = new Hashtable<>();
                //Adding parameters
                params.put("imageString", image);
                //returning parameters
                return params;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        //  VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }

    private String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            mPreviewImage.setImageBitmap(imageBitmap);
        } else if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            try {
                imageBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));
                mPreviewImage.setImageBitmap(imageBitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
