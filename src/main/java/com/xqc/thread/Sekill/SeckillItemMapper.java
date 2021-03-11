package com.xqc.thread.Sekill;

public interface SeckillItemMapper {
    SeckillItem selectByPrimaryKey(String seckillItemId);

    void updateByPrimaryKey(SeckillItem seckillItem);
}
