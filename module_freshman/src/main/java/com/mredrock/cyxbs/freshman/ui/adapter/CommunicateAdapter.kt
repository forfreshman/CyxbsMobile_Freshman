package com.mredrock.cyxbs.freshman.ui.adapter

import android.app.Dialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.utils.interfaces.CustomDialogClicklistener
import com.mredrock.cyxbs.freshman.weight.CustomDialog

class CommunicateAdapter(
    private val names: List<String>, private val context: Context,
    private val title: List<String>, private val qq: List<String>
) : RecyclerView.Adapter<CommunicateAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.freshman_recycler_item_academy, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val customDialog = CustomDialog(context, object : CustomDialogClicklistener {
            override fun doConfirm() {
                val successDialog=Dialog(context,R.style.freshman_CustomDialog)
                successDialog.setContentView(R.layout.freshman_dialog_success)
                val window =successDialog.window
                val lp=window.attributes
                lp.y=20
                window.attributes=lp
                successDialog.show()
                //保存到剪贴板
                val clipBoard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                //第一个参数为tag
                val clip = ClipData.newPlainText("QQ code ", qq[position])
                clipBoard.primaryClip = clip
            }

            override fun doCancel() {

            }
        })
        holder.textView.text = names[position]
        holder.linearLayout.setOnClickListener { view ->
            customDialog.setTile(title[position])
            customDialog.setMessage("QQ群:"+qq[position])
            customDialog.show()
        }
    }

    override fun getItemCount(): Int {
        return names.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var textView: TextView
        internal var linearLayout: LinearLayout

        init {
            textView = itemView.findViewById<View>(R.id.tv_communicate) as TextView
            linearLayout = itemView.findViewById<View>(R.id.ll_communicata) as LinearLayout
        }
    }


}
