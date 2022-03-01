package com.csg.p2p.service.impl.loan;

import com.alibaba.dubbo.config.annotation.Service;
import com.csg.p2p.cons.Constants;
import com.csg.p2p.mapper.loan.BidInfoMapper;
import com.csg.p2p.model.loan.BidInfo;
import com.csg.p2p.service.loan.BidInfoService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@Service(interfaceClass = BidInfoService.class, version = "1.0.0",  timeout = 15000)
public class BidInfoServiceImpl implements BidInfoService {

    @Autowired
    private BidInfoMapper bidInfoMapper;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public Double queryAllBidMoney() {
        Double allBidMoney = (Double) redisTemplate.opsForValue().get(Constants.ALL_BID_MONEY);
       /* if (ObjectUtils.allNull(allBidMoney)){
            synchronized (this){
                allBidMoney = (Double) redisTemplate.opsForValue().get(Constants.ALL_BID_MONEY);
                if (ObjectUtils.allNull(allBidMoney)){
                    allBidMoney = bidInfoMapper.selectAllBidMoney();
                    redisTemplate.opsForValue().set(Constants.ALL_BID_MONEY,allBidMoney, 7, TimeUnit.DAYS);
                }
            }
        }*/
        return allBidMoney;
    }

    @Override
    public List<BidInfo> queryBidInfoByLoanId(Integer id) {
        return bidInfoMapper.selectBidInfoByLoanId(id);

    }
}
