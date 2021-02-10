package com.disdukcapil.academy.ui.academy

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.disdukcapil.academy.R
import com.disdukcapil.academy.data.CourseEntity
import com.disdukcapil.academy.databinding.ItemsAcademyBinding
import com.disdukcapil.academy.ui.detail.DetailCourseActivity

class AcademyAdapter : RecyclerView.Adapter<AcademyAdapter.CourseViewHolder>() {

    private var listCourse = ArrayList<CourseEntity>()

    fun setCourse(courses : List<CourseEntity>){
        if (courses == null) return
        this.listCourse.clear()
        this.listCourse.addAll(courses)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val itemAcademyBinding = ItemsAcademyBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CourseViewHolder(itemAcademyBinding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = listCourse[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listCourse.size


    class CourseViewHolder(private val binding : ItemsAcademyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(courseEntity: CourseEntity) {
            with(binding) {
                tvItemTitle.text = courseEntity.title
                tvItemDate.text =
                    itemView.resources.getString(R.string.deadline_date, courseEntity.deadline)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailCourseActivity::class.java)
                    intent.putExtra(DetailCourseActivity.EXTRA_COURSE, courseEntity.courseId)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(courseEntity.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
            }
        }
    }
}