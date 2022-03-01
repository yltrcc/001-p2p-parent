package com.csg.p2p.service.loan;

import com.csg.p2p.model.loan.LoanInfo;
import com.csg.p2p.model.vo.PaginationOV;

import java.util.List;
import java.util.Map;

public interface LoanInfoService {

    Double queryHistoryAvgRate();

    List<LoanInfo> queryLoanInfoByProductType(Map<String,Integer> params);

    PaginationOV<LoanInfo> queryLoanInfoByPage(Map<String, Integer> params);

    LoanInfo queryLoanInfoById(Integer id);
}
