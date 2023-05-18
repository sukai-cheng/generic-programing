package com.easyexcel.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;
import com.alibaba.excel.write.metadata.WriteWorkbook;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.easyexcel.pojo.ActResultLogDO;
import com.easyexcel.service.ActResultLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author chengsukai
 */
@Slf4j
@Component
public class EasyExcelUtil {
    @Resource
    private ActResultLogService actResultLogService;

    private static final Integer totalCount = 20000;

    /**
     * 首行单元格
     * @param workbook
     * @param fontSize
     * @return
     */
    public static CellStyle getColumnTopStyle(Workbook workbook, int fontSize) {
        if (fontSize == 0) {
            fontSize = 10;
        }
        // 设置字体
        Font font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) fontSize);
        //字体加粗
        font.setBold(true);
        //设置字体名字
        font.setFontName("宋体");
        //设置样式;
        CellStyle style = workbook.createCellStyle();
        //左右居中
        style.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置边框
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        return style;
    }

    /**
     *
     * @param workbook
     * @param fontSize
     * @return
     */
    public static CellStyle getColumnSecondLineStyle(Workbook workbook, int fontSize) {
        if (fontSize == 0) {
            fontSize = 10;
        }
        Font font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) fontSize);
        //设置字体名字
        font.setFontName("Arial");
        //设置样式;
        CellStyle style = workbook.createCellStyle();
        //左右居中
        style.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置边框
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        return style;
    }


    /*
     * 字段样式
     */
    public static CellStyle getColumnStyle(Workbook workbook) {
        // 设置字体
        Font font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 10);
        //设置字体名字
        font.setFontName("Arial");
        //设置样式;
        CellStyle style = workbook.createCellStyle();
        //左右居中
        style.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置边框
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(true);
        return style;

    }



    /**
     * 设置表头
     * @param headTitle
     * @return
     */
    private static List<List<String>> head(String headTitle){
        List<List<String>> list = new ArrayList<>();
        List<String> firstCell = new ArrayList<>();
        firstCell.add(headTitle);
        firstCell.add("序号");
        List<String> secondCell = new ArrayList<>();
        secondCell.add(headTitle);
        secondCell.add("主管部门(区、县、开发区)");
        List<String> marchCell = new ArrayList<>();
        marchCell.add(headTitle);
        marchCell.add("单位性质/经费形式");
        List<String> forthCell = new ArrayList<>();
        forthCell.add(headTitle);
        forthCell.add("岗位类别");
        List<String> fifthCell = new ArrayList<>();
        fifthCell.add(headTitle);
        fifthCell.add("岗位简称");
        List<String> sixthCell = new ArrayList<>();
        sixthCell.add(headTitle);
        sixthCell.add("岗位代码");
        List<String> seventhCell = new ArrayList<>();
        seventhCell.add(headTitle);
        seventhCell.add("招聘人数");
        List<String> neightCell = new ArrayList<>();
        neightCell.add(headTitle);
        neightCell.add("招聘岗位所需资格条件");
        neightCell.add("专业名称");
        List<String> ninthCell = new ArrayList<>();
        ninthCell.add(headTitle);
        ninthCell.add("招聘岗位所需资格条件");
        ninthCell.add("学历");
        List<String> tenthCell = new ArrayList<>();
        tenthCell.add(headTitle);
        tenthCell.add("招聘岗位所需资格条件");
        tenthCell.add("学位");
        List<String> eleventhCell = new ArrayList<>();
        eleventhCell.add(headTitle);
        eleventhCell.add("招聘岗位所需资格条件");
        eleventhCell.add("其他条件");
        List<String> twelfthCell = new ArrayList<>();
        twelfthCell.add(headTitle);
        twelfthCell.add("笔试类别");
        List<String> thirteenthCell = new ArrayList<>();
        thirteenthCell.add(headTitle);
        thirteenthCell.add("备注");

        list.add(firstCell);
        list.add(secondCell);
        list.add(marchCell);
        list.add(forthCell);
        list.add(fifthCell);
        list.add(sixthCell);
        list.add(seventhCell);
        list.add(neightCell);
        list.add(ninthCell);
        list.add(tenthCell);
        list.add(eleventhCell);
        list.add(twelfthCell);
        list.add(thirteenthCell);
        return list;
    }
    /**
     * 导出逻辑代码
     */
    public void dataExport300w(HttpServletResponse response) {
        OutputStream outputStream = null;
        try {
            long startTime = System.currentTimeMillis();
            log.info("导出开始时间:{}", startTime);
            outputStream = response.getOutputStream();

            WriteWorkbook writeWorkbook = new WriteWorkbook();
            writeWorkbook.setOutputStream(outputStream);
            writeWorkbook.setExcelType(ExcelTypeEnum.XLSX);
            ExcelWriter writer = new ExcelWriter(writeWorkbook);
            String fileName = new String(("export-excel").getBytes(), StandardCharsets.UTF_8);

            WriteTable table = new WriteTable();
            table.setHead(head("2022年下半年西安市事业单位公开招聘工作人员岗位表"));

            //内容样式策略
            WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
            //垂直居中,水平居中
            contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            contentWriteCellStyle.setBorderLeft(BorderStyle.THIN);
            contentWriteCellStyle.setBorderTop(BorderStyle.THIN);
            contentWriteCellStyle.setBorderRight(BorderStyle.THIN);
            contentWriteCellStyle.setBorderBottom(BorderStyle.THIN);
            //设置 自动换行
            contentWriteCellStyle.setWrapped(true);
            // 字体策略
            WriteFont contentWriteFont = new WriteFont();
            // 字体大小，加粗，字体类型
            contentWriteFont.setFontName("宋体");
            contentWriteFont.setFontHeightInPoints((short) 10);
            contentWriteCellStyle.setWriteFont(contentWriteFont);
            //头部样式策略
            WriteCellStyle headWriteCellStyle = new WriteCellStyle();
            headWriteCellStyle.setWriteFont(contentWriteFont);

//            table.setCustomWriteHandlerList();
            // 记录总数：实际中需要根据查询条件（过滤数据）进行统计即可，
            // TODO 此处写入限定的条数进行自测
//            Integer totalCount = actResultLogService.count();
//            Integer totalCount = 200 * 10000;
//            Integer totalCount = 20000;
            // 每一个Sheet存放100w条数据
//            Integer sheetDataRows = ExcelConstants.PER_SHEET_ROW_COUNT;

            Integer sheetDataRows = 200000;
            // 每次写入的数据量20w
//            Integer writeDataRows = ExcelConstants.PER_WRITE_ROW_COUNT;
            Integer writeDataRows = 10000;
            // 计算需要的Sheet数量
            int sheetNum = totalCount % sheetDataRows == 0 ? (totalCount / sheetDataRows) : (totalCount / sheetDataRows + 1);
            // 计算一般情况下每一个Sheet需要写入的次数(一般情况不包含最后一个sheet,因为最后一个sheet不确定会写入多少条数据)
            int oneSheetWriteCount = totalCount > sheetDataRows ? sheetDataRows / writeDataRows : totalCount % writeDataRows > 0 ? totalCount / writeDataRows + 1 : totalCount / writeDataRows;
            // 计算最后一个sheet需要写入的次数
            int lastSheetWriteCount = totalCount % sheetDataRows == 0 ? oneSheetWriteCount : (totalCount % sheetDataRows % writeDataRows == 0 ? (totalCount / sheetDataRows / writeDataRows) : (totalCount / sheetDataRows / writeDataRows + 1));

            // 开始分批查询分次写入
            // 注意这次的循环就需要进行嵌套循环了,外层循环是Sheet数目,内层循环是写入次数
            List<List<String>> dataList = new ArrayList<>();
            for (int i = 0; i < sheetNum; i++) {
                //创建Sheet
                WriteSheet sheet = new WriteSheet();
                sheet.setSheetNo(i);
                sheet.setSheetName(fileName + i);
                // 循环写入次数: j的自增条件是当不是最后一个Sheet的时候写入次数为正常的每个Sheet写入的次数,如果是最后一个就需要使用计算的次数lastSheetWriteCount
                for (int j = 0; j < (i != sheetNum - 1 || i == 0 ? oneSheetWriteCount : lastSheetWriteCount); j++) {
                    // 集合复用,便于GC清理
                    dataList.clear();
                    // 分页查询一次20w
                    List<ActResultLogDO> resultList = actResultLogService.findByPage100w(j + 1 + oneSheetWriteCount * i, writeDataRows);
                    if (!CollectionUtils.isEmpty(resultList)) {
                        resultList.forEach(item -> {
                            dataList.add(Arrays.asList(item.getOnlineseqid(), item.getBusinessid(), item.getBecifno(), item.getIvisresult(), item.getCreatedby(), LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), item.getUpdateby(), LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), item.getRisklevel()));
                        });
                    }
                    // 写数据
                    writer.write(dataList, sheet, table);
                }
            }

            // 下载EXCEL 以下代码可以作为公共的进行封装.
            response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName).getBytes("gb2312"), StandardCharsets.ISO_8859_1) + ".xlsx");
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("utf-8");
            writer.finish();
            outputStream.flush();
            // 导出时间结束
            long endTime = System.currentTimeMillis();
            log.info("导出结束时间:{}", endTime + "ms");
            log.info("导出所用时间:{}", (endTime - startTime) / 1000 + "秒");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void dataImport300w(HttpServletResponse response) {

    }

    public static void main(String[] args) {
        Integer totalCount = 20000;
        // 每一个Sheet存放100w条数据
        Integer sheetDataRows = 200000;
        // 每次写入的数据量20w
        Integer writeDataRows = 10000;
        // 计算需要的Sheet数量
        int sheetNum = 1;
        // 计算一般情况下每一个Sheet需要写入的次数(一般情况不包含最后一个sheet,因为最后一个sheet不确定会写入多少条数据)
        int oneSheetWriteCount = sheetDataRows / writeDataRows;
        // 计算最后一个sheet需要写入的次数
        int lastSheetWriteCount = totalCount % sheetDataRows % writeDataRows == 0 ? totalCount / sheetDataRows / writeDataRows : totalCount / sheetDataRows / writeDataRows + 1;
        System.out.println(oneSheetWriteCount);
        System.out.println(lastSheetWriteCount);
    }
}
