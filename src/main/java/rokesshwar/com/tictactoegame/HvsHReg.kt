package rokesshwar.com.tictactoegame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_hvs_h__registation.*

class HvsHReg : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hvs_h__registation)
        ok.setOnClickListener {
            val name1 = ed1.text.toString()
            val name2 = ed2.text.toString()
            val nm1 = name1.toUpperCase()
            val nm2 = name2.toUpperCase()
            if(nm1.isEmpty() || nm2.isEmpty()){
                Toast.makeText(this,"Name TextBox is empty",Toast.LENGTH_LONG).show()
            }
            else if(nm1.isNotEmpty()||nm2.isNotEmpty()){
                startGame(nm1,nm2)
            }


        }


    }

    private fun startGame(name1 : String, name2 : String) {
        val intent = Intent(this, HvsH::class.java)
        val bundle=Bundle()
        bundle.putString("1", name1)
        bundle.putString("2", name2)
        intent.putExtra("firstbundle", bundle)
        startActivity(intent)
    }

}
