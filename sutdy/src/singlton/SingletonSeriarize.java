package singlton;

import java.io.Serializable;

public class SingletonSeriarize implements Serializable {
    private static final long serialVersionUID = 1L;

    private String GARBAGE_PACK_TIME = "7:00";
	public String getGARBAGE_PACK_TIME() {
		return GARBAGE_PACK_TIME;
	}

	public void setGARBAGE_PACK_TIME(String gARBAGE_PACK_TIME) {
		GARBAGE_PACK_TIME = gARBAGE_PACK_TIME;
	}

    private static final class SingletonHolder {
        private static final SingletonSeriarize instance = new SingletonSeriarize();
    }

    private SingletonSeriarize() {
    }

    public static SingletonSeriarize getInstance() {
        return SingletonHolder.instance;
    }

    private Object readResolve() {
        return SingletonHolder.instance;
    }

}
