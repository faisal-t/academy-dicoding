package com.disdukcapil.academy.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.disdukcapil.academy.R
import com.disdukcapil.academy.databinding.ActivityDetailCourseBinding
import com.disdukcapil.academy.databinding.ContentDetailCourseBinding

class DetailCourseActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailCourseBinding

    companion object{
        const val EXTRA_COURSE = "extra_course"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailCourseBinding = ActivityDetailCourseBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailCourseBinding.detailContent

        setSupportActionBar(activityDetailCourseBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}