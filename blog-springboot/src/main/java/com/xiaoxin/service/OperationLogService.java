package com.xiaoxin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoxin.dto.OperationLogDTO;
import com.xiaoxin.entity.OperationLog;
import com.xiaoxin.vo.ConditionVO;
import com.xiaoxin.vo.PageResult;


/**
 * @author xiaoxin
 * @Description: 操作日志服务
 * @version: $
 * @creat 2021 -10 -02 -12:58
 */
public interface OperationLogService extends IService<OperationLog> {
    /**
     * 查询日志列表
     *
     * @param conditionVO 条件
     * @return 日志列表
     */
    PageResult<OperationLogDTO> listOperationLogs(ConditionVO conditionVO);
}
