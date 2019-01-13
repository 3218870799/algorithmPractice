package com.xqc.util.weixinpay;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.security.MessageDigest;
import java.util.*;

/**

 * @author sunzhicheng
 * Created by cheng on 2016-5-25.
 */
/**
 * 
 * @author xqc
 * @data 2019年1月13日
 * Description:为请求前的操作（参数封装）
 * 微信支付接口参数封装实现类；
 * 根据：https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1
 *  或 ：https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=9_1
 *  来决定哪些参数为必填。
 */
public class WeixinPayApiImpl {
    private Map<String, Object> map = null;
    private List<String> requiredList = null;
    private final String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    private String key = "";
    /**
     * 获取微信接口地址
     * @return
     */
    public String getUrl() {
        return url;
    }


    //此变量没有实际的使用到，单纯为了编码时方便定位和是否漏掉参数而存在
    private String appid = null;//1   公众账号ID
    private String mch_id = null;//1   商户号
    private String sub_appid = null;//子商户公众账号ID
    private String sub_mch_id = null;//1   子商户号
    private String device_info = null;//设备号
    private String nonce_str = null;//1   随机字符串
    private String sign = null;//1   签名
    private String body = null;//1   商品描述
    private String detail = null;//商品详情
    private String attach = null;//附加数据
    private String out_trade_no = null;//1商户订单号
    private String fee_type = null;//货币类型
    private Integer total_fee = null;//1总金额
    private String spbill_create_ip = null;//1终端IP
    private String time_start = null;//交易起始时间
    private String time_expire = null;//交易结束时间
    private String goods_tag = null;//商品标记
    private String notify_url = null;//1通知地址
    private String trade_type = null;//1交易类型
    private String product_id = null;//商品ID
    private String limit_pay = null;//指定支付方式
    private String openid = null;//用户标识
    private String sub_openid = null;//用户子标识

    /**
     * 必填 公众账号ID
     * 例：wxd678efh567hg6787
     * 说明：微信分配的公众账号ID（企业号corpid即为此appId）
     *
     * @param appid
     */
    public void setAppid(String appid) {
        if(null!=appid){
            this.map.put("appid", appid);
        }
        this.appid = appid;
    }
    /**
     * 必填 商户号
     * 例：1230000109
     * 说明：微信支付分配的商户号
     *
     * @param mch_id
     */
    public void setMch_id(String mch_id) {
        if(null!=mch_id){
            this.map.put("mch_id", mch_id);
        }
        this.mch_id = mch_id;
    }
    /**
     * 子商户公众账号ID
     * 例：wxd678efh567hg6787
     * 说明：微信分配的子商户公众账号ID，如需在支付完成后获取sub_openid则此参数必传。
     *
     * @param sub_appid
     */
    public void setSub_appid(String sub_appid) {
        if(null!=sub_appid){
            this.map.put("sub_appid", sub_appid);
        }
        this.sub_appid = sub_appid;
    }
    /**
     * 必填 子商户号
     * 例：1230000109
     * 说明：微信支付分配的子商户号
     *
     * @param sub_mch_id
     */
    public void setSub_mch_id(String sub_mch_id) {
        if(null!=sub_mch_id){
            this.map.put("sub_mch_id", sub_mch_id);
        }
        this.sub_mch_id = sub_mch_id;
    }
    /**
     * 设备号
     * 例：013467007045764
     * 说明：终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
     *
     * @param device_info
     */
    public void setDevice_info(String device_info) {
        if(null!=device_info){
            this.map.put("device_info", device_info);
        }
        this.device_info = device_info;
    }
    /**
     * 必填 随机字符串
     * 例：5K8264ILTKCH16CQ2502SI8ZNMTM67VS
     * 说明：随机字符串，不长于32位。https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_3
     * 默认值：30位长度由A-Z,0-9组成的随机串
     * @param nonce_str
     */
    public void setNonce_str(String nonce_str) {
        if(null!=nonce_str){
            this.map.put("nonce_str", nonce_str);
        }
        this.nonce_str = nonce_str;
    }
    /**
     * 必填 签名【无需手动设值，调用时会自动计算并赋值】
     * 例：C380BEC2BFD727A4B6845133519F3AD6
     * 说明：签名，详见 https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_3
     * 默认值：调用时根据相应的算法自动进行计算或复制
     * @param sign
     */
    public void setSign(String sign) {
        if(null!=sign){
            this.map.put("sign", sign);
        }
        this.sign = sign;
    }
    /**
     * 必填 商品描述
     * 例：Ipad mini  16G  白色
     * 说明:商品或支付单简要描述
     *
     * @param body
     */
    public void setBody(String body) {
        if(null!=body){
            this.map.put("body", body);
        }
        this.body = body;
    }
    /**
     * 商品详情
     * 例：Ipad mini  16G  白色
     * 说明:商品名称明细列表
     *
     * @param detail
     */
    public void setDetail(String detail) {
        if(null!=detail){
            this.map.put("detail", detail);
        }
        this.detail = detail;
    }
    /**
     * 附加数据
     * 例：深圳分店
     * 说明：附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
     *
     * @param attach
     */
    public void setAttach(String attach) {
        if(null!=attach){
            this.map.put("attach", attach);
        }
        this.attach = attach;
    }
    /**
     * 必填 商户订单号
     * 例：20150806125346
     * 说明：商户系统内部的订单号,32个字符内、可包含字母,。
     * 其他说明 https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_2
     *
     * @param out_trade_no
     */
    public void setOut_trade_no(String out_trade_no) {
        if(null!=out_trade_no){
            this.map.put("out_trade_no", out_trade_no);
        }
        this.out_trade_no = out_trade_no;
    }
    /**
     * 货币类型  默认为：CNY 人民币
     * 例：CNY
     * 说明：符合ISO 4217标准的三位字母代码，默认人民币：CNY
     * 其他详见 https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_2
     *
     * @param fee_type
     */
    public void setFee_type(String fee_type) {
        if(null!=fee_type){
            this.map.put("fee_type", fee_type);
        }
        this.fee_type = fee_type;
    }
    /**
     * 必填 总金额，必须大于0 单位：分
     * 例：888【8元8角8分】
     * 说明：订单总金额，单位为分
     *
     * @param total_fee
     */
    public void setTotal_fee(Integer total_fee) {
        if(null!=total_fee&&total_fee>0){
            this.map.put("total_fee", total_fee);
        }
        this.total_fee = total_fee;
    }
    /**
     * 必填 终端IP
     * 例：	123.12.12.123
     * 说明：APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
     * 默认值：本机内网IP
     * @param spbill_create_ip
     */
    public void setSpbill_create_ip(String spbill_create_ip) {
        if(null!=spbill_create_ip){
            this.map.put("spbill_create_ip", spbill_create_ip);
        }
        this.spbill_create_ip = spbill_create_ip;
    }
    /**
     * 交易起始时间
     * 例：20091225091010
     * 说明：订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。
     * 详细：https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_2
     *
     * @param time_start
     */
    public void setTime_start(String time_start) {
        if(null!=time_start){
            this.map.put("time_start", time_start);
        }
        this.time_start = time_start;
    }
    /**
     * 交易结束时间
     * 例：20091225091010
     * 说明：订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。
     * 详细：https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_2
     *
     * @param time_expire
     */
    public void setTime_expire(String time_expire) {
        if(null!=time_expire){
            this.map.put("time_expire", time_expire);
        }
        this.time_expire = time_expire;
    }
    /**
     * 商品标记
     * 例：WXG
     * 说明：商品标记，代金券或立减优惠功能的参数
     * 说明详见：https://pay.weixin.qq.com/wiki/doc/api/tools/sp_coupon.php?chapter=12_1
     *
     * @param goods_tag
     */
    public void setGoods_tag(String goods_tag) {
        if(null!=goods_tag){
            this.map.put("goods_tag", goods_tag);
        }
        this.goods_tag = goods_tag;
    }
    /**
     * 必填 通知地址（回调地址）
     * 例：http://www.weixin.qq.com/wxpay/pay.php
     * 说明：接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
     *
     * @param notify_url
     */
    public void setNotify_url(String notify_url) {
        if(null!=notify_url){
            this.map.put("notify_url", notify_url);
        }
        this.notify_url = notify_url;
    }
    /**
     * 必填 交易类型
     * 例：NATIVE
     * 说明：取值如下：JSAPI，NATIVE，APP
     * 详细说明：https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_2
     *
     * @param trade_type
     */
    public void setTrade_type(String trade_type) {
        if(null!=trade_type){
            this.map.put("trade_type", trade_type);
        }
        this.trade_type = trade_type;
    }
    /**
     * 商品ID
     * 例：12235413214070356458058
     * 说明：trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
     *
     * @param product_id
     */
    public void setProduct_id(String product_id) {
        if(null!=product_id){
            this.map.put("product_id", product_id);
        }
        this.product_id = product_id;
    }
    /**
     * 指定支付方式
     * 例：no_credit
     * 说明：no_credit--指定不能使用信用卡支付
     *
     * @param limit_pay
     */
    public void setLimit_pay(String limit_pay) {
        if(null!=limit_pay){
            this.map.put("limit_pay", limit_pay);
        }
        this.limit_pay = limit_pay;
    }
    /**
     * 用户标识
     * 例：oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
     * 说明：trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。openid如何获取，可参考https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_4
     * 企业号请使用http://qydev.weixin.qq.com/wiki/index.php?title=OAuth%E9%AA%8C%E8%AF%81%E6%8E%A5%E5%8F%A3
     * 获取企业号内成员userid，再调用http://qydev.weixin.qq.com/wiki/index.php?title=Userid%E4%B8%8Eopenid%E4%BA%92%E6%8D%A2%E6%8E%A5%E5%8F%A3
     * 进行转换
     *
     * @param openid
     */
    public void setOpenid(String openid) {
        if(null!=openid){
            this.map.put("openid", openid);
        }
        this.openid = openid;
    }
    /**
     * 用户子标识
     * 例：oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
     * 说明：trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。openid如何获取，可参考https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_4
     * 企业号请使用http://qydev.weixin.qq.com/wiki/index.php?title=OAuth%E9%AA%8C%E8%AF%81%E6%8E%A5%E5%8F%A3
     * 获取企业号内成员userid，再调用http://qydev.weixin.qq.com/wiki/index.php?title=Userid%E4%B8%8Eopenid%E4%BA%92%E6%8D%A2%E6%8E%A5%E5%8F%A3
     * 进行转换
     *
     * @param sub_openid
     */
    public void setSub_openid(String sub_openid) {
        if(null!=sub_openid) {
            this.map.put("sub_openid", sub_openid);
        }
        this.sub_openid = sub_openid;
    }

    /**
     * 将不能为空的列指定到list中并返回这个list
     * @return
     */
    private List<String> requiredParam() {
        //定义不能为空的字段
        List<String> list = new ArrayList<String>();
        list.add("appid");
        list.add("mch_id");
        list.add("sub_mch_id");
        list.add("nonce_str");
        list.add("sign");
        list.add("body");
        list.add("out_trade_no");
        list.add("total_fee");
        list.add("spbill_create_ip");
        list.add("notify_url");
        list.add("trade_type");
        return list;
    }

    /**
     * appid,mch_id,nonce_str,sign,body,out_trade_no,total_fee,spbill_create_ip,notify_url,trade_type
     * 不能为空或NULL，详见set方法说明
     * 所有属性默认为null
     * 文档地址：https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=9_1
     * @param key  为商户的key【API密匙】
     */
    public WeixinPayApiImpl(String key) {
        super();
        this.key=key;
        map = new HashMap<String, Object>();
       List<String> tmpList = requiredParam();
        if (tmpList.size() > 0) {
            this.requiredList = tmpList;
        } else {
            this.requiredList = null;
        }
    }


    /**
     * 将所有不为null的属性封装成map并返回
     */
    public Map<String, Object> getMap() throws Exception {
        this.setDefaultValue();
        if(null!=this.requiredList) {
                for (String s : this.requiredList) {//检查为空的值是否必填
                    if (!this.map.containsKey(s)) {//出现未包含的必填项
                        throw new Exception(s + "--为必填项。请检查必填项：" + this.requiredList + " 是否填写正确。");
                    }
                    if ("total_fee".equals(s)) {//金额
                        Object o =  this.map.get(s);
                        int total = (Integer) o;
                        if (total <= 0) {
                            throw new Exception(s + "--为必填项。且必须大于0。");
                        }
                    }
                }
        }
        return this.map;
    }

    /**
     * 若xmlRootElementName为nill则没有Root节点
     *
     * @param xmlRootElementName 可以为null
     * @return
     */
    public String getXml(String xmlRootElementName) throws Exception{
       Map<String, Object> tmap = getMap();
        StringBuffer sbf = null;
        sbf = new StringBuffer();
        if (null != xmlRootElementName) {
            sbf.append("<" + xmlRootElementName + ">");
        }
            for (String s : tmap.keySet()) {
                Object tmp = tmap.get(s);
                    sbf.append("<" + s + ">" + tmp + "</" + s + ">");
            }
        if (null != xmlRootElementName) {
            sbf.append("</" + xmlRootElementName + ">");
        }
        try {
            return new String(sbf.toString().getBytes(),"ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    /***
     * MD5加码 生成32位md5码
     */
    private String string2MD5(String str){
        if (str == null || str.length() == 0) {
            return null;
        }
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };

        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf).toUpperCase();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 微信支付签名算法sign
     */
    private String getSign() {
        StringBuffer sb = new StringBuffer();
        String[] keyArr = (String[]) this.map.keySet().toArray(new String[this.map.keySet().size()]);//获取map中的key转为array
        Arrays.sort(keyArr);//对array排序
        for (int i = 0, size = keyArr.length; i < size; ++i) {
            if ("sign".equals(keyArr[i])) {
                continue;
            }
            sb.append(keyArr[i] + "=" + this.map.get(keyArr[i]) + "&");
        }
        sb.append("key=" + key);
        String sign = string2MD5(sb.toString());
        return sign;
    }

    /**
     * 生成由[A-Z,0-9]生成的随机字符串
     * @param length  欲生成的字符串长度
     * @return
     */
    private String getRandomString(int length){
        Random random = new Random();

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < length; ++i){
            int number = random.nextInt(2);
            long result = 0;

            switch(number){
                case 0:
                    result = Math.round(Math.random() * 25 + 65);
                    sb.append(String.valueOf((char)result));
                    break;
                case 1:

                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }
        }
        return sb.toString();
    }

    /**
     * 获取本机IP地址（内网）
     * @return IP
     */
    private static String getLocalIp() {
        String ip = null;
        Enumeration allNetInterfaces;
        try {
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                List<InterfaceAddress> InterfaceAddress = netInterface.getInterfaceAddresses();
                for (InterfaceAddress add : InterfaceAddress) {
                    InetAddress Ip = add.getAddress();
                    if (Ip != null && Ip instanceof Inet4Address) {
                        ip = Ip.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        return ip;
    }


    /**
     * 设置默认值
     */
    private void setDefaultValue(){
        if(null == this.map.get("nonce_str")){//随机串
            this.setNonce_str(this.getRandomString(30));
        }
        if(null == this.map.get("spbill_create_ip")){//终端IP
            this.setSpbill_create_ip(this.getLocalIp());
        }
        if(null == this.map.get("sign")){//签名
            this.setSign(this.getSign());
        }
    }
}
