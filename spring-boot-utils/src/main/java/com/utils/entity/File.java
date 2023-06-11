package com.utils.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;

/**
 * @author 白也
 * @date 2022/12/22 4:45 下午
 * @title
 */
@Data
@AllArgsConstructor
@EntityScan
@NoArgsConstructor
public class File implements Serializable {
    /**
     * 文件名称
     */
    private String FileName;
    /**
     * 返回直链
     *
     */
    private String url;

}
