package tn.esprit.Dari.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tn.esprit.Dari.modal.Payement;
import tn.esprit.Dari.repository.PayementRepository;


@Service("payementService")
public class PayementServiceImpl implements PayementService {
	@Autowired
	PayementRepository payementRepository;
  
	@Override
	public Payement addPayement(Payement payement) {
		payementRepository.save(payement) ;
		return payement;
	}
	@Override
	public Payement updatePayement (Payement payement) {
		return payementRepository.save(payement);
	}
	@Override
	public Payement findPayementById(long id) {
	    return payementRepository.findById(id).orElse(null);
	}
	
	public String callStripeAPIBuy(Payement payement) {

		URIBuilder uriBuilder = new URIBuilder();
		uriBuilder.setScheme("https")
		.setHost("api.stripe.com")
		.setPort(443)
		.setPath("/v1/payment_intents");
		uriBuilder.addParameter("amount", payement.getAmount().intValue()+"");
		uriBuilder.addParameter("currency", "usd");
		uriBuilder.addParameter("payment_method_types[]", "card");
		URI uri = null;
		try {
			uri = uriBuilder.build();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		HttpPost httpPost = new HttpPost(uri);


		httpPost.addHeader("Authorization", "Bearer sk_test_51IeRXFKcF1fvzlK2IouWCXEHmjgCLNrBGnHSBAanKff9bUieECPYlgqITdEv0FehPFpCbcIxp339gV9CTmq9poQ600qtifQXUU");
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
		httpPost.addHeader("Accept", "application/json");

		CloseableHttpClient client = HttpClients.createDefault();		    
		CloseableHttpResponse response = null;
		try {
			response = client.execute(httpPost);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	

		if(response!=null && response.getStatusLine().getStatusCode() == 200)
		{
			HttpEntity entity = response.getEntity();
			try {
				InputStream inputStream = entity.getContent();
				//	System.out.println(IOUtils.toString(inputStream, StandardCharsets.UTF_8));
				ObjectMapper mapper = new ObjectMapper();
				Map<String, Object> jsonMap = mapper.readValue(inputStream, Map.class);
				return (String) jsonMap.get("id");
			} catch (UnsupportedOperationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			HttpEntity entity = response.getEntity();
			InputStream inputStream=null;
			try {
				inputStream = entity.getContent();
			} catch (UnsupportedOperationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> jsonMap = null;
			try {
				jsonMap = mapper.readValue(inputStream, Map.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(jsonMap);
		}


		return null;

	}
}

