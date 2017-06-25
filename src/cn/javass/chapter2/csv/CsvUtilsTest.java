package cn.javass.chapter2.csv;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CsvUtilsTest {

	public static void main(String [] args){
		System.out.println("export file begin...");
		List<Data> dataList = buildDataList();
		dataList.add(0, buildHead());
		File file = new File("test.csv");
		File path = new File("d:\\test\\");
		if(CsvUtils.exportCsv(path, file, dataList)){
			System.out.println("export file success.");
		}else {
			System.out.println("export file fail.");
		}
	}
	
	private static List<Data> buildDataList(){
		System.out.println("buildDataList begin...");
		List<Data> dataList = new ArrayList<Data>();
		for (int i = 0; i < 100; i++) {
			Data data = new Data();
			int seqNo = i + 1;
			data.setId("" + seqNo);
			data.setName("name" + seqNo);
			data.setAge("" + seqNo);
			dataList.add(data);
		}
		System.out.println("buildDataList end...");
		return dataList;
	}
	
	private static Data buildHead() {
		System.out.println("buildHead begin...");
		Data data = new Data();
		data.setId("Id");
		data.setName("Name");
		data.setAge("Age");
		System.out.println("buildHead end...");
		return data;
	}
}
