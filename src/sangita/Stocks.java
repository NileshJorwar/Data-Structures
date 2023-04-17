package src.sangita;

public class Stocks {

    public float stockRate;

    public Stocks(float stockRate) {
        this.stockRate = stockRate;
    }

    public String checkRate(float Rate) throws StockHighException,StockLowException {
        if(Rate==0.8*stockRate){
            return "Hope to raise";
        } if (Rate<0.8*stockRate) {
            throw new StockLowException("Under Loss");
        }
        else  {
            throw new StockHighException("Under Profit");
        }
    }
}
    class StockLowException extends Exception{
        public StockLowException(String msg){
            super(msg);
        }
    }
class StockHighException extends Exception {
    public StockHighException(String msg){
        super(msg);
    }
}
class Source {
    public static void main(String[] args) throws StockHighException,StockLowException {
        Stocks stock=new Stocks(10.0f);
        stock.checkRate(5.0f);
    }
}
