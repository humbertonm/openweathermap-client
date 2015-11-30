package org.openweathermap.client.params;

/**
 * Created by betob_000 on 29/11/2015.
 */
public class BoundingBox {

  private Double latTopLeft;
  private Double lonTopLeft;
  private Double latBottomRight;
  private Double lonBottomRight;
  private Integer zoom;

  public BoundingBox() {
  }

  public BoundingBox(Double latTopLeft, Double lonTopLeft, Double latBottomRight, Double lonBottomRight, Integer zoom) {
    this.latTopLeft = latTopLeft;
    this.lonTopLeft = lonTopLeft;
    this.latBottomRight = latBottomRight;
    this.lonBottomRight = lonBottomRight;
    this.zoom = zoom;
  }

  public Double getLatTopLeft() {
    return latTopLeft;
  }

  public void setLatTopLeft(Double latTopLeft) {
    this.latTopLeft = latTopLeft;
  }

  public Double getLonTopLeft() {
    return lonTopLeft;
  }

  public void setLonTopLeft(Double lonTopLeft) {
    this.lonTopLeft = lonTopLeft;
  }

  public Double getLatBottomRight() {
    return latBottomRight;
  }

  public void setLatBottomRight(Double latBottomRight) {
    this.latBottomRight = latBottomRight;
  }

  public Double getLonBottomRight() {
    return lonBottomRight;
  }

  public void setLonBottomRight(Double lonBottomRight) {
    this.lonBottomRight = lonBottomRight;
  }

  public Integer getZoom() {
    return zoom;
  }

  public void setZoom(Integer zoom) {
    this.zoom = zoom;
  }
}
