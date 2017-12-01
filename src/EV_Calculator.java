public class EV_Calculator
{
    private double win_rate;
    private double booster_sell_price;
    private double booster_buy_price;
    private double average_card_value;
    private double treasure_chest;

    public EV_Calculator(double win_rate, double booster_sell_price,
                         double booster_buy_price, double average_card_value, double treasure_chest)
    {
        this.win_rate = win_rate;
        this.booster_buy_price = booster_buy_price;
        this.booster_sell_price = booster_sell_price;
        this.average_card_value = average_card_value;
        this.treasure_chest = treasure_chest;
    }

    //Expected Value from playing a 2-man
    public double two_man()
    {
        return -2 + win_rate * 3 + (1 - win_rate) * .5;
    }

    //Expected value from playing in a competitive single elimination booster draft
    public double comp_booster()
    {
        return -3 * booster_buy_price + 2 + Math.pow(win_rate,3) * 8 * booster_buy_price
                + Math.pow(win_rate,2) * (1-win_rate) * 4 * booster_buy_price + average_card_value;
    }

    public double pptq_constructed()
    {
        return -30 + 5 * Math.pow(win_rate,3) * Math.pow(1 - win_rate,2) * 6 * booster_sell_price
                   + 5 * Math.pow(win_rate,4) * Math.pow(1 - win_rate,1) * 10 * booster_sell_price
                   + 5 * Math.pow(win_rate,5) * 12 * booster_sell_price;
    }

    public double constructed_league()
    {
        return -12 + Math.pow(win_rate, 5) * (16 * treasure_chest + 18)
                   + 5 * Math.pow(win_rate, 4) * Math.pow(1 - win_rate, 1) * (8 * treasure_chest + 18)
                   + 5 * Math.pow(win_rate, 3) * Math.pow(1 - win_rate, 2) * (treasure_chest + 12);
    }

    public double draft_intermediate(){return 0.0;}

    public double draft_friendly(){return 0.0;}



    public static void main(String[] args) {
        EV_Calculator a = new EV_Calculator(.5, 3.3, 3.6, 1.5, 2.7);

        System.out.println(a.two_man());

        System.out.println(a.comp_booster());
        System.out.println(a.pptq_constructed());
        System.out.println(a.constructed_league());

    }
}
