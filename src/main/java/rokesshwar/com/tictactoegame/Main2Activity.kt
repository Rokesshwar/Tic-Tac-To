package rokesshwar.com.tictactoegame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        hvh.setOnClickListener {
            val intent=Intent(this,HvsHReg::class.java)
            startActivity(intent)
        }
    }
}

