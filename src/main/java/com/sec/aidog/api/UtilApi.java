package com.sec.aidog.api;


import com.sec.aidog.common.RedisUtil;
import com.sec.aidog.pojo.VolTemp;
import com.sec.aidog.service.NeckletService;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HeaderFooter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@RequestMapping("api")
@Controller
public class UtilApi {

    @Autowired
    private NeckletService neckletService;

    @RequestMapping(value="exportExcel",method = RequestMethod.POST)
    @ResponseBody
    public void GetHamletOwnerList(@RequestParam(value = "necid")String necid,@RequestParam(value = "begintime")String begintime,@RequestParam(value = "endtime")String endtime,@RequestParam(value = "level")String level,@RequestParam(value = "districtcode")String districtcode, HttpServletRequest request, HttpServletResponse response){
        String token = request.getHeader("token");
        try {
            //取出存在缓存中的已登录用户的信息
            String managerstr = RedisUtil.RedisGetValue("token:"+token);
            //权限控制


            switch (level){
                case "province":
                    districtcode = districtcode.substring(0,2);
                    break;
                case "city":
                    districtcode = districtcode.substring(0,4);
                    break;
                case "county":
                    districtcode = districtcode.substring(0,6);
                    break;
                case "village":
                    districtcode = districtcode.substring(0,9);
                    break;
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");//注意格式化的表达式
            List<VolTemp> voltemplist = neckletService.getNeckletVolAndTempVoltemplist(districtcode==null?"":districtcode,format.parse(begintime),format.parse(endtime),necid);


//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("sequence", "0001");
//            map.put("date", "2018/01/04");
//            map.put("chetaihao", "1#");
//            map.put("productName", "产品名称");
//            map.put("specification", "规格");
//            map.put("memo", "备注");
//            map.put("inspectRecordBizList", "一个list");

//            HSSFWorkbook wb = new HSSFWorkbook();
//            Sheet sheet = wb.createSheet("电压温度表");
//            Row row = sheet.createRow(0);
//            int i = 0;
//            for(String key : map.keySet()){
//                Cell cell = row.createCell(i);
//                cell.setCellValue((String) map.get(key));
//                i++;
//            }


            //创建工作薄
            XSSFWorkbook wb = new XSSFWorkbook();
            //创建表单
            XSSFSheet sheet = genSheet(wb,"电压和温度表");
            //创建表单样式
            XSSFCellStyle titleStyle = genTitleStyle(wb);//创建标题样式
            XSSFCellStyle contextStyle = genContextStyle(wb);//创建文本样式

            //创建Excel
            genExcel(sheet,titleStyle,contextStyle,voltemplist);

            XSSFRow row = sheet.createRow(0);//创建第一行，为标题，index从0开始
            XSSFCell cell;
            cell = row.createCell(0);//创建一列
//            cell.setCellValue(format.parse(begintime)+"-"+format.parse(endtime)+" 电压温度表");//标题
            cell.setCellValue("电压温度表");//标题
            cell.setCellStyle(titleStyle);//设置标题样式


            OutputStream fos = null;
            try {
                fos = response.getOutputStream();
                String userAgent = request.getHeader("USER-AGENT");
                String fileName = "电压温度表";
                try {
                    if(StringUtils.contains(userAgent, "Mozilla")){
                        fileName = new String(fileName.getBytes(), "ISO8859-1");
                    }else {
                        fileName = URLEncoder.encode(fileName, "utf8");
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/vnd.ms-excel;charset=utf-8");// 设置contentType为excel格式
                response.setHeader("Content-Disposition", "Attachment;Filename="+ fileName+".xls");
                wb.write(fos);
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //设置表单，并生成表单
    public static XSSFSheet genSheet(XSSFWorkbook workbook, String sheetName){
        //生成表单
        XSSFSheet sheet = workbook.createSheet(sheetName);
        //设置表单文本居中
        sheet.setHorizontallyCenter(true);
        sheet.setFitToPage(false);
        //打印时在底部右边显示文本页信息
        Footer footer = sheet.getFooter();
        footer.setRight( "Page " + HeaderFooter.numPages()+ " Of "+ HeaderFooter.page());
        //打印时在头部右边显示Excel创建日期信息
        Header header = sheet.getHeader();
        header.setRight("Create Date " + HeaderFooter.date() + " " + HeaderFooter.time());
        //设置打印方式
        XSSFPrintSetup ps = sheet.getPrintSetup();
        ps.setLandscape(true); // true：横向打印，false：竖向打印 ，因为列数较多，推荐在打印时横向打印
        ps.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE); //打印尺寸大小设置为A4纸大小
        return sheet;
    }

    //创建文本样式
    public static XSSFCellStyle genContextStyle(XSSFWorkbook workbook){
        XSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);//文本水平居中显示
        style.setVerticalAlignment(VerticalAlignment.CENTER);//文本竖直居中显示
        style.setWrapText(true);//文本自动换行

        //生成Excel表单，需要给文本添加边框样式和颜色
        /*
             CellStyle.BORDER_DOUBLE      双边线
             CellStyle.BORDER_THIN        细边线
             CellStyle.BORDER_MEDIUM      中等边线
             CellStyle.BORDER_DASHED      虚线边线
             CellStyle.BORDER_HAIR        小圆点虚线边线
             CellStyle.BORDER_THICK       粗边线
         */
        style.setBorderBottom(BorderStyle.THIN);//设置文本边框
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        //set border color
        style.setTopBorderColor(new XSSFColor(java.awt.Color.BLACK));//设置文本边框颜色
        style.setBottomBorderColor(new XSSFColor(java.awt.Color.BLACK));
        style.setLeftBorderColor(new XSSFColor(java.awt.Color.BLACK));
        style.setRightBorderColor(new XSSFColor(java.awt.Color.BLACK));

        return style;
    }

    //生成标题样式
    public static XSSFCellStyle genTitleStyle(XSSFWorkbook workbook){

        XSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setWrapText(true);

        //标题居中，没有边框，所以这里没有设置边框，设置标题文字样式
        XSSFFont titleFont = workbook.createFont();
        titleFont.setBold(true);//加粗
        titleFont.setFontHeight((short)15);//文字尺寸
        titleFont.setFontHeightInPoints((short)15);
        style.setFont(titleFont);

        return style;
    }

    public static void genExcel(XSSFSheet sheet,XSSFCellStyle titleStyle,XSSFCellStyle contextStyle, List<VolTemp> voltemplist) {

        //根据Excel列名长度，指定列名宽度  Excel总共4列
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                sheet.setColumnWidth(i, 6000);
            }else{
                sheet.setColumnWidth(i, 3000);
            }
        }

        //设置标题位置
        sheet.addMergedRegion(new CellRangeAddress(
                0, //first row
                0, //last row
                0, //first column
                3 //last column
        ));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");//注意格式化的表达式

        XSSFRow row = sheet.createRow(0);//创建第一行，为标题，index从0开始
        XSSFCell cell;
        cell = row.createCell(0);//创建一列
        cell.setCellValue("电压和温度表");//标题
        cell.setCellStyle(titleStyle);//设置标题样式

        row = sheet.createRow(1);//创建第二行
        cell = row.createCell(0);//创建第二行第一列
        cell.setCellValue("时间");//第二行第一列内容
        cell.setCellStyle(contextStyle);//设置样式
        cell = row.createCell(1);//2 row 1 column
        cell.setCellValue("项圈编号");
        cell.setCellStyle(contextStyle);
        cell = row.createCell(2);//2 row 2 column
        cell.setCellValue("电压");
        cell.setCellStyle(contextStyle);
        cell = row.createCell(3);//2 row 3 column
        cell.setCellValue("温度");
        cell.setCellStyle(contextStyle);

		/*
			实际填充数据的时候，对可能为空的数据要进行处理，要先进行判断，否则报错
			String value = Test.getVal();
			if(StringUtils.isNotBlank(value)) {
				cell.setCellValue(value);
			} else{
			    cell.setCellValue(" ");
			}
		*/
        //从数据库取数据填充到Excel，这步省略，添加模拟数据

        for(int i = 2 ; i< voltemplist.size()+2;i++){//i从2开始计数，因为上面已经创建了 0 1行
            row=sheet.createRow(i);//创建第三行
            cell=row.createCell(0);//创建第三行第一列
            cell.setCellValue(format.format(voltemplist.get(i-2).getRealtime()));//第三行第一列的值
            cell.setCellStyle(contextStyle);//设置样式
            cell=row.createCell(1);//2 row 1 column
            cell.setCellValue(voltemplist.get(i-2).getDeviceId());
            cell.setCellStyle(contextStyle);
            cell=row.createCell(2);//2 row 2 column
            cell.setCellValue(voltemplist.get(i-2).getVol());
            cell.setCellStyle(contextStyle);
            cell=row.createCell(3);//2 row 3 column
            cell.setCellValue(voltemplist.get(i-2).getTemp());
            cell.setCellStyle(contextStyle);
        }
    }
}
