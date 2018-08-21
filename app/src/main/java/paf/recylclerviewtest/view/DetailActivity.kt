package paf.recylclerviewtest.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import paf.recylclerviewtest.R

class DetailActivity : AppCompatActivity() {

    private val EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";
    private val EXTRA_MESSAGE = "EXTRA_MESSAGE"
    private val EXTRA_COLOR = "EXTRA_COLOR"

    private lateinit var dateAndTime : TextView
    private lateinit var message : TextView
    private lateinit var coloredBackground : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val i = intent
        val dateAndTimeExtra = i.getStringExtra(EXTRA_DATE_AND_TIME)
        val messageExtra = i.getStringExtra(EXTRA_MESSAGE)
        val colorResourceExtra = i.getIntExtra(EXTRA_COLOR, 0)

        message = findViewById(R.id.tv_message_body) as TextView
        dateAndTime = findViewById(R.id.tv_date_and_time_header) as TextView
        coloredBackground = findViewById(R.id.cont_color_background) as View

        message.setText(messageExtra)
        dateAndTime.setText(dateAndTimeExtra)
        coloredBackground.setBackgroundColor(colorResourceExtra)
    }
}
