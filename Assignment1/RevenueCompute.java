import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class RevenueCompute {

	public static void main(String[] args) {
		try {
			BufferedReader	fileReader = new BufferedReader(new FileReader("./MunExp.csv"));

			CsvToBean<CsvData> csvToBean = new CsvToBeanBuilder<CsvData>(fileReader)
					.withType(CsvData.class)
					.withIgnoreLeadingWhiteSpace(true)
					.build();

			List<CsvData> employees = csvToBean.parse();
			
			System.out.println("Category Wise Revenue And Expenditure");
			
			computeCatWise(employees);
			System.out.println();
			System.out.println("Year Wise Revenue And Expenditure");
			computeyearWise(employees);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void computeCatWise(List<CsvData> employees) {
		TreeMap<Integer,String> catWiseRevExp = new TreeMap<Integer,String>();
		
		for (CsvData c : employees) {
			int cat = c.getCategory();
			if(catWiseRevExp.containsKey(cat)) {
				String str = catWiseRevExp.get(cat);
				String[] x = str.split(",");
				long rev = Long.parseLong(x[0])+c.getRevenue();
				long exp = Long.parseLong(x[1])+c.getExpenditure();
				str = rev + "," + exp;
				catWiseRevExp.put(cat, str);
			}
			else {
				String str = c.getRevenue()+","+c.getExpenditure();
				catWiseRevExp.put(cat, str);
			}
		}
		System.out.println("Category   Revenue  Expenditure");
		for(Entry<Integer, String> m: catWiseRevExp.entrySet()){
			System.out.print(m.getKey()+"        ");
			String str = m.getValue();
			String[] x = str.split(",");
			System.out.println(x[0] + "  " + x[1]);
		}
	}
	
	public static void computeyearWise(List<CsvData> employees) {
		TreeMap<Integer,String> yWiseRevExp = new TreeMap<Integer,String>();
		
		for (CsvData c : employees) {
			int cat = c.getYear();
			if(yWiseRevExp.containsKey(cat)) {
				String str = yWiseRevExp.get(cat);
				String[] x = str.split(",");
				long rev = Long.parseLong(x[0])+c.getRevenue();
				long exp = Long.parseLong(x[1])+c.getExpenditure();
				str = rev + "," + exp;
				yWiseRevExp.put(cat, str);
			}
			else {
				String str = c.getRevenue()+","+c.getExpenditure();
				yWiseRevExp.put(cat, str);
			}
		}
		
		System.out.println("Year   Revenue   Expenditure");
		for(Entry<Integer, String> m: yWiseRevExp.entrySet()){
			System.out.print(m.getKey()+"   ");
			String str = m.getValue();
			String[] x = str.split(",");
			System.out.println(x[0] + "  " + x[1]);
		}
	}
	
}

