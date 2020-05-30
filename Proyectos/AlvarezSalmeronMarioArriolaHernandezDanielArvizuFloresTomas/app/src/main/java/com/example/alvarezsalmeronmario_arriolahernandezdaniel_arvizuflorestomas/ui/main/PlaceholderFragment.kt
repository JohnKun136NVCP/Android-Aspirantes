package com.example.alvarezsalmeronmario_arriolahernandezdaniel_arvizuflorestomas.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.alvarezsalmeronmarioarriolahernandezdanielarvizuflorestomas.R

import android.media.AudioManager
import android.media.SoundPool
import android.widget.Toast
/**
 * A placeholder fragment containing a simple view.
 */
@Suppress("DEPRECATION")
@SuppressWarnings("unused")
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel

    private var soundPool: SoundPool? = null
    private val soundId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }

        soundPool = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool!!.load(context, R.raw.latigazo, 1)
    }

    fun playSound(view: View) {
        soundPool?.play(soundId, 1F, 1F, 0, 0, 1F)
        Toast.makeText(context, "Playing sound. . . .", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        val textView: TextView = root.findViewById(R.id.section_label)
        pageViewModel.text.observe(this, Observer<String> {
            textView.text = it
        })
        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}