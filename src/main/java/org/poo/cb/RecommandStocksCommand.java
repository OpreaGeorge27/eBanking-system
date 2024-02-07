package org.poo.cb;

import java.util.ArrayList;
import java.util.Map;

public class RecommandStocksCommand implements Command{

    public RecommandStocksCommand(){

    }

    @Override
    public void execute() {
        Map<String, Stock> stocks = EBank.getInstance().getForSaleStocks();
        ArrayList<Stock> recommanded = new ArrayList<>();
        for (Stock stock: stocks.values()) {
            int cnt = 0;
            float SMAs=0f;
            float SMAl=0f;
            for (Float value:stock.getHistory().values()) {
                if(cnt >= 5 && cnt <= 10){
                    SMAs+=value;
                }
                SMAl+=value;
                cnt++;
            }
            SMAs/=5.0f;
            SMAl/=10.0f;
            if(SMAs>SMAl){
                recommanded.add(stock);
            }
        }
        EBank.getInstance().getJSONwriter().printRecStocks(recommanded);
    }
}
