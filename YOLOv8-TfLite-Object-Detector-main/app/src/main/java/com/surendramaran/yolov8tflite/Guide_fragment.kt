package com.surendramaran.yolov8tflite


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class GuideFragment : Fragment() {
    private lateinit var closeButton : ImageView
    private lateinit var guideFiger : ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_blank,container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        closeButton = view.findViewById<ImageView>(R.id.guide_close)
        guideFiger = view.findViewById<ImageView>(R.id.guide_finger)

        closeButton.setOnClickListener{
            closeThisFragment()
        }

        moveGuideFingerImg(guideFiger)

//        guideFiger.animate().x(80F).y(212F).setDuration(300);
//        guideFiger.startAnimation()

        autoClosed();

    }

    private fun closeThisFragment(){
        val manager = requireActivity().supportFragmentManager
        val fragmentTransction = manager.beginTransaction();
        fragmentTransction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out)
        fragmentTransction.remove(this).commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }

    private fun moveGuideFingerImg(figerImg : ImageView){
        val anim: Animation = AnimationUtils.loadAnimation(activity, R.anim.guide_finger_bounce)
        figerImg.startAnimation(anim)

    }

    private fun autoClosed(){
        lifecycleScope.launch {
            delay(5000)
            closeThisFragment()
        }

    }


}

