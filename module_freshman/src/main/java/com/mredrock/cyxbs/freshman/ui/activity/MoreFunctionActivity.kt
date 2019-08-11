package com.mredrock.cyxbs.freshman.ui.activity

<<<<<<< HEAD
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
=======
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
>>>>>>> upstream/master
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.util.MyImageLoader
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.freshman_activity_main.*
import kotlinx.android.synthetic.main.freshman_activity_more_function.*
<<<<<<< HEAD
import kotlinx.android.synthetic.main.freshman_copy_dialog.*
import kotlinx.android.synthetic.main.freshman_more_dialog.*
import kotlinx.android.synthetic.main.freshman_sf_fragment.view.*
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
=======
import kotlinx.android.synthetic.main.freshman_more_dialog.*
import kotlinx.android.synthetic.main.freshman_sf_fragment.view.*
>>>>>>> upstream/master
import java.lang.StringBuilder

class MoreFunctionActivity : BaseActivity() {
    override val isFragmentActivity: Boolean
        get() = false

<<<<<<< HEAD
    private var dialog: Dialog? = null
    private var copyDialog: Dialog? = null

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_more_function)

=======
    private var dialog : Dialog?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_more_function)
>>>>>>> upstream/master
        common_toolbar.init(
            title = "更多功能",
            listener = View.OnClickListener { v -> finish() }
        )
<<<<<<< HEAD
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.code)

        copyDialog = Dialog(this, R.style.freshman_ActionSheetDialogStyle)
        copyDialog!!.setContentView(R.layout.freshman_copy_dialog)
        val copyWindow = copyDialog!!.window
        copyWindow.setGravity(Gravity.BOTTOM)
        val copyLp: WindowManager.LayoutParams = copyWindow.attributes
        copyLp.y = 20
        copyLp.width=1000
        copyWindow.attributes = copyLp
        copyDialog!!.tv_dialog_copy.setOnClickListener { v ->
            saveImageToGallery(this@MoreFunctionActivity, bitmap)
            Toast.makeText(this@MoreFunctionActivity, "已保存图片到相册", Toast.LENGTH_SHORT).show()
            copyDialog!!.dismiss()
        }
        copyDialog!!.tv_dialog_cancel.setOnClickListener { v -> copyDialog!!.dismiss() }
=======
>>>>>>> upstream/master
        dialog = Dialog(this, R.style.freshman_edit_AlertDialog_style)
        dialog!!.setContentView(R.layout.freshman_more_dialog)
        dialog!!.iv_more_dia.setBackgroundResource(R.drawable.code)
        dialog!!.setCanceledOnTouchOutside(true)
        val window = dialog!!.window
        val lp: WindowManager.LayoutParams = window.attributes
        lp.x = 0
        lp.y = 40
        dialog!!.onWindowAttributesChanged(lp)
        dialog!!.iv_more_dia.setOnClickListener { v -> dialog!!.dismiss() }
<<<<<<< HEAD
        dialog!!.iv_more_dia.setOnLongClickListener(View.OnLongClickListener { v ->
            copyDialog!!.show()
            return@OnLongClickListener true
        })
        rl_more_third.setOnClickListener { v -> dialog!!.show() }
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

=======
        rl_more_third.setOnClickListener { v -> dialog!!.show() }
    }
>>>>>>> upstream/master
}
