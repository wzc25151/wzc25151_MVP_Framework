package com.sousouhardware.config;


/**
 * 服务器地址：
 * 1.http://www.sosowjc.com/
 * 2.http://121.43.111.133:47777/
 * 3.http://124.243.224.111:47777/
 */
public class ApiConfig {
    public static final String BASE_URL = "http://www.sosowjc.com/";
    public static final String BASE_URL_= "http://www.sosowjc.com";
    public static  final  String BASE_URL_2="http://121.43.111.133:47777/";
    public static  final  String BASE_URL_3="http://124.243.224.111:47777/";
//    public static final String IMG_BASE_URL = "http://121.43.111.133:51022/";
    public static final String IMG_BASE_URL= "http://www.sosowjc.com/";
    public static final String MOBILE_HOME_PRODUCTS_LIST = "common/aplHome/mobilehomeproductsList";
    public static final String PRODUCTS_DETAIL = "common/aplHome/productsDetail";//商品详情
    public static final String PRODUCT_SSKU = "common/aplHome/productssku";  //添加店铺
    public static final String PRODUCTS_SHOPSPRODUCTS = "common/aplHome/shopsProducts";  //同店推荐
    public static final String SHOP_BASICALLY = "common/aplHome/shopBasically"; //店铺基本&公司基本信息
    public static final String APLHOME_SHOP_CATEGORISE = "common//aplHome/shopCategories";//店铺中产品分类
    public static final String SHOP_PRODUCTS_LIST = "common/aplHome/shopProductsList";//店铺产品
    public static final String GET_SHOP_CODE_IMG = "common/MBUser/GetShopCodeImg";  //店铺生成二维码
    public static final String MBUSER_IF_COLLECT_GOODS = "common/MBUser/IfCollectGoods";    //商品是否收藏
    public static final String  MBUSER_DELECT_COLLECT_GOODS = "common/MBUser/DeleteCollectGoods";//商品取消收藏
    public static final String MBUSER_COLLECT_GOODS = "common/MBUser/CollectGoods";//商品收藏
    public static final String MBUSER_IF_COLLECT_SHOP = "common/MBUser/IfCollectShop";  //店铺中是否收藏
    public static final String MBUSER_COLLECT_SHOP = "common/MBUser/CollectShop";//店铺收藏
    public static final String  MBUSER_DELECT_COLLECT_SHOP = "common/MBUser/DeleteCollectShop";  //店铺取消收藏
    public static final String MORE_DISCOUNT_SALE_LIST = "common/aplHome/volumeproductsList";    //更多折扣产品
    public static final String MORE_POPULARITY_SHOP_LIST = "common/aplHome/popularityShopsList"; //更多人气店铺
    public static final String APLHOME_BRAND_LIST = "common/aplHome/brandList";//更多人气品牌
    public static final String MORE_ALL_SHOP_LIST = "common/aplHome/shopList";//店铺列表
    public static final String APLHOME_PRODUCTS_LIST  = "common/aplHome/productsList";   //全部商品
    public static final String SHOP_DETAILS = "common/aplHome/shopDetails";   //公司认证信息
    public static final String SHOP_CATEGORIES = "common/aplHome/shopCategories";  //店铺产品分类
    public static final String PRODUCTS_EVALUATE = "common/aplHome/productsEvaluate"; //产品评价
    public static final String DISCOUNT_PRODUCTSLIST = "common/aplHome/discountProductsList";  //热销单品
    public static final String MY_CART_ORDER_CAR = "common/aplHome/myCartOrderCar";//购物车列表
    public static final String UPDATE_CART_ORDER_CAR = "common/aplHome/UpdateCartOrderCar";//更新购物车产品数量
    public static final String DELETE_ORDER_CAR = "common/aplHome/DeleteOrderCar"; //删除购物车
    public static final String GOODS_FIRST_CATEGORY = BASE_URL + "common/aplHome/oneCategories";//一级分类
    public static final String GOODS_SECOND_CATEGORY = BASE_URL + "common/aplHome/twoCategories";//二，三级分类
    //
    public static final String GOODS_LIST = BASE_URL + "common/aplHome/productsList";
    public static final String CAR_BYORDER = "common/aplHome/CarByOrder";//确认订单(购物提交订单显示)
    public static final String ADD_ORDERCAR = "common/aplHome/AddOrderCar";  //加入购物车
    /**
     * 以下属于47777端口接口
     */
    public static final String LOGIN = "common/MBUser/Login"; //登录
    public static final String SHOPPING_REMOVE_COLLECTION = "common/MBUser/ShoppingRemoveCollection ";//移至收藏夹
    public static final String GET_PROVINCE = "common/MBUser/GetProvince"; //获取省份
    public static final String GET_CITY = "common/MBUser/GetCity"; //根据省份获取城市
    public static final String GET_COUNTY = "common/MBUser/GetCounty";//根据城市获取区
    public static final String ADD_MY_ADDRESS_INFO = "common/MBUser/AddMyAddressInfo";//新增收货地址
    public static final String DELETE_MY_ADDRESS = "common/MBUser/DeleteMyAddress";//新增收货地址
    public static final String PRODUCT_BYORDER = "common/aplHome/ProductByOrder";//点击立即订购跳转到确认订单
    public static final String GET_MYADDRESS = "common/MBUser/GetMyAddress"; //收货地址
    public static final String GET_MYADDRESS_INFO = "common/MBUser/getMyAddressInfo";//收货地址
    public static final String ADD_BY_ORDER = "common/aplHome/AddByOrder"; //购物车提交订单
    public static final String SUBMIT_ORDERBYPRODUCTID = "common/aplHome/SubmitOrderByProductId";   //立即订购提交订单
    public static final String ATTRIBUTEVALUELIST = BASE_URL + "common/aplHome/attriButevaluesList"; //获取产品筛选相关属性列表
    public static final String GETPAYSTR = IMG_BASE_URL + "common/APPPayment/GetPayStr";//获取支付信息接口
    public static final String HOT_KEYWORD = "http://www.sosowjc.com/common/aplHome/hotkeyword";//获取热门搜索
    /**
     * 我的模块请求地址
     */
    public static final String USER_BASE_URL = "http://124.243.224.111:47777/";
    public static final String GETMEINFO = "common/MBUser/GetMeInfo";//用户登录
    public static final String SENDCODE = "common/MBUser/SendCode"; //获取验证码
    public static final String INVALIDCODE = "common/MBUser/InvalidCode";  //验证验证码是否有效
    public static final String REGISTERUSER = "common/MBUser/RegisterUser"; //注册个人信息
    public static final String GET_MANAGEMENT = "common/MBUser/GetManagement";//协议
    public static final String GET_HELPORABOUT = "common/MBUser/GetHelpOrAbout";  //获取帮助
    public static final String GET_WULIU= "common/MBUser/GetMyExpressList";  //获取物流助手
    public static final String GET_JIAOYI= "common/MBUser/GetMyDealNewsList";//获取交易助手
    public static final String GETORDERINFO = "common/MBUser/GetOrderInfo";  //获取订单详情
    public static final String GETORDERLIST = "common/MBUser/GetOrderList";//获取订单列表
    public static final String GETSELLERORDERLIST="common/MBUser/GetSellerOrderList";   //获取卖家订单列表
    public static final String updatePic = "common/MBUser/UpdateUserPhoto";//上传图像
    public static final String updateNick = "common/MBUser/UpdateUserNickName";//更改昵称
    public static final String updatePassword = "common/MBUser/UpdatePassWord";//更改密码
    public static final String FindPassWord="common/MBUser/FindPassWord";//找回密码
    public static final String COLLECT = "common/MBUser/GetMyCollection";//获取收藏
    public static final String FCOMMENT = "common/MBUser/getMyComment";//获取我的评论
    public static final String COIN="common/MBUser/GetMyCoin";//获取我的金币
    public static final String GetMyOffLineUser="common/MBUser/GetMyOffLineUser";//获取我的线下用户
    public static final String UpdateMyAddressInfo="common/MBUser/UpdateMyAddressInfo";//编辑我的收货地址
    public static final String CancelOrderReason="common/MBUser/GetCloseReason";//获取取消订单理由表
    public static final String CancelOrder="common/MBUser/CloseOrder";//取消订单
    public static final String DeleteOrder="common/MBUser/DeleteOrder";//删除订单
    public static final String GetRefundInfo="common/MBUser/GetRefundInfo";//获取退货页面详情
    public static final String OrderItemRefund="common/MBUser/OrderItemRefund";//订单商品退款
    public static final String GetSellerInfo="common/MBUser/GetSellerInfo";//获取卖家个人中心
    public static final String getGrade="common/MBUser/GradeType";//获取等级类型
    public static final String gradePay="common/MBUser/UserPayGarder";//会员去支付
    public static final String getPayMessage="common//APPGraderPayment/GetPayStr";//会员支付

    public static final String picSpecial = "http://124.243.224.111:47777/";


}