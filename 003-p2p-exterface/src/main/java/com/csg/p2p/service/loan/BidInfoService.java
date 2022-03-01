package com.csg.p2p.service.loan;

import com.csg.p2p.model.loan.BidInfo;

import java.util.List;

public interface BidInfoService {
    Double queryAllBidMoney();

    List<BidInfo> queryBidInfoByLoanId(Integer id);
}
