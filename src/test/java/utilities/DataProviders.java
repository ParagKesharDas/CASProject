package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name = "userVerificationData")
	public static String[][]  getUserVerificationData() throws IOException {

		String path = ".\\testData\\BeCognizantUserInformation.xlsx";
		ExcelDataFile xlUtils = new ExcelDataFile(path);

		int totalrows = xlUtils.getRowCount("profileInfo");
		int totalcols = xlUtils.getCellCount("profileInfo", 1);
//		System.out.println(totalrows+" "+totalcols);
		String userVerificationData[][] = new String[totalrows][totalcols];
		
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				userVerificationData[i - 1][j] = xlUtils.getCellData("profileInfo", i, j);// i-1 because we are skipping 1st heading
//				System.out.print(xlUtils.getCellData("profileInfo", i, j)+" ");
			}
//			System.out.println();
		}
		return userVerificationData;

	}

	@DataProvider(name = "headerDataCheckingData")
	public static String[][]  headerCheckingData() throws IOException {

		String path = ".\\testData\\BeCognizantUserInformation.xlsx";
		ExcelDataFile xlUtils = new ExcelDataFile(path);

		int totalrows = xlUtils.getRowCount("headerChecking");
		int totalcols = xlUtils.getCellCount("headerChecking", 1);
//		System.out.println(totalrows+" "+totalcols);
		String headerDataCheckingData[][] = new String[totalrows][totalcols];
		
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				headerDataCheckingData[i - 1][j] = xlUtils.getCellData("headerChecking", i, j);// i-1 because we are skipping 1st heading
//				System.out.print(xlUtils.getCellData("headerChecking", i, j)+" ");
			}
//			System.out.println();
		}
		return headerDataCheckingData;

	}
	
	@DataProvider(name = "headerDataClickingData")
	public static String[][]  headerClickingData() throws IOException {

		String path = ".\\testData\\BeCognizantUserInformation.xlsx";
		ExcelDataFile xlUtils = new ExcelDataFile(path);

		int totalrows = xlUtils.getRowCount("headerClicking");
		int totalcols = xlUtils.getCellCount("headerClicking", 1);
//		System.out.println(totalrows+" "+totalcols);
		String headerDataClickingData[][] = new String[totalrows][totalcols];
		
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				headerDataClickingData[i - 1][j] = xlUtils.getCellData("headerClicking", i, j);// i-1 because we are skipping 1st heading
//				System.out.print(xlUtils.getCellData("headerClicking", i, j)+" ");
			}
//			System.out.println();
		}
		return headerDataClickingData;

	}
	
	@DataProvider(name = "SecoundPageValidationData")
	public static String[][]  secoundPageValidationData() throws IOException {

		String path = ".\\testData\\BeCognizantUserInformation.xlsx";
		ExcelDataFile xlUtils = new ExcelDataFile(path);

		int totalrows = xlUtils.getRowCount("headerClicking");
		int totalcols = xlUtils.getCellCount("headerClicking", 1);
//		System.out.println(totalrows+" "+totalcols);
		String secoundPageTitleValidationData[][] = new String[totalrows][totalcols];
		
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				secoundPageTitleValidationData[i - 1][j] = xlUtils.getCellData("headerClicking", i, j);// i=1 because we are skipping 1st heading
//				System.out.print(xlUtils.getCellData("headerClicking", i, j)+" ");
			}
//			System.out.println();
		}
		return secoundPageTitleValidationData;

	}
	
//	public static void main(String[] args) throws IOException {
//	DataProviders.getUserVerificationData();
//	DataProviders.headerCheckingData();
//	DataProviders.headerClickingData();
//	DataProviders.secoundPageValidationData();
//}

	
}
