package com.wlw.admin.myapplication.module;

import java.util.List;

public class HomeBean2 {

    private List<BannerListBean> bannerList;
    private List<ItemListBean> itemList;
    private List<ModuleEntranceBean> moduleEntrance;
    private List<?> productLists;
    private List<QuickAppointBean> quickAppoint;
    private List<CarouselBean> carousel;

    public List<BannerListBean> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<BannerListBean> bannerList) {
        this.bannerList = bannerList;
    }

    public List<ItemListBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBean> itemList) {
        this.itemList = itemList;
    }

    public List<ModuleEntranceBean> getModuleEntrance() {
        return moduleEntrance;
    }

    public void setModuleEntrance(List<ModuleEntranceBean> moduleEntrance) {
        this.moduleEntrance = moduleEntrance;
    }

    public List<?> getProductLists() {
        return productLists;
    }

    public void setProductLists(List<?> productLists) {
        this.productLists = productLists;
    }

    public List<QuickAppointBean> getQuickAppoint() {
        return quickAppoint;
    }

    public void setQuickAppoint(List<QuickAppointBean> quickAppoint) {
        this.quickAppoint = quickAppoint;
    }

    public List<CarouselBean> getCarousel() {
        return carousel;
    }

    public void setCarousel(List<CarouselBean> carousel) {
        this.carousel = carousel;
    }

    public static class BannerListBean {
        /**
         * bannerName : banner
         * bannerPicture : https://www.hongjimeng.net//UploadFiles/Temp/4686296743345594845.jpg
         * bannerUrl :
         * bannerType : 14
         */

        private String bannerName;
        private String bannerPicture;
        private String bannerUrl;
        private int bannerType;

        public String getBannerName() {
            return bannerName;
        }

        public void setBannerName(String bannerName) {
            this.bannerName = bannerName;
        }

        public String getBannerPicture() {
            return bannerPicture;
        }

        public void setBannerPicture(String bannerPicture) {
            this.bannerPicture = bannerPicture;
        }

        public String getBannerUrl() {
            return bannerUrl;
        }

        public void setBannerUrl(String bannerUrl) {
            this.bannerUrl = bannerUrl;
        }

        public int getBannerType() {
            return bannerType;
        }

        public void setBannerType(int bannerType) {
            this.bannerType = bannerType;
        }
    }

    public static class ItemListBean {
        /**
         * itemGroupCode : QJL
         * itemName : 清洁类
         * itemCode : QJL
         * itemIcon : https://www.hongjimeng.net//Areas/APPV2/Content/images/v160/qjl.png
         * itemType : 1
         */

        private String itemGroupCode;
        private String itemName;
        private String itemCode;
        private String itemIcon;
        private String itemType;

        public String getItemGroupCode() {
            return itemGroupCode;
        }

        public void setItemGroupCode(String itemGroupCode) {
            this.itemGroupCode = itemGroupCode;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getItemCode() {
            return itemCode;
        }

        public void setItemCode(String itemCode) {
            this.itemCode = itemCode;
        }

        public String getItemIcon() {
            return itemIcon;
        }

        public void setItemIcon(String itemIcon) {
            this.itemIcon = itemIcon;
        }

        public String getItemType() {
            return itemType;
        }

        public void setItemType(String itemType) {
            this.itemType = itemType;
        }
    }

    public static class ModuleEntranceBean {
        /**
         * moduleEntranceItemCode : TJCP
         * moduleEntranceName : 特价产品
         * moduleEntrancePicture : https://www.hongjimeng.net//Areas/APPV2/Content/images/tejia1.jpg
         * moduleEntranceType : 3
         * moduleEntranceContent : 每天都有惊喜发生
         * moduleEntranceIcon : https://www.hongjimeng.net//Areas/APPV2/Content/images/te-jia.png
         */

        private String moduleEntranceItemCode;
        private String moduleEntranceName;
        private String moduleEntrancePicture;
        private String moduleEntranceType;
        private String moduleEntranceContent;
        private String moduleEntranceIcon;

        public String getModuleEntranceItemCode() {
            return moduleEntranceItemCode;
        }

        public void setModuleEntranceItemCode(String moduleEntranceItemCode) {
            this.moduleEntranceItemCode = moduleEntranceItemCode;
        }

        public String getModuleEntranceName() {
            return moduleEntranceName;
        }

        public void setModuleEntranceName(String moduleEntranceName) {
            this.moduleEntranceName = moduleEntranceName;
        }

        public String getModuleEntrancePicture() {
            return moduleEntrancePicture;
        }

        public void setModuleEntrancePicture(String moduleEntrancePicture) {
            this.moduleEntrancePicture = moduleEntrancePicture;
        }

        public String getModuleEntranceType() {
            return moduleEntranceType;
        }

        public void setModuleEntranceType(String moduleEntranceType) {
            this.moduleEntranceType = moduleEntranceType;
        }

        public String getModuleEntranceContent() {
            return moduleEntranceContent;
        }

        public void setModuleEntranceContent(String moduleEntranceContent) {
            this.moduleEntranceContent = moduleEntranceContent;
        }

        public String getModuleEntranceIcon() {
            return moduleEntranceIcon;
        }

        public void setModuleEntranceIcon(String moduleEntranceIcon) {
            this.moduleEntranceIcon = moduleEntranceIcon;
        }
    }

    public static class QuickAppointBean {
        /**
         * quickItemGroupCode : KSYY
         * quickItemName : 快速预约
         * quickItemCode : KSYY
         * quickItemIcon : https://www.hongjimeng.net//Areas/APPV2/Content/images/kuaisu.gif
         * quickItemType : 6
         * quickItemUrl : https://www.hongjimeng.net//APPV2/Default/QuickAppointment
         * quickItemAnDorDUrl : https://www.hongjimeng.net//Areas/appv2/Content/images/quicksubscribe.png
         */

        private String quickItemGroupCode;
        private String quickItemName;
        private String quickItemCode;
        private String quickItemIcon;
        private String quickItemType;
        private String quickItemUrl;
        private String quickItemAnDorDUrl;

        public String getQuickItemGroupCode() {
            return quickItemGroupCode;
        }

        public void setQuickItemGroupCode(String quickItemGroupCode) {
            this.quickItemGroupCode = quickItemGroupCode;
        }

        public String getQuickItemName() {
            return quickItemName;
        }

        public void setQuickItemName(String quickItemName) {
            this.quickItemName = quickItemName;
        }

        public String getQuickItemCode() {
            return quickItemCode;
        }

        public void setQuickItemCode(String quickItemCode) {
            this.quickItemCode = quickItemCode;
        }

        public String getQuickItemIcon() {
            return quickItemIcon;
        }

        public void setQuickItemIcon(String quickItemIcon) {
            this.quickItemIcon = quickItemIcon;
        }

        public String getQuickItemType() {
            return quickItemType;
        }

        public void setQuickItemType(String quickItemType) {
            this.quickItemType = quickItemType;
        }

        public String getQuickItemUrl() {
            return quickItemUrl;
        }

        public void setQuickItemUrl(String quickItemUrl) {
            this.quickItemUrl = quickItemUrl;
        }

        public String getQuickItemAnDorDUrl() {
            return quickItemAnDorDUrl;
        }

        public void setQuickItemAnDorDUrl(String quickItemAnDorDUrl) {
            this.quickItemAnDorDUrl = quickItemAnDorDUrl;
        }
    }

    public static class CarouselBean {
        /**
         * carouselItemGroupCode : QJL
         * carouselItemName : 擦玻璃
         * carouselItemCode : CBL
         * carouselItemIcon : https://www.hongjimeng.net//Areas/APPV2/Content/images/piccbl.png
         * carouselItemType : 7
         */

        private String carouselItemGroupCode;
        private String carouselItemName;
        private String carouselItemCode;
        private String carouselItemIcon;
        private String carouselItemType;

        public String getCarouselItemGroupCode() {
            return carouselItemGroupCode;
        }

        public void setCarouselItemGroupCode(String carouselItemGroupCode) {
            this.carouselItemGroupCode = carouselItemGroupCode;
        }

        public String getCarouselItemName() {
            return carouselItemName;
        }

        public void setCarouselItemName(String carouselItemName) {
            this.carouselItemName = carouselItemName;
        }

        public String getCarouselItemCode() {
            return carouselItemCode;
        }

        public void setCarouselItemCode(String carouselItemCode) {
            this.carouselItemCode = carouselItemCode;
        }

        public String getCarouselItemIcon() {
            return carouselItemIcon;
        }

        public void setCarouselItemIcon(String carouselItemIcon) {
            this.carouselItemIcon = carouselItemIcon;
        }

        public String getCarouselItemType() {
            return carouselItemType;
        }

        public void setCarouselItemType(String carouselItemType) {
            this.carouselItemType = carouselItemType;
        }
    }
}
