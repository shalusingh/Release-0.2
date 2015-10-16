package com.onlinemarketplace.product.manager;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.onlinemarketplace.dataentity.domain.Product;

@Service
public class ProductNameIdMappingManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductNameIdMappingManager.class);

	CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
	
	@SuppressWarnings("unused")
	@Autowired
	private ApplicationContext appContext;
	
	@SuppressWarnings("unused")
	public boolean writeCSV(File file,List<Product> list){
		boolean result = false;
		CSVPrinter printer = null;
		LOGGER.info(" >>> Start writteng in csv file");
		boolean writeHeader = true;
		StringBuffer headers = new StringBuffer();
		FileWriter writer = null;
		try {
				writer = new FileWriter( file );
				printer = new CSVPrinter(writer,format);
				
				printer.printRecord("ID","NAME");
				 
        		for(Product product  : list){
				List<String> productData = new ArrayList<String>();
				productData.add(product.getId().toString() );
				productData.add(product.getName());
				
				printer.printRecord(productData);
	        }
			result = true;
		} catch (IOException ioException) {
			LOGGER.error("Unable to write data in csv file.", ioException);
			ioException.printStackTrace();
		}catch (Exception exception) {
			LOGGER.error("Unable to write data in csv file.", exception);
			exception.printStackTrace();
		}finally{
			try {  if(printer!=null) printer.close(); } catch (IOException e) { e.printStackTrace();}
			LOGGER.info(" >>> End writteng in csv file");
		}
        return result;
	}

	
	public Map<String, Long> getMappingFromCSV(File file){
		CSVParser parser =null;
		Map<String, Long> mapping = new HashMap<String, Long>();
		try{
			parser = new CSVParser(new FileReader( file ), format);
			for(CSVRecord record : parser){
				mapping.put(record.get("NAME"), Long.parseLong(record.get("ID")));
			}
		}catch(IOException ioException){
			LOGGER.error("Unable to write data in csv file.", ioException);
			ioException.printStackTrace();
		}finally{
			try { if(parser!=null) parser.close();} catch (Exception e) {}
		}
		return mapping;
	}
	
}
