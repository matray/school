public class Rules
{
    private boolean hitOnSoft17;
    private boolean doubleAfterSplitAllowed;
    private boolean lateSurrenderAllowed;
    private Payout payout;
    private SplitPossibilities splits;

    public Rules()
    {
        payout = Payout.THREETOTWO;
        splits = SplitPossibilities.THREEWITHTWOACES;
        hitOnSoft17 = true;
        doubleAfterSplitAllowed = true;
        lateSurrenderAllowed = false;
    }

    public boolean hitOnSoft17()
    {
        return hitOnSoft17;
    }

    public boolean doubleAfterSplitAllowed()
    {
        return doubleAfterSplitAllowed;
    }

    public boolean lateSurrenderAllowed()
    {
        return lateSurrenderAllowed;
    }

    public Payout payout()
    {
        return payout;
    }

    public SplitPossibilities splits()
    {
        return splits;
    }

    public void setPayout(Payout payout)
    {
        this.payout = payout;
    }

    public void setHitOnSoft17(boolean allowed)
    {
        hitOnSoft17 = allowed;
    }

    public void setDoubleAfterSplitAllowed(boolean allowed)
    {
        doubleAfterSplitAllowed = allowed;
    }

    public void setLateSurrenderAllowed(boolean allowed)
    {
        lateSurrenderAllowed = allowed;
    }

    public void setSplitPossibities(SplitPossibilities possibilities)
    {
        splits = possibilities;
    }
}
