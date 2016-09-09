package me.libraryaddict.disguise.disguisetypes.watchers;

import me.libraryaddict.disguise.disguisetypes.Disguise;
import me.libraryaddict.disguise.disguisetypes.FlagType;

public class InsentientWatcher extends LivingWatcher
{
    public InsentientWatcher(Disguise disguise)
    {
        super(disguise);
    }

    public void setMainHand(boolean mainHand)
    {
        setInsentientFlag(2, mainHand);
        sendData(FlagType.INSENTIENT_META);
    }

    public boolean isMainHand()
    {
        return getInsentientFlag(2);
    }

    public boolean isAI()
    {
        return getInsentientFlag(1);
    }

    public void setAI(boolean ai)
    {
        setInsentientFlag(1, ai);
        sendData(FlagType.INSENTIENT_META);
    }

    private void setInsentientFlag(int i, boolean flag)
    {
        byte b0 = (byte) getValue(FlagType.INSENTIENT_META);

        if (flag)
        {
            setValue(FlagType.INSENTIENT_META, (byte) (b0 | 1 << i));
        }
        else
        {
            setValue(FlagType.INSENTIENT_META, (byte) (b0 & (~1 << i)));
        }
    }

    private boolean getInsentientFlag(int i)
    {
        return ((byte) getValue(FlagType.INSENTIENT_META) & 1 << i) != 0;
    }
}
