package com.boundaryadvert.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import com.boundaryadvert.model.Container;
import com.boundaryadvert.model.Matrix;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BoundaryAdvertFunctions {

	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
	    Set<Object> seen = new HashSet<>();
	    return t -> seen.add(keyExtractor.apply(t));
	}
	
	public static String convertDataToDesigCode(String broadcaster, String jsonData) 
		throws JsonMappingException, JsonProcessingException
	{
		String txtToReturn = "";
		System.out.println("convertDataToDesigCode: broadcaster = " + broadcaster);
		ObjectMapper objectMapper = new ObjectMapper();
		
		switch (broadcaster.toUpperCase()){ 
		case BoundaryAdvertUtil.DOAD_BOUNDARY_ADVERT:
			
			List<Matrix> matrices = objectMapper.readValue(jsonData, new TypeReference<List<Matrix>>() {});
			System.out.println("convertDataToDesigCode: matrices size = " + matrices.size());
			List<Container> containerList = new ArrayList<Container>();

			for (Matrix matrix : matrices) {
				
				containerList = Arrays.asList(matrix.getContainerOne(),matrix.getContainerTwo(),matrix.getContainerThree());
				System.out.println("convertDataToDesigCode: containerList.size = " + containerList.size());
	            
				for (Container container : containerList) {
	            	
					txtToReturn = txtToReturn + "#REC^" + container.getWidth() 
						+ "^" + matrix.getContainerOne().getHeight();
						
					switch (container.getDataType().toUpperCase()) {
					case BoundaryAdvertUtil.VIDEO:
					case BoundaryAdvertUtil.IMAGE:
						txtToReturn = txtToReturn + "^" + container.getDataType().charAt(0);
						break;
					case BoundaryAdvertUtil.BLANK:
						txtToReturn = txtToReturn + "^" + "V";
						break;
					}
					txtToReturn = txtToReturn + "^" + "ROW_" + matrix.getMatrixId() + "_COLUMN_" + container.getContainerId();
					switch (container.getDataType().toUpperCase()) {
 					case BoundaryAdvertUtil.VIDEO:
					case BoundaryAdvertUtil.IMAGE:
						txtToReturn = txtToReturn + "^" + container.getDataPath();
						break;
					case BoundaryAdvertUtil.BLANK:
						txtToReturn = txtToReturn + "^" + BoundaryAdvertUtil.EMPTY;
						break;
					}
					System.out.println("ROW_" + matrix.getMatrixId() + "_COLUMN_" + container.getContainerId() + " container = " + container);
				}
				txtToReturn = txtToReturn + System.lineSeparator();
			}
			break;
		}
		return txtToReturn;
	}

	public static String getOnlineCurrentDate() throws IOException
	{
		HttpURLConnection httpCon = (HttpURLConnection) new URL("https://mail.google.com/").openConnection();
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date(httpCon.getDate()));
	}	
	
	}
