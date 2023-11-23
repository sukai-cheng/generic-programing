package com.java8.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Arrays.toList() 不能add
 *
 * @author chengsukai
 */
public class Main {
    public static void main(String[] args) {

        // 返回只读的List
        List<Integer> statusList = Arrays.asList(1, 2);
        System.out.println(statusList);
    }

    public List<Integer> cutOff(List<Integer> list,Integer startPos, Integer endPos) {
        if (list.size() <= 1){
            return list;
        }
        int i = startPos;
        int j = endPos;


    }

    private int cutPoint(List<Integer> list){
        int i = 0;
        // 遍历找到第一个合格点直到遇到不合格点, 记录长度

        // 找下一个不合格点
    }

    /**
     * 切割区间
     * @param list 源数据
     * @param startPos 开始位置
     * @param endPos 结束位置
     * @return arrayList which is cut by initial array.
     */
    private List<Integer> initSection(List<Integer> list, Integer startPos, Integer endPos){
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(i >= startPos && i <= endPos){
                res.add(list.get(i));
            }
        }
        return res;
    }
}
