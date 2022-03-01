package com.csg.p2p.mapper.loan;

import com.csg.p2p.model.loan.BidInfo;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BidInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(BidInfo record);

    int insertSelective(BidInfo record);

    BidInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BidInfo record);

    int updateByPrimaryKey(BidInfo record);

    Double selectAllBidMoney();

    List<BidInfo> selectBidInfoByLoanId(Integer id);
}