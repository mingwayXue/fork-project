package com.xue.erp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xue.erp.constants.ExceptionConstants;
import com.xue.erp.datasource.entities.SerialNumberEx;
import com.xue.erp.exception.BusinessParamCheckingException;
import com.xue.erp.service.serialNumber.SerialNumberService;
import com.xue.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Description
 *
 * @Author: cjl
 * @Date: 2019/1/22 10:29
 */
@RestController
public class SerialNumberController {
    private Logger logger = LoggerFactory.getLogger(SerialNumberController.class);

    @Resource
    private SerialNumberService serialNumberService;
    /**
     * create by: cjl
     * description:
     *  检查序列号是否存在
     * create time: 2019/1/22 11:02
     * @Param: id
     * @Param: materialName
     * @Param: serialNumber
     * @Param: request
     * @return java.lang.Object
     */
    @PostMapping("/serialNumber/checkIsExist")
    @ResponseBody
    public Object checkIsExist(@RequestParam("id") Long id, @RequestParam("materialName") String materialName,
                               @RequestParam("serialNumber") String serialNumber, HttpServletRequest request) throws Exception{
        JSONObject result = ExceptionConstants.standardSuccess();
        if(StringUtil.isEmpty(serialNumber)){
            throw new BusinessParamCheckingException(ExceptionConstants.SERIAL_NUMBERE_NOT_BE_EMPTY_CODE,
                    ExceptionConstants.SERIAL_NUMBERE_NOT_BE_EMPTY_MSG);
        }
        serialNumberService.checkIsExist(id, materialName, serialNumber);
        return result;
    }
    /**
     * create by: cjl
     * description:
     *  新增序列号信息
     * create time: 2019/1/22 17:10
     * @Param: beanJson
     * @Param: request
     * @return java.lang.Object
     */
    @PostMapping("/serialNumber/addSerialNumber")
    @ResponseBody
    public Object addSerialNumber(@RequestParam("info") String beanJson){
        JSONObject result = ExceptionConstants.standardSuccess();
        SerialNumberEx sne= JSON.parseObject(beanJson, SerialNumberEx.class);
        serialNumberService.addSerialNumber(sne);
        return result;

    }
    /**
     * create by: cjl
     * description:
     *  修改序列号信息
     * create time: 2019/1/23 13:56
     * @Param: beanJson
     * @return java.lang.Object
     */
    @PostMapping("/serialNumber/updateSerialNumber")
    @ResponseBody
    public Object updateSerialNumber(@RequestParam("info") String beanJson){

        JSONObject result = ExceptionConstants.standardSuccess();
        SerialNumberEx sne= JSON.parseObject(beanJson, SerialNumberEx.class);
        serialNumberService.updateSerialNumber(sne);
        return result;

    }
    /**
     * create by: cjl
     * description:
     *批量添加序列号
     * create time: 2019/1/29 15:11
     * @Param: materialName
     * @Param: serialNumberPrefix
     * @Param: batAddTotal
     * @Param: remark
     * @return java.lang.Object
     */
    @PostMapping("/serialNumber/batAddSerialNumber")
    @ResponseBody
    public Object batAddSerialNumber(@RequestParam("materialName") String materialName, @RequestParam("serialNumberPrefix") String serialNumberPrefix,
                                     @RequestParam("batAddTotal") Integer batAddTotal,@RequestParam("remark") String remark){

        JSONObject result = ExceptionConstants.standardSuccess();
        serialNumberService.batAddSerialNumber(materialName,serialNumberPrefix,batAddTotal,remark);
        return result;

    }















}
