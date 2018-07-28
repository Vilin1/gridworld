//package SparseGridNode;
public class SparseGridNode {
  private Object occupant;
  private int col;
  private SparseGridNode next;
  private SparseGridNode pre;

  public SparseGridNode(Object o, int c, SparseGridNode p, SparseGridNode n) {
    occupant = o;
    col = c;
    pre = p;
    next = n;
  }

  // get methods
  public Object getOccupant() {
    return occupant;
  }

  public int getCol() {
    return col;
  }

  public SparseGridNode getPre() {
    return pre;
  }

  public SparseGridNode getNext() {
    return next;
  }

  // set methods
  public void setOccupant(Object occ) {
    occupant = occ;
  }

  public void setPre(SparseGridNode newPre) {
    pre = newPre;
  }

  public void setNext(SparseGridNode newNext) {
    next = newNext;
  }
}
