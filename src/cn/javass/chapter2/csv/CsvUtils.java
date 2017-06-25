package cn.javass.chapter2.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;


  	
public class CsvUtils {

    public static boolean exportCsv(File path, File fileName, List<Data> dataList){
    	if(null == path || null == fileName){
    		return false;
    	}
    	if(CollectionUtils.isEmpty(dataList)){
    		return false;
    	}
    	
        boolean isSuccess = false;
        
        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        
        try {
        	if(!path.exists()){
        		path.mkdirs();
        	}
        	
			out = new FileOutputStream(path.getAbsolutePath() + "\\" + fileName.getName());
			osw = new OutputStreamWriter(out);
			bw = new BufferedWriter(osw);
			
			for (Data data : dataList) {
				bw.append(data.toString());
			}
        	
			isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess=false;
		} finally {
			if(bw!=null){
                try {
                    bw.close();
                    bw=null;
                } catch (IOException e1) {
                    e1.printStackTrace();
                } 
            }
            if(osw!=null){
                try {
                    osw.close();
                    osw=null;
                } catch (IOException e2) {
                    e2.printStackTrace();
                } 
            }
            if(out!=null){
                try {
                    out.close();
                    out=null;
                } catch (IOException e3) {
                    e3.printStackTrace();
                } 
            }
		}
        return isSuccess;
    }
    
    public static List<String> importeCsv(File file) {
    	List<String> dataList = new ArrayList<String>();
		if(null == file){
			return dataList;
		}
		
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = "";
			
			while (StringUtils.hasLength(line = br.readLine()) ) {
				dataList.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(br != null){
				try {
                    br.close();
                    br=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
			}
			
			if(fr != null){
				try{
					fr.close();
					fr = null;
				}catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
		return dataList;
	}
}
