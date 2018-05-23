package linitachi.hitzombie

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var score1= 0
    var t:Int= 0
    val random = Random()
    private var  m_nTime:Int = 0
    private var  endTime:Int = 20
    private val mHandlerTime = Handler()
    private var p1:Int=0
    private var p2:Int=0
    private var p3:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView.setColorFilter(Color.RED)
        imageView2.setColorFilter(Color.RED)
        imageView3.setColorFilter(Color.RED)
    }

    public override fun onDestroy() {
        mHandlerTime.removeCallbacks(timerRun)
        super.onDestroy()
    }

    private val timerRun = object : Runnable {
        override fun run() {
            ++m_nTime // 經過的秒數 + 1
            endTime--
            mHandlerTime.postDelayed(this, 1000)
            // 若要取消可以寫一個判斷在這決定是否啟動下一次即可
            if(endTime==0)
                mHandlerTime.removeCallbacks(this)
        }
    }
    private val game = object : Runnable {
        override fun run() {
            endtime.setText(endTime.toString())//倒數計時
            when (rand(0,6)) {
                0 -> {
                    imageView.setColorFilter(Color.RED)
                    p1=0
                }
                1 -> {imageView.setColorFilter(Color.GREEN)
                    p1=1
                }
                2 -> {
                    imageView2.setColorFilter(Color.RED)
                    p2=0
                }
                3 -> {
                    imageView2.setColorFilter(Color.GREEN)
                    p2=1
                }
                4 -> {
                    imageView3.setColorFilter(Color.RED)
                    p3=0
                }
                5 -> {
                    imageView3.setColorFilter(Color.GREEN)
                    p3=1
                }
            }
            mHandlerTime.postDelayed(this, 200)
            // 若要取消可以寫一個判斷在這決定是否啟動下一次即可
            if(endTime==0)
                mHandlerTime.removeCallbacks(this)
        }
    }
    fun start(view: View){
        mHandlerTime.postDelayed(timerRun, 1000);
        mHandlerTime.postDelayed(game, 200);
        startgame.setVisibility(View.INVISIBLE)
    }

    fun rand(from: Int, to: Int) : Int {
        return random.nextInt(to - from) + from
    }
    fun hit(view: View) {
        if(p1==1){
            score1+=1
            p1=0
            imageView.setColorFilter(Color.RED)
        }
        point.setText(score1.toString())
    }
    fun hit1(view: View) {
        if(p2==1){
            score1+=1
            p2=0
            imageView2.setColorFilter(Color.RED)
        }
        point.setText(score1.toString())
    }
    fun hit2(view: View) {
        if(p3==1){
            score1+=1
            p3=0
            imageView3.setColorFilter(Color.RED)
        }
        point.setText(score1.toString())
    }
}
