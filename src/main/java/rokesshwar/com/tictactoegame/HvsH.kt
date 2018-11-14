package rokesshwar.com.tictactoegame

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_hvs_h.*
import java.util.*

class HvsH : AppCompatActivity() {
    var point2 = 0
    var point1 = 0
    var name1 = ""
    var name2 = ""
    var cellId = 0
    var winner = -1
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hvs_h)

        val bundle = intent.extras.getBundle("firstbundle")

        name1 = bundle.getString("1")

        name2 = bundle.getString("2")

        play1.text = "$name1's point is $point1 "
        play2.text = "$name2's point is $point2 "

    }

    fun buClick(view: View) {
        val buSelect = view as Button

        when (buSelect.id) {
            R.id.but1 -> cellId = 1
            R.id.but2 -> cellId = 2
            R.id.but3 -> cellId = 3
            R.id.but4 -> cellId = 4
            R.id.but5 -> cellId = 5
            R.id.but6 -> cellId = 6
            R.id.but7 -> cellId = 7
            R.id.but8 -> cellId = 8
            R.id.but9 -> cellId = 9
        }
        playGame(cellId, buSelect)
    }

    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    private var activePlayer = 1
    private fun playGame(cellId: Int, buSelect: Button) {
        if (activePlayer == 1) {
            buSelect.text = "X"
            buSelect.setBackgroundColor(Color.parseColor("#ff000f"))
            player1.add(cellId)
            activePlayer = 2
        } else {
            buSelect.text = "O"
            buSelect.setBackgroundColor(Color.parseColor("#0000ff"))
            player2.add(cellId)
            activePlayer = 1
        }
        buSelect.isEnabled = false
        checkTheWinner()

    }

    private fun checkTheWinner() {

//        val bun=intent.extras
//        if(bun!=null){
//            val name1=intent.extras.getString("name1")
//            val name2=intent.extras.getString("name2")
//        }


        if (player1.contains(1) && player1.contains(2) && player1.contains(3)
            || player1.contains(4) && player1.contains(5) && player1.contains(6)
            || player1.contains(7) && player1.contains(8) && player1.contains(9)
            || player1.contains(1) && player1.contains(5) && player1.contains(9)
            || player1.contains(3) && player1.contains(5) && player1.contains(7)
            || player1.contains(1) && player1.contains(4) && player1.contains(7)
            || player1.contains(2) && player1.contains(5) && player1.contains(8)
            || player1.contains(3) && player1.contains(6) && player1.contains(9)
            || player1.contains(3) && player1.contains(6) && player1.contains(9)
        ) {
            Log.v("roki", "1")
            winner = 1
        } else if (player2.contains(1) && player2.contains(2) && player2.contains(3)
            || player2.contains(4) && player2.contains(5) && player2.contains(6)
            || player2.contains(7) && player2.contains(8) && player2.contains(9)
            || player2.contains(1) && player2.contains(5) && player2.contains(9)
            || player2.contains(3) && player2.contains(5) && player2.contains(7)
            || player2.contains(1) && player2.contains(4) && player2.contains(7)
            || player2.contains(2) && player2.contains(5) && player2.contains(8)
            || player2.contains(3) && player2.contains(6) && player2.contains(9)
        ) {
            Log.v("roki", "2")
            winner = 2
        }
        if (winner != -1) {
            if (winner == 1) {
                player1Wins()


            } else if (winner == 2) {
                player2Wins()

            }


        }
        if ((player1.size + player2.size) == 9) {
            if (winner != 1 && winner!=2) {
                gameTie()
            }

        }
    }


    private fun player1Wins() {
        Toast.makeText(this, "$name1 wins", Toast.LENGTH_SHORT).show()
        point1 += 1
        play1.text = "$name1's point is $point1 "
        but1.isEnabled = false
        but2.isEnabled = false
        but3.isEnabled = false
        but4.isEnabled = false
        but5.isEnabled = false
        but6.isEnabled = false
        but7.isEnabled = false
        but8.isEnabled = false
        but9.isEnabled = false
        newGame.isEnabled = true
        newGame.setBackgroundColor(Color.RED)
        newGame.setOnClickListener {
            newGame()
        }
        reset.isEnabled = true
        reset.setBackgroundColor(Color.YELLOW)
        reset.setOnClickListener {
            reset()
        }
        cont.isEnabled=true
        cont.setOnClickListener {
            cont()
            winner=-1
        }
    }


    private fun player2Wins() {
        Toast.makeText(this, "$name2 wins", Toast.LENGTH_SHORT).show()
        point2 += 1
        play2.text = "$name2's point is $point2 "
        but1.isEnabled = false
        but2.isEnabled = false
        but3.isEnabled = false
        but4.isEnabled = false
        but5.isEnabled = false
        but6.isEnabled = false
        but7.isEnabled = false
        but8.isEnabled = false
        but9.isEnabled = false
        newGame.isEnabled = true
        newGame.setBackgroundColor(Color.RED)
        newGame.setOnClickListener {
            newGame()
        }
        reset.isEnabled = true
        reset.setBackgroundColor(Color.YELLOW)
        reset.setOnClickListener {
            reset()
        }

        cont.isEnabled=true
        cont.setOnClickListener {
            cont()
            winner=-1
        }
    }

    private fun newGame() {
        val intent = Intent(this, HvsHReg::class.java)
        startActivity(intent)
    }

    private fun reset() {
        point1 = 0
        point2 = 0
        play1.text = "$name1's point is 0 "
        play2.text = "$name2's point is 0 "
        winner=-1
        but1.text=""
        but2.text=""
        but3.text=""
        but4.text=""
        but5.text=""
        but6.text=""
        but7.text=""
        but8.text=""
        but9.text=""
        but1.isEnabled = true
        but2.isEnabled = true
        but3.isEnabled = true
        but4.isEnabled = true
        but5.isEnabled = true
        but6.isEnabled = true
        but7.isEnabled = true
        but8.isEnabled = true
        but9.isEnabled = true
        but1.setBackgroundColor(Color.WHITE)
        but2.setBackgroundColor(Color.WHITE)
        but3.setBackgroundColor(Color.WHITE)
        but5.setBackgroundColor(Color.WHITE)
        but4.setBackgroundColor(Color.WHITE)
        but6.setBackgroundColor(Color.WHITE)
        but7.setBackgroundColor(Color.WHITE)
        but8.setBackgroundColor(Color.WHITE)
        but9.setBackgroundColor(Color.WHITE)

        player1.clear()
        player2.clear()

        /*val intent = Intent(this, HvsH::class.java)
        startActivity(intent)*/

    }

    private fun gameTie() {
        Toast.makeText(this, "Game tied", Toast.LENGTH_SHORT).show()
        newGame.isEnabled = true
        newGame.setBackgroundColor(Color.RED)
        newGame.setOnClickListener {
            newGame()
        }
        reset.isEnabled = true
        reset.setBackgroundColor(Color.YELLOW)
        reset.setOnClickListener {
            reset()
        }

        cont.isEnabled=true
        cont.setOnClickListener {
            cont()
            winner=-1

        }
    }
    fun cont(){
            winner=-1
            but1.text=""
            but2.text=""
            but3.text=""
            but4.text=""
            but5.text=""
            but6.text=""
            but7.text=""
            but8.text=""
            but9.text=""
            but1.isEnabled = true
            but2.isEnabled = true
            but3.isEnabled = true
            but4.isEnabled = true
            but5.isEnabled = true
            but6.isEnabled = true
            but7.isEnabled = true
            but8.isEnabled = true
            but9.isEnabled = true
            but1.setBackgroundColor(Color.WHITE)
            but2.setBackgroundColor(Color.WHITE)
            but3.setBackgroundColor(Color.WHITE)
            but5.setBackgroundColor(Color.WHITE)
            but4.setBackgroundColor(Color.WHITE)
            but6.setBackgroundColor(Color.WHITE)
            but7.setBackgroundColor(Color.WHITE)
            but8.setBackgroundColor(Color.WHITE)
            but9.setBackgroundColor(Color.WHITE)

        player1.clear()
        player2.clear()

       /* val intent=Intent(this,HvsH::class.java)
        startActivity(intent)*/

    }


}


