package com.mredrock.cyxbs.freshman.ui.activity


import android.annotation.SuppressLint
import android.net.nsd.NsdManager
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.db.FreshmanRoomDatabase
import com.mredrock.cyxbs.freshman.ui.fragment.AddMemoItemFragment
import com.mredrock.cyxbs.freshman.ui.fragment.EditMemoItemFragment
import com.mredrock.cyxbs.freshman.utils.interfaces.DIYMemoClicklistener
import com.mredrock.cyxbs.freshman.utils.interfaces.MyCallback
import com.mredrock.cyxbs.freshman.viewmodel.DIYMemoBeanVM
import com.mredrock.cyxbs.freshman.viewmodel.bean.DIYMemoBean
//import com.mredrock.cyxbs.freshman.db.Repository
//import com.mredrock.cyxbs.freshman.utils.interfaces.FoldBeanDao
import kotlinx.android.synthetic.main.freshman_activity_edit_memo.*
import kotlinx.android.synthetic.main.freshman_fragment_add_memo_item.*

class EditMemoActivity : BaseActivity() {
    override val isFragmentActivity: Boolean
        get() = false

    val manager = supportFragmentManager
    var add = AddMemoItemFragment()
    val edit = EditMemoItemFragment()
    var selectedNum = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_edit_memo)

        manager.beginTransaction().replace(R.id.frgment_add_and_display,add).commit()
        setToolbarBack()

        add.setListener(object : MyCallback{
            override fun OnDo(editText: EditText?, dataList : List<DIYMemoBean>?, viewModel: BaseViewModel?) {
                val bean = DIYMemoBean(editText?.text.toString())
                (viewModel as DIYMemoBeanVM).insertDITMemoBean(bean)
            }
        })
    }



    private fun setToolbarBack() {
        //取消被点击，回到主界面
        tv_edit_memo_cancel.setOnClickListener(){
            finish()
        }

        //删除被点击的点击事件


        //在编辑单条备忘录后，点击保存之后跳转，并将备忘录的内容传入数据库
        tv_edit_memo_save.setOnClickListener{

        }


        tv_edit_memo_save.setOnClickListener {

            if ((it as TextView).text.equals("删除($selectedNum)") ){

                LogUtils.d("删除被电击了1","删除被电击了")
                val bundle = Bundle()
                bundle.putString("text","text")
                edit.arguments = bundle
////                val dao = FreshmanRoomDatabase.getInstance()?.dIYMemoBeanDao()
//                var dataList : List<DIYMemoBean>
//                val vm = DIYMemoBeanVM()
////                vm.deletAll()
//                vm.beans?.observe(this, Observer {
//
//                    //删除被选择的
//                    dataList = it.filter { it.isSelected == true }
//                    for (bean in dataList){
//                    vm.insertDITMemoBean(bean)
//
//                }
//                })

                edit.setEditListener(object : MyCallback{
                    override fun OnDo(editText: EditText?, dataList: List<DIYMemoBean>?, viewModel: BaseViewModel?) {
                        LogUtils.d("MyCallbackss","ss")
//                        viewModel as DIYMemoBeanVM
//                        viewModel.deletAll()
//                        viewModel.beans?.observe(this@EditMemoActivity, Observer {
//                            for (bean in dataList!!) {
//                                viewModel.insertDITMemoBean(bean)
//                            }
//                        })
                    }

                })


//                vm.deletAll()
//                for (bean in dataList){
//                    vm.insertDITMemoBean(bean)
//                }

            } else {

                LogUtils.d("删除被电击了2","删除被电击了")

                //跳转至备忘录浏览页面
                val transaction = manager.beginTransaction()
                transaction.replace(R.id.frgment_add_and_display,edit).commit()
                tv_edit_memo_title.setText("备忘录")
                tv_edit_memo_save.setText("删除")

                edit.setDIYMemoClicklistener(object : DIYMemoClicklistener{
                    @SuppressLint("SetTextI18n")
                    override fun onClick(needAdd: Boolean) {

                        if(needAdd) selectedNum++ else selectedNum--

                        if (selectedNum == 0) {
                            tv_edit_memo_save.setText("删除")
                        } else {
                            tv_edit_memo_save.setText("删除($selectedNum)")
                        }
                    }
                })
            }
        }
    }


}
