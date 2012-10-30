package uk.ltd.crossfire.companymanager.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;


public class BasicPlace extends Place {

	 public static class Tokenizer implements PlaceTokenizer<BasicPlace> {
	        @Override
	        public String getToken(BasicPlace place) {
	            return null;
	        }

	        @Override
	        public BasicPlace getPlace(String token) {
	            return null;
	        }
	    }

}
