package com.wxcampus.util;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.eclipse.jetty.util.security.Credential.MD5;

public class XmlParser {
	
	public static void main(String args[])
	{
	//	String arguments[]=
		Document document=DocumentHelper.createDocument();
		Element root=document.addElement("xml");
		root.addElement("appid").setText(Util.APPID);
		root.addElement("mch_id").setText("");
		root.addElement("device_info").setText("WEB");
		root.addElement("nonce_str").setText(Util.getRandomString());
		root.addElement("body").setText("零食");   //商品概述
		//root.addElement("detail").setText("");  //选填
		//root.addElement("attach").setText("");  //选填
		root.addElement("out_trade_no").setText(Util.getTradeNo());  //订单号
		root.addElement("fee_type").setText("CNY");
		root.addElement("total_fee").setText("16.00");  //订单总金额
		//root.addElement("spbill_create_ip").setText("");  //终端IP
		//root.addElement("time_start").setText("");     //订单起始时间
		//root.addElement("time_expire").setText("");    //订单结束时间
		//root.addElement("goods_tag").setText("");
		root.addElement("notify_url").setText("http://www.missjzp.cn/shop/paysuccess");
		root.addElement("trade_type").setText("JSAPI");
	//	root.addElement("product_id").setText("");
	//	root.addElement("limit_pay").setText("");
		//root.addElement("openid").setText("");
		List<Element> elements=root.elements();
	    String sign=Util.getSign(elements);
		root.addElement("sign").setText(sign); ////****************
		System.out.println(document.asXML());
		String text="<xml><appid><![CDATA[wxd930ea5d5a258f4f]]></appid><mch_id><![CDATA[10000100]]></mch_id><device_info>1000</device_info><body>test</body><nonce_str><![CDATA[ibuaiVcKdpRxkhJA]]></nonce_str><sign><![CDATA[9A0A8659F005D6984697E2CA0A9CF3B7]]></sign></xml>";
		try {
			Document document2=DocumentHelper.parseText(text);
			Element root2 = document2.getRootElement();
			List<Element> elements2=root2.elements();
			String sign2=Util.getSign(elements2);
			System.out.println(sign2);
			Iterator<Element> iterator=root2.elementIterator();
			System.out.println(root2.elements().size());
			while(iterator.hasNext())
			{
				Element ele=iterator.next();
				System.out.println(ele.getName()+" : "+ele.getText());
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}