package com.mredrock.cyxbs.freshman.ui.adapter

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.view.*
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mredrock.cyxbs.freshman.R
import kotlinx.android.synthetic.main.freshman_copy_dialog.*
import kotlinx.android.synthetic.main.freshman_more_dialog.*
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

class ActivityAdapter(
    private val activities: List<String>,
    private val context: Context
) : RecyclerView.Adapter<ActivityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.freshman_recycler_item_activity, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = activities[position]
        Glide.with(context).load(R.drawable.cover).into(holder.imageView)

        holder.button.setOnClickListener {
            val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.code)

            val copyDialog = Dialog(context, R.style.freshman_ActionSheetDialogStyle)
            copyDialog.setContentView(R.layout.freshman_copy_dialog)
            val copyWindow = copyDialog.window
            copyWindow.setGravity(Gravity.BOTTOM)
            val copyLp: WindowManager.LayoutParams = copyWindow.attributes
            copyLp.y = 20
            copyLp.width=1000
            copyWindow.attributes = copyLp
            copyDialog.tv_dialog_copy.setOnClickListener { v ->
                saveImageToGallery(context, bitmap)
                Toast.makeText(context, "已保存图片到相册", Toast.LENGTH_SHORT).show()
                copyDialog.dismiss()
            }
            copyDialog.tv_dialog_cancel.setOnClickListener { v -> copyDialog.dismiss() }

            val dialog = Dialog(context, R.style.freshman_edit_AlertDialog_style)
            dialog.setContentView(R.layout.freshman_more_dialog)
            dialog.iv_more_dia.setBackgroundResource(R.drawable.code)
            dialog.setCanceledOnTouchOutside(true)
            val window = dialog.window
            val lp: WindowManager.LayoutParams = window.attributes
            lp.x = 0
            lp.y = 40
            dialog.onWindowAttributesChanged(lp)
            dialog.iv_more_dia.setOnClickListener { v -> dialog.dismiss() }
            dialog.iv_more_dia.setOnLongClickListener(View.OnLongClickListener { v ->
                copyDialog.show()
                return@OnLongClickListener true
            })
            dialog.show()
        }
    }

    override fun getItemCount(): Int {
        return activities.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var textView: TextView
        internal var imageView: ImageView
        internal var button: Button

        init {
            textView = itemView.findViewById<View>(R.id.tv_communicate_activity) as TextView
            imageView = itemView.findViewById<View>(R.id.iv_communicate_activity) as ImageView
            button = itemView.findViewById<View>(R.id.btn_communicate_activity) as Button
        }
    }

    fun saveImageToGallery(context: Context, bmp: Bitmap) {
        // 首先保存图片
        val appDir = File(Environment.getExternalStorageDirectory(), "CQUPT")
        if (!appDir.exists()) {
            appDir.mkdir()
        }
        val fileName = System.currentTimeMillis().toString() + ".jpg"
        val file = File(appDir, fileName)
        try {
            var fos: FileOutputStream? = null
            try {
                fos = FileOutputStream(file)
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }

            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos)
            fos!!.flush()
            fos.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        // 其次把文件插入到系统图库
        try {
            MediaStore.Images.Media.insertImage(
                context.contentResolver,
                file.absolutePath, fileName, null
            )
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }

        // 最后通知图库更新
        context.sendBroadcast(Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://${file.path}")))

    }
}
