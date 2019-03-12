public class DealerObserver
{
    public DealerObserver()
    {
    }

    private Value showing;

    public void update(Value value)
    {
        showing = value;
    }

    public Value getShowing()
    {
        return showing;
    }
}
