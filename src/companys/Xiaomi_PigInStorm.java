package companys;

public class Xiaomi_PigInStorm {
	public int calculateMax(int[] prices) {
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;
        for(int cur : prices){
        	firstBuy = Math.max(firstBuy, -cur);
        	firstSell = Math.max(firstSell, firstBuy + cur);
        	secondBuy = Math.max(secondBuy, firstSell - cur);
        	secondSell = Math.max(secondSell, secondBuy + cur);
        }
        return secondSell;
    }
}
