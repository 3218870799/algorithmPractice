package com.xqc.util.weixinpay;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
/**
 * 
 * @author xqc
 * @data 2019年1月13日
 * Description:为解析请求返回的结果，并有有将支付链接的URL转为二维码图片流的方法。
 */
public class WeixinApiResultImpl {
    private Map<String, String> map = null;
    private Map<String, String> errorMap = null;

    /**
     * 接口返回的InputStream流（XML流）
     * @param inputStream
     */
    public WeixinApiResultImpl(InputStream inputStream) throws DocumentException {
        super();
            this.map = getResultsMap(inputStream);
        this.errorMap = new HashMap<String, String>();
        //错误码
        this.errorMap.put("NOAUTH", "商户无此接口权限");
        this.errorMap.put("NOTENOUGH", " 余额不足");
        this.errorMap.put("ORDERPAID", " 商户订单已支付");
        this.errorMap.put("ORDERCLOSED", "订单已关闭");
        this.errorMap.put("SYSTEMERROR", "系统错误");
        this.errorMap.put("APPID_NOT_EXIST", "APPID不存在");
        this.errorMap.put("MCHID_NOT_EXIST", "MCHID不存在");
        this.errorMap.put("APPID_MCHID_NOT_MATCH", "appid和mch_id不匹配");
        this.errorMap.put("LACK_PARAMS", "缺少参数");
        this.errorMap.put("OUT_TRADE_NO_USED", "商户订单号重复");
        this.errorMap.put("SIGNERROR", "签名错误");
        this.errorMap.put("XML_FORMAT_ERROR", "XML格式错误");
        this.errorMap.put("REQUIRE_POST_METHOD", "请使用post方法");
        this.errorMap.put("POST_DATA_EMPTY", "post数据为空");
        this.errorMap.put("NOT_UTF8", "编码格式错误 ");
    }


    /**
     * 只针对没有重复节点的xml
     * @param in
     * @return
     */
    private Map<String, String> getResultsMap(InputStream in) throws DocumentException {
        Map<String, String> map = new HashMap<String, String>();
        if (in == null) {
            return map;
        }
        SAXReader reader = new SAXReader();
        Document document = reader.read(in);
        Element root = document.getRootElement();
        List<Element> childElements = root.elements();
        for (Element child : childElements) {
            map.put(child.getName(), child.getStringValue());
        }
        return map;
    }


    private String return_code;//返回状态码
    private String return_msg;//返回信息
    private String appid;//公众账号ID
    private String mch_id;//商户号
    private String sub_appid;//子商户公众账号ID
    private String sub_mch_id;//子商户号
    private String device_info;//设备号
    private String nonce_str;//随机字符串
    private String sign;//签名
    private String result_code;//业务结果
    private String err_code;//错误代码
    private String err_code_des;//错误代码描述
    private String trade_type;//交易类型
    private String prepay_id;//预支付交易会话标识
    private String code_url;//二维码链接

    /**
     * 返回状态码
     *
     * @return
     */
    public String getReturn_code() {
        return this.map.get("return_code").toString();
    }

    /**
     * 返回信息
     *
     * @return
     */
    public String getReturn_msg() {
        return this.map.get("return_msg").toString();
    }

    /**
     * 当return_code为SUCCESS时返回：公众账号ID
     *
     * @return
     */
    public String getAppid() {
        return this.map.get("appid").toString();
    }

    /**
     * 当return_code为SUCCESS时返回：商户号
     *
     * @return
     */
    public String getMch_id() {
        return this.map.get("mch_id").toString();
    }

    /**
     * 当return_code为SUCCESS时返回：子商户公众账号ID
     *
     * @return
     */
    public String getSub_appid() {
        return this.map.get("sub_appid").toString();
    }

    /**
     * 当return_code为SUCCESS时返回：子商户号
     *
     * @return
     */
    public String getSub_mch_id() {
        return this.map.get("sub_mch_id").toString();
    }

    /**
     * 当return_code为SUCCESS时返回：设备号
     *
     * @return
     */
    public String getDevice_info() {
        return this.map.get("device_info").toString();
    }

    /**
     * 当return_code为SUCCESS时返回：随机字符串
     *
     * @return
     */
    public String getNonce_str() {
        return this.map.get("nonce_str").toString();
    }

    /**
     * 当return_code为SUCCESS时返回：签名
     *
     * @return
     */
    public String getSign() {
        return this.map.get("sign").toString();
    }

    /**
     * 当return_code为SUCCESS时返回：业务结果
     *
     * @return
     */
    public String getResult_code() {
        return this.map.get("result_code").toString();
    }

    /**
     * 当return_code为SUCCESS时返回：错误代码
     * 可以根据getErrorMsg(String errCode)  来获取错误信息。
     *
     * @return
     */
    public String getErr_code() {
        return this.map.get("err_code").toString();
    }

    /**
     * 当return_code为SUCCESS时返回：错误代码描述
     *
     * @return
     */
    public String getErr_code_des() {
        return this.map.get("err_code_des").toString();
    }

    /**
     * 当return_code 和result_code都为SUCCESS时返回：交易类型
     *
     * @return
     */
    public String getTrade_type() {
        return this.map.get("trade_type").toString();
    }

    /**
     * 当return_code 和result_code都为SUCCESS时返回：预支付交易会话标识
     *
     * @return
     */
    public String getPrepay_id() {
        return this.map.get("prepay_id").toString();
    }

    /**
     * 当return_code 和result_code都为SUCCESS时返回：二维码链接
     *
     * @return
     */
    public String getCode_url() {
        return this.map.get("code_url").toString();
    }

    /**
     * 根据错误编码返回错误信息
     *
     * @param errCode
     * @return
     */
    public String getErrorMsg(String errCode) {
        return this.errorMap.get(errCode);
    }

    //错误信息
    public final String NOAUTH = "商户无此接口权限";
    public final String NOTENOUGH = " 余额不足";
    public final String ORDERPAID = " 商户订单已支付";
    public final String ORDERCLOSED = "订单已关闭";
    public final String SYSTEMERROR = "系统错误";
    public final String APPID_NOT_EXIST = "APPID不存在";
    public final String MCHID_NOT_EXIST = "MCHID不存在";
    public final String APPID_MCHID_NOT_MATCH = "appid和mch_id不匹配";
    public final String LACK_PARAMS = "缺少参数";
    public final String OUT_TRADE_NO_USED = "商户订单号重复";
    public final String SIGNERROR = "签名错误";
    public final String XML_FORMAT_ERROR = "XML格式错误";
    public final String REQUIRE_POST_METHOD = "请使用post方法";
    public final String POST_DATA_EMPTY = "post数据为空";
    public final String NOT_UTF8 = "编码格式错误 ";


    /**
     * 返回接口获取到code_url的二维码图片image流
     * @param width 宽度
     * @param height 高度
     * @return
     * @throws IOException
     * @throws WriterException
     */
    public BufferedImage getBufImg(int width,int height)
            throws IOException, WriterException {
        if(null==this.getCode_url()||"".equals(this.getCode_url())) {
            throw new NullPointerException("请求微信接口出错，没有获取到code_url。");
        }
            // 二维码的图片格式
            String format = "png";
            Hashtable<EncodeHintType, String> hints =
                    new Hashtable<EncodeHintType, String>();
            // 内容所使用编码
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            BitMatrix bitMatrix = new MultiFormatWriter()
                    .encode(this.getCode_url(), BarcodeFormat.QR_CODE, width, height, hints);
            BufferedImage image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }
            }
       /* if (!ImageIO.write(image, format, new File("d:" + "csyor.com.png"))) {
            throw new IOException("Could not write an image of format " +
                    format + " to " );
        }*/
            return image;
    }

}
