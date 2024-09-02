package com.example.app_sem3_s1_geoquizwx64

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Level3Activity : AppCompatActivity() {

    private lateinit var questions : ArrayList<Question>

    private var position = 0

    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_level3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        populateQuestions()

        setup()
    }

    private fun populateQuestions(){
        questions = ArrayList()
        questions.add(Question("Does the Heisenberg Uncertainty Principle state that the position and momentum of a particle can be measured exactly at the same time?", false))
        questions.add(Question("Did the mathematician Carl Friedrich Gauss contribute significantly to the field of number theory?", true))
        questions.add(Question("Is Pluto currently classified as a planet?", false))
        questions.add(Question("Did Marie Curie win two Nobel Prizes in two different scientific fields?", true))
        questions.add(Question("Is the speed of light constant in all mediums, including water and glass?", false))
    }

    private fun setup(){
        // Link the UI components with the logic
        val btYesLvl3 = findViewById<Button>(R.id.btYesLvl3)

        val btNoLvl3 = findViewById<Button>(R.id.btNoLvl3)

        val tvQuestionsLvl3 = findViewById<TextView>(R.id.tvQuestionsLvl3)

        tvQuestionsLvl3.text = questions[position].sentence

        btYesLvl3.setOnClickListener{
            if(questions[position].answer){
                score++
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                if((position + 1) >= questions.size){
                    val intent = Intent(this, FinalScoreActivity::class.java).apply {
                        putExtra(EXTRA_MESS_LVL, score)
                    }

                    startActivity(intent)
                }
                else{
                    position++
                    tvQuestionsLvl3.text = questions[position].sentence
                }
            }
            else{
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
                position++
                tvQuestionsLvl3.text = questions[position].sentence
            }
        }

        btNoLvl3.setOnClickListener{
            if(!questions[position].answer){
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                score++
                if((position + 1) >= questions.size){
                    val intent = Intent(this, FinalScoreActivity::class.java).apply {
                        putExtra(EXTRA_MESS_LVL, score)
                    }

                    startActivity(intent)
                }
                else{
                    position++
                    tvQuestionsLvl3.text = questions[position].sentence
                }
            }
            else{
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
                position++
                tvQuestionsLvl3.text = questions[position].sentence
            }
        }

    }


}