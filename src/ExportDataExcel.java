/*
 * Delta CONFIDENTIAL
 *
 * (C) Copyright Delta Electronics, Inc. 2016 All Rights Reserved
 *
 * NOTICE:  All information contained herein is, and remains the
 * property of Delta Electronics. The intellectual and technical
 * concepts contained herein are proprietary to Delta Electronics
 * and are protected by trade secret, patent law or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Delta Electronics.
 */


import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;

import com.delta.ams.common.util.Log;


/**
 * @author V.Caifeng.Fan 
 * @ClassName ExportExcelMap 
 * @Description: TODO 
 * @date Jun 5, 2017 3:49:00 PM 
 */
@SuppressWarnings("deprecation")
public class ExportDataExcel {

	
		  /***
		   * ������
		   */
		  private  HSSFWorkbook workbook;

		  /***
		   * sheet
		   */
		  private  HSSFSheet sheet;
		

		  /***
		   * ��ͷ�п�ʼλ��
		   */
		  private  int headStartPosition = 1;

		  /***
		   * �ı��п�ʼλ��
		   */
		  private  int contentStartPosition = 2;
		  /**
		   * serial name
		   */
		  private  String SerialNumName = "No";
		  
		  
		  
		/**
		 * @return the headStartPosition
		 */
		public int getHeadStartPosition() {
		
			return headStartPosition;
		}

		
		/**
		 * @param headStartPosition the headStartPosition to set
		 */
		public void setHeadStartPosition(int headStartPosition) {
		
			this.headStartPosition = headStartPosition;
		}

		
		/**
		 * @return the contentStartPosition
		 */
		public int getContentStartPosition() {
		
			return contentStartPosition;
		}

		
		/**
		 * @param contentStartPosition the contentStartPosition to set
		 */
		public void setContentStartPosition(int contentStartPosition) {
		
			this.contentStartPosition = contentStartPosition;
		}

		
		/**
		 * @return the serialNumName
		 */
		public String getSerialNumName() {
		
			return SerialNumName;
		}

		
		/**
		 * @param serialNumName the serialNumName to set
		 */
		public void setSerialNumName(String serialNumName) {
		
			SerialNumName = serialNumName;
		}

		/**
		   * 
		   * @param dataList
		   *        ���󼯺�
		   * @param titleMap
		   *        ��ͷ��Ϣ��������������->Ҫ��ʾ�ı���ֵ)[��˳�����]
		   * @param sheetName
		   *        sheet���ƺͱ�ͷֵ
		 * @param headStart  excel head start row number 
		 * @param contentStart  excel  content start row number
		   */
		  public  void excelExport(List<?> dataList, Map<String, String> titleMap, String sheetName,boolean isAddNo) {
		   
		    initHSSFWorkbook(sheetName);
		    createHeadRow(titleMap,isAddNo);
		    createContentRow(dataList, titleMap,isAddNo);
		   
		    // д�봦����
		    try {
		      //����UUID�ļ�����
		      UUID uuid = UUID.randomUUID();
		      String filedisplay = uuid + ".xls";
		      OutputStream out = new FileOutputStream("D:\\" + filedisplay);
		      workbook.write(out);
		      out.close();
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }
		  }

		  /***
		   * 
		   * @param sheetName
		   *        sheetName
		   */
		  public  void initHSSFWorkbook(String sheetName) {
		    workbook = new HSSFWorkbook();
		    sheet = workbook.createSheet(sheetName);
		   
		  }
//		  public static void setExcelStyle() {
//			  // ����һ����ʽ
//		      HSSFCellStyle style = workbook.createCellStyle();
//		      // ������Щ��ʽ
//		      style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
//		      style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//		      style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//		      style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//		      style.setBorderRight(HSSFCellStyle.BORDER_THIN);
//		      style.setBorderTop(HSSFCellStyle.BORDER_THIN);
//		      style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//		      // ����һ������
//		      HSSFFont font = workbook.createFont();
//		      font.setColor(HSSFColor.VIOLET.index);
//		      font.setFontHeightInPoints((short) 12);
//		      font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//		      // ������Ӧ�õ���ǰ����ʽ
//		      style.setFont(font);
//			
//		}


		  /**
		   * create excel head row
		   * @param titleMap javabean field->excel headname 
		   */
		  public void createHeadRow(Map<String, String> titleMap,boolean isAddNo ) {
		    // ��1�д���
		    HSSFRow headRow = sheet.createRow(this.headStartPosition);
		    HSSFCellStyle style = workbook.createCellStyle();
		    HSSFFont font = workbook.createFont();
		    font.setFontHeightInPoints((short) 10);
		    font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		    style.setFont(font);
		    int i = 0;
		    if (isAddNo) {
				HSSFCell noCell = headRow.createCell(i);
				noCell.setCellStyle(style);
				noCell.setCellValue(this.SerialNumName); //$NON-NLS-1$
				i++;
			}
			for (String entry : titleMap.keySet()) {
		      HSSFCell headCell = headRow.createCell(i);
		      headCell.setCellStyle(style);
		      headCell.setCellValue(titleMap.get(entry));
		      i++;
		    }
		  }

		 /**
		  * 
		  * @param dataList which will write in excel file
		  * @param titleMap 
		  *  @param startRowNum  
		  */
		  public void createContentRow(List<?> dataList, Map<String, String> titleMap,List<String> replaceFields,boolean isAddNo) {
		    try {
		      int i=0;//row
		      for (Object obj : dataList) {
		        HSSFRow textRow = sheet.createRow(this.contentStartPosition + i);
		        int j = 0;//cell
		        if (isAddNo) {
					HSSFCell noCell = textRow.createCell(0);
					noCell.setCellValue(i + 1);
					j++;
				}
				for (String entry : titleMap.keySet()) {
				
		          String method = "get" + entry.substring(0, 1).toUpperCase() + entry.substring(1); //$NON-NLS-1$
		          Method m = obj.getClass().getMethod(method, null);
		          Object value =  m.invoke(obj, null);
		          value = value==null?"":value;
		          if(replaceFields.contains(entry)){
		        	  
		          }
		          //�ж�ֵ�����ͺ����ǿ������ת��
	                String textValue = null;
	                //�ж�ֵ�����ͺ����ǿ������ת��
			          String tsStr = "";  //$NON-NLS-1$
		              if (value instanceof Timestamp) {
		                	Timestamp ts = (Timestamp) value;
		                	
		                	 DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		                	 try {   
		                         //����һ   
		                         tsStr = sdf.format(ts);   
		                     } catch (Exception e) {   
		                         e.printStackTrace();   
		                         Log.e(e);
		                     }  
		                	 value = tsStr;
			        }
		           
		          HSSFCell textcell = textRow.createCell(j);
		          textcell.setCellValue(value.toString());
		          j++;
		        }
		        
		        i++;
		      }

		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }
		  }
		  /**
		   * �Զ������У���Ǳ�Ҫ������򿪴˷��������ڴ棩
		   * @param size ����
		   */
		  public void autoSizeColumn(Integer size) { 
		    for (int j = 0; j < size; j++) {
		      sheet.autoSizeColumn(j);
		    }
		  }
		
	

		

		  /**
		   * @param args
		   */
		  public static void main(String[] args) {

		    /**ģ�����ݿ�ʼ*/
		    List<Employee> staffs = new ArrayList<Employee>();
		    for (int i = 0; i < 65532; i++) {
		      Employee staff = new Employee(i, i+"group", 1900+i, 12, 25, 2500+i);
		      staffs.add(staff);
		    }
		    Map<String,String> titleMap = new LinkedHashMap<String,String>();
		   
		    titleMap.put("name", "����");
		    titleMap.put("clazz", "���");
		    titleMap.put("year", "���");
		    titleMap.put("month", "�·�");
		    titleMap.put("day", "��");
		    titleMap.put("salary", "н��");
		    String sheetName = "��Ϣ����";
		    /**ģ�����ݽ���*/

		    System.out.println("start����");
		    long start = System.currentTimeMillis();
		    ExportDataExcel exportDataExcel = new ExportDataExcel();
		    exportDataExcel.excelExport(staffs, titleMap, sheetName,false);
		    long end = System.currentTimeMillis();
		    System.out.println("end����");
		    System.out.println("��ʱ��"+(end-start)+"ms");
		  }

		

}
