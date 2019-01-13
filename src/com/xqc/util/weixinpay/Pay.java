package com.xqc.util.weixinpay;

import org.dom4j.DocumentException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

/**
 * 测试入口
 * @author xqc
 * @data 2019年1月13日
 * Description:
 */
public class Pay {

    public BufferedImage PayToQuickMarkImg() {

        return null;
    }

    /***
     * MD5加码 生成32位md5码
     */
    public static String string2MD5(String inStr){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString().toUpperCase();

    }


    public static void main(String[] s){
        try{
        WeixinPayApiImpl p =  new WeixinPayApiImpl("输入商户key");
        p.setAppid("");//公众号
        p.setMch_id("");//商户号
        p.setSub_mch_id("");//子商户号
        p.setDevice_info("AASSSSS001");//设备号
        p.setOut_trade_no("9984S851312W365");//商户订单号
        p.setTotal_fee(1);//金额
        p.setTrade_type("NATIVE");//交易类型1
        p.setBody("测试支付");//商品描述
        p.setNotify_url("http://www.baidu.com");//通知地址1
        String xml = p.getXml("xml");
        System.out.println(xml);
           InputStream in = HttpClientUtil.sendXMLDataByPost(p.getUrl(),xml).getEntity().getContent();
            WeixinApiResultImpl wxres = new WeixinApiResultImpl(in);
            System.err.println(wxres.getCode_url());
            ImageIO.write(wxres.getBufImg(500,500),"png",new File("d:" + "aa.png"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



