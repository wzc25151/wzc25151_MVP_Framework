package com.sousouhardware.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/4/7.
 */
public class HomeRefreshBean {
    private int flag;
    /**
     * 折扣特卖
     */
    private MessageBean message;
    private ProTypeBean ProType;
    private ShopsBean shops;
    private List<BrandBean> brand;
    /**
     * Banner轮播图
     */
    private List<SlideadsBean> slideads;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public ProTypeBean getProType() {
        return ProType;
    }

    public void setProType(ProTypeBean ProType) {
        this.ProType = ProType;
    }

    public ShopsBean getShops() {
        return shops;
    }

    public void setShops(ShopsBean shops) {
        this.shops = shops;
    }

    public List<BrandBean> getBrand() {
        return brand;
    }

    public void setBrand(List<BrandBean> brand) {
        this.brand = brand;
    }

    public List<SlideadsBean> getSlideads() {
        return slideads;
    }

    public void setSlideads(List<SlideadsBean> slideads) {
        this.slideads = slideads;
    }

    public static class MessageBean {
        private int total;
        private List<RowsBean> rows;
        public int getTotal() {
            return total;
        }
        public void setTotal(int total) {
            this.total = total;
        }
        public List<RowsBean> getRows() {
            return rows;
        }
        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {
            private int id;
            private String imgUrl;
            private String ProductName;
            private double MarketPrice;
            private double MinSalePrice;
            private String productCode;
            private String MeasureUnit;
            private int SaleCounts;
            private String CompanyAddress;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getProductName() {
                return ProductName;
            }

            public void setProductName(String ProductName) {
                this.ProductName = ProductName;
            }

            public double getMarketPrice() {
                return MarketPrice;
            }

            public void setMarketPrice(double MarketPrice) {
                this.MarketPrice = MarketPrice;
            }

            public double getMinSalePrice() {
                return MinSalePrice;
            }

            public void setMinSalePrice(double MinSalePrice) {
                this.MinSalePrice = MinSalePrice;
            }

            public String getProductCode() {
                return productCode;
            }

            public void setProductCode(String productCode) {
                this.productCode = productCode;
            }

            public String getMeasureUnit() {
                return MeasureUnit;
            }

            public void setMeasureUnit(String MeasureUnit) {
                this.MeasureUnit = MeasureUnit;
            }

            public int getSaleCounts() {
                return SaleCounts;
            }

            public void setSaleCounts(int SaleCounts) {
                this.SaleCounts = SaleCounts;
            }

            public String getCompanyAddress() {
                return CompanyAddress;
            }

            public void setCompanyAddress(String CompanyAddress) {
                this.CompanyAddress = CompanyAddress;
            }
        }
    }

    public static class ProTypeBean {
        private int total;
        private List<RowsBean> rows;
        public int getTotal() {
            return total;
        }
        public void setTotal(int total) {
            this.total = total;
        }
        public List<RowsBean> getRows() {
            return rows;
        }
        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }
        public static class RowsBean {
            private int id;
            private String imgUrl;
            private String ProductName;
            private double MarketPrice;
            private double MinSalePrice;
            private String productCode;
            private String MeasureUnit;
            private int SaleCounts;
            private String CompanyAddress;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getProductName() {
                return ProductName;
            }

            public void setProductName(String ProductName) {
                this.ProductName = ProductName;
            }

            public double getMarketPrice() {
                return MarketPrice;
            }

            public void setMarketPrice(double MarketPrice) {
                this.MarketPrice = MarketPrice;
            }

            public double getMinSalePrice() {
                return MinSalePrice;
            }

            public void setMinSalePrice(double MinSalePrice) {
                this.MinSalePrice = MinSalePrice;
            }

            public String getProductCode() {
                return productCode;
            }

            public void setProductCode(String productCode) {
                this.productCode = productCode;
            }

            public String getMeasureUnit() {
                return MeasureUnit;
            }

            public void setMeasureUnit(String MeasureUnit) {
                this.MeasureUnit = MeasureUnit;
            }

            public int getSaleCounts() {
                return SaleCounts;
            }

            public void setSaleCounts(int SaleCounts) {
                this.SaleCounts = SaleCounts;
            }

            public String getCompanyAddress() {
                return CompanyAddress;
            }

            public void setCompanyAddress(String CompanyAddress) {
                this.CompanyAddress = CompanyAddress;
            }
        }
    }

    public static class ShopsBean {
        private int total;
        private List<RowsBean> rows;
        public int getTotal() {
            return total;
        }
        public void setTotal(int total) {
            this.total = total;
        }
        public List<RowsBean> getRows() {
            return rows;
        }
        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }
        public static class RowsBean {
            private int Id;
            private String ShopGrade;
            private String ShopName;
            private Object BusinessSphere;
            private String Logo;
            private String CompanyName;
            private int CompanyRegionId;
            private String CompanyAddress;
            private int CreateDate;
            private int ProductNumbere;
            private int orderProduct;
            private int buyerNumber;
            private Object distance;

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
            }

            public String getShopGrade() {
                return ShopGrade;
            }

            public void setShopGrade(String ShopGrade) {
                this.ShopGrade = ShopGrade;
            }

            public String getShopName() {
                return ShopName;
            }

            public void setShopName(String ShopName) {
                this.ShopName = ShopName;
            }

            public Object getBusinessSphere() {
                return BusinessSphere;
            }

            public void setBusinessSphere(Object BusinessSphere) {
                this.BusinessSphere = BusinessSphere;
            }

            public String getLogo() {
                return Logo;
            }

            public void setLogo(String Logo) {
                this.Logo = Logo;
            }

            public String getCompanyName() {
                return CompanyName;
            }

            public void setCompanyName(String CompanyName) {
                this.CompanyName = CompanyName;
            }

            public int getCompanyRegionId() {
                return CompanyRegionId;
            }

            public void setCompanyRegionId(int CompanyRegionId) {
                this.CompanyRegionId = CompanyRegionId;
            }

            public String getCompanyAddress() {
                return CompanyAddress;
            }

            public void setCompanyAddress(String CompanyAddress) {
                this.CompanyAddress = CompanyAddress;
            }

            public int getCreateDate() {
                return CreateDate;
            }

            public void setCreateDate(int CreateDate) {
                this.CreateDate = CreateDate;
            }

            public int getProductNumbere() {
                return ProductNumbere;
            }

            public void setProductNumbere(int ProductNumbere) {
                this.ProductNumbere = ProductNumbere;
            }

            public int getOrderProduct() {
                return orderProduct;
            }

            public void setOrderProduct(int orderProduct) {
                this.orderProduct = orderProduct;
            }

            public int getBuyerNumber() {
                return buyerNumber;
            }

            public void setBuyerNumber(int buyerNumber) {
                this.buyerNumber = buyerNumber;
            }

            public Object getDistance() {
                return distance;
            }

            public void setDistance(Object distance) {
                this.distance = distance;
            }
        }
    }

    public static class BrandBean {
        private int brandid;
        private boolean isChecked;
        private String value;
        private String Logo;

        public int getBrandid() {
            return brandid;
        }

        public void setBrandid(int brandid) {
            this.brandid = brandid;
        }

        public boolean isIsChecked() {
            return isChecked;
        }

        public void setIsChecked(boolean isChecked) {
            this.isChecked = isChecked;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getLogo() {
            return Logo;
        }

        public void setLogo(String Logo) {
            this.Logo = Logo;
        }
    }

    public static class SlideadsBean {
        private int Id;
        private String ImageUrl;
        private String UrlName;
        private int UrlId;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getImageUrl() {
            return ImageUrl;
        }

        public void setImageUrl(String ImageUrl) {
            this.ImageUrl = ImageUrl;
        }

        public String getUrlName() {
            return UrlName;
        }

        public void setUrlName(String UrlName) {
            this.UrlName = UrlName;
        }

        public int getUrlId() {
            return UrlId;
        }

        public void setUrlId(int UrlId) {
            this.UrlId = UrlId;
        }
    }
}