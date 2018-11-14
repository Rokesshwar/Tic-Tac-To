package rokesshwar.com.tictactoegame

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newGame.isEnabled = false
        newGame.setBackgroundColor(Color.GRAY)
    }

    fun buClick(view: View) {
        val buSelect = view as Button
        var cellId = 0
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
//        Toast.makeText(this, "Cell ID $cellId", Toast.LENGTH_SHORT).show()
        playGame(cellId, buSelect)
    }

    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    private var activePlayer = 1
     fun playGame(cellId: Int, buSelect: Button) {
        if (activePlayer == 1) {
            buSelect.text = "X"
            buSelect.setBackgroundColor(Color.parseColor("#ff000f"))
            player1.add(cellId)
            activePlayer = 2
            comPlay()
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
        var winner = -1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)
            || player1.contains(4) && player1.contains(5) && player1.contains(6)
            || player1.contains(7) && player1.contains(8) && player1.contains(9)
            || player1.contains(1) && player1.contains(5) && player1.contains(9)
            || player1.contains(3) && player1.contains(5) && player1.contains(7)
            || player1.contains(1) && player1.contains(4) && player1.contains(7)
            || player1.contains(2) && player1.contains(5) && player1.contains(8)
            || player1.contains(3) && player1.contains(6) && player1.contains(9)
        ) {
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
            winner = 2
        }
        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Player 1 wins", Toast.LENGTH_SHORT).show()

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

            } else if (winner == 2) {
                Toast.makeText(this, "Player 2 wins", Toast.LENGTH_SHORT).show()

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
            }


        }
    }

    fun newGame() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

    fun comPlay() {
        val emptycell = ArrayList<Int>()
        for (cellId in 1..9) {
            if (!player2.contains(cellId) ||! player1.contains(cellId)) {
                emptycell.add(cellId)
            }
        }
        val rand = Random()
        val randIndex = rand.nextInt(emptycell.size - 0) + 0
        val cellId = emptycell[randIndex]
        val buSelect: Button
        buSelect = when (cellId) {
            1 -> but1
            2 -> but2
            3 -> but3
            4 -> but4
            5 -> but5
            6 -> but6
            7 -> but7
            8 -> but8
            9 -> but9
            else -> but1

        }
        playGame(cellId,buSelect)

    }
}
