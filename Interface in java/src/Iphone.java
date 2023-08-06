public class Iphone implements Phone {
    String nam;
    double co;
    double bat_life;

    @Override
    public void name(String nam) {
        System.out.println("Phone Name:: " + nam);
    }
@Override
    public void cost(String nam, double co) {
        System.out.println("\s\s"+nam + " Cost:: " + co+" Rs.");
    }
@Override
    public void battery_life(String nam, double bat_life) {
        System.out.println("\s\s"+nam + " Battery Life:: " + bat_life+" hours/day");
    }

}