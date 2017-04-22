package uj.edu.handgeometry;

import uj.edu.handgeometry.exception.FingerException;

/**
 * Created by zaloguj on 02.04.2017.
 */
public interface Geometry {

    public void init() throws FingerException;

    public Double getLittleLenght();
    public Double getThumbLenght();
    public Double getRingLenght();
    public Double getIndexLenght();
    public Double getMiddleLenght();
    public Double getRadius();
    public Double getThumbWidthTop();
    public Double  getThumbWidthBot();
    public Double  getIndexWidthTop();
    public Double  getIndexWidthBot();
    public Double  getMiddleWidthTop();
    public Double  getMiddleWidthBot();
    public Double  getRingWidthTop();
    public Double  getRingWidthBot();
    public Double  getLittleWidthTop();
    public Double  getLittleWidthBot();
    public Double getPalmWidth();

    public void draw(String filePath,String origin);

}
