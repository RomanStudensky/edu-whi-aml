package lesson5;
interface Workable {
    void work();
}

  class Programmer implements Workable {
      public void work() {
          System.out.println("Программист пишет код");
      }
  }

  class Driver implements Workable {
      public void work(){
          System.out.println("Водитель ведет машину");
      }
  }

  public class Main{
      public static void main(String[] args) {
          Workable[] work = new Workable[2];

          work[0] = new Programmer();
          work[1] = new Driver();

          for(Workable w : work){
              w.work();
          }
      }
  }