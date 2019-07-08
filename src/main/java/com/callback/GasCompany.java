package com.callback;

public class GasCompany implements GasListener {
    private String result;
    public void advertiseTo(IndoorsMan man) {
        System.out.println("煤气公司：这是我们的联系方式，欢迎来电！");
        man.setGasListener(this);
    }

//    public GasCompany(String result) {
//        this.result = result;
//    }

    @Override
    public void offerGas(String msg) {
        System.out.println("煤气公司接收的订单：" + msg);
        String pBuffer = "aaa";
        setResult(pBuffer);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
