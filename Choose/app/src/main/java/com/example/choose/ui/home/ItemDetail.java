package com.example.choose.ui.home;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.choose.R;
import com.example.choose.RetrofitStatic;
import com.example.choose.UserInfo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDetail extends AppCompatActivity {
    private ImageView imageView;
    private TextView title, desc;
    private ImageButton like, addCart;
    private Button buy;
    private Intent intent;

    private int itemId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity)this).getSupportActionBar().hide();
        setContentView(R.layout.activity_item_detail);

        imageView = findViewById(R.id.detail_image);
        title = findViewById(R.id.detail_title);
        desc = findViewById(R.id.detail_desc);
        like = findViewById(R.id.like);
        addCart = findViewById(R.id.cart);
        buy = findViewById(R.id.buy);

        intent = getIntent();
//        imageView.setImageResource(Integer.parseInt(intent.getStringExtra("image")));
        itemId = intent.getIntExtra("ItemId", -1);
        Glide.with(this).load("http://192.249.19.252:2680" + intent.getStringExtra("image")).into(imageView);
        title.setText(intent.getStringExtra("title"));
        desc.setText(intent.getStringExtra("desc"));

        Log.d("Print", "----------------------" + itemId + "-----------------------");

        // ************* 최근 본 상품 DB에 추가 *************** //
        //
        //

        like.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("@","~~");
                // *********** 좋아요 DB에 추가 ************ //
            }
        });
        addCart.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("@","!!");
                // *********** 장바구니 DB에 추가 ************ //
                if (UserInfo.isIsLogin()) {
                    addUserCart(UserInfo.getEmail(), itemId);
                } else {
                    Toast.makeText(getApplicationContext(), "로그인이 필요한 서비스 입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buy.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ************* 구매 화면으로 전환 *************** //
            }
        });

    }

    private void addUserCart(String email, int itemId) {
        RetrofitStatic.getmRetrofitAPI().addItemToCart(email, itemId).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("PRINT", "--------------Adding to Cart Success!!-----------------");
                Toast.makeText(getApplicationContext(), "장바구니에 추가 되었습니다.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("PRINT", "--------------Adding to Cart Fail!!--------------------");
            }
        });
    }
}
