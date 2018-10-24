package com.example.owner.checkactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SubActivity extends MainActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MySubActivity","onCreate");

        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        if (intent != null) {
            // なんかうまくいかなかったんだけど、リソースの抽出とやらをやったらなぜか取得できてた
            String str = intent.getStringExtra(getString(R.string.MainActivity));
            //インテントからなんとか引っ張り出せた文字列をトーストで表示させる。
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        }

        //課題2の部分
        Button SearchButton = findViewById(R.id.URLSearchButton);
        SearchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //ここにテキストフォームを用意しておく
                //ここに打ち込まれた文字列をURLの中に格納しておく
                EditText edit = findViewById(R.id.URLForm);
                String URL = edit.getText().toString();

                //取得してきていると思うんだけど、なんか落ちる→http://から始めていないせいだった。
                //書いてなかったら追加するとかは実際に作るときにはしようかな
                //テキストフォームに入った文字列をIntentの中に格納する
                Intent searchIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                //一旦強制的にグーグル開くことにした
                //失敗原因が分かったのでこのintentは使わないことにした。デバック用ってことで
                Intent intent =new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.com/"));

                //格納されたURLをVIEWするようにアクションを飛ばしている。
                startActivity(searchIntent);
            }
        });
    }
}
