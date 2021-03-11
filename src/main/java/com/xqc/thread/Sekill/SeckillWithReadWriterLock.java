package com.xqc.thread.Sekill;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SeckillWithReadWriterLock {
    @Autowired
    private SeckillItemMapper seckillItemMapper;
    @Autowired
    private SeckillRecordMapper seckillRecordMapper;

    public CommonResult seckill(String seckillItemId, String userPhone) {

        CommonResult result = new CommonResult();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        try {
            /* 1、查询秒杀商品剩余数量*/
            //加读锁
            lock.readLock().lock();
            SeckillItem seckillItem = seckillItemMapper.selectByPrimaryKey(seckillItemId);
            int itemAccount = seckillItem != null ? seckillItem.getNumber() : 0;
            if (itemAccount < 1) {
                result.setStatus(false);
                result.setMessage("商品【" + seckillItem.getName() + "】已经被抢光啦~");
                return result;
            }
            lock.readLock().unlock();

            /* 2、更新秒杀商品剩余数量*/
            lock.writeLock().lock();
            seckillItem.setNumber(seckillItem.getNumber() - 1);
            seckillItemMapper.updateByPrimaryKey(seckillItem);

            /* 3、添加秒杀记录*/
            SeckillRecord seckillRecord = new SeckillRecord();
            seckillRecord.setSeckillItemId(seckillItemId);
            seckillRecord.setState(0);
            seckillRecord.setUserPhone(userPhone);
            seckillRecord.setCreateTime(new Date());
            seckillRecordMapper.insert(seckillRecord);
            lock.writeLock().unlock();

            result.setData(seckillItem);
            result.setMessage("恭喜您抢到商品【" + seckillItem.getName() + "】");
        } catch (Exception e) {
            lock.readLock().unlock();
            lock.writeLock().unlock();
            e.printStackTrace();
            result.setStatus(false);
            result.setMessage("出了点小问题，我们的攻城狮正在奋力抢修~");
            return result;
        }
        return result;
    }
}
