package com.callback;

public class IndoorsMan {
    GasListener gasListener;

    public void setGasListener(GasListener gasListener) {
        this.gasListener = gasListener;
    }

    public void prepareCook() {
        System.out.println("宅男：准备下厨做几个花式大菜！");
        System.out.println("宅男：进厨房，烧菜...");
        System.out.println("宅男：刚开火，就发现煤气不足，没办法，只能打电话叫煤气。");
        gasListener.offerGas("宅男：送一瓶煤气过来!");
    }
}
