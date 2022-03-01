package com.csg.p2p.service.impl.loan;

import com.alibaba.dubbo.config.annotation.Service;
import com.csg.p2p.cons.Constants;
import com.csg.p2p.mapper.loan.LoanInfoMapper;
import com.csg.p2p.model.loan.LoanInfo;
import com.csg.p2p.model.vo.PaginationOV;
import com.csg.p2p.service.loan.LoanInfoService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@Service(interfaceClass = LoanInfoService.class, version = "1.0.0", timeout = 15000)
public class LoanInfoServiceImpl implements LoanInfoService {

    @Autowired
    private LoanInfoMapper loanInfoMapper;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public Double queryHistoryAvgRate() {
        // 重新设置redis数据库key的序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        Double historyAvgRate = (Double) redisTemplate.opsForValue().get(Constants.HISTORY_AVG_RATE);
        /*if (ObjectUtils.allNull(historyAvgRate)){
            synchronized (this){
                historyAvgRate = (Double) redisTemplate.opsForValue().get(Constants.HISTORY_AVG_RATE);
                if (ObjectUtils.allNull(historyAvgRate)){
                    System.out.println("====mysql====");
                    historyAvgRate = loanInfoMapper.selectHistoryAvgRate();
                    redisTemplate.opsForValue().set(Constants.HISTORY_AVG_RATE,historyAvgRate, 7, TimeUnit.DAYS);

                }else {
                    System.out.println("====redis====");
                }
            }
        } else{
            System.out.println("====redis====");
        }*/
        return historyAvgRate;
    }

    @Override
    public List<LoanInfo> queryLoanInfoByProductType(Map<String,Integer> params) {
        return loanInfoMapper.selectLoanInfoByProductType(params);
    }

    @Override
    public PaginationOV<LoanInfo> queryLoanInfoByPage(Map<String, Integer> params) {
        PaginationOV<LoanInfo> paginationOV = new PaginationOV();
        paginationOV.setDatas(loanInfoMapper.selectLoanInfoByProductType(params));
        paginationOV.setTotaSize(loanInfoMapper.loanInfoCountByType(params));
        return paginationOV;
    }

    @Override
    public LoanInfo queryLoanInfoById(Integer id) {
        return loanInfoMapper.selectByPrimaryKey(id);
    }


}
