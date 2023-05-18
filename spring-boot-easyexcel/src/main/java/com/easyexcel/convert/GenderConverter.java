package com.easyexcel.convert;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;

/**
 * @author chengsukai
 */
public class GenderConverter implements Converter<Integer> {

    @Override
    public Class<?> supportJavaTypeKey() {
        return Integer.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    /**
     * 读的时候会调用, 将Excel中的字段汉字转换成Java的Integer对象
     *
     * @param context
     * @return
     * @throws Exception
     */
    @Override
    public Integer convertToJavaData(ReadConverterContext<?> context) throws Exception {
        return context.getReadCellData().getStringValue().equals("男") ? 1 : 0;
    }

    /**
     * 写的时候会调用, 将Java的Integer对象转换为Excel中的字符串
     *
     * @param context
     * @return
     * @throws Exception
     */
    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<Integer> context) throws Exception {
        String gender = context.getValue() == 1 ? "男" : "女";
        return new WriteCellData<String>(gender);
    }
}
