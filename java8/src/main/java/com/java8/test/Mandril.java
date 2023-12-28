package com.java8.test;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 芯棒
 * @author chengsukai
 */
@AllArgsConstructor
@NoArgsConstructor
public class Mandril {
    String id;
    /**
     * 测试工厂
     */
    String Werks;
    /**
     * 母棒编号
     */
    String Original_Lot;
    /**
     * 批次编号twentyForthCell
     */
    String Lot;
    /**
     * 物料编号
     */
    String Matnr;

    String FAOppucy;
    /**
     * 产品类别
     */
    String fTargetManufactureType;
    String fCladType;
    /**
     * 拉丝张力
     */
    String fTension;
    String VadDevice;
    String ClottingDevice;
    String VadDateTime;
    String ISODate;
    String SinterDateTime;
    String ObjType;
    /**
     * 开始位置
     */
    String fRootBeginPosition;
    /**
     * 结束位置
     */
    String fRootEndPosition;
    /**
     * 长度
     */
    String fLength;
    String fODia;
    /**
     * 重量
     */
    String fWeight;
    String fStretchTZ;
    String fMatnrRemark;
    String fWbzj;
    /**
     * 最佳外包
     */
    String fZJWB;
    String fQualifiedLength;
    String fBXB;
    /**
     * 截止波长
     */
    String fJZBC;
    /**
     * 模场直径
     */
    String fMFD;
    String fWQD;
    /**
     * 方案ID
     */
    String fYSCSBill;
    String FromState;
    String FromRemark;
    String TemplateNo;
    String updateSystem;
    String updateDate;
    String createDate;
    /**
     * 方案ID
     */
    String TestModuleId;
    String ExeState;
    String ExeStockState;
    String fKw;
    String XBBH;
    String IsFreeze;
    String VadDateTimeTransfer;
    String SinterDateTimeTransfer;
    String HistoryFromState;
    String HistoryFromRemark;
    String F_CladDiameterAgv;
    String F_RefractivityMin;
    String F_DeltaDegree;
    String F_ValidLength;
    String F_Remark;
    String fZZZJ;
    /**
     * 直径
     */
    String fCladDia;
    /**
     * 合格率
     */
    String fQualifiedPercent;
    /**
     * 合格长度
     */
    String fDvgQualifiedLength;
    /**
     * 包芯比
     */
    String fCladCorePrecent;
    /**
     * 包芯比最小值
     */
    String fCladCorePrecentMin;
    String fKQualifiedPercent;
    String fCurrentCsaNeed;
    String fMaxODia;
    String fMinODia;
    String fAgvODia;
    String F_ESIMinus;
    String F_WidthRatio;
    String F_TopFall;
    String F_UTessionQualifiedLength;
    String F_LTessionQualifiedLength;
    String F_CoreRefractivity;
    String F_CladRefractivity;
    String F_ESIPlus;
    String F_ESI;
    String F_Delta;
    String fCutOFFPC;
    String fMFDPC;
    String F_DeltaPC;
    String fODiaPC;
    /**
     * 截止波长极差
     */
    String F_CutOFFRange;
    String fLgort;
    String F_IsCLine;
    String F_CWerks;
    /**
     * 合格长度
     */
    String fQualifiedLength2;
    String fQualifiedPercent2;
    String fCutOFF2;
    String fMFD2;
    String fBestCladDia2;
    String fNormalizedValue2;
    String fGBExecState2;
    String FromRemark2;
    String F_CloseOffParentType;
    String F_CloseOffType;
    String F_InputValue;
    String DebugId;
    String DebugCreatorUserId;
    String DebugCreatorTime;
    String F_ExecTime;
    /**
     * 工厂编号
     */
    String F_StockWerks;
    String F_StockUpdateTime;
    String F_AgeStartDateTime;
    String IsFreezeValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWerks() {
        return Werks;
    }

    public void setWerks(String werks) {
        Werks = werks;
    }

    public String getOriginal_Lot() {
        return Original_Lot;
    }

    public void setOriginal_Lot(String original_Lot) {
        Original_Lot = original_Lot;
    }

    public String getLot() {
        return Lot;
    }

    public void setLot(String lot) {
        Lot = lot;
    }

    public String getMatnr() {
        return Matnr;
    }

    public void setMatnr(String matnr) {
        Matnr = matnr;
    }

    public String getFAOppucy() {
        return FAOppucy;
    }

    public void setFAOppucy(String FAOppucy) {
        this.FAOppucy = FAOppucy;
    }

    public String getfTargetManufactureType() {
        return fTargetManufactureType;
    }

    public void setfTargetManufactureType(String fTargetManufactureType) {
        this.fTargetManufactureType = fTargetManufactureType;
    }

    public String getfCladType() {
        return fCladType;
    }

    public void setfCladType(String fCladType) {
        this.fCladType = fCladType;
    }

    public String getfTension() {
        return fTension;
    }

    public void setfTension(String fTension) {
        this.fTension = fTension;
    }

    public String getVadDevice() {
        return VadDevice;
    }

    public void setVadDevice(String vadDevice) {
        VadDevice = vadDevice;
    }

    public String getClottingDevice() {
        return ClottingDevice;
    }

    public void setClottingDevice(String clottingDevice) {
        ClottingDevice = clottingDevice;
    }

    public String getVadDateTime() {
        return VadDateTime;
    }

    public void setVadDateTime(String vadDateTime) {
        VadDateTime = vadDateTime;
    }

    public String getISODate() {
        return ISODate;
    }

    public void setISODate(String ISODate) {
        this.ISODate = ISODate;
    }

    public String getSinterDateTime() {
        return SinterDateTime;
    }

    public void setSinterDateTime(String sinterDateTime) {
        SinterDateTime = sinterDateTime;
    }

    public String getObjType() {
        return ObjType;
    }

    public void setObjType(String objType) {
        ObjType = objType;
    }

    public String getfRootBeginPosition() {
        return fRootBeginPosition;
    }

    public void setfRootBeginPosition(String fRootBeginPosition) {
        this.fRootBeginPosition = fRootBeginPosition;
    }

    public String getfRootEndPosition() {
        return fRootEndPosition;
    }

    public void setfRootEndPosition(String fRootEndPosition) {
        this.fRootEndPosition = fRootEndPosition;
    }

    public String getfLength() {
        return fLength;
    }

    public void setfLength(String fLength) {
        this.fLength = fLength;
    }

    public String getfODia() {
        return fODia;
    }

    public void setfODia(String fODia) {
        this.fODia = fODia;
    }

    public String getfWeight() {
        return fWeight;
    }

    public void setfWeight(String fWeight) {
        this.fWeight = fWeight;
    }

    public String getfStretchTZ() {
        return fStretchTZ;
    }

    public void setfStretchTZ(String fStretchTZ) {
        this.fStretchTZ = fStretchTZ;
    }

    public String getfMatnrRemark() {
        return fMatnrRemark;
    }

    public void setfMatnrRemark(String fMatnrRemark) {
        this.fMatnrRemark = fMatnrRemark;
    }

    public String getfWbzj() {
        return fWbzj;
    }

    public void setfWbzj(String fWbzj) {
        this.fWbzj = fWbzj;
    }

    public String getfZJWB() {
        return fZJWB;
    }

    public void setfZJWB(String fZJWB) {
        this.fZJWB = fZJWB;
    }

    public String getfQualifiedLength() {
        return fQualifiedLength;
    }

    public void setfQualifiedLength(String fQualifiedLength) {
        this.fQualifiedLength = fQualifiedLength;
    }

    public String getfBXB() {
        return fBXB;
    }

    public void setfBXB(String fBXB) {
        this.fBXB = fBXB;
    }

    public String getfJZBC() {
        return fJZBC;
    }

    public void setfJZBC(String fJZBC) {
        this.fJZBC = fJZBC;
    }

    public String getfMFD() {
        return fMFD;
    }

    public void setfMFD(String fMFD) {
        this.fMFD = fMFD;
    }

    public String getfWQD() {
        return fWQD;
    }

    public void setfWQD(String fWQD) {
        this.fWQD = fWQD;
    }

    public String getfYSCSBill() {
        return fYSCSBill;
    }

    public void setfYSCSBill(String fYSCSBill) {
        this.fYSCSBill = fYSCSBill;
    }

    public String getFromState() {
        return FromState;
    }

    public void setFromState(String fromState) {
        FromState = fromState;
    }

    public String getFromRemark() {
        return FromRemark;
    }

    public void setFromRemark(String fromRemark) {
        FromRemark = fromRemark;
    }

    public String getTemplateNo() {
        return TemplateNo;
    }

    public void setTemplateNo(String templateNo) {
        TemplateNo = templateNo;
    }

    public String getUpdateSystem() {
        return updateSystem;
    }

    public void setUpdateSystem(String updateSystem) {
        this.updateSystem = updateSystem;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getTestModuleId() {
        return TestModuleId;
    }

    public void setTestModuleId(String testModuleId) {
        TestModuleId = testModuleId;
    }

    public String getExeState() {
        return ExeState;
    }

    public void setExeState(String exeState) {
        ExeState = exeState;
    }

    public String getExeStockState() {
        return ExeStockState;
    }

    public void setExeStockState(String exeStockState) {
        ExeStockState = exeStockState;
    }

    public String getfKw() {
        return fKw;
    }

    public void setfKw(String fKw) {
        this.fKw = fKw;
    }

    public String getXBBH() {
        return XBBH;
    }

    public void setXBBH(String XBBH) {
        this.XBBH = XBBH;
    }

    public String getIsFreeze() {
        return IsFreeze;
    }

    public void setIsFreeze(String isFreeze) {
        IsFreeze = isFreeze;
    }

    public String getVadDateTimeTransfer() {
        return VadDateTimeTransfer;
    }

    public void setVadDateTimeTransfer(String vadDateTimeTransfer) {
        VadDateTimeTransfer = vadDateTimeTransfer;
    }

    public String getSinterDateTimeTransfer() {
        return SinterDateTimeTransfer;
    }

    public void setSinterDateTimeTransfer(String sinterDateTimeTransfer) {
        SinterDateTimeTransfer = sinterDateTimeTransfer;
    }

    public String getHistoryFromState() {
        return HistoryFromState;
    }

    public void setHistoryFromState(String historyFromState) {
        HistoryFromState = historyFromState;
    }

    public String getHistoryFromRemark() {
        return HistoryFromRemark;
    }

    public void setHistoryFromRemark(String historyFromRemark) {
        HistoryFromRemark = historyFromRemark;
    }

    public String getF_CladDiameterAgv() {
        return F_CladDiameterAgv;
    }

    public void setF_CladDiameterAgv(String f_CladDiameterAgv) {
        F_CladDiameterAgv = f_CladDiameterAgv;
    }

    public String getF_RefractivityMin() {
        return F_RefractivityMin;
    }

    public void setF_RefractivityMin(String f_RefractivityMin) {
        F_RefractivityMin = f_RefractivityMin;
    }

    public String getF_DeltaDegree() {
        return F_DeltaDegree;
    }

    public void setF_DeltaDegree(String f_DeltaDegree) {
        F_DeltaDegree = f_DeltaDegree;
    }

    public String getF_ValidLength() {
        return F_ValidLength;
    }

    public void setF_ValidLength(String f_ValidLength) {
        F_ValidLength = f_ValidLength;
    }

    public String getF_Remark() {
        return F_Remark;
    }

    public void setF_Remark(String f_Remark) {
        F_Remark = f_Remark;
    }

    public String getfZZZJ() {
        return fZZZJ;
    }

    public void setfZZZJ(String fZZZJ) {
        this.fZZZJ = fZZZJ;
    }

    public String getfCladDia() {
        return fCladDia;
    }

    public void setfCladDia(String fCladDia) {
        this.fCladDia = fCladDia;
    }

    public String getfQualifiedPercent() {
        return fQualifiedPercent;
    }

    public void setfQualifiedPercent(String fQualifiedPercent) {
        this.fQualifiedPercent = fQualifiedPercent;
    }

    public String getfDvgQualifiedLength() {
        return fDvgQualifiedLength;
    }

    public void setfDvgQualifiedLength(String fDvgQualifiedLength) {
        this.fDvgQualifiedLength = fDvgQualifiedLength;
    }

    public String getfCladCorePrecent() {
        return fCladCorePrecent;
    }

    public void setfCladCorePrecent(String fCladCorePrecent) {
        this.fCladCorePrecent = fCladCorePrecent;
    }

    public String getfCladCorePrecentMin() {
        return fCladCorePrecentMin;
    }

    public void setfCladCorePrecentMin(String fCladCorePrecentMin) {
        this.fCladCorePrecentMin = fCladCorePrecentMin;
    }

    public String getfKQualifiedPercent() {
        return fKQualifiedPercent;
    }

    public void setfKQualifiedPercent(String fKQualifiedPercent) {
        this.fKQualifiedPercent = fKQualifiedPercent;
    }

    public String getfCurrentCsaNeed() {
        return fCurrentCsaNeed;
    }

    public void setfCurrentCsaNeed(String fCurrentCsaNeed) {
        this.fCurrentCsaNeed = fCurrentCsaNeed;
    }

    public String getfMaxODia() {
        return fMaxODia;
    }

    public void setfMaxODia(String fMaxODia) {
        this.fMaxODia = fMaxODia;
    }

    public String getfMinODia() {
        return fMinODia;
    }

    public void setfMinODia(String fMinODia) {
        this.fMinODia = fMinODia;
    }

    public String getfAgvODia() {
        return fAgvODia;
    }

    public void setfAgvODia(String fAgvODia) {
        this.fAgvODia = fAgvODia;
    }

    public String getF_ESIMinus() {
        return F_ESIMinus;
    }

    public void setF_ESIMinus(String f_ESIMinus) {
        F_ESIMinus = f_ESIMinus;
    }

    public String getF_WidthRatio() {
        return F_WidthRatio;
    }

    public void setF_WidthRatio(String f_WidthRatio) {
        F_WidthRatio = f_WidthRatio;
    }

    public String getF_TopFall() {
        return F_TopFall;
    }

    public void setF_TopFall(String f_TopFall) {
        F_TopFall = f_TopFall;
    }

    public String getF_UTessionQualifiedLength() {
        return F_UTessionQualifiedLength;
    }

    public void setF_UTessionQualifiedLength(String f_UTessionQualifiedLength) {
        F_UTessionQualifiedLength = f_UTessionQualifiedLength;
    }

    public String getF_LTessionQualifiedLength() {
        return F_LTessionQualifiedLength;
    }

    public void setF_LTessionQualifiedLength(String f_LTessionQualifiedLength) {
        F_LTessionQualifiedLength = f_LTessionQualifiedLength;
    }

    public String getF_CoreRefractivity() {
        return F_CoreRefractivity;
    }

    public void setF_CoreRefractivity(String f_CoreRefractivity) {
        F_CoreRefractivity = f_CoreRefractivity;
    }

    public String getF_CladRefractivity() {
        return F_CladRefractivity;
    }

    public void setF_CladRefractivity(String f_CladRefractivity) {
        F_CladRefractivity = f_CladRefractivity;
    }

    public String getF_ESIPlus() {
        return F_ESIPlus;
    }

    public void setF_ESIPlus(String f_ESIPlus) {
        F_ESIPlus = f_ESIPlus;
    }

    public String getF_ESI() {
        return F_ESI;
    }

    public void setF_ESI(String f_ESI) {
        F_ESI = f_ESI;
    }

    public String getF_Delta() {
        return F_Delta;
    }

    public void setF_Delta(String f_Delta) {
        F_Delta = f_Delta;
    }

    public String getfCutOFFPC() {
        return fCutOFFPC;
    }

    public void setfCutOFFPC(String fCutOFFPC) {
        this.fCutOFFPC = fCutOFFPC;
    }

    public String getfMFDPC() {
        return fMFDPC;
    }

    public void setfMFDPC(String fMFDPC) {
        this.fMFDPC = fMFDPC;
    }

    public String getF_DeltaPC() {
        return F_DeltaPC;
    }

    public void setF_DeltaPC(String f_DeltaPC) {
        F_DeltaPC = f_DeltaPC;
    }

    public String getfODiaPC() {
        return fODiaPC;
    }

    public void setfODiaPC(String fODiaPC) {
        this.fODiaPC = fODiaPC;
    }

    public String getF_CutOFFRange() {
        return F_CutOFFRange;
    }

    public void setF_CutOFFRange(String f_CutOFFRange) {
        F_CutOFFRange = f_CutOFFRange;
    }

    public String getfLgort() {
        return fLgort;
    }

    public void setfLgort(String fLgort) {
        this.fLgort = fLgort;
    }

    public String getF_IsCLine() {
        return F_IsCLine;
    }

    public void setF_IsCLine(String f_IsCLine) {
        F_IsCLine = f_IsCLine;
    }

    public String getF_CWerks() {
        return F_CWerks;
    }

    public void setF_CWerks(String f_CWerks) {
        F_CWerks = f_CWerks;
    }

    public String getfQualifiedLength2() {
        return fQualifiedLength2;
    }

    public void setfQualifiedLength2(String fQualifiedLength2) {
        this.fQualifiedLength2 = fQualifiedLength2;
    }

    public String getfQualifiedPercent2() {
        return fQualifiedPercent2;
    }

    public void setfQualifiedPercent2(String fQualifiedPercent2) {
        this.fQualifiedPercent2 = fQualifiedPercent2;
    }

    public String getfCutOFF2() {
        return fCutOFF2;
    }

    public void setfCutOFF2(String fCutOFF2) {
        this.fCutOFF2 = fCutOFF2;
    }

    public String getfMFD2() {
        return fMFD2;
    }

    public void setfMFD2(String fMFD2) {
        this.fMFD2 = fMFD2;
    }

    public String getfBestCladDia2() {
        return fBestCladDia2;
    }

    public void setfBestCladDia2(String fBestCladDia2) {
        this.fBestCladDia2 = fBestCladDia2;
    }

    public String getfNormalizedValue2() {
        return fNormalizedValue2;
    }

    public void setfNormalizedValue2(String fNormalizedValue2) {
        this.fNormalizedValue2 = fNormalizedValue2;
    }

    public String getfGBExecState2() {
        return fGBExecState2;
    }

    public void setfGBExecState2(String fGBExecState2) {
        this.fGBExecState2 = fGBExecState2;
    }

    public String getFromRemark2() {
        return FromRemark2;
    }

    public void setFromRemark2(String fromRemark2) {
        FromRemark2 = fromRemark2;
    }

    public String getF_CloseOffParentType() {
        return F_CloseOffParentType;
    }

    public void setF_CloseOffParentType(String f_CloseOffParentType) {
        F_CloseOffParentType = f_CloseOffParentType;
    }

    public String getF_CloseOffType() {
        return F_CloseOffType;
    }

    public void setF_CloseOffType(String f_CloseOffType) {
        F_CloseOffType = f_CloseOffType;
    }

    public String getF_InputValue() {
        return F_InputValue;
    }

    public void setF_InputValue(String f_InputValue) {
        F_InputValue = f_InputValue;
    }

    public String getDebugId() {
        return DebugId;
    }

    public void setDebugId(String debugId) {
        DebugId = debugId;
    }

    public String getDebugCreatorUserId() {
        return DebugCreatorUserId;
    }

    public void setDebugCreatorUserId(String debugCreatorUserId) {
        DebugCreatorUserId = debugCreatorUserId;
    }

    public String getDebugCreatorTime() {
        return DebugCreatorTime;
    }

    public void setDebugCreatorTime(String debugCreatorTime) {
        DebugCreatorTime = debugCreatorTime;
    }

    public String getF_ExecTime() {
        return F_ExecTime;
    }

    public void setF_ExecTime(String f_ExecTime) {
        F_ExecTime = f_ExecTime;
    }

    public String getF_StockWerks() {
        return F_StockWerks;
    }

    public void setF_StockWerks(String f_StockWerks) {
        F_StockWerks = f_StockWerks;
    }

    public String getF_StockUpdateTime() {
        return F_StockUpdateTime;
    }

    public void setF_StockUpdateTime(String f_StockUpdateTime) {
        F_StockUpdateTime = f_StockUpdateTime;
    }

    public String getF_AgeStartDateTime() {
        return F_AgeStartDateTime;
    }

    public void setF_AgeStartDateTime(String f_AgeStartDateTime) {
        F_AgeStartDateTime = f_AgeStartDateTime;
    }

    public String getIsFreezeValue() {
        return IsFreezeValue;
    }

    public void setIsFreezeValue(String isFreezeValue) {
        IsFreezeValue = isFreezeValue;
    }
}

