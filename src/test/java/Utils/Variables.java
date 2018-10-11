package Utils;

public class Variables {

    private static String selectedProductName;
    private static String orderNo;

    public void setSelectedProductName(String selectedProductName){
        this.selectedProductName=selectedProductName;
    }

    public static String getSelectedProductName(){
        return selectedProductName;
    }

    public void setOrderNo(String orderNo){
        this.orderNo=orderNo;
    }

    public static String getOrderNo(){
        return orderNo;
    }

}
