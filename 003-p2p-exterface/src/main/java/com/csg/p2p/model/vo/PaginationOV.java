package com.csg.p2p.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName:PaginationOV
 * Package:com.csg.p2p.model.vo
 * Description:
 *
 * @date: 2021/12/30 15:54
 * @author: csg
 */
public class PaginationOV<T> implements Serializable {
    // 数据
    private List<T> datas;

    // 总记录数
    private Integer totaSize;

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public Integer getTotaSize() {
        return totaSize;
    }

    public void setTotaSize(Integer totaSize) {
        this.totaSize = totaSize;
    }
}
