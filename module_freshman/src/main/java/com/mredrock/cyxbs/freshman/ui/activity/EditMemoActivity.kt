package com.mredrock.cyxbs.freshman.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.fragment.app.Fragment
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
//import com.mredrock.cyxbs.freshman.db.Repository
//import com.mredrock.cyxbs.freshman.utils.interfaces.FoldBeanDao
import kotlinx.android.synthetic.main.freshman_activity_edit_memo.*

class EditMemoActivity : BaseActivity() {
    override val isFragmentActivity: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_edit_memo)

        common_toolbar.init(title = "",icon = R.drawable.freshman_edit_memo_character_cancel, listener = object : View.OnClickListener{
            override fun onClick(v: View?) {
                //当左上角的取消二字被点击
                finish()
            }

        })
        //判断toobar的标题显示什么
        judgeToolbarTitle(frgment_add_and_display)
//        val reo = Repository<FoldBeanDao>(application)


    }



    private fun judgeToolbarTitle(fragment: Fragment) {
        val bar = common_toolbar
        if (fragment.isVisible) {
            bar.title = "编辑"
        } else {
            bar.title = "备忘录"
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.freshman_memo, menu)

        return true
    }

//    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.freshman_memo, menu)
//        return true
//    }



}
