package com.example.app_sem3_s1_geoquizwx64

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val EXTRA_MESS_LVL = "com.example.app_sem3_s1_geoquizwx64.SCORE"

class Level1Activity : AppCompatActivity() {

    private lateinit var questions : ArrayList<Question>

    private var position = 0

    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_level1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Populate the default questions and answers
        populateQuestions()

        setUp()
    }

    private fun populateQuestions(){
        questions = ArrayList()
        questions.add(Question("Is Piura capital of Chile", false))
        questions.add(Question("Is Piura capital of Peru", false))
        questions.add(Question("Is Lima capital of Peru", true))
        questions.add(Question("Is Quito capital of Ecuador", true))
        questions.add(Question("Is Paris capital of France", true))
    }

    @SuppressLint("SetTextI18n")
    private fun setUp(){
        // Link the UI components with the logic
        val btYes = findViewById<Button>(R.id.btYes)

        val btNo = findViewById<Button>(R.id.btNo)

        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)

        tvQuestion.text = questions[position].sentence

        btYes.setOnClickListener{
            if(questions[position].answer){
                score++
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                if(position++ >= questions.size){
                    val intent = Intent(this, FinalScoreActivity::class.java).apply {
                        putExtra(EXTRA_MESS_LVL, score)
                    }

                    startActivity(intent)
                }
                else{
                    position++
                    tvQuestion.text = questions[position].sentence
                }
            }
            else{
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
                position++
                tvQuestion.text = questions[position].sentence
            }
        }

        btNo.setOnClickListener{
            if(!questions[position].answer){
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                score++
                if(position++ >= questions.size){
                    val intent = Intent(this, FinalScoreActivity::class.java).apply {
                        putExtra(EXTRA_MESS_LVL, score)
                    }

                    startActivity(intent)
                }
                else{
                    position++
                    tvQuestion.text = questions[position].sentence
                }
            }
            else{
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
                position++
                tvQuestion.text = questions[position].sentence
            }
        }

    }
}