//package com.mredrock.cyxbs.freshman.ui.adapter
//
//import android.content.Context
//import android.view.View
//import com.bumptech.glide.Glide
//import com.bumptech.glide.GlideBuilder
//import com.mredrock.cyxbs.common.utils.extensions.setImageFromUrl
//import com.mredrock.cyxbs.freshman.R
//import com.mredrock.cyxbs.freshman.viewmodel.bean.AdmissionProcessBean
//import kotlinx.android.synthetic.main.freshman_recycle_item_bus_line.view.*
//import kotlinx.android.synthetic.main.freshman_recycle_item_process.view.*
//
///**
// *created by chenyang
// *on 2019/8/9
// */
//class AdmissionProcessAdapter(
//    val context: Context, val datas: List<AdmissionProcessBean>,
//    override val latoutId: Int
//) : BaseAdapter<AdmissionProcessBean>(datas, context) {
//
//
//    private var opened = -1
//    override fun creatHolder(holder: BaseViewHolder, t: AdmissionProcessBean) {
//
//
//        val view = holder.getView()
//        view.tv_admission_mainTitle.setText(t.title)
//        view.tv_admission_subTitle.setText(t.detail)
//        if (t.photo != null && !t.photo.equals(null)) {
//            // Glide.with(context).load(t.photo).into(holder.getView().iv_admission_photo)
//            view.iv_admission_photo.setImageFromUrl("http://129.28.185.138:9025/zsqy/image/3-3-1.JPG")
//        }
//
//
//        val position = datas.indexOf(t)
//        if (position == opened) {
//            view.tv_admission_subTitle.visibility = View.VISIBLE
//            view.iv_admission_photo.visibility = View.VISIBLE
//
//        } else {
//            view.tv_admission_subTitle.visibility = View.GONE
//            view.iv_admission_photo.visibility = View.GONE
//        }
//
//        if (holder.getView().tv_admission_subTitle.visibility == View.VISIBLE) {
//            holder.getView().iv_admission_fold.setImageResource(R.drawable.freshman_necessary_fold_icon_up)
//        }
//
//
//        //当箭头点击之后决定是展开具体路线还是收起具体路线
//        holder.getView().setOnClickListener { v ->
//
//            if (opened == holder.adapterPosition) {
//                //当前item已经被展开，关闭
//                opened = -1
//                notifyItemChanged(holder.adapterPosition)
//            } else {
//                val oldOpend = opened
//                opened = holder.adapterPosition
//                notifyItemChanged(oldOpend)
//                notifyItemChanged(opened)
//            }
//        }
//
//        holder.setVisiable()
//    }
//
//    private fun BaseAdapter.BaseViewHolder.setVisiable() {
//        val view = getView()
//        view.setOnClickListener() {
//            if (view.tv_admission_subTitle.visibility == View.VISIBLE) {
//                it.iv_admission_fold.setImageResource(R.drawable.freshman_necessary_fold_icon_up)
//            } else {
//                it.iv_admission_fold.setImageResource(R.drawable.freshman_necessary_fold_icon_down)
//            }
//        }
//    }
//
//}