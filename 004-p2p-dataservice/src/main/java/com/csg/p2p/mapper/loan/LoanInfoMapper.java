package com.csg.p2p.mapper.loan;

import com.csg.p2p.model.loan.LoanInfo;

import java.util.List;
import java.util.Map;

public interface LoanInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoanInfo record);

    int insertSelective(LoanInfo record);

    LoanInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoanInfo record);

    int updateByPrimaryKey(LoanInfo record);

    Double selectHistoryAvgRate();

    List<LoanInfo> selectLoanInfoByProductType(Map<String, Integer> params);

    int loanInfoCountByType(Map<String, Integer> params);
}