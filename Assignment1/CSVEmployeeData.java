import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVEmployeeData {

	public static void main(String[] args) {
		try {
			BufferedReader	fileReader = new BufferedReader(new FileReader("./MunExp.csv"));

			CsvToBean<CsvData> csvToBean = new CsvToBeanBuilder<CsvData>(fileReader)
					.withType(CsvData.class)
					.withIgnoreLeadingWhiteSpace(true)
					.build();

			List<CsvData> employees = csvToBean.parse();
			//TreeMap for storing year wise revenue and expenditure
			TreeMap<Integer,ArrayList<Long>> yWiseRevExp = new TreeMap<Integer,ArrayList<Long>>();
			//computing the revenue and expenditure and storing it in tree map
			for(int yr = 1979; yr < 1988; yr++) {
				ArrayList<Long> al=new ArrayList<Long>();
				yearWiseRevenue(employees,yr,al);
				yWiseRevExp.put(yr,al);
			}
			
			//printing
			System.out.println("Year Wise Revenue and Expenditure");
			System.out.println("Year  Revenue   Expenditure");
			for(Entry<Integer, ArrayList<Long>> m: yWiseRevExp.entrySet()){
				System.out.print(m.getKey()+"  ");  
				ArrayList<Long> al=new ArrayList<Long>(m.getValue());
				ListIterator<Long> itr=al.listIterator();
				while(itr.hasNext()){  
					System.out.print(itr.next()+"  ");  
				} 
				 System.out.println();
				}
			//TreeMap for storing category wise revenue and expenditure
			TreeMap<Integer,ArrayList<Long>> cWiseRevExp = new TreeMap<Integer,ArrayList<Long>>();
			
			//computing the revenue and expenditure and storing it in tree map
			for(int ct = 100; ct < 1350; ct++) {
				ArrayList<Long> al=new ArrayList<Long>();
				if(catWiseRevenue(employees,ct,al))
					cWiseRevExp.put(ct,al);
			}
			
			//printing
			System.out.println();
			System.out.println("Category Wise Revenue and Expenditure");
			System.out.println("Category Revenue  Expenditure");
			for(Entry<Integer, ArrayList<Long>> m: cWiseRevExp.entrySet()){
				System.out.print(m.getKey()+"      ");  
				ArrayList<Long> al=new ArrayList<Long>(m.getValue());
				ListIterator<Long> itr=al.listIterator();
				while(itr.hasNext()){  
					System.out.print(itr.next()+"  ");  
				} 
				 System.out.println();
				}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void yearWiseRevenue(List<CsvData> c,int y,ArrayList<Long> al) {
		long totalR = 0;
		long totalE = 0;
		
		for (CsvData employees : c) {
			if(employees.getYear() == y) {
				totalR += employees.getRevenue();
				totalE += employees.getExpenditure();
			}
		}
		al.add(totalR);
		al.add(totalE);
	}
	
	public static boolean catWiseRevenue(List<CsvData> c,int cat,ArrayList<Long> al) {
		long totalR = 0;
		long totalE = 0;
		
		for (CsvData employees : c) {
			if(employees.getCategory() == cat) {
				totalR += employees.getRevenue();
				totalE += employees.getExpenditure();
			}
		}
		if(totalR == 0 || totalE == 0) 
			return false;
		al.add(totalR);
		al.add(totalE);
		return true;
	}
	
}
