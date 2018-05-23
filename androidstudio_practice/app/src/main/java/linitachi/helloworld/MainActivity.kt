package linitachi.helloworld

import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import linitachi.helloworld.R.id.*
import java.io.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun load(view: View) {
        Toast.makeText(this,"沒有輸入身高喔",2).show()
    }
    fun store(view: View) {
        val sd_main = File(Environment.getExternalStorageDirectory(),"/AAAAAA")
        Toast.makeText(this,sd_main.toString(),2).show()
        var success = true
        if (!sd_main.exists()) {
            success = sd_main.mkdirs()
            Toast.makeText(this,success.toString(),2).show()
        }
        if (success) {
            val sd = File("testt.txt")
            Toast.makeText(this,"33333",2).show()
            if (!sd.exists()) {
                success = sd.mkdirs()
                Toast.makeText(this,"22222",2).show()
            }
            if (success) {
                // directory exists or already created
                val dest = File(sd, "testt.txt")
                dest.appendText("record goes here")
                Toast.makeText(this,"身高喔",2).show()
            }
        }
    }
    fun bmi(view: View) {
        // 顯示訊息框，指定三個參數
        // Context：通常指定為「this」
        // String或int：設定顯示在訊息框裡面的訊息或文字資源
        // int：設定訊息框停留在畫面的時間
        if ("".equals(et1.getText().toString().trim()))
            Toast.makeText(this,"沒有輸入身高喔",2).show()
        else if ("".equals(et2.getText().toString().trim()))
            Toast.makeText(this,"沒有輸入體重喔",2).show()
        else {
            var fh = et1.getEditableText().toString().toFloat()
            var fw = et2.getEditableText().toString().toFloat()
            val fresult: Float
            fh = fh / 100 // 計算BMI
            fh = fh * fh  // 計算BMI
            fresult = fw / fh
            Toast.makeText(this, "您的BMI為"+fresult.toString(), 2).show()
            tv3.setText(fresult.toString())
            if (fresult < 18.5)
                tv4.setText("體重過輕")
            else if (18.5 <= fresult && fresult < 24)
                tv4.setText("正常範圍")
            else if (24 <= fresult && fresult < 27)
                tv4.setText("過    重")
            else if (27 <= fresult && fresult < 30)
                tv4.setText("輕度肥胖")
            else if (30 <= fresult && fresult < 35)
                tv4.setText("中度肥胖")
            else if (fresult >= 35)
                tv4.setText("重度肥胖")
        }
    }
}
