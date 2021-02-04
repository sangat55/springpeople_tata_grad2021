package com.tata.ecommerce.business;

public class TaxCalculatorImpl implements TaxCalculator {


    @Override
    public float computeIGST(double totalPrice, String catName) {

        float gst = 0.0f;
        switch (catName) {
            case "Electronics":
                gst = (float) (gst + totalPrice * .18);
                break;
            case "Grocery":
                gst = (float) (gst + totalPrice * .09);
                break;
            case "Medicines":
                gst = (float) (gst + totalPrice * 0.05);
                break;
            case "HCE":
                gst = (float) (gst + totalPrice * .11);
                break;
            default:
                gst = 0.0f;
        }
        return gst;
    }

    @Override
    public float[] computeCGSTSGST(double totalPrice, String categoryName) {
        float[] gstComponents=new float[2];
        switch (categoryName) {
            case "Electronics":
                gstComponents[0] = (float) (totalPrice * .09);
                gstComponents[1] = (float) ( totalPrice * .09);
                break;
            case "Grocery":
                gstComponents[0] = (float) (totalPrice * .0425);
                gstComponents[1] = (float) (totalPrice * .0425);
                break;
            case "Medicines":
                gstComponents[0] = (float) (totalPrice * .0125);
                gstComponents[1] = (float) (totalPrice * .0125);
                break;
            case "HCE":
                gstComponents[0] = (float) (totalPrice * .055);
                gstComponents[1] = (float) (totalPrice * .055);
                break;
            default:
                gstComponents[0] = 0.0f;
                gstComponents[1] =0.0f;
        }
        return gstComponents;

    }
}
