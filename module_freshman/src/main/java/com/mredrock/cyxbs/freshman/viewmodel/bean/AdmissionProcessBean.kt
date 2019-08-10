package com.mredrock.cyxbs.freshman.viewmodel.bean

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nullable

/**
 * created by chenyang
 * on 2019/8/9
 */
@Entity
 class AdmissionProcessBean {
    /**
     * code : 200
     * info : ok
     * text : [{"title":"报道时间","message":"9月5日-6日","photo":"","detail":""},{"title":"持相关证件至风雨操场报道","message":"","photo":"2-1.jpg","detail":"风雨操场（体育馆）：新校门直走至三教处右转\r\n      各学院报道具体场地安排请结合相关信息\r\n"},{"title":"带上行李包裹去到自己对应的宿舍","message":"","photo":"","detail":"到宿舍后，需准备两张一寸照片，在一楼宿管人员处填写入住表，填写完毕即可拿到寝室钥匙和空调遥控器，完成入住。若去寝室前还未报道拿校卡，进入寝室后须向宿管人员出示录取通知书，再填入住表。"},{"title":"在支付宝上完成校卡充值后圈存","message":"","photo":"2-2.png","detail":"第一步，线上充值：支付宝首页-大学生活-一卡通-新卡充值-完善一卡通信息-确认充值\r\n（若支付宝首页未发现\u201c大学生活\u201d，点击\u201c更多\u201d从中进行寻找）\r\n第二步，线下圈存：线上充值成功后，携带校卡找到学校圈存机完成款项入卡，并且完成洗澡钱包、喝水钱包转账\r\n"},{"title":"军训安排","message":"","photo":"","detail":"军训将在开学一周后进行，届时请根据相关信息购买军训物资\r\n      同时入学体检也将在军训期间进行\r\n"},{"title":"更多内容","message":"","photo":"","detail":"保卫处户籍转移\r\n校医院入学体检\r\n学生处助学贷款、绿色通道\r\n财务处完善缴费\r\n"}]
     */
//    var info: String? = null
//    var text: List<TextBean>? = null

//    class TextBean {
        /**
         * title : 报道时间
         * message : 9月5日-6日
         * photo :
         * detail :
         */
        @Nullable @PrimaryKey var id : Int = 0
        var title: String? = null
        var message: String? = null
        var photo: String? = null
        var detail: String? = null
//    }
}
