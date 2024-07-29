public class Action implements Runnable
{
    private boolean hasEffect;
    private int damage;
    private String type;
    private String name;
    private boolean isHarmful;

    public Action(){}

    public Action(boolean hasEffect, int damage, String type, String name, boolean isHarmful)
    {
        this.hasEffect = hasEffect;
        this.damage = damage;
        this.type = type;
        this.name = name;
        this.isHarmful = isHarmful;
    }

    public boolean getHasEffect(){return hasEffect;}
    public int getActionDamage(){return damage;}
    public String getType(){return type;}
    public String getName(){return name;}
    public boolean getIsHarmful(){return isHarmful;}

    public void effectProcess(){}

    public String toString(){return getName();}

    @Override
    public void run(){this.effectProcess();}
}
