package com.travelsky.b2g.b2gcommon.exception;

import java.text.MessageFormat;

/**
 * Created by zhuxiaoyu on 16/3/31.
 */
public enum ResponseCode  {

    SUCCESS(0, "success"),
    ERROR(1, "error"),
    MISSING_PARAMETERS_ERROR(15501, "Missing parameters error, parameter : {0}"),
    PARAMETER_FORMAT_ERROR(15502, "parameters format error, parameter : {0}"),
    SIGN_ERROR(15503, "sign error"),
    TIMESTAMP_ERROR(15504, "timestamp error"),
    ORDER_EXISTS_ERROR(15602, "order id exists error"),
    NOT_ENOUGH_ERROR(15701,"not enough {0}"),
    // zxy添加登入提示信息
    VERIFY_CODE_ERROR(15801,"验证码错误"),



    LOGIN_ERROR(16000,"用户名或密码错误。"),
    TOKEN_TIMEOUT_ERROR(16001,"登录超时或非法登录。"),
    UNAUTHORIZED(16003,"未授权。"),





    SUB_PORJECT_ERROR(16002,"当前节点下存在相同的名称."),


    //用户管理模块
    EMPLOYEEID_ISEMPTY(16500,"登陆名为空"),
    PWD_ISEMPTY(16501,"密码为空"),
    NAME_ISEMPTY(16502,"真实姓名为空"),
    ISADMIN_ISEMPTY(16503,"权限为空"),
    ISADMIN_ERROR(16504,"权限值错误"),
    STATE_ISEMPTY(16505,"状态为空"),
    STATE_ERROR(16506,"状态值错误"),
    AREA_ISEMPTY(16507,"地区为空"),
    AREA_ERROR(16508,"地区不存在"),
    SEX_ERROR(16509,"性别的值错误"),
    USER_EXIST(16510,"用户已存在"),
    NO_PROPERTY(16511,"没有要修改的值"),
    USER_NOEXIST(16510,"用户不存在"),
    //PARAMETER_FORMAT_ERROR(16512,"参数格式不正确"),

    //用户组管理模块
    PARENTID_ISEMPTY(16600,"父组id不存在"),
    TYPE_ISEMPTY(16601,"类型不能为空"),
    USERGROUP_EXIST(16602,"用户组已存在"),
    USERGROUP_NOEXIST(16603,"用户组不存在"),
    USERGROUP_ISPARENT(16604,"该组为父组"),
    USERID_ISEMPTY(16605,"用户id为空"),
    GROUPID_ISEMPTY(16606,"用户组id为空"),
    USER_IN_GROUP(16607,"该组已存在该用户"),
    USER_NOIN_GROUP(16608,"该组不存在该用户"),
    PARENTGROUP_STOP(16608,"父组已停用"),


    //role
    ROLE_PARENT_NULL(16701,"父节点ID不能为空."),
    ROLE_PARENT_ERROR(16702,"父节点ID无法匹配到角色."),
    ROLE_NAME_ERROR(16703,"父节点下存在相同的名称."),
    ROLE_DELETECHECK_ERROR(16704,"当前节点下存在有效子节点，不能删除."),
    ROLE_REGAINCHECK_ERROR(16705,"当前节点的父节点为删除状态，不能恢复当前节点"),

    //zb 地域提示
    AREA_NAME_REPETITION(163001,"父节点下存在相同名称"),
    AREA_NAME_NULL(163002,"地域名称不能为空"),
    AREA_LEVEL_NULL(163003,"地域级别不能为空"),
    IS_PARENT(163004,"该节点为父节点，不能删除，请先处理其名下子节点"),
    HAVE_USERS(1630013,"该节点下有关联用户,不能删除"),
    //zb 用户扩展提示 
    SYSTEM_NAME_NULL(163005,"系统资源名不能为空"),
    SYSTEM_HOST_NULL(163006,"host不能为空"),
    SYSTEM_PORT_NULL(163007,"端口名不能为空"),
    SYSTEM_CONTENTPATH_NULL(163008,"上下文不能为空"),
    //zb 资源
    NAME_NULL(163009,"名称不能为空"),
    RESOURCE_SYSTEM_NULL(163010,"资源名不能为空"),
    RESOURCE_URL_NULL(163011,"url不能为空"),
    RESOURCE_RESTYPE_NULL(163012,"类型不能为空"),
    RESOURCE_PARENT_ILLEGAL(163014,"未找到该父节点"),
    RESOURCE_SYSTEM_ILLEGAL(163015,"所选系统不存在"),
    RESOURCE_TYPE_ILLEGAL(163016,"所选资源类型不存在"),
    IS_USED(163017,"资源类型被引用，不能删除"),
    //商品中心--库存 赵璧
    TYPE_ERROR(163018,"查询库存时请选择查询方式，查询方式：1：按类目2：商品编码3：原厂型号"),
    NUM_ERROR(163019,"调出数量大于当前库存"),
    ALLOT_STATE_ERROR(163020,"待出库的调拨单才可以取消，请核对调拨状态"),
    STOCK_ERROR(163021,"错误：库存表中该商品在该仓库可售状态下有多条记录，请核对库存"),
    TRANSFER_ERROR(163022,"估算价或调拨数量出错"),
    MISTAKE_STATE_ERROR(163023,"只有待审核状态下的差错单才可以被审核，请核对差错单状态"),
    //订单中心
    ORDER_STATE_NOT1OR2(200000,"订单状态不是不处理，未支付或待发货"),
    GROUPID_IS_NULL(200002,"档口id为空"),
    USERID_IS_NULL(200004,"采购员id为空"),
    GOODSID_NULL(163009,"商品编码不能为空"),
    ORDERID_NULL(163009,"未传入订单id"),
    ORDER_ENQUIRY_STATE(163009,"订单的询价状态为询价中，不能直接发货"),
    ORDER_STATE(163009,"订单状态为发货中或已发货，不能直接发货"),
    EXCESS(163012,"采购员采购额度不足"),
    REASON_NOT_NULL(163013,"拒绝原因不能为空"),
    REPEAT_DATA(163020,"存在重复的数据"),
    
    ORDER_UPLOAD_FILE_NOTFOUND(17000,"上传文件为空"),
    ORDER_UPLOAD_FILE_TYPEERROR(17001,"上传文件格式错误"),
    INVOICE_DOWNLOAD_ERROR(17002,"导出失败"),

    ORDERLIST_COMMON_ERROR(17003,"查询订单失败"),
    NO_DATA(163010,"没有想要处理的数据"),
    DATA_INCLUDE_DISPOSE(163011,"数据中包含已处理的"),
    //订单中心扫码异常165000 zb
    IMEI_CODE_REPEAT(165000,"imei码重复"),
    IMEI_CODE_NOT_FIND(165001,"未找到指定的imei码"),
    MID_ERROR(165002,"批次号不符"),
    IMEI_CODE_STATE_ERROR(165003,"该商品目前的状态下不能更改IMEI"),
    
    
    
    

    RPC_REMOTE_ERROR(163020,"远程方法错误"),
    MQ_ERROR(163021,"消息队列错误"),


    GOODS_TYPE_HAVE_CHILDREN(164000,"此商品类型有叶子节点，不可删除"),
    
    
    //价格管理
    PRICE_NOT_NULL(211000,"价格不能为空"),
    SSID_NOT_EXIST(211001,"SSID不存在"),
    NAME_NOT_NULL(211002,"描述不能为空"),
    /**** 商品中心- 价格体系返回码begin ****/
    
    GOODS_AUDITSTATE_NULL(300101, "审核状态不能为空"),
    GOODS_PRICINGSTRUTER_NAME_NULL(300102, "价格体系名称不能为空"),
    GOODS_PRICINGSTRUTER_GOODS_NULL(300103, "商品信息不能为空"),
    GOODS_PRICINGSTRUTER_GOODS_SID_NULL(300104, "商品id不能为空"),
    GOODS_PRICINGSTRUTER_GOODS_PRICE_NULL(300105, "商品活动价格不能为空"),
    GOODS_PRICINGSTRUTER_GOODS_DESC_ERROR(300106, "商品描述最多输入100个文字"),
    GOODS_PRICINGSTRUTER_DELETE_ERROR(300107, "当前数据处于流程审核中，不能编辑或删除"),
    GOODS_PRICINGSTRUTER_NAME_REPETITION(300108, "价格体系名称已存在，请重新填写"),
    GOODS_PRICINGSTRUTER_DELETE_COUNT_ERROR(30019, "此价格体系已被门店使用，不能删除"),
    GOODS_PRICINGSTRUTER_GOODS_SID_ERROR(300110, "SID重复"),
    GOODS_PRICINGSTRUTER_GOODS_PRICE_ERROR(300111, "活动价格保留小数点后两位"),
    GOODS_PRICINGSTRUTER_NAME_ERROR(300112, "价格体系名称最多输入100个文字"),
    
    GOODS_PRICINGSTRUTER_AUDIT_ERROR(300201, "当前数据已审核，请选择其他数据"),
    
    /**** 商品中心- 价格体系返回码end ****/

    /**** 门店app远程接口- begin ****/
    APPSERVER_IMEICODE_OR_BARCODE_ERROR(310001, "库存数据异常"),
    APPSERVER_GOODS_STATE_ERROR(310002,"该商品目前的状态下不能调出"),
    APPSERVER_N0_GOODS(310003,"未找到该商品对应的商品编码"),
    APPSERVER_N0T_FIND_ALLOT(310004,"该调拨单中未找到该商品"),
    APPSERVER_TOO_MANY_ALLOT(310005,"调出商品过多"),
    APPSERVER_GOODS_STATE_EORROR(310006,"此商品不允许调拨"),
    APPSERVER_SUBMIT_EORROR(310007,"只有发起人才可以提交"),
    APPSERVER_ALLOT_STATE_EORROR(310008,"未找到出库中的数据，请核对调拨单状态"),
    /**** 门店app- end ****/



    /**** 商品中心- 门店价格体系返回码begin ****/
    
	GOODS_STORE_NAME_REPETITION(400101, "所选门店已存在，请重新选择"),
    GOODS_STORE_CODE_NULL(400102, "门店编码不能为空"),
    GOODS_STORE_NAME_NULL(400103, "门店名称不能为空"),
    GOODS_STORE_ADDR_NULL(400104, "门店地址不能为空"),
    GOODS_STORE_AREAID_NULL(400105, "门店城市不能为空"),
    GOODS_STORE_PERSON_NULL(400106, "门店负责人不能为空"),
    
    GOODS_STORE_STRUCT_NAME_REPETITION(400201, "所选门店价格体系已存在，请重新选择"),
    GOODS_STORE_STRUCT_ERPSTOREID_NULL(400202, "请选择数据条目后进行价格体系的添加或修改"),
    GOODS_STORE_STRUCT_ERPPRICESTRUCTID_NULL(400203, "价格体系不能为空"),
    GOODS_STORE_STRUCT_DESC_ERROR(400204, "描述最多输入100个文字"),
    GOODS_STORE_STRUCT_DEFAULTPRICE_ERROR(400205, "价格体系为指导价，不能修改或删除"),
    GOODS_STORE_STRUCT_DATE_ERROR(400206, "开始或结束时间格式错误"),
    GOODS_STORE_STRUCT_SE_DATE_ERROR(400207, "开始时间不能大于结束时间"),
    GOODS_STORE_STRUCT_GOUP_ERROR(400208, "上浮请输入数字"),
    GOODS_STORE_STRUCT_CAMEUP_ERROR(400209, "下浮请输入数字"),
    
    GOODS_STORE_GROUPNAME_REPETITION(400301, "群组名称已存在，请重新填写"),
    GOODS_STORE_GROUPSTOREID_REPETITION(400302, "请勾选当前群组分配的门店"),
    GOODS_STORE_GROUPNAME_NULL(400303, "群组名称不能为空"),
    GOODS_STORE_GROUPNAME_ERROR(400304, "群组名称最多输入100个文字"),
    GOODS_STORE_ID_ERROR(400305, "请输入正确的门店id"),
    
    /**** 商品中心- 门店价格体系返回码end ****/
    

    EMAIL_TITLE_ERRPR(500001,"邮件标题错误"),
    EMAIL_CONTENT_ERRPR(500002,"邮件正文错误"),
    EMAIL_PERSON_ERRPR(500003,"邮件发送人错误"),

    UNKNOWN_ERROR(15999, "unknown error") ;
    
    
    

    private int err;
    private String message;
    ResponseCode(int err, String message){
        this.err = err;
        this.message = message;
    }
    public int getErr() {
        return err;
    }
    public void setErr(int err) {
        this.err = err;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage(Object...parameterName) {
        return MessageFormat.format(this.getMessage(), parameterName);
    }

}
