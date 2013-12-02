package com.emts.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.emts.util.IConstant;
@Repository
public class PrintReportDaoImpl implements PrintReportDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@SuppressWarnings("unchecked")
	public List<Object> getAllClient() {
		List<Object> client=null;
		client=hibernateTemplate.find("from Client where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return client;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getAllPublication() {
		List<Object> publication = null ;
		publication = hibernateTemplate.find("from Publication where IS_DELETED="+IConstant.IS_DELETED_ACTIVE);
		return publication;
	}
	@SuppressWarnings("unchecked")
	public HashMap<String, Object[]> pieChartReport(Integer clientId, String fromDate, String toDate, Integer publicationId, String param) {
		List<Object> positiveList=null;
		List<Object> negitiveList=null;
		if(param!=null && param.equals("{param=Publication}"))
		{
			positiveList = hibernateTemplate.find("select count(t.newsTrend) ,sum(t.marking) from PrintTracking t WHERE t.isDeleted="+IConstant.IS_DELETED_ACTIVE+" AND t.newsTrend LIKE 'Positive%' AND t.client.clientId="+clientId+" AND t.date BETWEEN '"
					+ fromDate + "' AND '" + toDate + "' and t.chanel.channelId="+publicationId);

			negitiveList = hibernateTemplate.find("select count(t.newsTrend),sum(t.marking) from PrintTracking t WHERE t.isDeleted="+IConstant.IS_DELETED_ACTIVE+" AND t.newsTrend LIKE 'Negative%' AND t.client.clientId="+clientId+" AND t.date BETWEEN '"
					+ fromDate + "' AND '" + toDate + "' and t.chanel.channelId="+publicationId);
		}
		if(param!=null && param.equals("{param=Publication}"))
		{
			positiveList = hibernateTemplate.find("select count(t.newsTrend) ,sum(t.marking) from PrintTracking t WHERE t.isDeleted="+IConstant.IS_DELETED_ACTIVE+" AND t.newsTrend LIKE 'Positive%' AND t.client.clientId="+clientId+" AND t.date BETWEEN '"
					+ fromDate + "' AND '" + toDate + "'");

			negitiveList = hibernateTemplate.find("select count(t.newsTrend),sum(t.marking) from PrintTracking t WHERE t.isDeleted="+IConstant.IS_DELETED_ACTIVE+" AND t.newsTrend LIKE 'Negative%' AND t.client.clientId="+clientId+" AND t.date BETWEEN '"
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

}
