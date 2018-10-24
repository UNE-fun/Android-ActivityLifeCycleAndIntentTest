package com.example.owner.checkactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //onCreateが無事できたことをコンソールに出力しておく
        Log.d("Myactivity", "onCreate");

        //avtivity_main.xmlを読み込んでいる（と願っている。違ったらなんで入ってるのかわからない）
        //最初から書かれていたヤツ
        setContentView(R.layout.activity_main);

        //サブアクティビティを呼び出すボタン
        Button subActButton = findViewById(R.id.SubActivityButton);
        subActButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //インテントを新しく作る。タイポしてるとか言われてるけどまぁ無視で
                //ここでパケ名とクラス名を格納することで、明示的インテントを飛ばしている。3で暗黙的インテントになるので、なれたらコメントアウトする
                //Intent testintent = new Intent();
                //testintent.setClassName("com.example.owner.checkactivity", "com.example.owner.checkactivity.SubActivity");

                //ここにテキストフォームを用意しておく
                //ここに打ち込まれた文字列をURLの中に格納しておく
                EditText edit = findViewById(R.id.CommentForm);
                //フォームに打ち込まれた文字列を格納しておく
                String Comment = edit.getText().toString();

                //暗黙的インテントで呼び出す
                Intent testintent = new Intent();
                testintent.setAction("UNE");

                // カテゴリを追加したり、Uriを設定する。うまくいかなくて調べたらこの辺追加してたから真似した
                testintent.addCategory(Intent.CATEGORY_BROWSABLE);
                testintent.addCategory("hoge");

                testintent.setData(Uri.parse("http://www.google.co.jp/"));

                //インテントにぶちこんでサブアクティビティに送り付ける
                testintent.putExtra("comment", Comment);

                //アクティビティ飛ばすよ
                startActivity(testintent);
            }
        });

        //アクティビティのライフサイクルを確認するときにfinish()コマンドを呼び出すために設置したボタン。
        //押すとアクティビティ終了する
        Button fbutton = findViewById(R.id.finishButton);
        fbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    //こっから下はアクティビティのライフサイクルを確認するために用意したもの。今回は不要なので放置
    //あったらあったで便利な時が来るのかもしれなくもないかもしれないし
    @Override
    protected void onStart() {
        Log.d("Myactivity", "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("Myactivity", "onResume");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.d("Myactivity", "onRestart");
        super.onRestart();
    }


    @Override
    protected void onPause() {
        Log.d("Myactivity", "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("Myactivity", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("Myactivity", "onDestroy");
        super.onDestroy();
    }
}
