package dayron.romero.alu.ulpgc.es.sprint3.app;

public class ItemCount {
  private int count;
  private int id;

  public ItemCount(int count, int id){
    this.count=count;
    this.id= id;
  }
  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getId() {
    return id;
  }
}
