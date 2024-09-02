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

class Level2Activity : AppCompatActivity() {

    private lateinit var questions : ArrayList<Question>

    private var position = 0

    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_level2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        populateQuestions()

        setUp()
    }

    private fun populateQuestions(){
        questions = ArrayList()
        questions.add(Question("Is Tokyo the capital of South Korea?", false))
        questions.add(Question("Did the Titanic sink in 1912?", true))
        questions.add(Question("Is the Amazon Rainforest located entirely within Brazil?", false))
        questions.add(Question("Can humans naturally produce vitamin C in their bodies?", false))
        questions.add(Question("Was Albert Einstein awarded the Nobel Prize for his theory of relativity?", false))
    }

    private fun setUp()
    {
        // Link the UI components with the logic
        val btYesLvl2 = findViewById<Button>(R.id.btYesLvl2)

        val tvQuestionLvl2 = findViewById<TextView>(R.id.tvQuestionLvl2)

        val btNoLvl2 = findViewById<Button>(R.id.btNoLvl2)

        tvQuestionLvl2.text = questions[position].sentence

        btYesLvl2.setOnClickListener{
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
                    tvQuestionLvl2.text = questions[position].sentence
                }
            }
            else{
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
                position++
                tvQuestionLvl2.text = questions[position].sentence
            }
        }

        btNoLvl2.setOnClickListener{
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
                    tvQuestionLvl2.text = questions[position].sentence
                }
            }
            else{
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
                position++
                tvQuestionLvl2.text = questions[position].sentence
            }
        }

    }

}