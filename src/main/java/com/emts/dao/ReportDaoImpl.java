package com.emts.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.emts.model.Chanel;
import com.emts.util.IConstant;
@Repository
public class ReportDaoImpl implements ReportDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@SuppressWarnings("unchecked")
	public List<Object> getAllClient() {
		List<Object> client=null;
		client=hibernateTemplate.find("from Client where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return client;
	}
	@SuppressWarnings("unchecked")
	public List<Object> getAllChanel() {
		List<Object> chanel=null;
		chanel=hibernateTemplate.find("from Chanel where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return chanel;
	}
	@SuppressWarnings("unchecked")
		public HashMap<String, Object[]> pieChartReport(Integer clientId, String fromDate, String toDate, Integer channelId, String param) {
			List<Object> positiveList=null;
			List<Object> negitiveList=null;
			if(param!=null && param.equals("{param=Channel}"))
			{
				positiveList = hibernateTemplate.find("select count(t.newsTrend) ,sum(t.marking) from Tracking t WHERE t.isDeleted="+IConstant.IS_DELETED_ACTIVE+" AND t.newsTrend LIKE 'Positive%' AND t.client.clientId="+clientId+" AND t.date BETWEEN '"
						+ fromDate + "' AND '" + toDate + "' and t.chanel.channelId="+channelId);

				negitiveList = hibernateTemplate.find("select count(t.newsTrend),sum(t.marking) from Tracking t WHERE t.isDeleted="+IConstant.IS_DELETED_ACTIVE+" AND t.newsTrend LIKE 'Negative%' AND t.client.clientId="+clientId+" AND t.date BETWEEN '"
						+ fromDate + "' AND '" + toDate + "' and t.chanel.channelId="+channelId);
			}
			if(param!=null && param.equals("{param=AllChannel}"))
			{
				positiveList = hibernateTemplate.find("select count(t.newsTrend) ,sum(t.marking) from Tracking t WHERE t.isDeleted="+IConstant.IS_DELETED_ACTIVE+" AND t.newsTrend LIKE 'Positive%' AND t.client.clientId="+clientId+" AND t.date BETWEEN '"
						+ fromDate + "' AND '" + toDate + "'");

				negitiveList = hibernateTemplate.find("select count(t.newsTrend),sum(t.marking) from Tracking t WHERE t.isDeleted="+IConstant.IS_DELETED_ACTIVE+" AND t.newsTrend LIKE 'Negative%' AND t.client.clientId="+clientId+" AND t.date BETWEEN '"
						+ fromDate + "' AND '" + toDate + "'");
			}
			
		 /* for (int i=0; i<positiveList.size(); i++){
			     Object[] positive  = (Object[]) positiveList.get(i);
			     System.out.println("Element "+Arrays.toString(positive));
			     System.out.println("Element "+positive[0]);
			     System.out.println("Element "+positive[1]);
			  }
		  
		  for (int i=0; i<negitiveList.size(); i++){
			  	 Object[] negitive = (Object[]) negitiveList.get(i);
			     System.out.println("Element "+Arrays.toString(negitive));
			  }*/
		
		  HashMap<String, Object[]> map=new HashMap<String, Object[]>();
		  if(positiveList.size()!=0 || negitiveList.size()!=0 )
		  {
		  map.put("positive", (Object[]) positiveList.get(0));
		  map.put("negitive", (Object[]) negitiveList.get(0));
		  }
		  return map;
	}
	@SuppressWarnings("unchecked")
	public HashMap<String, List<Object>> genrateSectorWisePieChartReport(Integer clientId,
			String fromDate, String toDate, Integer channelId, String param) {
		List<Object> sectorPositiveList=null;
		List<Object> sectorNegitiveList=null;
		HashMap<String, List<Object>> map = new HashMap<String, List<Object>>();
		if(param!=null && param.equals("{param=Sector}"))
		{
			sectorPositiveList=	hibernateTemplate.find("SELECT sum(t.marking),t.sector.sectorName  from Tracking t WHERE t.isDeleted="+IConstant.IS_DELETED_ACTIVE+" AND t.newsTrend LIKE 'Positive%' AND t.client.clientId="+clientId+" AND t.date BETWEEN '"
					+ fromDate + "' AND '" + toDate + "' GROUP BY t.sector.sectorName ORDER BY t.sector.sectorName ");
			
			
			sectorNegitiveList=	hibernateTemplate.find("SELECT sum(t.marking),t.sector.sectorName  from Tracking t WHERE t.isDeleted="+IConstant.IS_DELETED_ACTIVE+" AND t.newsTrend LIKE 'Negative%' AND t.client.clientId="+clientId+" AND t.date BETWEEN '"
					+ fromDate + "' AND '" + toDate + "' GROUP BY t.sector.sectorName ORDER BY t.sector.sectorName ");
			System.out.println("Positive Sector List"+sectorPositiveList);
			System.out.println("Negative Sector List"+sectorNegitiveList);
			map.put("sectorPositiveList", sectorPositiveList);
			map.put("sectorNegitiveList", sectorNegitiveList);
			
			
		}
		return map;
	}
	@SuppressWarnings("unchecked")
	public HashMap<String, List<Object>> channelWisePieChart(Integer clientId, String fromDate,String toDate, String param) {
		List<Object> channelList=null;
		List<Object> channelPositiveList=null;
		List<Object> channelNegativeList=null;
		List positiveChannelList=new ArrayList();
		List negativeChannelList=new ArrayList();
		
		HashMap<String, List<Object>> map = new HashMap<String, List<Object>>();
		
		channelList=hibernateTemplate.find("SELECT t.chanel  from Tracking t WHERE t.isDeleted="+IConstant.IS_DELETED_ACTIVE+" AND t.client.clientId="+clientId+" AND t.date BETWEEN '"
					+ fromDate + "' AND '" + toDate + "' GROUP BY t.chanel ");
		System.out.println("channelList----"+channelList.size());
		for(int i = 0 ; i < channelList.size() ; i++)
		{
		System.out.println("channelList"+((Chanel)channelList.get(i)).getChannelName());
			
		channelPositiveList=hibernateTemplate.find("select count(t.newsTrend),sum(t.marking) from Tracking t WHERE t.isDeleted="+IConstant.IS_DELETED_ACTIVE+" AND t.newsTrend LIKE 'Positive%' AND t.client.clientId="+clientId+" AND t.date BETWEEN '"
				+ fromDate + "' AND '" + toDate + "' and t.chanel.channelId='"+((Chanel)channelList.get(i)).getChannelId()+"' GROUP BY t.chanel.channelId ");
		if(channelPositiveList.size()==0)
		{
			Object[] obj = new Object[2];
			obj[0]=0;
			obj[1]=0;
			channelPositiveList.add(obj);
		}
		
		positiveChannelList.addAll(channelPositiveList);
		
		channelNegativeList=hibernateTemplate.find("select count(t.newsTrend),sum(t.marking) from Tracking t WHERE t.isDeleted="+IConstant.IS_DELETED_ACTIVE+" AND t.newsTrend LIKE 'Negative%' AND t.client.clientId="+clientId+" AND t.date BETWEEN '"
				+ fromDate + "' AND '" + toDate + "' and t.chanel.channelId='"+((Chanel)channelList.get(i)).getChannelId()+"' GROUP BY t.chanel.channelId ");	
		if(channelNegativeList.size()==0)
		{
			Object[] obj = new Object[2];
			obj[0]=0;
			obj[1]=0;
			channelNegativeList.add(obj);
		}
		negativeChannelList.addAll(channelNegativeList);
		}
		map.put("positiveChannelList", positiveChannelList);
		map.put("negativeChannelList", negativeChannelList);
		map.put("channelList", channelList);
		return map;
		
	}
	@SuppressWarnings("unchecked")
	public List<Object> EMTPDFReport(String fromDate, String toDate, Integer channelId) {
		List<Object> pdfTracking=null;
		pdfTracking=hibernateTemplate.find("from Tracking t WHERE t.isDeleted="+IConstant.IS_DELETED_ACTIVE+" AND t.date BETWEEN '" + fromDate + "' AND '" + toDate + "' and t.chanel.channelId='"+channelId+"' ORDER BY t.trackingId DESC");
		System.out.println("pdfTracking List"+pdfTracking);
		return pdfTracking;
	}
 
}
