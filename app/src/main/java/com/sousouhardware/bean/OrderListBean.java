package com.sousouhardware.bean;

import java.util.List;

/**
 * Created by wangxiangbo on 2016/7/20.
 */
public class OrderListBean {

    /**
     * success : true
     * status : 0
     * msg : [{"OrderId":2016071906503160,"ShopName":"南通南拓电气设备有限公司","GoodsSum":1,"Freight":0,"ProductTotalAmount":188.81,"OrderStatus":4,"ProcessStatus":4,"OrderItems":[{"ItemsId":756,"GoodsImg":"/Storage/Shop/228/Products/24291/1_100.png","GoodsName":"正泰 电线电缆 家装铜芯硬线 BV2.5平国标铜100米 红色","GoodsPrice":188.81,"GoodsColor":"","GoodsSize":"","GoodsQuantity":1,"GoodsReturn":0}]},{"OrderId":2016071926544322,"ShopName":"南通南拓电气设备有限公司","GoodsSum":1,"Freight":0,"ProductTotalAmount":54.95,"OrderStatus":4,"ProcessStatus":4,"OrderItems":[{"ItemsId":755,"GoodsImg":"/Storage/Shop/228/Products/24232/1_100.png","GoodsName":"正泰电器 漏电保护开关 NBE7LE 2P63A 二极漏电断路器C63","GoodsPrice":54.95,"GoodsColor":"","GoodsSize":"","GoodsQuantity":1,"GoodsReturn":0}]},{"OrderId":2016071974512335,"ShopName":"南通南拓电气设备有限公司","GoodsSum":1,"Freight":0,"ProductTotalAmount":46.95,"OrderStatus":4,"ProcessStatus":4,"OrderItems":[{"ItemsId":754,"GoodsImg":"/Storage/Shop/228/Products/24257/1_100.png","GoodsName":"正泰漏电断路器C32 两项家用带触电保护空气开关NBE7LE 2P 32A","GoodsPrice":46.95,"GoodsColor":"","GoodsSize":"","GoodsQuantity":1,"GoodsReturn":0}]},{"OrderId":2016071972953425,"ShopName":"南通南拓电气设备有限公司","GoodsSum":1,"Freight":0,"ProductTotalAmount":42.96,"OrderStatus":4,"ProcessStatus":4,"OrderItems":[{"ItemsId":753,"GoodsImg":"/Storage/Shop/228/Products/24277/1_100.png","GoodsName":"正泰漏电断路器C20 家用带触电保护空气开关断路器NBE7LE 2P 20A","GoodsPrice":42.96,"GoodsColor":"","GoodsSize":"","GoodsQuantity":1,"GoodsReturn":0}]},{"OrderId":2016071912921376,"ShopName":"南通南拓电气设备有限公司","GoodsSum":1,"Freight":0,"ProductTotalAmount":188.81,"OrderStatus":4,"ProcessStatus":4,"OrderItems":[{"ItemsId":752,"GoodsImg":"/Storage/Shop/228/Products/24345/1_100.png","GoodsName":"正泰 电线电缆 家装铜芯硬线 BV2.5平国标铜100米 绿色","GoodsPrice":188.81,"GoodsColor":"","GoodsSize":"","GoodsQuantity":1,"GoodsReturn":0}]},{"OrderId":2016071937562215,"ShopName":"南通南拓电气设备有限公司","GoodsSum":1,"Freight":0,"ProductTotalAmount":175.82,"OrderStatus":4,"ProcessStatus":4,"OrderItems":[{"ItemsId":751,"GoodsImg":"/Storage/Shop/228/Products/24356/1_100.png","GoodsName":"正泰电线电缆国标多股软电线 国标铜芯线 BVR 1.5平方 100米 红色 100米","GoodsPrice":175.82,"GoodsColor":"","GoodsSize":"","GoodsQuantity":1,"GoodsReturn":0}]},{"OrderId":2016071918598120,"ShopName":"南通南拓电气设备有限公司","GoodsSum":1,"Freight":0,"ProductTotalAmount":7.98,"OrderStatus":4,"ProcessStatus":4,"OrderItems":[{"ItemsId":750,"GoodsImg":"/Storage/Shop/228/Products/23915/1_100.png","GoodsName":"正泰电工墙壁开关插座NEW7D 大功率三级插座 空调插座 16A三孔插","GoodsPrice":7.98,"GoodsColor":"","GoodsSize":"","GoodsQuantity":1,"GoodsReturn":0}]},{"OrderId":2016071962762972,"ShopName":"南通南拓电气设备有限公司","GoodsSum":1,"Freight":0,"ProductTotalAmount":26.15,"OrderStatus":4,"ProcessStatus":4,"OrderItems":[{"ItemsId":749,"GoodsImg":"/Storage/Shop/228/Products/23937/1_100.png","GoodsName":"正泰墙壁开关插座面板86型 NEW7D 电话电脑插座面板 网线电话插座","GoodsPrice":26.15,"GoodsColor":"","GoodsSize":"","GoodsQuantity":1,"GoodsReturn":0}]},{"OrderId":2016071977782906,"ShopName":"南通南拓电气设备有限公司","GoodsSum":1,"Freight":0,"ProductTotalAmount":9.8,"OrderStatus":4,"ProcessStatus":4,"OrderItems":[{"ItemsId":748,"GoodsImg":"/Storage/Shop/228/Products/24194/1_100.png","GoodsName":"正泰 钢架墙壁开关插座 NEW7L香槟金色 墙面插座 五孔插座","GoodsPrice":9.8,"GoodsColor":"","GoodsSize":"","GoodsQuantity":1,"GoodsReturn":0}]},{"OrderId":2016071866691038,"ShopName":"常熟市虞山镇三兴五金标准件商行","GoodsSum":1,"Freight":0,"ProductTotalAmount":0.01,"OrderStatus":4,"ProcessStatus":4,"OrderItems":[{"ItemsId":721,"GoodsImg":"/Storage/Shop/344/Products/4258/1_100.png","GoodsName":"镍圆头带垫自攻螺丝钉","GoodsPrice":0.01,"GoodsColor":"","GoodsSize":"","GoodsQuantity":1,"GoodsReturn":0}]}]
     */

    private boolean success;
    private int status;
    /**
     * OrderId : 2016071906503160
     * ShopName : 南通南拓电气设备有限公司
     * GoodsSum : 1
     * Freight : 0.0
     * ProductTotalAmount : 188.81
     * OrderStatus : 4
     * ProcessStatus : 4
     * OrderItems : [{"ItemsId":756,"GoodsImg":"/Storage/Shop/228/Products/24291/1_100.png","GoodsName":"正泰 电线电缆 家装铜芯硬线 BV2.5平国标铜100米 红色","GoodsPrice":188.81,"GoodsColor":"","GoodsSize":"","GoodsQuantity":1,"GoodsReturn":0}]
     */

    private List<MsgBean> msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<MsgBean> getMsg() {
        return msg;
    }

    public void setMsg(List<MsgBean> msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        private long OrderId;
        private String ShopName;
        private int GoodsSum;
        private double Freight;
        private double ProductTotalAmount;
        private int OrderStatus;
        private int ProcessStatus;
        /**
         * ItemsId : 756
         * GoodsImg : /Storage/Shop/228/Products/24291/1_100.png
         * GoodsName : 正泰 电线电缆 家装铜芯硬线 BV2.5平国标铜100米 红色
         * GoodsPrice : 188.81
         * GoodsColor :
         * GoodsSize :
         * GoodsQuantity : 1
         * GoodsReturn : 0
         */

        private List<OrderItemsBean> OrderItems;

        public long getOrderId() {
            return OrderId;
        }

        public void setOrderId(long OrderId) {
            this.OrderId = OrderId;
        }

        public String getShopName() {
            return ShopName;
        }

        public void setShopName(String ShopName) {
            this.ShopName = ShopName;
        }

        public int getGoodsSum() {
            return GoodsSum;
        }

        public void setGoodsSum(int GoodsSum) {
            this.GoodsSum = GoodsSum;
        }

        public double getFreight() {
            return Freight;
        }

        public void setFreight(double Freight) {
            this.Freight = Freight;
        }

        public double getProductTotalAmount() {
            return ProductTotalAmount;
        }

        public void setProductTotalAmount(double ProductTotalAmount) {
            this.ProductTotalAmount = ProductTotalAmount;
        }

        public int getOrderStatus() {
            return OrderStatus;
        }

        public void setOrderStatus(int OrderStatus) {
            this.OrderStatus = OrderStatus;
        }

        public int getProcessStatus() {
            return ProcessStatus;
        }

        public void setProcessStatus(int ProcessStatus) {
            this.ProcessStatus = ProcessStatus;
        }

        public List<OrderItemsBean> getOrderItems() {
            return OrderItems;
        }

        public void setOrderItems(List<OrderItemsBean> OrderItems) {
            this.OrderItems = OrderItems;
        }

        public static class OrderItemsBean {
            private int ItemsId;
            private String GoodsImg;
            private String GoodsName;
            private double GoodsPrice;
            private String GoodsColor;
            private String GoodsSize;
            private int GoodsQuantity;
            private int GoodsReturn;

            public int getItemsId() {
                return ItemsId;
            }

            public void setItemsId(int ItemsId) {
                this.ItemsId = ItemsId;
            }

            public String getGoodsImg() {
                return GoodsImg;
            }

            public void setGoodsImg(String GoodsImg) {
                this.GoodsImg = GoodsImg;
            }

            public String getGoodsName() {
                return GoodsName;
            }

            public void setGoodsName(String GoodsName) {
                this.GoodsName = GoodsName;
            }

            public double getGoodsPrice() {
                return GoodsPrice;
            }

            public void setGoodsPrice(double GoodsPrice) {
                this.GoodsPrice = GoodsPrice;
            }

            public String getGoodsColor() {
                return GoodsColor;
            }

            public void setGoodsColor(String GoodsColor) {
                this.GoodsColor = GoodsColor;
            }

            public String getGoodsSize() {
                return GoodsSize;
            }

            public void setGoodsSize(String GoodsSize) {
                this.GoodsSize = GoodsSize;
            }

            public int getGoodsQuantity() {
                return GoodsQuantity;
            }

            public void setGoodsQuantity(int GoodsQuantity) {
                this.GoodsQuantity = GoodsQuantity;
            }

            public int getGoodsReturn() {
                return GoodsReturn;
            }

            public void setGoodsReturn(int GoodsReturn) {
                this.GoodsReturn = GoodsReturn;
            }
        }
    }
}
