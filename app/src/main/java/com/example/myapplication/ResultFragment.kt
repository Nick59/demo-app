package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ResultFragment: Fragment() {

    var text: String? = null
    lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        text = arguments?.getString("text")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        rootView = inflater.inflate(R.layout.fragment_result, container, false)

        rootView.findViewById<TextView>(R.id.text_result).text = text



        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rootView.setOnClickListener{
            var transaction = fragmentManager?.beginTransaction()

            transaction?.setCustomAnimations(R.anim.animation, R.anim.animation)
            transaction?.remove(this)?.commit()


        }
    }

    override fun onDestroy() {

        (activity as CallbackResultFragment).mcGiveBite("BITE")


        super.onDestroy()

    }

    companion object {
        const val TAG = "FragmentDeBite"

        fun newInstance(text: String): ResultFragment {
            var fragment = ResultFragment()

            val args = Bundle()

            args.putString("text", text)

            fragment.arguments = args

            return fragment
        }
    }

    interface CallbackResultFragment {
        fun mcGiveBite(callback:String)
    }

}