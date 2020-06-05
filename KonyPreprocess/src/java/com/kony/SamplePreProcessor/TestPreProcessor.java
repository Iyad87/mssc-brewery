package com.kony.SamplePreProcessor;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.konylabs.middleware.common.DataPreProcessor2;
import com.konylabs.middleware.controller.DataControllerRequest;
import com.konylabs.middleware.controller.DataControllerResponse;
import com.konylabs.middleware.dataobject.Param;
import com.konylabs.middleware.dataobject.Result;
import com.konylabs.middleware.session.Session;

public class TestPreProcessor implements DataPreProcessor2 {

	private static final Logger LOG = Logger.getLogger(TestPreProcessor.class);
	
	
	@Override
	public boolean execute(HashMap inputMap, DataControllerRequest request,
			DataControllerResponse response, Result result) throws Exception {
		LOG.debug("########### In Sample PreProcessor.execute() ##########");
		//get our session object
		Session session = request.getSession();
		//get the value of the type input parameter
		String newsValue = (String) inputMap.get("newsType");
		LOG.debug("########### Value of News Type: " + newsValue);
		//check to see if valid type parameter value sent
		if(newsValue == null || newsValue.equals("")){
			String valueInSession = (String) session.getAttribute("TYPE_IN_SESSION");
			LOG.debug("########### Value of News Type from session: " + valueInSession);
			//check if there is a valid session value
			if(valueInSession == null || valueInSession.equals("")){
				result.addParam(new Param("opstatus", "-1", "String"));
				result.addParam(new Param("errmsg", "NewsType Not Available in Session", "String"));
				return false;
			}
			
			//use value from session as the input parameter value
			LOG.debug("########### Using the value of the session attribute to perform service call: " + valueInSession);
			inputMap.put("newsType", valueInSession);
			//remove value from session – so next time it's null if nothing passed in from device
			LOG.debug("########### Removing the TYPE_IN_SESSION from session ");
			session.removeAttribute("TYPE_IN_SESSION");
		}
		else{
			//replace the session value with the latest value
			LOG.debug("########### Setting the session attribute TYPE_IN_SESSION with the value: " + newsValue);
			session.setAttribute("TYPE_IN_SESSION", newsValue);
		}
		return true;
	}

}
