package com.zj.demo.launchmode

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_thrid.*

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thrid)

        toolbar.title = "Third Activity"

        btn1.setOnClickListener {
            /**
             * FLAG_ACTIVITY_CLEAR_TASK :如果在调用Context.startActivity时传递这个标记，
             * 将会导致任何用来放置该activity的已经存在的task里面的已经存在的activity先清空，
             * 然后该activity再在该task中启动，也就是说，这个新启动的activity变为了这个空task的根activity.
             * 所有老的activity都结束掉。该标志必须和FLAG_ACTIVITY_NEW_TASK一起使用。
             */
//                    Intent intent = new Intent(SignUpWithEmailStepTwo.this, FindFriendsActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(intent);
//                    overridePendingTransition(R.anim.translate_from_right_in, R.anim.scale_out);


            val intent = Intent(this, FirstActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }

        /**
         * 1.FLAG_ACTIVITY_SINGLE_TOP单独使用是没有效果的,必须和Intent.FLAG_ACTIVITY_CLEAR_TOP配合使用
         * 2.FLAG_ACTIVITY_CLEAR_TOP可以单独使用, 效果是对目标activity之上的全部清空,然后自己也onDestroy,并重新启动一个自己
         * 3.FLAG_ACTIVITY_CLEAR_TOP 和 FLAG_ACTIVITY_SINGLE_TOP 一起使用的话,会查找栈中是否已经存在目标activity
         * 如果存在则直接跳转到目标activity(并不会onDestroy和onCreate),并清空目标activity之上的所有activity,如果不存在则创建并
         * 清空之上的所有activity
         */
        btn2.setOnClickListener {
            val intent1 = Intent(this, FirstActivity::class.java)
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            val intent2 = Intent(this, FirstActivity::class.java)
            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            val intent3 = Intent(this, FirstActivity::class.java)
            intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent1)
            startActivity(intent2)
            startActivity(intent3)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}